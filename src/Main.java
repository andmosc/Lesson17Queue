import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int input=0;

        while(true) {
            System.out.print("Ожидаю ввода этажа (для завершения надмите 0) : ");
            input = Integer.parseInt(scanner.nextLine());
            if (input == 0) {
                while(!queue.isEmpty()) {
                    System.out.print("этаж "+queue.poll()+" -> ");
                }
                System.out.println(" этаж 0");
                return;
            }
            queue.offer(input);
        }
    }
}
