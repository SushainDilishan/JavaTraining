public class Application {
    public static void main(String[] args) {

        Student student = Student.getStudent();

        System.out.println(student.getDetails().getName()+"\n"+student.getDetails().getAge());
    }
}
