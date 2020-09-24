public class Iftest {
    public static void main(String[] args) {
        maxOfThree(3,61,9);
    }

    public m1(int first, int second, int third) {
        this.first=Iftest.maxOfThree();
        this.second=second;
        this.third=third;
    }

    public static int maxOfThree(int first, int second, int third) {
        int result;
        if(first==second&&second==third) {
            result=1;
        } else if(first>second&&first>third) {
            result=2;
        } else if(second>first&&second>third) {
            result=3;
        } else {
            result=4;
        }
        return result;
    }

    public int getResult() {
        return result;
    }

    public static void printResult() {
        switch(Iftest.maxOfThree(Iftest.maxOfThree())) {
            case1:
            System.out.println("Error:Same number");
            case2:
            System.out.println(Iftest.maxOfThree() + " is largest number");
            case3:
            System.out.println(second + " is largest number");
            case4:
            System.out.println(third + " is largest number");
        }
    }
}
