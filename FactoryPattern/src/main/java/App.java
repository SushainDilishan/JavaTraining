public class App {
    public static void main(String[] args) {

        Bundles bundles = BundleFactory.createBundle(BundleCode.BUDGET);
        System.out.println(bundles);


        Bundles bundles1 = BundleFactory.createBundle(BundleCode.VALENTINE);
        System.out.println(bundles1);
    }
}
