package threadError;

class TestThread implements Runnable {
    int instanceV=0;    //instance variable
    public void run() {
        int localV=0;   //local variable
        while(localV<3) {
            System.out.println("local variable : "+ ++localV);   //increase local variable
            System.out.println("instance variable : "+ ++instanceV);    //increase instance variable
            System.out.println();
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        TestThread tt=new TestThread();
        Thread t1=new Thread(tt);       //make two thread from one method
        Thread t2=new Thread(tt);
        t1.start();
        t2.start();
    }
}
//결과 다르게 나옴. 향후 확인해볼것.