package Study1;

public class SwitchBreak {
    public static void main (String[] args) {
        int n=3;
//break문은 들어간 시점에서 switch문 밖으로 빠져나가게 된다.
// 부분적으로 else if문 대체 가능
        switch(n)
        {
            case 1:
                System.out.println("Simple Java");
                break;
            case 2:
                System.out.println("Funny Java");
                break;
            case 3:
                System.out.println("Fantastic Java");
                break;
            default:
                System.out.println("The best programming language");
        }

        System.out.println("Do you like Java?");
    }
}
