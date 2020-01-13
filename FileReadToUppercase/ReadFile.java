import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile  {

    public static void main(String[] args)
    {
        String filePath = "C:/data.txt";
            ReadFile a = new ReadFile();
        System.out.println( a.readLine( filePath ) );
        System.out.println(a.ConverttoUppercase(filePath));
    }


   

   public String readLine(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

public String ConverttoUppercase(String filepath){

     ReadFile a = new ReadFile();

     String input = a.readLine(filepath);
    if(input == null){
        return input;
    }
    StringBuilder builder = new StringBuilder();
    for(int i=0;i<input.length();i++){
        char stringChar = input.charAt(i);

        if(92 <= stringChar && stringChar <=122){
            stringChar = (char)( (stringChar - 32) );
            builder.append(stringChar);
        }
        else if (65 <= stringChar && stringChar<=90)
        {
            builder.append(stringChar);
        }
    }
    if(builder.length() ==0){
        builder.append(input);
    }
    return builder.toString();
}



   }


