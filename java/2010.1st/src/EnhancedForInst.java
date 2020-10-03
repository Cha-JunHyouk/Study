class Box4 {
    private String contents;
    private int boxNum;

    Box4(int num, String cont) {
        boxNum=num;
        contents=cont;
    }
    public int getBoxNum() {
        return boxNum;
    }
    public String toString() {
        return contents;
    }
}

class EnhancedForInst {
    public static void main(String[] args) {
        Box4[] ar=new Box4[5];
        ar[0]=new Box4(101,"Coffee");
        ar[1]=new Box4(202,"Computer");
        ar[2]=new Box4(303, "Apple");
        ar[3]=new Box4(404,"Dress");
        ar[4]=new Box4(505,"Fairy-tale book");

        //배열에서 번호가 505인 Box를 찾아 그 내용물을 출력하는 반복문
        for(Box4 e:ar) {
            if(e.getBoxNum()==505) {
                System.out.println(e);
            }
        }
    }
}
