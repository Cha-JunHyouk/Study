class Boxes7<T> {
    private T ob;
    public void set(T o) {
        ob=o;
    }
    public T get() {
        return ob;
    }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class Unboxer3 {
    public static <T> T openBox(Boxes7<T> box) {
        return box.get();
    }

    //Generic method which is comfirm(print) contents of the box
    public static void peekBox(Boxes7<?> box) {
        System.out.println(box);
    }
}

class WildCardUnboxer {
    public static void main(String[] args) {
        Boxes7<String> box=new Boxes7<>();
        box.set("So Simple String");
        Unboxer3.peekBox(box);
    }
}
