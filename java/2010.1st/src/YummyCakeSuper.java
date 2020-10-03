class Cake2 {
    public void yummy() {
        System.out.println("Yummy cake");
    }
}

class CheeseCake2 extends Cake2 {
    public void yummy() {
        super.yummy();          //Cake의 yummy 메소드 호출
        System.out.println("Yummy cheese cake");
    }
    public void tasty() {
        super.yummy();          //Cake의 yummy 메소드 호출
        System.out.println("Yummy tasty cake");
    }
}

class YummyCakeSuper {
    public static void main(String[] args) {
        CheeseCake2 cake=new CheeseCake2();
        cake.yummy();
        cake.tasty();
    }
}
