class MobilePhone {
    protected String number;        //전화번호

    public MobilePhone(String num) {
        number=num;
    }
    public void answer() {
        System.out.println("Hi from "+number);
    }
}

class SmartPhone extends MobilePhone {
    private String androidVer;

    public SmartPhone(String num, String ver) {
        super(num);
        androidVer=ver;
    }
    public void playApp() {
        System.out.println("App is running in "+androidVer);
    }
}

class MobileSmartPhone {
    public static void main(String[] args) {
        SmartPhone phone=new SmartPhone("010-7168-4282", "RedVelvetCake");
        phone.answer();
        phone.playApp();
    }
}
