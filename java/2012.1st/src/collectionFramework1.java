package senior;

import java.util.ArrayList;
import java.util.HashSet;

public class Lesson1 {
//List,Set
//ArrayList,LinkedList : List
//HashSet, TreeSet, LinkedHashSet : Set
//어떤형태의 데이터도 저장이 된다. 길이를 몰라도 저장이 된다.
//특정형태의 데이터만 저장하고 싶다.
	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();
		al1.add(100); al1.add(3.14); al1.add("KOREA"); al1.add('A');
		al1.add(true); al1.add(new Car()); al1.add(new Taxi());
		int count = al1.size();
		System.out.println(count);
		//1.Car만 저장되는 ArrayList
		ArrayList<Car> al2 = new ArrayList<Car>();//Car만 저장됨
		al2.add(new Car()); al2.add(new Car());
		ArrayList<Taxi> al3 = new ArrayList<Taxi>();//Taxi만 저장됨
		al3.add(new Taxi()); al3.add(new Taxi());
		//특정형태의 데이터만 저장되도록 CF를 선언하는 방법:Generic
		//CF 모든형태의 데이터가 저장된다. 단, 객체만 가능하다.
		//기본형 데이터 ----> 객체형 데이터 (래퍼클래스)
		Integer i1 = new Integer(100);
		al1.add(i1); al1.add(100);//기본형->객체형 자동변환(오토박싱)
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









