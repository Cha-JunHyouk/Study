class Cake {
    public void yummy() {
        System.out.println("Yummy cake");
    }
}

class CheeseCake extends Cake {
    public void yummy() {       //Cake의 yummy 메소드를 오버라이딩 함
        System.out.println("Yummy cheese cake");
    }
}

class YummyCakeOverriding {
    public static void main(String[] args) {
        Cake c1=new CheeseCake();
        CheeseCake c2=new CheeseCake();

        c1.yummy();
        c2.yummy();
    }
}
