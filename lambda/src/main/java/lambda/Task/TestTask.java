package lambda.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TestTask implements Callable<List<String>> {

    private int random;

    public TestTask(int random) {
        this.random = random;
    }

    @Override
    public List<String> call() {
        List<String> list = new ArrayList<>();
        if (random % 2 == 0) {
            System.out.println("success");
            list.add("success");
        } else {
            System.out.println("fail");
            list.add("fail");
        }
        return list;
    }
}
