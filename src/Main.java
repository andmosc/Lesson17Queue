import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static final int NUM_FLURS = 25;
    public static final int WAIT_DOORS_IN_SECONDS = 5;
    public static final int WAIT_MOVE_IN_SECONDS = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int input;

        while (true) {
            System.out.print("Ожидаю ввода этажа (для завершения надмите 0) : ");
            input = Integer.parseInt(scanner.nextLine());

            if (input > NUM_FLURS || input < 0)
                continue;
            if (input == 0) {
                outFlurs(queue);
                return;
            }
            queue.offer(input);
        }
    }

    public static int outFlurs(Queue q) {
        int totalSeconds=0;
        while (!q.isEmpty()) {
            System.out.print("этаж " + q.poll() + " -> ");
            totalSeconds += WAIT_DOORS_IN_SECONDS*WAIT_MOVE_IN_SECONDS;
        }
        System.out.println(" этаж 0");
        return totalSeconds;
    }
}
