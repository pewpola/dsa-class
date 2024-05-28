package overflow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        char c = sc.next().charAt(0);
        int q = sc.nextInt();

        System.out.println(overflow(n, c, p, q));
        sc.close();
    }

    public static String overflow(int n, char c, int p, int q) {
        int s = p + q;
        int m = p * q;

        if (c == '+' && s <= n) {
            return "OK";
        } else if (c == '+' && s > n) {
            return "OVERFLOW";
        } else if (c == '*' && m <= n) {
            return "OK";
        } else {
            return "OVERFLOW";
        }
    }
}
