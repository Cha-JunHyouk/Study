public class ReculFactorial {
    public static void main(String[] args) {
        System.out.println("3 factorial:"+factorial(3));
        System.out.println("12 factorial:"+factorial(12));
    }

    public static int factorial(int n) {
        if(n==1)                            //n이 1이면 1 반환
            return 1;
        else                                //1이 아닐 시 n * (n-1)! 하여 값을 반환
            return n*factorial(n-1);
    }
}
//메소드가 호출되면 해당 메소드의 사본이 생성되어 실행된다고 생각하자
