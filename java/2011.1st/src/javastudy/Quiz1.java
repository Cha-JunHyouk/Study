package senior;

public class Quiz1 {
	public static void main(String[] args) {
		Sales sales = new Sales();//������ ����
		Software soft = new Software();//���ߺ� ����
		Sasaki sasaki = new Sasaki("���Ű");
		Inowoe inowoe = new Inowoe("�̳�쿡");
		sasaki.doSum(soft.workers);
		inowoe.doSum(sales.workers);
	}
}
class Sales {
	Worker[] workers;
	Worker[] worker_ = {new Ito("����"),
			new Danaka("�ٳ���"),
			new Nakamura("�����")};
	Sales(){
		workers = new Worker[3];
		for(int i=0; i<workers.length; i++) {
			workers[i] = worker_[i];
			workers[i].get();//���� ����
		}
	}
}
class Software{
	Worker[] workers;
	Worker[] worker_ = {new Yamamoto("�߸ϸ���"),
			new Gobayasi("��پ߽�"),
			new Yosida("��ô�")};
	Software(){
		workers = new Worker[3];
		for(int i=0; i<workers.length; i++) {
			workers[i] = worker_[i];
			workers[i].get();//���� ����
		}
	}
}
class Yamamoto extends Worker{
	Yamamoto(String name){ super(name);}
}
class Gobayasi extends Worker{
	Gobayasi(String name){super(name);}
}
class Yosida extends Worker{
	Yosida(String a){super(a);}
}
class Nakamura extends Worker{
	Nakamura(String name){super(name);}
}
class Danaka extends Worker{
	Danaka(String name){super(name);}
}
class Ito extends Worker{
	Ito(String name){super(name);}
}
class Worker {
	int salary;
	String name;
	Worker(String name){
		this.name = name;
	}
	void get() {//���޼��� ����
		salary = (int)(Math.random()*6+5);
	}
}
class Sasaki extends Manager{
	Sasaki(String name){super(name);}
	@Override
	void doSum(Worker[] w) {
		int total = 0;
		for(int i=0; i<w.length; i++) {
			total=total + w[i].salary;
		}
		System.out.println("���ߺ� ��:"+total);
	}
}
abstract class Manager {
	String name;
	Manager(String name){this.name = name;}
	abstract void doSum(Worker[] w);
}
class Inowoe extends Manager{
	Inowoe(String name){super(name);}
	void doSum(Worker[] w) {
		int total = 0;
		for(int i=0; i<w.length; i++) {
			total=total + w[i].salary;
		}
		System.out.println("������ ��:"+total);
	}
}















