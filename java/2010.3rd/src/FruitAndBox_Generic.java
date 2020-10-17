class Apples {
    public String toString() {
        return "I am an apple.";
    }
}

class Oranges {
    public String toString() {
        return "I am an orange.";
    }
}

class Boxes<T> {
    private T ob;

    public void set(T o) {
        ob=o;
    }
    public T get() {
        return ob;
    }
}

public class FruitAndBox_Generic {
    public static void main(String[] args) {
        Boxes<Apples> aBox=new Boxes<Apples>();
        Boxes<Oranges> oBox=new Boxes<Oranges>();

        aBox.set(new Apples());
        oBox.set(new Oranges());

        Apples ap=aBox.get();
        Oranges og=oBox.get();

        System.out.println(ap);
        System.out.println(og);
    }
}
