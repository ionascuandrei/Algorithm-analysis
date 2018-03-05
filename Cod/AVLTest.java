
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AVLTest {
    public static void main(String[] args) throws FileNotFoundException
    {
        //Fisierul de input
        Scanner read = new Scanner(new File("inp10000.txt"));

        int size = read.nextInt();
        int[] elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = read.nextInt();
        }

        //Adaugare elemente in arbore
        double duration = 0;
        for (int j = 0; j < 100; j++) {
            AVLTree tree = new AVLTree();
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                tree.root = tree.insert(tree.root, elements[i]);
            }
            long endTime = System.nanoTime();
            duration = duration + (endTime - startTime);
        }
        duration = duration/100;
        System.out.println("Insert in milisecunde");
        System.out.println(duration/1000000);


        //Cautare Minim
        AVLTree tree = new AVLTree();
        for (int i = 0; i < size; i++) {
            tree.root = tree.insert(tree.root, elements[i]);
        }

        duration = 0;
        for (int j = 0; j < 100; j++) {
            long startTime = System.nanoTime();
            tree.minValueNode(tree.root);
            long endTime = System.nanoTime();
            duration = duration + (endTime - startTime);
        }
        duration = duration/100;
        System.out.println("FindMin in nanosecunde");
        System.out.println(duration);


        //Cautare Maxim
        tree = new AVLTree();
        for (int i = 0; i < size; i++) {
            tree.root = tree.insert(tree.root, elements[i]);
        }

        duration = 0;
        for (int j = 0; j < 100; j++) {
            long startTime = System.nanoTime();
            tree.maxValueNode(tree.root);
            long endTime = System.nanoTime();
            duration = duration + (endTime - startTime);
        }
        duration = duration/100;
        System.out.println("FindMax in nanosecunde");
        System.out.println(duration);

        //Stergere min
        tree = new AVLTree();
        for (int i = 0; i < size; i++) {
            tree.root = tree.insert(tree.root, elements[i]);
        }

        duration = 0;
        for (int j = 0; j < 100; j++) {

            long startTime = System.nanoTime();
            Node min = tree.minValueNode(tree.root);
            tree.deleteNode(tree.root,min.key);
            long endTime = System.nanoTime();
            duration = duration + (endTime - startTime);
        }
        duration = duration/100;
        System.out.println("DeleteMin in nanosecunde");
        System.out.println(duration);

        //Stergere max
        tree = new AVLTree();
        for (int i = 0; i < size; i++) {
            tree.root = tree.insert(tree.root, elements[i]);
        }

        duration = 0;
        for (int j = 0; j < 100; j++) {

            long startTime = System.nanoTime();
            Node max = tree.maxValueNode(tree.root);
            tree.deleteNode(tree.root,max.key);
            long endTime = System.nanoTime();
            duration = duration + (endTime - startTime);
        }
        duration = duration/100;
        System.out.println("DeleteMax in nanosecunde");
        System.out.println(duration);
    }
}
