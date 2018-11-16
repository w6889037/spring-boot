package annotation;

/**
 * Created by xianchun.hu on 4/17/2018.
 */
@Student(value = "aaa")
public class Person {

    @Student(value = "studentName")
    private String name;

    @Teacher(value = "teacherAge")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Student(value = "study")
    private void study(){
        System.out.println("studying......");
    }

    @Teacher(value = "teacher")
    private void teach(){
        System.out.println("studying......");
    }
}
