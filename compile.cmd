@echo off

@REM GERA DNAMICAMENTE A LISTA DE ARQUIVOS JAVA ENCONTRADOS NO PROJETO
dir /s /b src\*.java > sources.txt

@REM javac -encoding UTF-8 -d out src/JogoDePerguntas/*.java
javac -cp "lib/*" -d out @sources.txt