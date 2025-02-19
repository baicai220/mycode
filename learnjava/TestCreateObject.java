import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestCreateObject {
    @Test
    public void test1() throws Exception{

        Class<?> clazz = Class.forName("Student");
        //clazz代表Student类型
        //clazz.newInstance()创建的就是Student的对象
        Object obj = clazz.newInstance();
        System.out.println(obj); // Student{id=0, name='null', score=0, age=0}
    }

    @Test
    public void test2()throws Exception{
        //(1)获取Class对象
        Class<?> clazz = Class.forName("Student");
        /*
         * 获取AStudent类型中的有参构造
         * 如果构造器有多个，通常是根据形参【类型】列表来获取指定的一个构造器的
         */
        //(2)获取构造器对象
        Constructor<?> constructor = clazz.getDeclaredConstructor(int.class,String.class,int.class,int.class);

        //(3)创建实例对象
        // T newInstance(Object... initargs)  这个Object...是在创建对象时，给有参构造的实参列表
        Object obj = constructor.newInstance(10,"奥特曼",10,10);
        System.out.println(obj); // Student{id=10, name='奥特曼', score=10, age=10}
    }
}