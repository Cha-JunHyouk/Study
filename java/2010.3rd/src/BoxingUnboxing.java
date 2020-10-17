class BoxingUnboxing {
    public static void main(String[] args) {
        Integer iObj=new Integer(10);       //boxing
        Double dObj=new Double(3.14);       //boxing
        System.out.println(iObj);
        System.out.println(dObj);
        System.out.println();

        int num1=iObj.intValue();               //unboxing
        double num2=dObj.doubleValue();         //unboxing
        System.out.println(num1);
        System.out.println(num2);
        System.out.println();
        //way to increase wrapper instance value
        iObj=new Integer(iObj.intValue()+10);
        dObj=new Double(dObj.doubleValue()+1.2);
        System.out.println(iObj);
        System.out.println(dObj);
    }
}
