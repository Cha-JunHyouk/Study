class ExceptionMessage {
    public static void md1(int n) {
        md2(n,0);       //call bottom method
    }
    public static void md2(int n1, int n2) {
        int r=n1/n2;    //exception occured
    }
    public static void main(String[] args) {
        try {
            md1(3);
        } catch(Throwable e) {
            e.printStackTrace();
        }
        System.out.println("end of line");
    }
}
