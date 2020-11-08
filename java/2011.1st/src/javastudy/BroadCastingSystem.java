package javastudy;
public class Lesson1 {
	public static void main(String[] args) {
		AbcSystem bs = new BbcSystem();
		bs.doDo();
		bs.doIt();
	}
}
class BbcSystem extends AbcSystem{
	void doIt() {
		System.out.println("BbcSystem");
	}
}
abstract class AbcSystem {
	int a = 100;
	void doDo() { int c = a + 10;}
	abstract void doIt();
}











