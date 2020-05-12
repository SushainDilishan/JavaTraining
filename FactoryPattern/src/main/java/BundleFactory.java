public class BundleFactory  {
    public static Bundles createBundle(BundleCode bundleCode){

        switch (bundleCode){
            case BUDGET:
                return new BudgetBundle();
            case FAMILY:
                return new FamilyBundle();
            case VALENTINE:
                return new ValentineBundle();
            default:
                return null;
        }
    }
}
