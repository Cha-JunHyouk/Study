interface Printable3 {
    void print(String s);
}

class Printer3 implements Printable3 {
    public void print(String s) {
        System.out.println(s);
    }
}

public class Lambda1 {
    public static void main(String[] args) {
        Printable3 prn=new Printer3();
        prn.print("What is Lambda?");
    }
}
