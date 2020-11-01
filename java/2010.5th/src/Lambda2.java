interface Printable4 {
    void print(String s);
}

public class Lambda2 {
    public static void main(String[] args) {
        Printable4 prn=new Printable4() {
            public void print(String s) {
                System.out.println(s);
            }
        };
        prn.print("What is Lambda?");
    }
}
