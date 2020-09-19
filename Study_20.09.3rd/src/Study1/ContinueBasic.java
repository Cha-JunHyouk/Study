package Study1;

public class ContinueBasic {
   public static void main(String[] args) {
       int num=0;
       int count=0;

       while((num++)<100) {
           if(((num%5)!=0)||((num%7)!=0))
               continue;                    //5와 7의 배수가 아니면 건너뒤고 위로 이동
           count++;
           System.out.println(num);         //5와 7의 배수인 경우에만 실핼
       }
       System.out.println("count:"+count);
   }
}
