package util;

import java.util.ArrayList;

public class MatjipExpert {
	public ArrayList<String> getNames(String town) {
		ArrayList<String> names = new ArrayList<String>();
		if(town.equals("JONGRO")) {//종로구를 선택한 경우
			names.add("종로 김밥"); names.add("단성사");
			names.add("태평루"); 
		}else if(town.equals("KANGNAM")) {//강남구를 선택한 경우
			names.add("강남 횟집"); names.add("만리장성");
			names.add("역삼 복집");
		}else if(town.equals("SONGPA")) {//송파구룰 선택한 경우
			names.add("소나무 숲"); names.add("송파 해장국");
		}else if(town.equals("KANGDONG")) {//강동구를 선택한 경우
			names.add("강동 일식"); names.add("강동 분식");
		}else if(town.equals("KANGBUK")) {//강북구를 선택한 경우
			names.add("대학 식당"); names.add("강북 일식");
			names.add("강북 파전");
		}
		return names;
	}
}
