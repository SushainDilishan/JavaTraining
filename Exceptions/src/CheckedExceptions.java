import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExceptions {
    //this is one way of handling checking exceptions using throws keyword
    public  static void main(String args[]) throws IOException {
        FileInputStream input = null;

        input = new FileInputStream("D:/file.txt");

        int m;
        while ((m = input.read()) != -1) {
            System.out.print((char)m);
        }

        input.close();
        CheckedExceptions a = new CheckedExceptions();
        a.Usingtrycatch();
    }
    public void Usingtrycatch(){

        FileInputStream input1 = null;
        try {
            input1 = new FileInputStream("D:/file.txt");
        } catch(FileNotFoundException e) {
            System.out.println("The file does not " + "exist at the location");
        }



    }

    }

}
