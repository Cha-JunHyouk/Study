package Study1;
//while은 조건에 만족하는 한 명령어를 반복실행함.
public class WhileBasic {
    public static void main(String[] args) {
        int num=0;

        while(num<5) { //num<5를 만족하면 반복실행, 반복조건
            System.out.println("I like Java"+num);      //반복영역
            num++;                                      //반복영역
        }
    }
}
