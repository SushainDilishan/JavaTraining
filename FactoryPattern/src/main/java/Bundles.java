import java.util.ArrayList;
import java.util.List;

public abstract class Bundles {
   protected List<Chocolates> chocolates = new ArrayList<Chocolates>();

    public Bundles(){
        createBundle();
    }

    protected abstract void createBundle();

    @Override
    public String toString() {
        return "bundles{" +"chocolates" +chocolates+ "}";
    }
}
