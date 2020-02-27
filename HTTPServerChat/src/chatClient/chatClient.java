package chatClient;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class chatClient {

    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static String ip = "localhost", name = "Sushi", port = "8000";



    static {

        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("127.0.0.1")) {
                            return true;
                        }
                        return false;
                    }
                });
    }


    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type **connect ip:port as name**  to connect to Chat Room...");
        String command = scanner.nextLine();
        Pattern regex1 = Pattern.compile("^connect " +
                "(?<ip>((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))" +
                ":(?<port>\\d{4})" +
                " as " +
                "(?<name>\\w*)$");
        Matcher matches = regex1.matcher(command);

        if (matches.find()) {
            ip = matches.group("ip");
            name = matches.group("name");
            port = matches.group("port");

            System.out.println("ip: " + ip);
            System.out.println("name: " + name);
            System.out.println("port: " + port);


            System.setProperty("javax.net.ssl.trustStore", "src/myKeyStore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "123456");



            String httpsURL = "https://" + ip + ":" + port + "/register?name=" + name;
            URL url = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();


            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
            br.close();


            //connect 127.0.0.1:8000 as sushi

            new Thread(() -> {
                Scanner send = new Scanner(System.in);
                System.out.println("Type *list* to find other Chat users ");
                System.out.println("Use *Send <messageBody> -> <Receiver Name>*");
                while (true) {
                    System.out.print(":");
                    String sendToServer = send.nextLine();


                    if (sendToServer.equals("list")) {
                        getList();
                    }

                    if (Pattern.matches("send (?<msg>.*)->(?<name>.*)", sendToServer)) {
                        sendToServer(sendToServer);
                    }

                }
            }).start();


            new Thread(() -> {
                while (true) {

                    try {
                        Thread.sleep(4000);
                        String httpsURL1 = "https://127.0.0.1:8000/inbox?name=" + name;
                        URL url1 = new URL(httpsURL1);
                        HttpsURLConnection  connection = (HttpsURLConnection) url1.openConnection();


                        InputStream inputStream= connection.getInputStream();
                        InputStreamReader reader = new InputStreamReader(inputStream);
                        BufferedReader reader1 = new BufferedReader(reader);
                        String inputLine1;
                        while ((inputLine1 = reader1.readLine()) != null) {
                            if (!inputLine1.equals("no"))
                                System.out.println(inputLine1);
                        }
                        reader1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } else {
            System.out.println("Wrong Input !");
        }
    }

    private static void sendToServer(String sendToServer) {

        try {


            Matcher matcher2 = Pattern.compile("send (?<msg>.*)->(?<name>.*)").matcher(sendToServer);
            if (matcher2.find()) {

                String message = matcher2.group("msg");
                String receiver = matcher2.group("name");
                String sender = name;


                String httpsURL1 = "https://127.0.0.1:8000/send?message=" + message
                        + "&receiver=" + receiver
                        + "&sender=" + sender;
                URL url = new URL(httpsURL1);
                HttpsURLConnection conn1 = (HttpsURLConnection) url.openConnection();


                InputStream stream = conn1.getInputStream();
                InputStreamReader reader = new InputStreamReader(stream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String inputLine1;
                while ((inputLine1 = bufferedReader.readLine()) != null) {
                    System.out.println(inputLine1);
                }
                bufferedReader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getList() {

        try {
            System.out.println("list");
            String httpsURL1 = "https://127.0.0.1:8000/list?name=" + name;
            URL myUrl1 = new URL(httpsURL1);
            HttpsURLConnection conn1 = (HttpsURLConnection) myUrl1.openConnection();


            InputStream stream = conn1.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String inputLine1;
            while ((inputLine1 = bufferedReader.readLine()) != null) {
                System.out.println(inputLine1);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
