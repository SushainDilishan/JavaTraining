package chatClient;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsExchange;

import java.io.IOException;
import java.io.OutputStream;

public class testClass implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String output = "Hey";
        HttpsExchange httpsExchange = (HttpsExchange) exchange;
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin","");
        exchange.sendResponseHeaders(200,output.getBytes().length);
        OutputStream stream = exchange.getResponseBody();


        stream.write(output.getBytes());
        stream.close();
    }
}
