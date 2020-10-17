class Box2<T> {
    private T ob;

    public void set(T o) {
        ob=o;
    }
public T get() {
        return ob;
    }
}

class PrimitiveAndGeneric {
    public static void main(String[] args) {
        Box2<Integer> iBox=new Box2<Integer>();
        iBox.set(125);
        int num=iBox.get();
        System.out.println(num);
    }
}
