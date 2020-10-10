public class Test {
    public static void main(String[] args) {
        JavaStore js = new JavaStore();
        Tanaka tanaka = new Tanaka(200000);
        tanaka.buyLeagueOfLegend(js.gs.lol);
        tanaka.buyStarCraft(js.gs.sc);
        tanaka.buySubNautica(js.gs.sn);
        System.out.println("잔액 : "+tanaka.pocketMoney);
    }
}

class Tanaka {
    Tanaka(int m) {
        pocketMoney=m;
    }
    int pocketMoney;
    void buyLeagueOfLegend(LeagueOfLegend lol) {
        pocketMoney=pocketMoney-lol.price;
    }
    void buyStarCraft(StarCraft sc) {
        pocketMoney=pocketMoney-sc.price;
    }
    void buySubNautica(SubNautica sn) {
        pocketMoney=pocketMoney-sn.price;
    }
}

class JavaStore {
    JavaStore() {}
    GameStore gs=new GameStore();
}

class GameStore {
    GameStore() {}
    LeagueOfLegend lol=new LeagueOfLegend(10000);
    StarCraft sc=new StarCraft(9000);
    SubNautica sn=new SubNautica(11000);

}

class LeagueOfLegend {
    LeagueOfLegend(int p) {
        price=p;
    }
    int price;
}

class StarCraft {
    StarCraft(int p) {
        price=p;
    }
    int price;
}

class SubNautica {
    SubNautica(int p) {
        price=p;
    }
    int price;
}


//자바백화점이 있습니다.
//자바백화점에 가전매장과 의류매장과 과일매장이 있습니다.
/*
class JavaStore {//자바백화점
	JavaStore(){}
	ElectroMart em = new ElectroMart();
	ClothingMart cm = new ClothingMart();
	FruitsMart fm = new FruitsMart();
}
class ElectroMart {//가전매장
	ElectroMart(){}
	Computer c = new Computer(50000);
	TV t = new TV(80000);
}
class Computer {
	Computer(int p){ price = p;}
	int price;
}
class TV {
	TV(int p){price = p;}
	int price;
}
//가전매장에 컴퓨터와 TV가 있습니다.가격이 있습니다.
class ClothingMart {//의류매장
	ClothingMart(){}
	Jean j = new Jean(500); TShirt t = new TShirt(1000);
}
class Jean {//청바지
	Jean(int a){price = a;}
	int price;
}
class TShirt{
	int price;
	TShirt(int a){price = a;}
}
//의류매장에 청바지와 티셔츠가 있습니다. 가격이 있습니다.
class FruitsMart {//과일매장
	FruitsMart(){}
	Apple a = new Apple(500); Banana b=new Banana(300);
}
class Apple{
	int price;
	Apple(int a){price = a;}
}
class Banana {
	Banana(int a){price = a;}
	int price;
}
//과일매장에 사과와 바나나가 있습니다. 가격이 있습니다.
class Danaka {
	Danaka(int p){money = p;}
	int money;
	void buyComputer(Computer c) {
		money = money - c.price;
	}//컴퓨터를 구매하는 행위
	void buyBanana(Banana b) {
		money = money - b.price;
	}//바나나를 구매하는 행위
	void buyApple(Apple a) {
		money = money - a.price;
	}//사과를 구매하는 행위
	void buyJean(Jean j) {
		money = money - j.price;
	}//청바지를 구매하는 행위
}
//다나까가 있습니다. 용돈(20000)이 있습니다.
//다나까가 컴퓨터와 바나나를 구매했습니다.
//다나까가 사과와 청바지를 구매했습니다.
//다나까의 용돈 잔액을 출력합니다.
*/


















