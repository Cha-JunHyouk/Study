import java.math.BigInteger;

class SoBigInteger {
    public static void main(String[] args) {
        //print max value which is able to print long
        System.out.println("최대 정수 : "+Long.MAX_VALUE);
        System.out.println("최소 정수 : "+Long.MIN_VALUE);
        System.out.println();

        //Represents a very large number of instances of BigInteger instance
        BigInteger big1=new BigInteger("10000000000000");
        BigInteger big2=new BigInteger("-9999999999999");

        //addition computation based on BigInteger
        BigInteger r1=big1.add(big2);
        System.out.println("덧셈 결과 : "+r1);

        //multiplication computation based on BigInteger
        BigInteger r2=big1.multiply(big2);
        System.out.println("곱셈 결과 : "+r2);
        System.out.println();

        //return value as integer which is saved in instance
        int num=r1.intValueExact();
        System.out.println("From BigInteger : "+num);
    }
}
