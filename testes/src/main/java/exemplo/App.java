package exemplo;
/**
 * Hello world!
 *
 */
public class App 
{
    public static int calculaMult(int a, int b){
        int res = a * b;
        return res;
    }
    public static boolean comparaNumeros(double a, double b){
        return a > b;
    }
    public static boolean parouimpar(double numero){
        return numero%2==0;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
