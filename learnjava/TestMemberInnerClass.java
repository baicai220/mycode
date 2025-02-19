public class TestMemberInnerClass {
    public static void main(String[] args) {
        //创建静态内部类实例，并调用方法
        Outer.StaticInner inner = new Outer.StaticInner();
        inner.inFun();
        //调用静态内部类静态方法
        Outer.StaticInner.inMethod();

        System.out.println("*****************************");

        //创建非静态内部类实例（方式1），并调用方法
        Outer outer = new Outer();
        Outer.NoStaticInner inner1 = outer.new NoStaticInner();
        inner1.inFun();

        //创建非静态内部类实例（方式2）
        Outer.NoStaticInner inner2 = outer.getNoStaticInner();
        inner1.inFun();
    }
}
class Outer{
    private static String a = "外部类的静态a";
    private static String b  = "外部类的静态b";
    private String c = "外部类对象的非静态c";
    private String d = "外部类对象的非静态d";

    static class StaticInner{
        private static String a ="静态内部类的静态a";
        private String c = "静态内部类对象的非静态c";
        public static void inMethod(){
            System.out.println("Inner.a = " + a);
            System.out.println("Outer.a = " + Outer.a);
            System.out.println("b = " + b);
        }
        public void inFun(){
            System.out.println("Inner.inFun");
            System.out.println("Outer.a = " + Outer.a);
            System.out.println("Inner.a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
//            System.out.println("d = " + d);//不能访问外部类的非静态成员
        }
    }

    class NoStaticInner{
        private String a = "非静态内部类对象的非静态a";
        private String c = "非静态内部类对象的非静态c";

        public void inFun(){
            System.out.println("NoStaticInner.inFun");
            System.out.println("Outer.a = " + Outer.a);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("Outer.c = " + Outer.this.c);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
        }
    }


    public NoStaticInner getNoStaticInner(){
        return new NoStaticInner();
    }
}
//Inner.inFun
//Outer.a = 外部类的静态a
//Inner.a = 静态内部类的静态a
//        b = 外部类的静态b
//c = 静态内部类对象的非静态c
//Inner.a = 静态内部类的静态a
//Outer.a = 外部类的静态a
//        b = 外部类的静态b
//        *****************************
//        NoStaticInner.inFun
//Outer.a = 外部类的静态a
//        a = 非静态内部类对象的非静态a
//b = 外部类的静态b
//Outer.c = 外部类对象的非静态c
//        c = 非静态内部类对象的非静态c
//d = 外部类对象的非静态d
//NoStaticInner.inFun
//Outer.a = 外部类的静态a
//        a = 非静态内部类对象的非静态a
//b = 外部类的静态b
//Outer.c = 外部类对象的非静态c
//        c = 非静态内部类对象的非静态c
//d = 外部类对象的非静态d