class Boxes2<T> {
    private T ob;

    public void set(T o) {
        ob=o;
    }
    public T get() {
        return ob;
    }
}

class Unboxer {
    public static <T> T openBox(Boxes2<T> box) {
        return box.get();
    }
}

class GenericMethodBoxMaker2 {
    public static void main(String[] args) {
        Boxes2<String> box=new Boxes2<>();
        box.set("My generic method");

        String str=Unboxer.<String>openBox(box);
        System.out.println(str);
    }
}
