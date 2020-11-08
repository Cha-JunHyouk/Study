package javastudy;


class MyDraw implements Shape,Draw{
	public void doSome() {}
	public void doIt() {}
	public void doDo() {}
}

interface Show extends Draw, Shape{}
interface Draw {
	void doSome();
}
interface Shape {
	void doIt();
	void doDo();
}
public class Interface {
	public static void main(String[] args) {

	}
}



