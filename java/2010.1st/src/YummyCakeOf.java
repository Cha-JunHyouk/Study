class Cake4 {

}

class CheeseCake4 extends Cake4 {

}

class StrawberryCheeseCake4 extends CheeseCake4 {

}

class YummyCakeOf {
    public static void main(String[] args) {
        Cake4 cake=new StrawberryCheeseCake4();

        if(cake instanceof Cake4) {
            System.out.println("케익 인스턴스 or");
            System.out.println("케익 상속하는 인스턴스 \n");
        }
        if(cake instanceof CheeseCake4) {
            System.out.println("치즈케익 인스턴스 or");
            System.out.println("치즈케익 상속하는 인스턴스 \n");
        }
        if(cake instanceof StrawberryCheeseCake4) {
            System.out.println("딸기치즈케익 인스턴스 or");
            System.out.println("딸기치즈케익 상속하는 인스턴스 \n");
        }
    }
}
