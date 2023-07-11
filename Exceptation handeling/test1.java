class Demo {
    public void a() {
        try {
            b();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    void b() throws Exception {
        int num1 = 10;
        int num2 = 0;
        int result = num1 / num2;
        System.out.println(result);
    }
}

public class test1 {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.a();
    }
}
