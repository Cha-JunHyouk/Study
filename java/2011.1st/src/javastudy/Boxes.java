package javastudy;

final class SmallBox extends Box {}
class Box {
	void doSome() {
		System.out.println("doSome");
	}
	final void doDo() {
		System.out.println("doDo");
	}
	int a = 10;
	final int MAX = 20;
	void doIt() {
		a = 20;
	}
}

public class Boxes {
	public static void main(String[] args) {

	}
}
