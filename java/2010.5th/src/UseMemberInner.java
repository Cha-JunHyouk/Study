interface Printable {
    void print();
}

class Papers {
    private String con;
    public Papers(String s) {
        con=s;
    }
    public Printable getPrinter() {
        return new Printer();
    }

    private class Printer implements Printable {
        public void print() {
            System.out.println(con);
        }
    }
}

public class UseMemberInner {
    public static void main(String[] args) {
        Papers p=new Papers("I`m so happy");
        Printable prn=p.getPrinter();
        prn.print();
    }
}
