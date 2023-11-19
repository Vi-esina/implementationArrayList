import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(112);
        integerMyArrayList.add(4);
        integerMyArrayList.add(543);
        integerMyArrayList.add(-1);
        integerMyArrayList.showToString();
        integerMyArrayList.add(0, 10);
        integerMyArrayList.showToString();
        integerMyArrayList.remove(3);
        integerMyArrayList.showToString();
        MyArrayList<Integer> integerMyArrayList1 = new MyArrayList<>();
        integerMyArrayList.add(5);
        integerMyArrayList.add(156);
        integerMyArrayList.addAll(integerMyArrayList1);
        integerMyArrayList.showToString();
        integerMyArrayList.remove((Integer) 112);
        integerMyArrayList.showToString();

        Comparator<Integer> comparator = Comparator.naturalOrder();
        integerMyArrayList.sort(comparator);
        integerMyArrayList.showToString();
    }
}



