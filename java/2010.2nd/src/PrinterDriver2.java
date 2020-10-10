interface Printable2 {
    void print(String doc);
}

class Prn204Drv implements Printable2 {
    @Override
    public void print(String doc) {
        System.out.println("From MD-204 printer");
        System.out.println(doc);
    }
}

class Prn731Drv implements Printable2 {
    @Override
    public void print(String doc) {
        System.out.println("From MD-731 printer");
        System.out.println(doc);
    }
}

class PrinterDriver2 {
    public static void main(String[] args) {
        String myDoc="This is a report about...";

        Printable2 prn=new Prn204Drv();
        prn.print(myDoc);
        System.out.println();

        prn=new Prn731Drv();
        prn.print(myDoc);
    }
}
