import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String x = "60";
        String y = "548";
        String z = "547";
        String w = "9";

        List<String> list = new ArrayList<>();
        list.add(y);
        list.add(x);
        list.add(z);
        list.add(w);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

//        (String a, String b) -> {
//            String ab = a + b;
//            String ba = b + a;
//
//            return ab.compareTo(ba) > 0 ? -1 : 1;
//        }

        System.out.println(list.toString());
    }
}
