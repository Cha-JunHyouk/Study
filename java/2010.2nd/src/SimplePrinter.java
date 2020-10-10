interface Printable5 {
    static void printLine(String str) {
        System.out.println(str);
    }
    default void print(String doc) {
        printLine(doc);         //interface의 static method 호출
    }
}

//interface Printable5에는 implement해야 할 method가 존재하지 않는다
class Printer5 implements Printable5 {}

class SimplePrinter {
    public static void main(String[] args) {
        String myDoc="This is a report about...";
        Printable5 prn=new Printer5();
        prn.print(myDoc);

        //interface의 static method 직접 호출
        Printable5.printLine("end of line");
    }
}
