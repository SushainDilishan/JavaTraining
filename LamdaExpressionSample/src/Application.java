import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


        public class Application {
            public static void main(String[] args) {
                List<Employee> employees = new ArrayList<>();
                employees.add(new Employee("Sushain",70));
                employees.add(new Employee("Eranda",80));
                employees.add(new Employee("Iresh",90));
                employees.add(new Employee("Dinuka",69));

                Comparator<Employee> employeeComparator=(e1,e2)->(e1.getMarks()>e2.getMarks()?+1:e1.getMarks()<e2.getMarks()?-1:0);
                Collections.sort(employees,employeeComparator);
                System.out.println(employees);

    }

}
