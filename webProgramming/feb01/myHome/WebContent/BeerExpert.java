package util;

import java.util.ArrayList;

public class BeerExpert {
	public ArrayList<String> getBrands(String color){
		ArrayList<String> brands = new ArrayList<String>();
		if(color.equals("������")) {
			brands.add("OK Light"); brands.add("Budwiser");
		}else if(color.equals("Ȳ��")) {
			brands.add("Chorus"); brands.add("Stout");
		}else if(color.equals("��ο��")) {
			brands.add("Jack Daniel"); brands.add("KGB");
			brands.add("OB Larger");
		}else if(color.equals("����")) {
			brands.add("Gout Stout"); brands.add("Jail Pale Ale");
			brands.add("Black Jack");
		}
		return brands;
	}
}
