class Boxes4<T> {
    protected T ob;
    public void set(T o) {
        ob=o;
    }
    public T get() {
        return ob;
    }
}

class SteelBox<T> extends Boxes4<T> {
    public SteelBox(T o) {
        ob=o;
    }
}

class GenericInheritance {
    public static void main(String[] args) {
        Boxes4<Integer> iBox=new SteelBox<>(7959);
        Boxes4<String> sBox=new SteelBox<>("Simple");
        System.out.println(iBox.get());
        System.out.println(sBox.get());
    }
}
