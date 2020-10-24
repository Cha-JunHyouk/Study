public class ArrayAndBoxing {
    public static void main(String[] args) {
        Museum m = new Museum();
        //m에 들어있는 인스턴스의 갯수
        //Museum 1개, Sangja 10개, Sangja배열 1개
        //Diamond 55개, Diamond배열 10개, 총 77개
        Diamond[] d1 = m.method1();
        //첫번째 상자에 있는 다이아몬드10개로 바뀌는 메서드
        Diamond[] d2 = m.method2();
        //다섯번째 상자에 있는 다이아몬드5개로바뀌는 메서드
        Diamond[] d3 = m.method3();
        //열번째 상자에 있는 다이아몬드1개로 바뀌는 메서드
        System.out.println(d1.length+","+d2.length+
                ","+d3.length);
    }
}
class Museum{//박물관 객체
    Diamond[] method3() {
        return sangja[9].dias;//열번째 상자의 다이아배열
    }
    Diamond[] method2() {
        return sangja[4].dias;//다섯번째 상자의 다이아배열
    }
    Diamond[] method1(){
        return sangja[0].dias;//첫번째 상자의 다이아배열
    }
    Sangja[] sangja = new Sangja[10];
    int[] nums = {10,9,8,7,6,5,4,3,2,1};//다이아몬드갯수
    Museum(){
        for(int i=0; i<sangja.length; i++) {
            sangja[i] = new Sangja(nums[i]);
        }//10회 반복
    }
}
class Diamond{//다이아몬드 객체
    Diamond(){}
}
class Sangja {//상자 객체
    Diamond[] dias;
    Sangja(int num){
        dias = new Diamond[num];
        for(int i=0; i<dias.length; i++) {
            dias[i] = new Diamond();
        }
    }
}