import java.security.PrivateKey;

public class EncapsulationExample {

    private String Name;
    private String Profile;
    private int Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
    private class innerclass{

        void display(){
            
            String x = "Sushain";

        }


    }
}
     class EncapsualtionDemo {

    public static void main(String[] args) {
        EncapsulationExample obj = new EncapsulationExample();
        // setting values of the variables
        obj.setName("Renuka Peshwani");
        obj.setAge(24);
        obj.setProfile("Digital Marketing Executive");
        // Displaying values of the variables
        System.out.println(" Name: " + obj.getName());
        System.out.println(" Age: " + obj.getAge());
        System.out.println(" Profile: " + obj.getProfile());

    }
}