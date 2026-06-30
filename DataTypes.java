public class DataTypes {
    public static void main(String[] args) {
        byte b = 10;
        short s = 876;
        int i = 5764;
        long l = 234000;
        float f = 24.7f;
        double d = 20.99;
        char c = 'A';
        boolean bool = true;
        System.out.println("byte: " + Byte.BYTES);
        System.out.println("short: " + Short.BYTES);
        System.out.println("int: " + Integer.BYTES);
        System.out.println("long: " + Long.BYTES);
        System.out.println("float: " + Float.BYTES);
        System.out.println("double: " + Double.BYTES);
        System.out.println("char: " + Character.BYTES);
        //Usually byte size of boolean is 1 byte
    }
}