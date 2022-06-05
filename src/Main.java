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
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите целое значение!");
                continue;
            }
            if (input > NUM_FLURS || input < 0) {
                System.out.println("Этажей в доме: (1-" + NUM_FLURS + ")");
                continue;
            }
            queue.offer(input);

            if (input == 0) {
                outFlurs(queue);
                return;
            }

        }
    }

    public static void outFlurs(Queue q) {
        int totalSeconds = 0;
        int currentFlur = 0;
        int previosFlur = 0;

        while (!q.isEmpty()) {
            currentFlur = (int) q.peek();
            totalSeconds += Math.abs(currentFlur - previosFlur) * WAIT_MOVE_IN_SECONDS + WAIT_DOORS_IN_SECONDS;
            previosFlur = (int) q.peek();
            System.out.print("этаж " + q.poll() + " -> ");
        }
        System.out.println(" этаж 0");
        System.out.println("Время затраченное лифтом на маршрут: " + totalSeconds + " c.");
    }
}
