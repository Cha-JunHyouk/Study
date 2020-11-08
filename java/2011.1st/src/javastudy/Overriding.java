package javastudy;

public class Overriding {
	public static void main(String[] args) {
		F15 f15 = new F15(); f15.shootMisile();
		JF15 jf15 = new JF15(); jf15.shootMisile();
	}
}

class JF15 implements Fighter {
	@Override
	public void shootMisile() {
		System.out.println(" ");
	}
}
class F15 implements Fighter{
	@Override
	public void shootMisile() {
		System.out.println(" ");
	}
}

interface Face {
	int abc = 200;
	void doIt();
}

class S15 implements Fighter {
	@Override
	public void shootMisile() {
		
	}
}
interface Fighter {
	final int abc = 200;//���
	abstract void shootMisile();
}
abstract class Ship{
	final double PI = 3.141592;
	int a = 100; String name = " ";
	void doIt() {System.out.println("doIt");}
	abstract void doDo();
}



















