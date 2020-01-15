import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    class FileHandler {
    public static void main(String[] args) {
        String Path = "D:/aa.txt";
        try(FileWriter fileWriter = new FileWriter(Path)) {
            String fileContent = "This is a sample text.";
            fileWriter.write(fileContent);
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
