class AccessWay {
    static int num=0;

    AccessWay() {           //생성자
        incrCnt();
    }
    void incrCnt() {
        num++;              //클래스 내부에서 이름을 통해 클래스 변수에 접근
    }
}

public class ClassVarAccess {
    public static void main(String[] args) {
        AccessWay way=new AccessWay();  //인스턴스 생성
        way.num++;          //클래스 외부에서 인스턴스의 이름을 통해 접근
        AccessWay.num++;    //클래스 외부에서 클래스의 이름을 통한 접근
        System.out.println("num="+AccessWay.num);
   }
}
