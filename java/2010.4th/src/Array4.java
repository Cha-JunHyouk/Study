class Hero {
    Hero(){}
    String name="영웅";
}

public class Array4 {
    public static void main(String[] args) {
        //Hero 3개가 저장된 배열 생성
        Hero[] h = {new Hero(),new Hero(),new Hero()};
        //Hero[] s = new Here[3];
        int a = 10;
        showHere(a); showHere(10);
        showThere(new int[3]);
        int[] aa = {2,4,6};
        showThere(aa);
        showHero(new Hero[30]); showHero(h);
    }
    public static void showHero(Hero[] a) {

    }
    public static void showThere(int[] a) {

    }
    public static void showHere(int a) {

    }
}
