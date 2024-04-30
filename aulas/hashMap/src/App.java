public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(compression(hashCode("Elemento01")));
        System.out.println(compression(hashCode("Elemento10")));
    }

    public static int compression(int hashCode) {
        return hashCode % 17;
    }

    public static int hashCode(String key) {
        int hashCode = 0;
        int a = 5;

        for (int i = 0; i < key.length(); i++) {
            hashCode = hashCode << a | hashCode >>> (32 - a);
            hashCode += key.charAt(i);
        }

        return hashCode;
    }
}
