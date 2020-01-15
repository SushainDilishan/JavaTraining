import java.util.InputMismatchException;
import java.util.Scanner;

public class Frog {
    public static void main(String[] args) {
        Frog a = new Frog();
        a.FrogCalculateDistance();
    }

    void FrogCalculateDistance() {

        Scanner scanner = new Scanner(System.in);
        boolean validate = false;
        int time = 0;


        do {
            System.out.println("Enter the Time");
            try {
                time = scanner.nextInt();
                validate = true;

            } catch (InputMismatchException e) {

                System.out.println("Input has to be a number");
                break;
            }

        } while (validate == false);

           int remainder = time%8;

         if (remainder==0){

             System.out.println("Distance traveled by jhon is "+((time/8)*9)+" m ");
         }
         else if(remainder<=1){
             System.out.println("Distance traveled by jhon is " +((time/8)*9+5)+ " m ");

         }else if(remainder<=3) {
             System.out.println("Distance traveled by jhon is " + ((time / 8) * 9 + 8) + " m ");
         }
         else if(remainder<=7) {
             System.out.println("Distance traveled by jhon is " + ((time / 8) * 9 + 9) + " m ");
         }

    }
}
