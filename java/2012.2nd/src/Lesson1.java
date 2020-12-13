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
//1.Thread��� �̸��� Ŭ������ ����Ѵ�. 
class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.print("+");
		}
	}
}
//2.Runnable�̸��� �������̽��� ����Ѵ�.
class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.print("-");
		}
	}
}













