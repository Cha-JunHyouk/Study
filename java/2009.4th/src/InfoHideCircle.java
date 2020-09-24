class Circle2 {
    private double rad=0;           //class 내부에서만 접근 가능
    final double PI=3.14;

    public Circle2(double r) {
        setRad(r);
    }

    public void setRad(double r) {  //rad에 값을 저장
        if(r<0) {                   //세터. 인스턴스 변수의 값을 설정하는 용도로 정의된 method
            rad=0;
            return;
        }
        rad=r;
    }

    public double getRad() {        //rad에 저장된 값을 반환
        return rad;                 //게터. 인스턴스 변수의 값을 참조하는 용도로 정의된 method
    }

    public double getArea() {
        return (rad*rad)*PI;
    }
}

class InfoHideCircle {
    public static void main(String[] args) {
        Circle2 c=new Circle2(1.5);
        System.out.println("반지름:"+c.getRad());
        System.out.println("넓이:"+c.getArea()+"\n");

        c.setRad(3.4);
        System.out.println("반지름:"+c.getRad());
        System.out.println("넓이:"+c.getArea());
    }
}
