import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollectionAdd {

    @Test
    public void testAddAll(){
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add(2);
        System.out.println("c1 = " + c1); // c1 = [1, 2]

        Collection c2 = new ArrayList();
        c2.add(1);
        c2.add(2);
        System.out.println("c2 = " + c2); // c2 = [1, 2]

        Collection other = new ArrayList();
        other.add(1);
        other.add(2);
        other.add(3);
        System.out.println("other = " + other); // other = [1, 2, 3]

        c1.addAll(other);
        System.out.println("c1集合元素的个数：" + c1.size());//5
        System.out.println("c1.addAll(other) = " + c1); // c1.addAll(other) = [1, 2, 1, 2, 3]

        c2.add(other);
        System.out.println("c2集合元素的个数：" + c2.size());//3
        System.out.println("c2.add(other) = " + c2); // c2.add(other) = [1, 2, [1, 2, 3]]
    }
}