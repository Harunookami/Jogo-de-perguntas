$path = "src"
$filter = "*.java"
$binPath = "out"
$mainClass = "Server.GameServer"
$processName = "java"
$lastModified = @{}  # Hash para armazenar timestamps dos arquivos

# Criando o watcher para monitorar arquivos na pasta src/
$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = $path
$watcher.Filter = $filter
$watcher.IncludeSubdirectories = $true
$watcher.EnableRaisingEvents = $true

Write-Host "Monitorando mudanças em $path ..."

$job = $null  # Variável para armazenar o processo rodando

while ($true) {
    $event = $watcher.WaitForChanged("Changed", 2000)

    if ($event) {
        $file = $event.Name
        if (-not $file) { continue }  # Evita erro de índice nulo

        $fullPath = "$path\$file"

        # Se o arquivo não existe mais, ignore
        if (!(Test-Path $fullPath)) { continue }

        # Verifica se o arquivo realmente mudou (evita loop infinito)
        $currentModified = (Get-Item $fullPath).LastWriteTime
        if ($lastModified.ContainsKey($file) -and $lastModified[$file] -eq $currentModified) {
            continue
        }
        $lastModified[$file] = $currentModified

        Write-Host "Arquivo modificado: $file. Recompilando..."

        # Compilar código (evita erro se já houver binário rodando)
        javac -d $binPath "$path\*.java" 2>&1 | Out-Null

        # Encerrar o processo Java anterior se estiver rodando
        $existing = Get-Process -Name $processName -ErrorAction SilentlyContinue
        if ($existing) {
            Stop-Process -Name $processName -Force
            Start-Sleep -Seconds 1  # Aguarda 1 segundo antes de reiniciar
        }

        # Iniciar nova instância do programa
        Start-Process -NoNewWindow -FilePath "java.exe" -ArgumentList "-cp $binPath $mainClass"
    }
}
