import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b, n;

        b = sc.nextInt();
        n = sc.nextInt();

        System.out.println(exponencial(b, n));

        sc.close();
    }

    public static int exponencial(int b, int n) {
        if (n == 0) {
            return 1;
        }
        return b * exponencial(b, n - 1);
    }
}