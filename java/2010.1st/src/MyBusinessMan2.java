class Man2 {
    String name;
    public Man2(String name) {
        this.name=name;
    }
    public void tellYourName() {
        System.out.println("My name is "+name);
    }
}

class BusinessMan2 extends Man2 {
    String company;
    String position;

    public BusinessMan2(String name, String company, String position) {
        super(name);
        this.company=company;
        this.position=position;
    }
    public void tellYourInfo () {
        System.out.println("My company is "+company);
        System.out.println("My position is "+position);
        tellYourName();
    }
}

class MyBusinessMan2 {
    public static void main(String[] args) {
        BusinessMan2 man= new BusinessMan2("Yoon", "Hybrid ELD", "Staff Eng");
        man.tellYourInfo();
    }
}
