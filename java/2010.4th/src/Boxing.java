class Box {
    Box(){}
}

public class Boxing {
    public static int a() {return 100;}
    public static char b() {return 'A';}
    public static double c() {return 1.23;}
    public static String d() {return "ABC";}
    public static Box e() {return new Box();}
    public static String[] f() {
//		String[] a = new String[3];
        String[] a = {"A","AB","ABC"};
        return a;
    }
    public static Box[] g() {
//		Box[] b = new Box[5];
        Box[] b = {new Box(),new Box(),new Box()};
        return b;
    }
    public static void main(String[] args) {
        int a = a(); char b = b(); double c = c();
        String d = d(); Box e = e();
        String[] f = f(); Box[] g = g();
    }
}
