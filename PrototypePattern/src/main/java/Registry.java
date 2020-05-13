import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<HumanType,Human> humans = new HashMap<HumanType, Human>();

    public Registry(){
        this.intialize();
    }

    private void intialize() {


        Student student = new Student();
        student.setName("saman");
        student.setAge(18);
        student.setSchool("Central");

        Employee employee = new Employee();
        employee.setName("Amal");
        employee.setAge(25);
        employee.setSalary("200000");

        humans.put(HumanType.STUDENT,student);
        humans.put(HumanType.EMPLOYEE,employee);
    }

    public Human getHuman(HumanType humanType){
        Human human = null;
        try {
             human = (Human) humans.get(humanType).clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return human;
    }


}
