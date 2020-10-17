class Boxes3<T> {
    private T ob;

    public void set(T o) {
        ob=o;
    }
    public T get() {
        return ob;
    }
}

class BoxFactory2 {
    public static <T extends Number> Boxes3<T> makeBox(T o) {
        Boxes3<T> box=new Boxes3<T>();
        box.set(o);

        System.out.println("Boxed data : "+o.intValue());
        return box;
    }
}

class Unboxer2 {
    public static <T extends Number> T openBox(Boxes3<T> box) {
        System.out.println("Unboxed data : "+box.get().intValue());
        return box.get();
    }
}

class BoundedGenericMethod {
    public static void main(String[] args) {
        Boxes3<Integer> sBox=BoxFactory2.makeBox(new Integer(5959));
        int n=Unboxer2.openBox(sBox);
        System.out.println("Returned data : "+n);
    }
}
