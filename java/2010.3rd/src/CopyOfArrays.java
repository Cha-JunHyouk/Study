import java.util.Arrays;

class CopyOfArrays {
    public static void main(String[] args) {
        double[] arOrg={1.1, 2.2, 3.3, 4.4, 5.5};

        //copy all
        double[] arCpy1=Arrays.copyOf(arOrg, arOrg.length);

        //copy to third element
        double[] arCpy2=Arrays.copyOf(arOrg, 3);
    }
}
