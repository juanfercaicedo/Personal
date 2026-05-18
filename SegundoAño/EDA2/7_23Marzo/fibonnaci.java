// Ejemplo fibonnaci utilizando recursividad
public class fibonnaci {
    public static void main(String[] args) {
        fibo(1);
    }

    static long fibo(int n) {
        if(n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
