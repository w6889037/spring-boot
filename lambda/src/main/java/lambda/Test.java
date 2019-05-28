package lambda;

import lambda.model.Student;
import lambda.model.User;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Student student = new Student();

        Class c=Class.forName("lambda.model.Student");
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student, "aaaaaa");
        String name = (String) field.get(student);
        System.out.println(name);

        User u = new User();
        u.setUsername("uuuuu");
        Class superclass = c.getSuperclass();
        Field superField = superclass.getDeclaredField("username");
        superField.setAccessible(true);
        String username = (String)superField.get(u);
        System.out.println(username);
    }
}
