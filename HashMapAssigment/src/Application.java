import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Krish",80);
        hashMap.put("iresh",70);
        hashMap.put("Dinuka",60);
        hashMap.put("dhanuka",90);
        hashMap.put("Sushain",70);

        List<String> employees = hashMap.keySet().stream().filter((s) -> hashMap.get(s) > 60).sorted().collect(Collectors.toList());
        System.out.println(employees);
    }
}
