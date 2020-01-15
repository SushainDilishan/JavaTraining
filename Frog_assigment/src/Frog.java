import java.util.InputMismatchException;
import java.util.Scanner;

public class Frog {

     void Frog(){
         Scanner scanner = new Scanner(System.in);
         boolean validate = false;
         int distance = 0;
         int jump1 = 0;
         int jump2 = 0;
         int jump3 = 0;

         do {
             System.out.println("Enter the distance");
             try {
                 distance = scanner.nextInt();
                 validate = true;

             }catch (InputMismatchException e){

                 System.out.println("Input has to be a number");
             }

         }while (validate==false);



     }
}
