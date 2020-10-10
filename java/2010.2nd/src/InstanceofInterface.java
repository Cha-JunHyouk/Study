interface Printable6 {
    void printLine(String str);
}

class SimplePrinter2 implements Printable6 {        //Printable6를 직접 구현함
    public void printLine(String str) {
        System.out.println(str);
    }
}

class MultiPrinter extends SimplePrinter2 {         //Printable6를 간접 구현함
    public void printLine(String str) {
        super.printLine("start of multi...");
        super.printLine(str);
        super.printLine("end of multi...");
    }
}

class InstanceofInterface {
    public static void main(String[] args) {
        Printable6 prn1=new SimplePrinter2();
        Printable6 prn2=new MultiPrinter();

        if(prn1 instanceof Printable6) {
            prn1.printLine("This is a simple printer.");
        }
        System.out.println();

        if(prn2 instanceof Printable6) {
            prn2.printLine("This is multiple printer.");
        }
    }
}
