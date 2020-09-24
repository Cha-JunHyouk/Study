package zoo;

class Duck {        //default로 선언되었으므로 동일 패키지 내에서만 인스턴스 생성 가능
    //빈 클래스
}

public class Cat {  //public으로 선언되었으므로 어디서든 인스턴스 생성 가능
    public void makeCat() {
        //Duck과 같은 패키지로 묶여있으니 Duck 인스턴스 생성 가능
        Duck quack=new Duck();
    }
}
