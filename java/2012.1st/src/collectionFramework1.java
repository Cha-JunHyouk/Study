package senior;

import java.util.ArrayList;
import java.util.HashSet;

public class Lesson1 {
//List,Set
//ArrayList,LinkedList : List
//HashSet, TreeSet, LinkedHashSet : Set
//������� �����͵� ������ �ȴ�. ���̸� ���� ������ �ȴ�.
//Ư�������� �����͸� �����ϰ� �ʹ�.
	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();
		al1.add(100); al1.add(3.14); al1.add("KOREA"); al1.add('A');
		al1.add(true); al1.add(new Car()); al1.add(new Taxi());
		int count = al1.size();
		System.out.println(count);
		//1.Car�� ����Ǵ� ArrayList
		ArrayList<Car> al2 = new ArrayList<Car>();//Car�� �����
		al2.add(new Car()); al2.add(new Car());
		ArrayList<Taxi> al3 = new ArrayList<Taxi>();//Taxi�� �����
		al3.add(new Taxi()); al3.add(new Taxi());
		//Ư�������� �����͸� ����ǵ��� CF�� �����ϴ� ���:Generic
		//CF ��������� �����Ͱ� ����ȴ�. ��, ��ü�� �����ϴ�.
		//�⺻�� ������ ----> ��ü�� ������ (����Ŭ����)
		Integer i1 = new Integer(100);
		al1.add(i1); al1.add(100);//�⺻��->��ü�� �ڵ���ȯ(����ڽ�)
//		ArrayList<int> al4 = new ArrayList<int>();
		ArrayList<Integer> al4 = new ArrayList<Integer>();
		al4.add(100); al4.add(80); al4.add(new Integer(70));
		ArrayList<Double> al5 = new ArrayList<Double>();
		al5.add(3.14); al5.add(1.11);
		HashSet<Car> hs1 = new HashSet<Car>();
		Car car = new Car();
		hs1.add(car); hs1.add(new Car()); hs1.add(car);
	}
}
class Car{}
class Taxi{}









