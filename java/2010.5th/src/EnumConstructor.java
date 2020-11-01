enum Person3 {
    MAN, WOMAN;

    private Person3() {
        System.out.println("Person constructor called");
    }

    @Override
    public String toString() {
        return "I am a Dog person";
    }
}

public class EnumConstructor {
    public static void main(String[] args) {
        System.out.println(Person3.MAN);
        System.out.println(Person3.WOMAN);
    }
}
