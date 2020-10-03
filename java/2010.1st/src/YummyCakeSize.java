class Cake3 {
    public int size;
    public Cake3(int sz) {
        size=sz;
    }
    public void showCakeSize() {
        System.out.println("Bread Ounces : "+size);
    }
}

class CheeseCake3 extends Cake3 {
    public int size;
    public CheeseCake3(int sz1, int sz2) {
        super(sz1);
        size=sz2;
    }
    public void shoeCakeSize() {
        //super.size는 상위 클래스의 멤버 size를 의미함
        System.out.println("Bread ounces : "+super.size);
        System.out.println("Cheese Ounces : "+size);
    }
}

class YummyCakeSize {
    public static void main(String[] args) {
        CheeseCake3 ca1=new CheeseCake3(5, 7);
        Cake3 ca2=ca1;

        //ca2는 Cake3형이므로 ca2.size는 Cake3의 멤버 size를 의미함
        System.out.println("Bread Ounces : "+ca2.size);
        //ca1은 CheeseCake3형이므로 ca1.size는 CheeseCake3의 멤버 size를 의미함
        System.out.println("Cheese Ounces : "+ca1.size);
        System.out.println();

        ca1.shoeCakeSize();
        System.out.println();
        ca2.showCakeSize();
    }
}
