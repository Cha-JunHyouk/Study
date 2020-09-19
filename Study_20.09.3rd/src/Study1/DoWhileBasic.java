package Study1;

public class DoWhileBasic {//반복영역을 Do문으로 따로 뺀 형태. 실행 결과는 동일.
    public static void main(String[] args) {
        int num=0;

        do {//반복 영역
            System.out.println("I like Java"+num);
            num++;
        } while(num<5); //반복 조건
    }
}
