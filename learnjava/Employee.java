public class Employee {
    private int id;
    private String name;
    private int age;
    private int s;
    public Employee(int id, String tom, int age, int s) {
        this.id = id;
        this.name = tom;
        this.age = age;
        this.s = s;

    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee() {

    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", s=" + s + '}';
    }
}
