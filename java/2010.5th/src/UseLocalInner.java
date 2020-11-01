interface Printable1 {
    void print();
}

class Papers1 {
    private String con;
    public Papers1(String s) {
        con=s;
    }
    public Printable1 getPrinter() {
        class Printer1 implements Printable1 {
            public void print() {
                System.out.println(con);
            }
        }
        return new Printer1();
    }
}

public class UseLocalInner {
    public static void main(String[] args) {
        Papers1 p=new Papers1("I`m so happy");
        Printable1 prn=p.getPrinter();
        prn.print();
    }
}
