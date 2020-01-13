 class Diamond {

     public static void main(String[] args) {
         int n = 10;
         int s = n - 1;

         for (int i = 0; i < n; i++) {
             for (int j = 0; j < s; j++)
                System.out.print(" ");
             for (int j = 0; j <= i; j++)
                 System.out.print("* ");
             System.out.print("\n"); 
             s--;
         }
         s = 0;
         for (int i = n; i > 0; i--) {
             for (int j = 0; j < s; j++)
                 System.out.print(" ");
             for (int j = 0; j < i; j++)
                 System.out.print("* ");
             System.out.print("\n");
             s++;
         }
     }
}
