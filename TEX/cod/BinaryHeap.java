package BinaryHeap;
import java.util.Arrays;
import java.util.NoSuchElementException;

class BinaryHeap
{
    private static final int d = 2;
    private int heapSize;
    private int[] heap;

    public BinaryHeap(int capacity)
    {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty( )
    {
        return heapSize == 0;
    }

    public boolean isFull( )
    {
        return heapSize == heap.length;
    }

    public void makeEmpty( )
    {
        heapSize = 0;
    }

    private int parent(int i)
    {
        return (i - 1)/d;
    }

    private int kthChild(int i, int k)
    {
        return d * i + k;
    }

    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return heap[0];
    }

    public int findMax( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int max =0;
        int pos =-1;
        for(int i=0; i<heapSize;i++) {
            if(max< heap[i] ) {
                max = heap[i];
                pos =i;
            }
        }
        return pos;
    }

    public int deleteMin()
    {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }

    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);
        return keyItem;
    }

    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }
        heap[childInd] = tmp;
    }

    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    private int minChild(int ind)
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize))
        {
            if (heap[pos] < heap[bestChild])
                bestChild = pos;
            pos = kthChild(ind, k++);
        }
        return bestChild;
    }

    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }
}

