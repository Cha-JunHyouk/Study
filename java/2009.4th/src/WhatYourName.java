
class WhatYourName {
    static class AAA {
        public void showname() {
            System.out.println("My name is AAA");
        }
    }

    static class ZZZ {
        public void showname() {
            System.out.println("My name is ZZZ");
        }

        public static void main(String[] args) {
            AAA aaa = new AAA();          //인스턴스 생성
            aaa.showname();             //초기화 코드

            ZZZ zzz = new ZZZ();          //인스턴스 생성
            zzz.showname();             //초기화 코드
        }
    }
}