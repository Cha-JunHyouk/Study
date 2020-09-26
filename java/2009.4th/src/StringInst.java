class StringInst {
    public static void showString(String str) {
        System.out.println(str);
        System.out.println(str.length());       //length로 문자열 글자 수 산출
    }

    public static void main(String[] args) {
        String str1=new String("The Simple String");
        String str2="The Best String.";

        System.out.println(str1);
        System.out.println(str1.length());      //length의 반환값을 인자로 전달
        System.out.println();                   //단순한 줄바꿈

        System.out.println(str2);
        System.out.println(str2.length());      //length의 반환값을 인자로 전달
        System.out.println();                   //단순한 줄바꿈

        showString("Funny String");             //String 인스턴스 생성 후에 메소드 호출
    }
}
