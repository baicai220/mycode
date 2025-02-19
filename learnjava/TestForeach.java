import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;

public class TestForeach {
    @Test
    public void test01(){
        Collection coll = new ArrayList();
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        //foreach循环其实就是使用Iterator迭代器来完成元素的遍历的。
        for (Object o : coll) {
            System.out.println(o);
        }
    }
    @Test
    public void test02(){
        int[] nums = {1,2,3,4,5};
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("-----------------");
        String[] names = {"张三","李四","王五"};
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test03(){
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "demo";
            System.out.println(myStr); //demo
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]); // null
        }
        /*
        增强for循环会依次将数组str中的每个元素赋值给临时变量myStr。
        myStr只是一个临时变量，它存储的是数组元素的副本，而不是数组元素本身的引用。
        当执行myStr = "demo";时，只是将临时变量myStr指向了新的字符串对象"demo"，并没有改变数组str中元素的引用。
        所以，在增强for循环中打印myStr时，会输出"demo"，但数组str中的元素仍然是null
         */
    }
}