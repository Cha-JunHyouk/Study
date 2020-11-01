interface Printable5 {
    void print(String s);
}

public class Lambda3 {
    public static void main(String[] args) {
        Printable5 prn=(s)->{
            System.out.println(s);
        };
        prn.print("What is Lambda?");
    }
}
