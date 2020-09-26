//this는 오버로딩 된 다른 생성자를 의미함
class SimpleBox {
    private int data;
    SimpleBox(int data) {
        this.data=data;             //this가 붙었으므로 매개변수가 아닌 인스턴스 변수를 의미함
    }
    void setData(int data) {
        this.data=data;
    }
    int getData() {
        return this.data;
    }
}

class ThisInst {
    public static void main(String[] args) {
        SimpleBox box=new SimpleBox(99);
        System.out.println(box.getData());
        box.setData(77);
        System.out.println(box.getData());
    }
}
