class Person {
    String name;

    public Person(String name) {
        this.name=name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("destroyed :  "+name);
    }
}

class ObjectFinallize {
    public static void main(String[] args) {
        Person p1=new Person("Yoon");
        Person p2=new Person("Park");
        p1=null;            //reference object to garbage collection
        p2=null;            //reference object to garbage collection

        //System.gc();
        //System.renFinalization();

        System.out.println("end of line");
    }
}
