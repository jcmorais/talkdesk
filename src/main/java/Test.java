import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        LocalTime t = LocalTime.of(12,0,1);
        LocalTime t2 = LocalTime.of(12,3,10);

        System.out.println(t.getMinute());

        System.out.printf((t2.getSecond()-t.getSecond())+ "");
    }
}
