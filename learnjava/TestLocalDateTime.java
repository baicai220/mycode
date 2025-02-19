import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestLocalDateTime {
    public static void main(String[] args) {
        TestLocalDateTime tldt=new TestLocalDateTime();
        tldt.test01(); // 2025-02-06
        tldt.test02(); // 16:03:06.572388900
        tldt.test03(); // 2025-02-06T16:03:24.847622400
        tldt.test04(); // 2025-02-06
        tldt.test05(); // 37
        tldt.test06(); // 2025-03-08
        tldt.test07(); // 2025-01-07

    }

    public void test01(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    public void test02(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    public void test03(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    public void test04(){
        LocalDate lai = LocalDate.of(2025, 2, 6);
        System.out.println(lai);
    }

    public void test05(){
        LocalDate lai = LocalDate.of(2025, 2, 6);
        System.out.println(lai.getDayOfYear());
    }

    public void test06(){
        LocalDate lai = LocalDate.of(2025, 2, 6);
        LocalDate go = lai.plusDays(30);
        System.out.println(go);
    }

    public void test07(){
        LocalDate now = LocalDate.now();
        LocalDate before = now.minusDays(30);
        System.out.println(before);
    }
}