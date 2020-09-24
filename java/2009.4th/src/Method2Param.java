public class Method2Param {
    public static void main(String[] args) {
        double myHeight=181;
        hiEveryone(12, 12.5);           //인자 12와 12.5 전달
        hiEveryone(13, myHeight);             //인자 13과 변수 myHeight에 저장된 값 전달
        byEveryone();               //전달 인자 없음
    }
    
    public static void hiEveryone(int age, double height) {     //매개변수의 선언이 둘 이상이 될 수 있음
        System.out.println("제 나이는 "+age+"세 입니다.");
        System.out.println("제 키는 "+height+"cm 입니다.");
    }
    
    public static void byEveryone() {       //값 전달 불필요시 생략 가능
        System.out.println("다음에 뵙겠습니다.");
    }
}
