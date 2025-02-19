import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class demo3 {
    public static void main(String[] args) {
        Collection<?> list = null;
        list = new ArrayList<Double>();
//        list.add(3);//编译不通过
        list.add(null);
        read(list); //null

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        l1.add("尚硅谷");
        l2.add(15);
        read(l1); // 尚硅谷
        read(l2); // 15

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("尚硅谷", 15);

    }

    public static void read(Collection<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

}
