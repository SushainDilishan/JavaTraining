public class RethrowExample {
    public static void main(String[] args) {
        try {
            String string = args[0];
            System.out.println(string);
        }catch (ArrayIndexOutOfBoundsException e){

            System.out.println("Logging ArrayIndexoutofindexbound exception");
            throw e;
        }
    }
}
