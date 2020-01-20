import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Application {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Eranda", 80));
        employees.add(new Employee("Iresh", 90));
        employees.add(new Employee("Sushain", 70));
        employees.add(new Employee("Dinuka", 60));


        //filter
        // employees.stream().filter(e->e.getName().contains("S")).collect(Collectors.toList());
        // System.out.println(employees);
        //sort
        List<Employee> employees2 = employees.stream().sorted((e1, e2) -> {

            if (e1.getMarks() > e2.getMarks())
                return +1;
            if (e2.getMarks() < e2.getMarks())
                return -1;
            return 0;


        }).collect(Collectors.toList());
        System.out.println(employees2);
    }

    }
