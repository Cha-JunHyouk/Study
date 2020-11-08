package senior;

public class Quiz1 {
	public static void main(String[] args) {
		Sales sales = new Sales();//영업부 생성
		Software soft = new Software();//개발부 생성
		Sasaki sasaki = new Sasaki("사사키");
		Inowoe inowoe = new Inowoe("이노우에");
		sasaki.doSum(soft.workers);
		inowoe.doSum(sales.workers);
	}
}
class Sales {
	Worker[] workers;
	Worker[] worker_ = {new Ito("이토"),
			new Danaka("다나까"),
			new Nakamura("나까무라")};
	Sales(){
		workers = new Worker[3];
		for(int i=0; i<workers.length; i++) {
			workers[i] = worker_[i];
			workers[i].get();//월급 수령
		}
	}
}
class Software{
	Worker[] workers;
	Worker[] worker_ = {new Yamamoto("야먀모토"),
			new Gobayasi("고바야시"),
			new Yosida("요시다")};
	Software(){
		workers = new Worker[3];
		for(int i=0; i<workers.length; i++) {
			workers[i] = worker_[i];
			workers[i].get();//월급 수령
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
	void get() {//월급수령 행위
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
		System.out.println("개발부 합:"+total);
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
		System.out.println("영업부 합:"+total);
	}
}















