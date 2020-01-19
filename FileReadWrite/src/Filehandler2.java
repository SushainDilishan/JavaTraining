import java.io.*;

public class Filehandler2 {
    public static void main(String[] args) {
        String Path = "D:/aa.txt";
        try(InputStream inputStream = new FileInputStream(Path)) {
            String fileContent = "This is a sample text.";
            inputStream.(fileContent);
        } catch (IOException e) {

        }
        try(FileReader fileReader = new FileReader(Path)) {
            int ch = fileReader.read();
            while(ch != -1) {
                System.out.print((char)ch);
                ch = fileReader.read();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
