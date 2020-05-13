public class Student extends Human {

    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                '}';
    }
}
