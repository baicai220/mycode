public class SubClass extends SuperClass implements SuperInterface,MotherInterface {
    public void method(){
//        System.out.println("x = " + x);//模糊不清
        System.out.println("super.x = " + super.x); //super.x = 1
        System.out.println("SuperInterface.x = " + SuperInterface.x); //SuperInterface.x = 2
        System.out.println("MotherInterface.x = " + MotherInterface.x); //MotherInterface.x = 3
        //没有重名问题，可以直接访问
        System.out.println("y = " + y); //y = 2
    }

    public static void main(String[] args) {
        new SubClass().method();
    }
}