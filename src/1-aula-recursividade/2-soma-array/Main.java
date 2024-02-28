
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(sumArray(array, 5));
    }

    public static int sumArray(int[] array, int n) {
        if (n == 0) {
            return 0;
        }
        return sumArray(array, n - 1) + array[n - 1];
    }
}
