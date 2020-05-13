public class Employee extends Human {

    private String salary;

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary='" + salary + '\'' +
                '}';
    }
}
