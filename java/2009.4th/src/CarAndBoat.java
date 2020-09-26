class Car {
    void myCar() {
        System.out.println("This is my car.");
    }
}

class Boat {
    void myBoat() {
        System.out.println("This is my boat.");
    }
}

class Out {
    public static void main(String[] args) {
        Car c=new Car();
        Boat b=new Boat();
        c.myCar();
        b.myBoat();
    }
}
