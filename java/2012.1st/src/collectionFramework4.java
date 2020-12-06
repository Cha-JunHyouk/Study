package senior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Lesson4 {
//List와 Set에 저장된 데이터를 검색할 때 Iterator를 사용
//--> Iterator를 사용해서 데이터를 검색
//Map에서도 Iterator를 사용할 수 있다.
//--> 1. Iterator를 사용해서 키를 검색
//--> 2. Iterator를 사용해서 데이터를 검색
//--> 3. Iterator를 사용해서 키,데이터를 검색
//List와 Set은 iterator() 메서드를 사용해서 Iterator를 생성
//Map은 iterator()메서드가 없어서 직접 Iterator를 생성할 수 없다.
//직접 생성할 수 없으므로, 간접으로 생성한다.
	public static void main(String[] args) {
		ArrayList al = new ArrayList(); 
		Iterator i1 = al.iterator();
		HashSet hs = new HashSet();
		Iterator i2 = hs.iterator();
		HashMap hm = new HashMap();
//		hm.iterator();//안된다.
	}
}












