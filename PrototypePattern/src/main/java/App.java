public class App {

    public static void main(String[] args) {


        Registry registry = new Registry();

        Employee employee = (Employee) registry.getHuman(HumanType.EMPLOYEE);
        System.out.println(employee);

        employee.setSalary("11111");

        System.out.println(employee);

        Employee employee1 = (Employee) registry.getHuman(HumanType.EMPLOYEE);
        System.out.println(employee1);


    }
}
