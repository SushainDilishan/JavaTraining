public class Employee {



    private String name;
    private int Marks;

    public Employee(String name, int Marks) {
        this.name = name;
        this.Marks = Marks;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", Marks=" + Marks +""
                ;
    }


}
