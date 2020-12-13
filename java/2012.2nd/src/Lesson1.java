package senior;

public class Lesson1 {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		
		MyThread2 mt2 = new MyThread2();
		Thread th = new Thread(mt2);
		th.start();
	}
}
//1.Thread라는 이름의 클래스를 상속한다. 
class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.print("+");
		}
	}
}
//2.Runnable이름의 인터페이스를 상속한다.
class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.print("-");
		}
	}
}













