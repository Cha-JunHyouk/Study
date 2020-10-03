public class ReturnStringBuilder {
    public static void main(String[] args) {
       StringBuilder stb1=new StringBuilder("123");
       StringBuilder stb2=new StringBuilder(45678);

       System.out.println(stb1.toString());
       System.out.println(stb2.toString());

       //인덱스 0~4까지의 문자 삭제
        stb2.delete(0,5);

        System.out.println(stb1.toString());
        System.out.println(stb2.toString());

        //참조 값의 비교
        if(stb1==stb2) {
            System.out.println("같은 인스턴스 참조");
        } else {
            System.out.println("다른 인스턴스 참조");
        }
    }
}
