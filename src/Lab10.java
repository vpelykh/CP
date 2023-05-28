import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class Lab10 {
    private static final int MAX_FIRST_QUEUE_LENGTH = 100;
    private static final int MAX_SECOND_QUEUE_LENGTH = 80;
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
                    if (queue.size() < MAX_FIRST_QUEUE_LENGTH) {
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
                    if (queue.size() < MAX_FIRST_QUEUE_LENGTH) {
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
        System.out.println("Максимальна довжина першої черги: " + MAX_FIRST_QUEUE_LENGTH);
        System.out.println("Максимальна довжина другої черги: " + MAX_SECOND_QUEUE_LENGTH);
    }
}
