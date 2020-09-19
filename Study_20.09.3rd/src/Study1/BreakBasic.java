package Study1;

public class BreakBasic {   //break문은 반복문에서 빠져나갈때도 사용
    public static void main(String[] args) {
        int num=1;
        boolean search=false;   //search의 초기값은 false이나, 조건에 만족하는 첫 값을 찾을 경우 true로

        //처음 만나는 5의 배수이자 7의 배수인 수를 찾는 반복문
        while(num<100) {//5로 나누어 나머지가 0인 수와 7로 나누어 나머지가 0인 수를 동시에 만족하면 true
            if(((num%5)==0)&&((num%7)==0)) {
                search=true;
                break;      //while문 탈출
            }
            num++;
        }

        if(search)
            System.out.println("찾는 정수는 "+num+"입니다.");
        else
            System.out.println("5의 배수이자 7의 배수인 수를 찾지 못했습니다.");
    }
}
