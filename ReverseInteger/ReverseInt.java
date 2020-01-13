
import java.util.Scanner;


public class ReverseInt {
    
    public static void main(String[] args){

int x;
int rev = 0;

System.out.println("Enter an Integer value");

Scanner in = new Scanner(System.in);
x = in.nextInt();

while( x != 0){

rev = rev * 10;
rev = rev + x%10;
x= x/10;
}

System.out.println("Reverse number is:" + rev);

}
    }
}