package lambda;

import lambda.Task.TestTask;
import util.TaskUtil;

import java.util.ArrayList;
import java.util.List;
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
        ExecutorService executor = TaskUtil.createThreadPool();
        List<Future<List<String>>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 10);
            Future<List<String>> future = executor.submit(new TestTask(random));
            futureList.add(future);
        }
        for (Future<List<String>> listFuture : futureList) {
            List<String> strings = listFuture.get();
            System.out.println(strings);
        }
    }
}
