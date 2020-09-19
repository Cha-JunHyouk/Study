package Study1;

public class SwitchBasic {
    public static void main (String[] args) {
        int n=3;
        //case, default는 레이블이라고 칭햔다.
        //case에 해당하는 부분이 없으면 default부터
        //레이블은 눈에 띄어야 하므로 들여쓰기 하지 않는다.
        switch(n) {
        case 1:
            System.out.println("Simple Java");
        case 2:
            System.out.println("Funny Java");
        case 3:
            System.out.println("Fantastic Java");
        default:
            System.out.println("The best programming language");
        }

        System.out.println("Do you like Java?");
    }
}
