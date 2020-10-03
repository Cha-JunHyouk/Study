import java.awt.print.Paper;

class Boxes {
    public void simpleWrap() {
        System.out.println("Simple Wrapping");
    }
}

class PaperBoxes extends Boxes {
    public void paperWrap() {
        System.out.println("Paper Wrapping");
    }
}

class GoldPaperBoxes extends PaperBoxes {
    public void goldWrap() {
        System.out.println("Gold Wrapping");
    }
}

class Wrapping {
    public static void main(String[] args) {
        Boxes box1=new Boxes();
        PaperBoxes box2=new PaperBoxes();
        GoldPaperBoxes box3=new GoldPaperBoxes();

        wrapBox(box1);
        wrapBox(box2);
        wrapBox(box3);
    }
    public static void wrapBox(Boxes box) {
        if(box instanceof GoldPaperBoxes) {
            ((GoldPaperBoxes)box).goldWrap();       //형 변환 후 메소드 호출
        } else if(box instanceof PaperBoxes) {
            ((PaperBoxes)box).paperWrap();          //형 변환 후 메소드 호출
        } else {
            box.simpleWrap();
        }
    }
}
