package cn.tuna.gof.flyWeight;

public class Main {
    private static  BigString[] bsarray = new BigString[1000];

    public static void main(String[] args) {
        System.out.println("共享时：");
        testAllocation(true);
        System.out.println("非共享时：");
        testAllocation(false);
    }
    public static void testAllocation(boolean shared){
        for (int i = 0; i < bsarray.length; i++) {
            bsarray[i] = new BigString("1212123",shared);
        }
        showMemory();
    }
    public static void showMemory(){
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用内存 = " + used);
    }
    /*public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs1 = new BigString(args[0],false);
        bs1.print();
        BigString bs2 = new BigString(args[0],true);
        bs2.print();
    }*/
}
