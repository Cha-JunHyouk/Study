package senior;

import java.util.HashMap;

public class Lesson3 {
	//Map�� Ű�� �������� �����θ� ����ȴ�.Ű:������ Ž���� ���� ������
	//Map�� ����� ��ǥ���� Ŭ����:HashMap
	//Ű�� �ߺ��� �Ǹ� �ȵȴ�. �����ʹ� �ߺ��� �ǵ� �ȴ�.
	//Map�� CF�̹Ƿ�, ��� ������ �����Ͱ� ����ȴ�.
	//List,Set�� Generic�� �����ؼ� Ư�������� �����͸� ������ �� �ִ�.
	//Map�� Ư�������� �����͸� ������ �� �ִ�. ��, Generic�� �����ϴ�.
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("112328", 100);
		map.put(123, 3.14);
		map.put(1.1, "�ڱ浿");
		map.put('a', 'K');
		Object value = map.get(1.1);
		System.out.println("�˻��� DATA:"+value);
		int count = map.size();
		System.out.println("����� �������� ��:"+count);
		HashMap<Integer,String> map2 = new HashMap<Integer,String>();
		//Ű�� ����������, �����ʹ� ���ڿ��� ����
		map2.put(1, "�౸"); map2.put(2, "�߱�");
		map2.put(3, "��"); map2.put(4, "�豸");
		String str = map2.get(3); System.out.println(str);
		boolean flag1 = map2.containsKey(5);
		//5��� Ű�� ������ true, ������ false
		System.out.println(flag1);
		boolean flag2 = map2.containsValue("�״Ͻ�");
		//"�״Ͻ�"��� �����Ͱ� ������ true, ������ false
		System.out.println(flag2);
		boolean flag3 = map2.isEmpty();
		//map2�� ��������� true, ������� ������ false
		System.out.println(flag3);
		map2.clear();//map2�� �����ϰ� ����.void �޼���
		int cnt = map2.size();//map2�� ����� �������� ��
		System.out.println(cnt);
	}
}







