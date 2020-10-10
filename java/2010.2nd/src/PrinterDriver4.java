interface Printable4 {
    void print(String doc);
    default void printCMYK(String doc) {}       //interface의 default method
}

class Prn737Drv implements Printable4 {
    @Override
    public void print(String doc) {
        System.out.println("From MD-737 printer");
        System.out.println(doc);
    }
}

class Prn908Drv implements Printable4 {
    @Override
    public void print(String doc) {
        System.out.println("From MD-908 black & white ver");
        System.out.println(doc);
    }

    public void printCMYK(String doc) {
        System.out.println("From MD-908 CMYK ver");
        System.out.println(doc);
    }
}

class PrinterDriver4 {
    public static void main(String[] args) {
        String myDoc="This is a report about...";
        Printable4 prn1=new Prn737Drv();
        prn1.print(myDoc);
        System.out.println();

        Printable4 prn2=new Prn908Drv();
        prn2.print(myDoc);
    }
}
