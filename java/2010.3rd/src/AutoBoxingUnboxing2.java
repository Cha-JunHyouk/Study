class AutoBoxingUnboxing2 {
    public static void main(String[] args) {
        Integer num=10;
        num++;      //execute auto boxing/auto unboxing
        System.out.println(num);

        num+=3;     //execute auto boxing/auto unboxing
        System.out.println(num);

        int r=num+5;        //execute auto unboxing
        Integer rObj=num-5;         //execute auto unboxing
        System.out.println(r);
        System.out.println(rObj);
    }
}
