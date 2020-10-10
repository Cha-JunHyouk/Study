import java.util.Scanner;

class ExceptionCase3 {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        System.out.print("a/b...a? : ");        //입력오류 발생 가능
        int n1=kb.nextInt();
        System.out.print("a/b...b? : ");        //입력오류 발생 가능
        int n2=kb.nextInt();
        System.out.printf("%d/%d=%d \n", n1, n2, n1/n2);
        System.out.println("end of line");
    }
}
