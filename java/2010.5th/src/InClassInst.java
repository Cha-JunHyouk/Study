class Person2 {
    public static final Person2 MAN=new Person2();
    public static final Person2 WOMAN=new Person2();

    @Override
    public String toString() {
        return "I am a dog Person";
    }
}

public class InClassInst {
    public static void main(String[] args) {
        System.out.println(Person2.MAN);
        System.out.println(Person2.WOMAN);
    }
}
