package chatServer1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sendMessage implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        URI uri = httpExchange.getRequestURI();
        String s = uri.getRawQuery();

        try{
            Matcher matcher = Pattern.compile("message=(?<msg>\\w*)&receiver=" +
                    "(?<rec>\\w*)&sender=(?<sen>\\w*)").matcher(s);
            if(matcher.find()){
                System.out.println("message :"+ matcher.group("msg"));
                System.out.println("Sent to: "+ matcher.group("rec"));
                System.out.println("Sent by: "+ matcher.group("sen"));

                String message = matcher.group("msg");
                String receiver = matcher.group("rec");
                String sender = matcher.group("sen");

                main.userList.keySet().forEach(name->{
                    if (receiver.equals(name)){

                        main.userList.put(name,sender +"->"+ message);

                    } });
                System.out.println(main.userList.values());

                String response = "Delivered to " + receiver;

                httpExchange.sendResponseHeaders(200,response.length());
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(response.toString().getBytes());

                outputStream.close();
            }
        }catch (Exception e){
            System.out.println("Message Send Failed");
         e.printStackTrace();

        }


    }
}
