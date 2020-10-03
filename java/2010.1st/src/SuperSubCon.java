class SuperCLS {
    public SuperCLS() {     //생성자 정의
        System.out.println("I`m Super Class.");
    }
}

class SubCLS extends SuperCLS {
    public SubCLS() {       //생성자 정의
        System.out.println("I`m Sub Class.");
    }
}

class SuperSubCon {
    public static void main(String[] args) {
        new SubCLS();
    }
}
//하위 클래스의 인스턴스 생성시 상위 클래스, 하위 클래스의 생성자 모두 호출된다.
//하위 클래스의 인스턴스 생성시 상위 클래스의 생성자가 먼저 호출된다.