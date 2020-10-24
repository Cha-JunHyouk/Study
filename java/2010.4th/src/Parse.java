public class Parse {
    public static void main(String[] args) {
        System.out.println("데이터의 수 : "+args.length);
        for(int index=0;index<args.length;index++) {
            System.out.println(args[index]);
        }
        System.out.println(args[0]+" "+args[1]+" "+args[2]);
        double d1=Double.parseDouble(args[0]);
        double d2=Double.parseDouble(args[1]);
        double d3=Double.parseDouble(args[2]);
        System.out.println(d1+d2+d3);
    }

}
