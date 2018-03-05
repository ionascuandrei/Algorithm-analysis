import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BHTest {
    public static void main(String[] args) throws FileNotFoundException {
        //Fisierul de input
        Scanner read = new Scanner(new File("inp10000.txt"));

        int size = read.nextInt();

        int[] values = new int[size];
        double duration = 0;
        for (int i = 0; i < size; i++) {
            values[i] = read.nextInt();
        }
        //INSERT
        BinaryHeap heap = new BinaryHeap(size);
        for (int j = 0; j < 100; j++) {
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                heap.insert(values[i]);
            }
            long endTime = System.nanoTime();
            duration = duration + (endTime - startTime);
            heap.makeEmpty();
        }
        duration = duration / 100;
        System.out.println("Insert in milisecunde");
        System.out.println(duration / 1000000);

        //Delete Max
        duration = 0;
        double duration1 =0;
        for (int j = 0; j < 100; j++) {
            heap = new BinaryHeap(size);
            for (int i = 0; i < size; i++) {
                heap.insert(values[i]);
            }
            long startTime = System.nanoTime();
            long startTime1 = System.nanoTime();
            int max = heap.findMax();
            long endTime1 = System.nanoTime();


            heap.delete(max);
            long endTime = System.nanoTime();
            duration = duration + (endTime - startTime);
            duration1 = duration1 + (endTime1 - startTime1);
        }
        duration = duration / 100;
        duration1 = duration1 / 100;
        System.out.println("FindMAX in nanosecunde");
        System.out.println(duration1);

        System.out.println("DeleteMAX in nanosecunde");
        System.out.println(duration);
    }
}
