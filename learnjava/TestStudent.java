import java.util.Arrays;

public class TestStudent {
    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student(3, "张三", 90, 23);
        arr[1] = new Student(1, "熊大", 100, 22);
        arr[2] = new Student(5, "王五", 75, 25);
        arr[3] = new Student(4, "李四", 85, 24);
        arr[4] = new Student(2, "熊二", 85, 18);

        System.out.println("按照成绩排序");
        StudentScoreComparator sc = new StudentScoreComparator();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (sc.compare(arr[j], arr[j + 1]) > 0) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
//        按照成绩排序
//        Student{id=5, name='王五', score=75, age=25}
//        Student{id=2, name='熊二', score=85, age=18}
//        Student{id=4, name='李四', score=85, age=24}
//        Student{id=3, name='张三', score=90, age=23}
//        Student{id=1, name='熊大', score=100, age=22}

        Arrays.sort(arr, sc);
        System.out.println(Arrays.toString(arr));
        //[Student{id=5, name='王五', score=75, age=25},
        // Student{id=2, name='熊二', score=85, age=18},
        // Student{id=4, name='李四', score=85, age=24},
        // Student{id=3, name='张三', score=90, age=23},
        // Student{id=1, name='熊大', score=100, age=22}]

    }
}