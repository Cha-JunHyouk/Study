class SimpleMathUse {
    public static void main(String[] args) {
        System.out.println("원주율 : "+Math.PI);
        System.out.println("2의 제곱근 : "+Math.sqrt(2));
        System.out.println();
        System.out.println("파이에 대한 Degree : "+Math.toDegrees(Math.PI));
        System.out.println("2 파이에 대한 Degree : "+Math.toDegrees(2.0*Math.PI));
        System.out.println();

        double radian45=Math.toRadians(45);         //convert to radian
        System.out.println("sin45 : "+Math.sin(radian45));
        System.out.println("cos45 : "+Math.cos(radian45));
        System.out.println("tan45 : "+Math.tan(radian45));
        System.out.println();
        System.out.println("log45 : "+Math.log(25));
        System.out.println("2^16 : "+Math.pow(2, 16));
    }
}
