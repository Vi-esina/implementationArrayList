import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> integerMyArrayList= new MyArrayList<>();
        integerMyArrayList.add(12);
        integerMyArrayList.add(13);
        integerMyArrayList.add(14);
        integerMyArrayList.showToString();
        integerMyArrayList.add(0,10);
        integerMyArrayList.showToString();
        integerMyArrayList.remove(1);
        integerMyArrayList.showToString();
        MyArrayList<Integer> integerMyArrayList1= new MyArrayList<>();
        integerMyArrayList.add(112);
        integerMyArrayList.add(113);
        integerMyArrayList.addAll(integerMyArrayList1);
        integerMyArrayList.showToString();
//integerMyArrayList.remove((Integer)13);
        integerMyArrayList.showToString();

    }
}