class Circle3 {
    static final double PI=3.1415;      //변하지 않는 참조 목적의 값, 모든 Circle3 인스턴스가 참조해야 하는 값
    private double radius;

    Circle3(double rad) {       //생성자 생성 및 초기화
        radius=rad;
    }
    void showPerimeter() {
        double peri=(radius*2)*PI;
        System.out.println("둘레:"+peri);
    }
    void showArea() {
        double area=(radius*radius)*PI;
        System.out.println("넓이:"+area);
    }
}

class CircleConstPI {
    public static void main(String[] args) {
        Circle3 c=new Circle3(1.2);         //인스턴스 생성
        c.showPerimeter();
        c.showArea();
    }
}
