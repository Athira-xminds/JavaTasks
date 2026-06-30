public class TypeCasting {

    public static void main(String[] args) {

        int a = 100000;
        float b = (float) a;
        byte c = (byte) a;
        long d = (long) a;
        double e = (double) a;
        System.out.println("Integer: " + a);
        System.out.println("Float: " + b);
        System.out.println("Byte: " + c);
        System.out.println("Long: " + d);
        System.out.println("Double: " + e);

        char char1 = 'A';
        int ascii_val = (int) char1;

        System.out.println(ascii_val);
    }
}
