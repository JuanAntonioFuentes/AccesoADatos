public class Ejemplo7 {
    public static void main(String[] args) {
        try {
            
        
        int a = 10;
        int b = 0;
        int c = 10/0;
        System.out.println(c);
        } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                
            }
    }
}
