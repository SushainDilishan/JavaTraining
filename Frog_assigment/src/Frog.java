import java.util.InputMismatchException;
import java.util.Scanner;

public class Frog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog a = new Frog();
        int select=0;
        System.out.println("Type 1 to calculate time and type 2 for distance");
        select =scanner.nextInt();
        if(select==1){
            a.FrogCalculatetime();

        }else if(select==2){
            a.FrogCalculateDistance();
        }
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

    void FrogCalculatetime(){

        Scanner scanner = new Scanner(System.in);
        boolean validate = false;
        int distance = 0;


        do {
            System.out.println("Enter the Distance");
            try {
                distance = scanner.nextInt();
                validate = true;

            } catch (InputMismatchException e) {

                System.out.println("Input has to be a number");
                break;
            }

        } while (validate == false);

        int remainder = distance%9;

        if (remainder==0){

            System.out.println("Time taken by jhon is "+((distance/9)*8)+" s ");
        }
        else if(remainder<=5){
            System.out.println("Time taken by jhon is " +((distance/9)*8 + 1)+ " s ");

        }else if(remainder<=8) {
            System.out.println("Time taken by jhon is " + ((distance/9) * 8 + 3) + " s ");
        }
        else if(remainder>8) {
            System.out.println("Time taken by jhon is " + ((distance/9) * 8 + 8) + " s ");
        }
    }

    }

