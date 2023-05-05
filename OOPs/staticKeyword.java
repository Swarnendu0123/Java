import java.util.*;

class Student {
    int age;
    static String collage;
    static String skill;
    static {
        System.out.println("skill alorted");
        skill = "java";
    }

    public void showData() {
        System.out.println("age: " + age + ", college : " + collage + ", Skill : " + skill);
    }

    public void study() {
        System.out.println("studying " + age);
    }
}

public class staticKeyword {
    static{
        int a =10;
        System.out.println(a);
    }

    public static void main(String[] args) {
        // System.out.println("in main");
        // Student swarnendu = new Student();
        // Student shilpa = new Student();
        // System.out.println(swarnendu.skill);
        final int key = 1;

        System.out.println(key);
        
    }
}
