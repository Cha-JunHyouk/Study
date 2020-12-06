package senior;

import java.util.HashMap;

public class Lesson3 {
	//Map은 키와 데이터의 쌍으로만 저장된다.키:데이터 탐색을 위한 데이터
	//Map을 상속한 대표적인 클래스:HashMap
	//키는 중복이 되면 안된다. 데이터는 중복이 되도 된다.
	//Map도 CF이므로, 모든 형태의 데이터가 저장된다.
	//List,Set에 Generic을 적용해서 특정형태의 데이터만 저장할 수 있다.
	//Map도 특정형태의 데이터만 저장할 수 있다. 즉, Generic이 가능하다.
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("112328", 100);
		map.put(123, 3.14);
		map.put(1.1, "박길동");
		map.put('a', 'K');
		Object value = map.get(1.1);
		System.out.println("검색된 DATA:"+value);
		int count = map.size();
		System.out.println("저장된 데이터의 수:"+count);
		HashMap<Integer,String> map2 = new HashMap<Integer,String>();
		//키는 정수만가능, 데이터는 문자열만 가능
		map2.put(1, "축구"); map2.put(2, "야구");
		map2.put(3, "농구"); map2.put(4, "배구");
		String str = map2.get(3); System.out.println(str);
		boolean flag1 = map2.containsKey(5);
		//5라는 키가 있으면 true, 없으면 false
		System.out.println(flag1);
		boolean flag2 = map2.containsValue("테니스");
		//"테니스"라는 데이터가 있으면 true, 없으면 false
		System.out.println(flag2);
		boolean flag3 = map2.isEmpty();
		//map2가 비어있으면 true, 비어있지 않으면 false
		System.out.println(flag3);
		map2.clear();//map2를 깨끗하게 비운다.void 메서드
		int cnt = map2.size();//map2에 저장된 데이터의 수
		System.out.println(cnt);
	}
}







