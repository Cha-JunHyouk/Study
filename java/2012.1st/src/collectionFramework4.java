package senior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Lesson4 {
//List�� Set�� ����� �����͸� �˻��� �� Iterator�� ���
//--> Iterator�� ����ؼ� �����͸� �˻�
//Map������ Iterator�� ����� �� �ִ�.
//--> 1. Iterator�� ����ؼ� Ű�� �˻�
//--> 2. Iterator�� ����ؼ� �����͸� �˻�
//--> 3. Iterator�� ����ؼ� Ű,�����͸� �˻�
//List�� Set�� iterator() �޼��带 ����ؼ� Iterator�� ����
//Map�� iterator()�޼��尡 ��� ���� Iterator�� ������ �� ����.
//���� ������ �� �����Ƿ�, �������� �����Ѵ�.
	public static void main(String[] args) {
		ArrayList al = new ArrayList(); 
		Iterator i1 = al.iterator();
		HashSet hs = new HashSet();
		Iterator i2 = hs.iterator();
		HashMap hm = new HashMap();
//		hm.iterator();//�ȵȴ�.
	}
}












