class Cakes {
    //Object 메소드의 toString 메소드를 오버라이딩
    public String toString() {
        //Object 클래스의 toString 메소드를 호출하여 반환 결과 출력
        System.out.println(super.toString());
        return "My birthday Cake";
    }
}

class CheeseCakes extends Cakes {
    //Cake 클래스의 toString 메소드를 오버라이딩
    public String toString() {
        return "My birthday Cheese Cake";
    }
}

class OverridingToString {
    public static void main(String[] args) {
        Cakes c1=new Cakes();
        Cakes c2=new CheeseCakes();

        //c1이 참조하는 인스턴스의 toString 메소드 호출로 이어짐
        System.out.println(c1);
        System.out.println();
        
        //c2가 참조하는 인스턴스의 toString 메소드 호툴로 이어짐
        System.out.println(c2);
    }
}
