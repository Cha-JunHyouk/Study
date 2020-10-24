class Star{
    Star(){}
}
public class Array {
    public static void m1(int i) { i=5;	}//10에서5로바뀜
    public static void m2(Star[] a) {a[1]=new Star();}
    public static void main(String[] args) {
        int i = 10;
        m1(10); m1(i);
        Star[] abc = new Star[10];//abc에는 Star가 없다.
        abc[0] = new Star();//Star가 1개 있다.
        m2(abc);
        m2(new Star[10]);
    }

}

