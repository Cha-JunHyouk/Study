class AutoBoxingUnboxing {
    public static void main(String[] args) {
        Integer iObj=10;        //auto boxing
        Double dObj=3.14;       //auto boxing
        System.out.println(iObj);
        System.out.println(dObj);
        System.out.println();

        int num1=iObj;           //auto unboxing
        double num2=dObj;       //auto unboxing
        System.out.println(num1);
        System.out.println(num2);
    }
}
