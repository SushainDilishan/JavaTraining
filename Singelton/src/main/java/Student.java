import java.sql.Connection;

public class Student {

    public static volatile Student student;
    public static volatile Details details;

    private Student(){

        if(student !=null){
            throw new RuntimeException("Please Use the Get Method");
        }
    }



    public static Student getStudent() {

        if(student==null){

            synchronized (Student.class){

                if(student==null) {
                    student = new Student();

                }
                }
        }

        return student;
    }

    public Details getDetails(){

        if(details ==null){
            synchronized (Student.class){

                if(details == null){
                    details = new Details();
                }
            }
        }
        return details;
    }

}
