package util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskUtil {

    private static ExecutorService executor;

    private TaskUtil() {

    }

    public static ExecutorService createThreadPool() {
        if (executor == null) {
            executor = Executors.newCachedThreadPool();
        }
        return executor;
    }
}
