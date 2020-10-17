import java.util.Arrays;

class ArraySort {
    public static void main(String[] args) {
        int[] ar1={1, 2, 3, 4, 5};
        double[] ar2={1.1, 2.2, 3.3, 4.4, 5.5};
        Arrays.sort(ar1);
        Arrays.sort(ar2);

        for(int n:ar1) {
            System.out.print(n+"\t");
        }
        System.out.println();

        for(double d:ar2) {
            System.out.print(d+"\t");
        }
        System.out.println();
    }
}
