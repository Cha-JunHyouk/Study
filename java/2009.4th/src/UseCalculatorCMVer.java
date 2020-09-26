class SC {
    static final double PI=3.1415;
    static double add(double n1, double n2) {
        return n1+n2;
    }
    static double min(double n1, double n2) {
        return n1-n2;
    }
    static double calCircleArea(double r) {
        return PI*r*r;
    }
    static double calCirclePeri(double r) {
        return PI*(r*2);
    }
}

class UC {
    public static void main(String[] args) {
        SC sc=new SC();
        System.out.println("3+4="+sc.add(3,4));
        System.out.println("반지름 2.2인 원의 넓이 : "+sc.calCircleArea(2.2));
        System.out.println("15-7="+sc.min(15,7));
        System.out.println("반지름 5.0인 원의 둘레 : "+sc.calCirclePeri(5.0));
    }
}
