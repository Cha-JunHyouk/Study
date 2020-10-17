class Box6<T> {
    private T ob;

    public void set(T o) {
        ob=o;
    }
    public T get() {
        return ob;
    }
}

class BoxFactory {
    public static <T> Box6<T> makeBox(T o) {
        Box6<T> box=new Box6<T>();
        box.set(o);
        return box;
    }
}

class GenericMethodBoxMaker {
    public static void main(String[] args) {
        Box6<String> sBox=BoxFactory.makeBox("Sweet");
        System.out.println(sBox.get());

        Box6<Double> dBox=BoxFactory.makeBox(7.59);
        System.out.println(dBox.get());
    }
}
