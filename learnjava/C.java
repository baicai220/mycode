interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
//        System.out.println(x); //报错
        // 修改如下：
//        System.out.println(A.x); //0
        System.out.println(super.x);// 1
    }
    public static void main(String[] args) {
        new C().pX();
    }
}