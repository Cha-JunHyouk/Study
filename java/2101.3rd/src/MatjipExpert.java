package util;

import java.util.ArrayList;

public class MatjipExpert {
	public ArrayList<String> getNames(String town) {
		ArrayList<String> names = new ArrayList<String>();
		if(town.equals("JONGRO")) {//���α��� ������ ���
			names.add("���� ���"); names.add("�ܼ���");
			names.add("�����"); 
		}else if(town.equals("KANGNAM")) {//�������� ������ ���
			names.add("���� Ƚ��"); names.add("�����强");
			names.add("���� ����");
		}else if(town.equals("SONGPA")) {//���ı��� ������ ���
			names.add("�ҳ��� ��"); names.add("���� ���屹");
		}else if(town.equals("KANGDONG")) {//�������� ������ ���
			names.add("���� �Ͻ�"); names.add("���� �н�");
		}else if(town.equals("KANGBUK")) {//���ϱ��� ������ ���
			names.add("���� �Ĵ�"); names.add("���� �Ͻ�");
			names.add("���� ����");
		}
		return names;
	}
}
