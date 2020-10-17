class Boxes6<T> {
    private T ob;
    public void set(T o) {
        ob=o;
    }
    public T get() {
        return ob;
    }
}

class EmptyboxFactory {
    public static <T> Boxes6<T> makeBox() {     //Generic method
        Boxes6<T> box=new Boxes6<>();           //create box
        return box;                             //return created box
    }
}

class TargetTypes {
    public static void main(String[] args) {
        Boxes6<Integer> iBox=EmptyboxFactory.<Integer>makeBox();
        iBox.set(25);
        System.out.println(iBox.get());
    }
}
