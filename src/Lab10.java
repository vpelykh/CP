import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class Lab10 {
    private static final int MAX_QUEUE_LENGTH = 100;
    private static final int MAX_SIMULATION_TIME = 10000;
    private static Queue<Integer> queue = new LinkedList<>();
    private static Random random = new Random();
    private static int firstThreadProcessCount = 0;
    private static int secondThreadProcessCount = 0;
    private static int lostFirstThreadProcessCount = 0;
    private static int lostSecondThreadProcessCount = 0;
    public static void main(String[] args) {
        simulateProcesses();
        printResults();
    }
    private static void simulateProcesses() {
        long startTime = System.currentTimeMillis();
        Thread firstThread = new Thread(() -> {
            while (System.currentTimeMillis() - startTime < MAX_SIMULATION_TIME) {
                if (random.nextBoolean()) {
                    if (queue.size() < MAX_QUEUE_LENGTH) {
                        synchronized (queue) {
                            queue.add(1);
                            firstThreadProcessCount++;
                        }
                    } else {
                        lostFirstThreadProcessCount++;
                    }
                }
            }
        });
        Thread secondThread = new Thread(() -> {
            while (System.currentTimeMillis() - startTime < MAX_SIMULATION_TIME) {
                if (random.nextBoolean()) {
                    if (queue.size() < MAX_QUEUE_LENGTH) {
                        synchronized (queue) {
                            if (queue.isEmpty()) {
                                queue.add(2);
                            } else {
                                lostSecondThreadProcessCount++;
                            }
                            secondThreadProcessCount++;
                        }
                    } else {
                        lostSecondThreadProcessCount++;
                    }
                }
            }
        });
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Обробка процесів на процесорах
        while (!queue.isEmpty()) {
            synchronized (queue) {
                if (queue.peek() != null && queue.peek() == 1 && queue.size() > 1) {
                    queue.poll();
                    queue.poll();
                } else {
                    queue.poll();
                }
            }
        }
    }
    private static void printResults() {
        System.out.println( MAX_QUEUE_LENGTH);
        double totalFirstThreadProcesses = firstThreadProcessCount + lostFirstThreadProcessCount;
        double totalSecondThreadProcesses = secondThreadProcessCount + lostSecondThreadProcessCount;
        double lostFirstThreadPercentage = totalFirstThreadProcesses == 0 ? 0 : (double) lostFirstThreadProcessCount / totalFirstThreadProcesses * 100;
        double lostSecondThreadPercentage = totalSecondThreadProcesses == 0 ? 0 : (double) lostSecondThreadProcessCount / totalSecondThreadProcesses * 100;
        System.out.println(lostFirstThreadPercentage);
        System.out.println(lostSecondThreadPercentage);
    }
}
