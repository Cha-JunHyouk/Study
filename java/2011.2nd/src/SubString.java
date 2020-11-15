public class SubString {
    public static void main(String[] args) {
        String st1="990925-1012999";
        String st2=st1.substring(0, 6);
        String st3=st1.substring(7, 14);
        String st4=st2.concat(st3);
        System.out.println(st4);

        String s1="991101-1010012";
        String s2=s1.substring(0, 6)+' '+s1.substring(7);
        System.out.println(s2);
    }
}
