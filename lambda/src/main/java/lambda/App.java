package lambda;

import lambda.impl.UserServiceImpl;
import lambda.inter.UserService;
import lambda.model.User;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(args[0]);
        UserService userService = (x) -> {
            System.out.println(x);
        };
        userService.save("ddd");
        UserService userService1 = (y) -> {
            System.out.println(y);
        };
        userService1.save("www");
        UserService userService2 = new UserServiceImpl();
        userService2.save("aaa");

        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.forEach(System.out::println);

        Map<String, String> map = new HashMap<>(1);
        System.out.println(map.size());
        map.put("aaa", "AAA");
        map.put("bbb", "BBB");
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        Set<String> set = new HashSet<>();
        set.add("sss");
        set.add("ddd");
        set.forEach(System.out::println);

        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
        Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);

        List<String> collect = list.stream().filter(s -> "1111".equals(s) || "2222".equals(s)).collect(Collectors.toList());
        collect.forEach(System.out::println);

        collect.forEach(c -> {
            c = ("1111").equals(c) ? "3333" : "4444";
            System.out.println(c);
        });

        collect.stream().forEach(c -> {
            c = ("1111").equals(c) ? "3333" : "4444";
            System.out.println(c);
        });

        List<String> listString = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        Stream<String> stringStream = listString.stream().map(String::toUpperCase);
        stringStream.forEach(System.out::println);

        Stream<Character> characterStream = listString.stream().flatMap((String s) -> {
            char[] chars = s.toCharArray();
            List<Character> cList = new ArrayList<>();
            for (char aChar : chars) {
                cList.add(aChar);
            }
            return cList.stream();
        });
        characterStream.forEach(System.out::println);

        List<User> users = Arrays.asList(new User("aaa", "bbb", Arrays.asList("篮球", "足球")), new User("ccc", "ddd", Arrays.asList("乒乓球", "羽毛球")));
        users.stream().map(User::getUsername).forEach(System.out::println);
        users.stream().map(User::getPassword).forEach(System.out::println);
        users.stream().map(User::getAihao).forEach(l -> {
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i));
            }
        });

        Stream<String> stringStream1 = users.stream().flatMap(o -> {
            List<String> aihao = o.getAihao();
            return aihao.stream();
        });
        stringStream1.forEach(System.out::println);

        List<String> sortList = Arrays.asList("fff", "lll", "xxx", "aaa");
        sortList.stream().sorted().forEach(System.out::println);

        List<User> userList = Arrays.asList(new User("zzz", "bbb", Arrays.asList("篮球", "足球")), new User("sss", "ddd", Arrays.asList("乒乓球", "羽毛球")));
        userList.stream().sorted(Comparator.comparing(User::getUsername)).forEach(e -> System.out.println(e.getUsername()));

        boolean zzz = userList.stream().allMatch(e -> e.getUsername().equals("zzz"));
        System.out.println(zzz);

        boolean zzz1 = userList.stream().anyMatch(e -> e.getUsername().equals("zzz"));
        System.out.println(zzz1);

        boolean www = userList.stream().noneMatch(e -> e.getUsername().equals("www"));
        System.out.println(www);

        Optional<User> first = userList.stream().sorted(Comparator.comparing(User::getUsername)).findFirst();
        System.out.println(first.get().getUsername());

        Optional<User> any = userList.stream().findAny();
        System.out.println(any.get().getUsername());

        List<User> userList2 = Arrays.asList(new User("zzz", "bbb", 23, Arrays.asList("篮球", "足球")), new User("sss", "ddd", 21, Arrays.asList("乒乓球", "羽毛球")));
        Optional<User> min = userList2.stream().min(Comparator.comparing(User::getAge));
        System.out.println(min.get().getAge());

        Optional<User> max = userList2.stream().max(Comparator.comparing(User::getAge));
        System.out.println(max.get().getAge());

        long count = userList2.stream().count();
        System.out.println(count);

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer reduce = intList.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Integer> reduce1 = intList.stream().reduce(Integer::sum);
        System.out.println(reduce1.get());

        Optional<Integer> reduce2 = userList2.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println(reduce2.get());

        List<String> collect1 = userList2.stream().map(User::getUsername).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        Set<Integer> collect2 = userList2.stream().map(User::getAge).collect(Collectors.toSet());
        collect2.forEach(System.out::println);

        ArrayList<String> collect3 = userList2.stream().map(User::getUsername).collect(Collectors.toCollection(ArrayList::new));
        collect3.forEach(System.out::println);

        Long collect4 = userList2.stream().collect(Collectors.counting());
        System.out.println(collect4);

        Double collect5 = userList2.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println(collect5);

        Integer collect6 = userList2.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(collect6);

        Optional<User> collect7 = userList2.stream().collect(Collectors.minBy(Comparator.comparing(User::getAge)));
        System.out.println(collect7.get().getAge());

        Optional<User> collect8 = userList2.stream().collect(Collectors.maxBy(Comparator.comparing(User::getAge)));
        System.out.println(collect8.get().getAge());

        Map<String, List<User>> collect9 = userList2.stream().collect(Collectors.groupingBy(User::getUsername));
        collect9.forEach((key, value) -> {
            value.forEach((v) -> {
                System.out.println(key + ":" + v.getUsername());
            });
        });

        System.out.println("------------");

        List<User> userList3 = Arrays.asList(
                new User("zzz", "aaa", 23, Arrays.asList("篮球", "足球")),
                new User("zzz", "bbb", 23, Arrays.asList("篮球", "足球")),
                new User("zzz", "ccc", 20, Arrays.asList("篮球", "足球")),
                new User("www", "ddd", 23, Arrays.asList("篮球", "足球")),
                new User("www", "eee", 23, Arrays.asList("篮球", "足球")),
                new User("www", "fff", 21, Arrays.asList("篮球", "足球"))
        );
        Map<String, Map<Integer, List<User>>> collect10 = userList3.stream()
                .collect(Collectors.groupingBy(User::getUsername, Collectors.groupingBy(User::getAge)));
        collect10.forEach((key, value) -> {
            System.out.print(key + ": [");
            value.forEach((key1, value1) -> {
                System.out.print("{" + key1 + ":");
                value1.forEach(e -> {
                    System.out.print(e.getPassword());
                    if (e != value1.get(value1.size() - 1)) {
                        System.out.print(",");
                    }
                });
                System.out.print("}");
            });
            System.out.println("]");
            System.out.println();
        });

        Map<Boolean, List<User>> collect11 = userList3.stream().collect(Collectors.partitioningBy((a) -> a.getAge() > 21));
        collect11.forEach((key, value) -> {
            System.out.print(key + ": [");
            value.forEach(e -> {
                System.out.print(e.getPassword());
                if (value.get(value.size() - 1) != e) {
                    System.out.print(",");
                }
            });
            System.out.print("]");
            System.out.println();
        });

        IntSummaryStatistics collect12 = userList3.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(collect12.getAverage());
        System.out.println(collect12.getCount());
        System.out.println(collect12.getMax());
        System.out.println(collect12.getMin());
        System.out.println(collect12.getSum());

        String collect13 = userList3.stream().map(User::getPassword).collect(Collectors.joining(",", "###", "==="));
        System.out.println(collect13);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().map(i -> i * i).forEach(System.out::println);

        Optional<Integer> reduce3 = userList3.stream().map(i -> 1).reduce(Integer::sum);
        System.out.println(reduce3.get());

        Instant start = Instant.now();
        LongStream.rangeClosed(0, 100000000L).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        long l = Duration.between(start, end).toMillis();
        System.out.println("耗费时间：" + l);

        /*Optional<User> op = Optional.of(null);
        System.out.println(op.get());*/

        /*Optional<User> op1 = Optional.empty();
        System.out.println(op1.get());*/

        Optional<User> op2 = Optional.ofNullable(null);
        if (op2.isPresent()) {
            System.out.println(op2.get());
        } else {
            System.out.println("op2没值就什么也不做");
        }

        User user = op2.orElse(new User());
        System.out.println(user);

        User user1 = op2.orElseGet(() -> new User());
        System.out.println(user1);

        Optional<String> s = op2.map(e -> e.getUsername());
        String asd = s.orElse("asd");
        System.out.println(asd);

        Optional<String> s1 = op2.flatMap(e -> Optional.of(e.getUsername()));
        String s2 = s1.orElse("aaa");
        System.out.println(s2);

        /*新日期API*/
        System.out.println("==================");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        /*加两年*/
        LocalDateTime localDateTime1 = localDateTime.plusYears(2);
        System.out.println(localDateTime1);

        /*减俩月*/
        LocalDateTime localDateTime2 = localDateTime.minusMonths(2);
        System.out.println(localDateTime2);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());

        Instant instant = Instant.now();
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli());

        Instant instant1 = Instant.ofEpochSecond(60);
        System.out.println(instant1);

        /*计算两个时间的间隔*/
        Instant instant3 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant4 = Instant.now();
        Duration between = Duration.between(instant3, instant4);
        System.out.println(between.getSeconds());
        System.out.println(between.toMillis());
        System.out.println(between.toNanos());

        LocalTime localTime1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime2 = LocalTime.now();
        Duration between1 = Duration.between(localTime1, localTime2);
        System.out.println(between1.toMillis());

        /*日期格式化*/
        LocalDateTime localDateTime3 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = localDateTime3.format(dateTimeFormatter);
        System.out.println(format);

        List<String> lll = new ArrayList<>();
        lll.add("1");
        lll.add("2");
        lll.add("3");
        lll.add("4");
        lll.add("5");
        lll.add("6");
        lll.add("7");
        lll.add("8");
        lll.add("9");
        Optional<Integer> reduce4 = lll.stream().map(Integer::parseInt).reduce(Integer::sum);
        System.out.println(reduce4.get());
        Optional<String> reduce5 = lll.stream().reduce(String::join);
        System.out.println(reduce5.get());
        String join = String.join(",", lll);
        System.out.println(join);
    }
}
