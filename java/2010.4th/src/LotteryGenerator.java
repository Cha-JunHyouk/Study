public class LotteryGenerator {
    public static void main(String[] args) {
        LottoGenerator lg=new LottoGenerator();
        lg.init();
        lg.shuffleNumber();
        lg.output();
    }
}

class LottoGenerator{
    LottoGenerator() {}
    int[] box=new int[45];
    void output( ) {
        for(int index=0;index<6;index++) {
            System.out.println(box[index]+" ");
        }
        System.out.println();
    }
    void shuffleNumber() {
        for(int index=0;index<100;index++) {
            int randomNumber=(int)(Math.random()*45);
            int space=-1;
            space=box[0];
            box[0]=box[randomNumber];
            box[randomNumber]=space;
        }
    }
    void init() {
        for(int index=0;index<45;index++) {
            box[index]=index+1;
        }
    }
}

