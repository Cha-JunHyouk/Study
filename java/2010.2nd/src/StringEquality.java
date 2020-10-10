class StringEquality {
    public static void main(String[] args) {
        String str1=new String("So Simple");
        String str2=new String("So Simple");

        //if~else sentence which is comparing reference object
        if(str1==str2) {
            System.out.println("str1, str2 has same reference object");
        } else {
            System.out.println("str1, str2 has different reference object");
        }

        //if~else sentence which is comparing two other instance
        if(str1.equals(str2)) {
            System.out.println("both of str1 and str2 has same contents");
        } else {
            System.out.println("both of str1 and str2 has different contents to other");
        }
    }
}
