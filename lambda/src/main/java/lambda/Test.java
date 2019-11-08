package lambda;

import lambda.Task.TestTask;
import lambda.model.Student;
import lambda.model.User;
import util.TaskUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, ExecutionException, InterruptedException {
        /*Student student = new Student();

        Class c = Class.forName("lambda.model.Student");
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
        String username = (String) superField.get(u);
        System.out.println(username);

        Date date = DateUtils.addDays(new Date(), 1);
        System.out.println(date);

        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(end.toLocalTime());

        Instant instant = Instant.now();
        long currentTimeMillis = instant.toEpochMilli();
        System.out.println(currentTimeMillis + "," + new Date().getTime());

        Timestamp timestamp = Timestamp.valueOf(end);
        long endTimeMillis = timestamp.getTime();
        System.out.println(endTimeMillis);

        System.out.println(endTimeMillis - currentTimeMillis);

        int v = (int) (Math.random() * 10);
        System.out.println(v);*/

//        ExecutorService executor = Executors.newFixedThreadPool(10);
        /*ExecutorService executor = TaskUtil.createThreadPool();
        List<Future<List<String>>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 10);
            Future<List<String>> future = executor.submit(new TestTask(random));
            futureList.add(future);
        }
        for (Future<List<String>> listFuture : futureList) {
            List<String> strings = listFuture.get();
            System.out.println(strings);
        }*/
        Map<String, Object> map = new HashMap<>();
        map.put("aaa", "AAA");
        map.put("bbb", "BBB");
        map.put("ccc", "CCC");
        map.put("ddd", "DDD");
        System.out.println(map);

        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("aaa");
        user.setAge(11);
        user.setPassword("ppp");

        User user2 = new User();
        user2.setUsername("bbb");
        user2.setAge(11);
        user2.setPassword("ddd");

        users.add(user);
        users.add(user2);

        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("sss");
        student.setAge(11);
        student.setUsername("aaa");
        student.setPassword("bbb");

        Student student2 = new Student();
        student2.setName("sss");
        student2.setAge(11);
        student2.setUsername("ccc");
        student2.setPassword("ddd");

        students.add(student);
        students.add(student2);

        users.stream().forEach(u -> {
           
        });
    }
}
