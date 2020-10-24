public class Array3 {
    public static void main(String[] args) {
        int x = 10;
        int[] v1 = new int[3];
        v1[0]=1; v1[1]=3; v1[2]=5;
        m1(10); m2(v1); m2(new int[5]);
    }
    public static void m2(int[] a) {

    }
    public static void m1(int a) {
        System.out.println(a);
    }
}
