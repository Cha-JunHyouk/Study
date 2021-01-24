package util;

import java.util.ArrayList;

public class BeerExpert {
	public ArrayList<String> getBrands(String color){
		ArrayList<String> brands = new ArrayList<String>();
		if(color.equals("밝은색")) {
			brands.add("OK Light"); brands.add("Budwiser");
		}else if(color.equals("황색")) {
			brands.add("Chorus"); brands.add("Stout");
		}else if(color.equals("어두운색")) {
			brands.add("Jack Daniel"); brands.add("KGB");
			brands.add("OB Larger");
		}else if(color.equals("갈색")) {
			brands.add("Gout Stout"); brands.add("Jail Pale Ale");
			brands.add("Black Jack");
		}
		return brands;
	}
}
