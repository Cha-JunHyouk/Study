class Circle {
    double rad=0;                       //인스턴스 변수 선언과 동시에 초기화
    final double PI=3.14;

    public Circle(double r) {
        setRad(r);
    }

    public void setRad(double r) {
        if(r<0) {                       //rad에 0보다 작은 값이 저장되지 않도록 하겠다
            rad=0;
            return;                     //반지름이 0일시 실행을 그만두고 메소드 밖으로 빠져나감
        }
        rad=r;
    }

    public double getArea() {
        return (rad*rad)*PI;
    }
}

class UnsafeCircle {
    public static void main(String[] args) {
        Circle c=new Circle(1.5);
        System.out.println(c.getArea());

        c.setRad(2.5);
        System.out.println(c.getArea());
        c.setRad(-3.3);
        System.out.println(c.getArea());
        c.rad=-4.5;
        System.out.println(c.getArea());
    }
}
