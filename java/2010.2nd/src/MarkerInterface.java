interface Upper {}
interface Lower {}

interface Printable7{
    String getContents();
}

class Report implements Printable7, Upper {      //
    String cons;

    Report(String cons) {
        this.cons=cons;
    }
    public String getContents() {
        return cons;
    }
}

class Printer2 {
    public void printContents(Printable7 doc) {
        if(doc instanceof Upper) {
            System.out.println((doc.getContents()).toUpperCase());
        } else if(doc instanceof Lower) {
            System.out.println((doc.getContents()).toLowerCase());
        } else {
            System.out.println(doc.getContents());
        }
    }
}

class MarkerInterface {
    public static void main(String[] args) {
        Printer2 prn=new Printer2();
        Report doc=new Report("Simple Funny News");
        prn.printContents(doc);
    }
}
