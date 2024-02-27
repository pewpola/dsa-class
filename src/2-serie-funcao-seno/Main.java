public class Main {
    public static void main(String[] args) {
        System.out.println(seno(30, 1));
    }

    public static int somaBinaria(int[] v) {
        return somaBinaria(v, 0, v.length - 1);
    }

    public static int somaBinaria(int[]v, int l, int u) {
        if (l > u) {
            return 0;
        } else if (l == u) {
            return v[l];
        }
        int m = (l + u) / 2;
        return somaBinaria(v, l, m) + somaBinaria(v, m + 1, u);
    }

    public static double grausParaRadiano(double angulo) {
        return angulo * Math.PI / 180;
    }

    public static double seno(double angulo, int n) {
        double x = grausParaRadiano(angulo);
        return seno(x, n, 3, x);
    }

    private static double seno(double x, int n, int b, double t) {
        if (n == 1) {
            return x;
        }
        t = t * (x * x) / (b * (b-1)) * (- 1);
        return t + seno(x, n - 1, b + 2, t);
    }
    
    public static int fatorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fatorial(n - 1);
    }
}

