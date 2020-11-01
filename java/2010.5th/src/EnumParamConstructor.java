enum Person4 {
    MAN(29), WOMAN(25);

    int age;
    private Person4(int age) {
        this.age=age;
    }

    @Override
    public String toString() {
        return "I am "+age+" years old";
    }
}

public class EnumParamConstructor {
    public static void main(String[] args) {
        System.out.println(Person4.MAN);
        System.out.println(Person4.WOMAN);
    }
}
