class UseWrapperClass {
    public static void showData(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        Integer iInst=new Integer(3);       //create wrapper class which is wrapping Integer 3
        showData(iInst);
        showData(new Double(7.15));         //create and send wrapper class which is wrapping real number 7.15
    }
}
