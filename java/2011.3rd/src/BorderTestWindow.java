import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class BorderTestWindow extends JFrame {
	JPanel[] pans = new JPanel[9]; Font font;
	JLabel[] lbls = new JLabel[9];
	public BorderTestWindow(String str) {
		super(str);
		font = new Font("돋움체",Font.BOLD, 30);
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel((i+1)+"번 패널입니다.");
			lbls[i].setFont(font);//폰트 적용
		}//레이블 8개 생성
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			pans[i].add(lbls[i]);//패널에 레이블을 붙임
		}//패널 8개 생성(패널에 경계선을 적용할 예정)
		//테두리가 없는 경계선(Border)객체
		EmptyBorder b1 = new EmptyBorder(5,3,5,3);
		//5:위쪽여백,3:왼쪽여백,5:아래여백,3:오른쪽여백
		pans[0].setBorder(b1);//첫번째 패널에 경계선설정
		//테두리선과 색깔있는 경계선 객체
		LineBorder b2 = new LineBorder(Color.RED, 3);
		//적색, 두께 3
		pans[1].setBorder(b2);//두번째 패널에 경계선설정
		//홈이 파여 있는 경계선 객체
		EtchedBorder b3 = new EtchedBorder();
		pans[2].setBorder(b3);//세번째 패널에 경계선설정
		//튀어나오는 느낌의 경계선 객체
		BevelBorder b4 = new BevelBorder(
				BevelBorder.RAISED);
		pans[3].setBorder(b4);//네번째 패널에 경계선설정
		//들어간 느낌의 경계선 객체
		SoftBevelBorder b5 = new SoftBevelBorder(
				SoftBevelBorder.LOWERED);
		pans[4].setBorder(b5);//다섯번째 패널에 경계선설정
		//테두리의 각방향의 크기를 설정하는 경계선 객체
		MatteBorder b6 = new MatteBorder(5,10,15,20,
				Color.CYAN);
		//5:위두께,10:왼쪽두께,15:아래두께,20:오른쪽두께
		pans[5].setBorder(b6);//여섯번째패널에 경계선설정
		//제목을 넣을 수 있는 경계선 객체
		TitledBorder b7 = new TitledBorder("제목");
		pans[6].setBorder(b7);
		//제목의 위치를 바꿀 수 있다.
		TitledBorder b8 = new TitledBorder(
			new EtchedBorder(), "제목", 
			TitledBorder.RIGHT, TitledBorder.TOP,
			new Font("궁서체",Font.BOLD,12),
			Color.BLUE);
		pans[7].setBorder(b8);
		//경계선을 섞어서 나타낼수 있는 경계선객체
		//섞을 경계선을 만든다. 최소 두 개
		SoftBevelBorder sbb = new SoftBevelBorder(
				SoftBevelBorder.RAISED);
		TitledBorder tb = new TitledBorder("제목");
		CompoundBorder b9 = new CompoundBorder(sbb,tb);
		//제목보더와 들어간느낌의 보더를 섞음
		pans[8].setBorder(b9);
		
		JPanel center = new JPanel();
		for(int i=0; i<=8; i++) {
			center.add(pans[i]);
		}
		this.add("Center",center); 
		this.setSize(500, 300); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BorderTestWindow("다양한 경계선 ver1.0");
	}

}












