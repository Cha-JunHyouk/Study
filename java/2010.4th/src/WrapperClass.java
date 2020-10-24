public class WrapperClass {
    public static void m1(String[] a) {

    }
    public static void main(String[] a) {
        //메인 메서드의 매개변수의 데이터 형태는 문자열이므로
        //숫자(정수,실수), 문자하나(char) 등으로 처리할 수 없다.
        //그런데, 자바에서는 문자열을 정수, 문자열을 실수,
        //문자열을 문자하나 등으로 바꿔주는 객체를 제공하고 있다.
        //따라서, 이 객체를 사용하면 문자열로 되어있는 숫자를
        //정수 혹은 실수로 바꿔서 사용할 수 있다.
        //참고로, 이런 객체들을 "래퍼(wrapper) 클래스"라고 한다.

        System.out.println("입력된 데이터의 수:"+
                a.length);
        for(int index=0; index<a.length;index++) {
            System.out.println(a[index]);
        }
        //a[0] = "100"; a[1] = "200"; a[2] = "300";
        System.out.println(a[0] + a[1] + a[2]);
        //Integer.parseInt(문자열);
        int a1 = Integer.parseInt(a[0]);//"100" -> 100
        int a2 = Integer.parseInt(a[1]);//"200" -> 200
        int a3 = Integer.parseInt(a[2]);//"300" -> 300
        System.out.println(a1 + a2 + a3);
        m1(new String[3]);
        String[] b = {"1","2","3"};
        m1(b);
    }
}













