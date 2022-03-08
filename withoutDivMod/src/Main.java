public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int div = div(a, b);
        System.out.println(div);
        int mod = mod(a, b);
        System.out.println(mod);
    }

    public static int div(int a, int b) {
        int count = 0;
        for (int i = 1; i * b <= a; i++) {
            if (i * b == a) {
                count = i;
            } else {
                count = i;
            }

        }
        return count;
    }

    public static int mod(int a, int b) {
        int count = a - (div(a, b) * b);
        return count;
    }
}
