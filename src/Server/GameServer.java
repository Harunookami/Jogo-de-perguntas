package Server;

import javax.json.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class GameServer {
    public static void main(String[] args) throws IOException {
        int port = 80;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new StaticFileHandler("public"));
        server.setExecutor(null);
        server.start();

        System.out.println("Server is running on http://localhost:" + port + "...");
    }
}

class StaticFileHandler implements HttpHandler {
    private final String publicDir;

    public StaticFileHandler(String publicDir) {
        this.publicDir = publicDir;
    }

    /*
     * Endpoints da API:
     * /api/questao
     * /api/checar-resposta
     */

    private void send(HttpExchange exchange, int code, String content, String contentType) throws IOException {
        exchange.getResponseHeaders().set("Content-Type",
                (contentType != null && !contentType.isEmpty()) ? contentType : "text/html");
        exchange.sendResponseHeaders(200, content.length());
        exchange.getResponseBody().write(content.getBytes());
        exchange.getResponseBody().close();
    }

    private void sendFile(HttpExchange exchange, File file) throws IOException {
        exchange.sendResponseHeaders(200, file.length());
        OutputStream os = exchange.getResponseBody();
        Files.copy(file.toPath(), os);
        os.close();
    }

    private void send(HttpExchange exchange, int code, String content) throws IOException {
        this.send(exchange, code, content, "text/html");
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestPath = exchange.getRequestURI().getPath();
        if (requestPath.equals("/")) {
            requestPath = "/index.html"; // padrão para index.html
        }
        System.out.println("Request Path Atual: " + requestPath);

        if (requestPath.equals("/api/questao")) {
            send(exchange, 200, "{\"error\": false}", "application/json");
            return;
        }

        File file = new File(publicDir + requestPath);

        // checa se é arquivo ou diretorio
        if (!file.exists() || file.isDirectory()) {
            send(exchange, 200, "404 Not Found");
            return;
        }

        sendFile(exchange, file);
    }
}
