package Study1;

public class Practice { //1부터 10까지의 곱의 결과를 출력하는 프로그램을 for문을 이용해서 작성해보자.
    public static void main(String[] args) {
        int a=1;
        for (int n=1; n<=10; n++)
        a*=n;
        System.out.println(a);
    }
}
