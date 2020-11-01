interface Printable2 {
    void print();
}

class Papers2 {
    private String con;
    public Papers2(String s) {
        con=s;
    }
    public Printable2 getPrinter() {
        return new Printable2() {
            public void print() {
                System.out.println(con);
            }
        };
    }
}

public class UseAnonymousInner {
    public static void main(String[] args) {
        Papers2 p=new Papers2("I`m so happy");
        Printable2 prn= p.getPrinter();
        prn.print();
    }
}
