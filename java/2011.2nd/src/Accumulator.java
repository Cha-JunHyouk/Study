public class Accumulator {
    public static void main(String[] args) {
        for(int index=0; index<10; index++) {
            Accumulator.add(index);
        }
        Accumulator.showResult();
    }
    static int sum=0;
    static void add(int a) {
        sum=sum+a;
    }
    static int showResult() {
        System.out.println("sum="+sum);
       return sum;
    }
}