import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDateTime;

public class TimeZone{

public static void main(String[]args){
try{

Scanner scanner=new Scanner(System.in);
System.out.print("Enter Year  :-");
int year=scanner.nextInt();
System.out.print("Enter Month's number :-");
int month=scanner.nextInt();
System.out.print("Enter Day  :-");
int day=scanner.nextInt();
System.out.print("Enter Hour  :-");
int hour=scanner.nextInt();
System.out.print("Enter Minute  :-");
int minute=scanner.nextInt();

System.out.println("");
LocalDateTime localDateTime=LocalDateTime.of(year,Month.of(month),day,hour,minute);
ZonedDateTime zonedDateTime=ZonedDateTime.of(localDateTime,ZoneId.of("UTC"));
System.out.println("UTC Time :- "+zonedDateTime);

System.out.println("");
ZonedDateTime zonedDateTimePst=ZonedDateTime.of(localDateTime,ZoneId.of("America/Los_Angeles"));
System.out.println("PST time :- "+zonedDateTimePst+"\n");

}catch(Exception e){
System.out.println("Please Enter Date & Time Correctly");
}

}
}