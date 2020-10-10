interface Printabillity {
    public void print(String doc);
}

class SPrinterDriver implements Printabillity {
    @Override
    public void print(String doc) {
        System.out.println("From Samsung printer");
        System.out.println(doc);
    }
}

class LPrinterDriver implements Printabillity {
    @Override
    public void print(String doc) {
        System.out.println("From LG printer");
        System.out.println(doc);
    }
}

class PrinterDriver {
    public static void main(String[] args) {
        String myDoc="This is report about ...";

        Printabillity prn=new SPrinterDriver();
        prn.print(myDoc);

        prn=new LPrinterDriver();
        prn.print(myDoc);
    }
}
