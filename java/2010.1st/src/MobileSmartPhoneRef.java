class MobilePhone2{
    protected String number;

    public MobilePhone2(String num) {
        number=num;
    }
    public void answer() {
        System.out.println("Hi~ from "+number);
    }
}

class SmartPhone2 extends MobilePhone2 {
    private String androidVer;

    public SmartPhone2(String num, String ver) {
        super(num);
        androidVer=ver;
    }
    public void playApp() {
        System.out.println("App is running in "+androidVer);
    }
}

class MobileSmartPhoneRef {
    public static void main(String[] args) {
        SmartPhone2 ph1=new SmartPhone2("010-7168-4282", "RedVelvetCake");
        MobilePhone2 ph2=new SmartPhone2("010-1234-5678", "RedVelvetCake");

        ph1.answer();
        ph1.playApp();
        System.out.println();

        ph2.answer();
        //ph2.playApp();
    }
}
