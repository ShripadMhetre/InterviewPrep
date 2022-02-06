package queue;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueLinkedListImpl {
    Node front, rear;
    int size;

    public QueueLinkedListImpl() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public Node getNewNode(int val) {
        Node newNode = new Node(val);
        return newNode;
    }

    public void insert(int val) {
        if (rear == null) {
            front = rear = getNewNode(val);
            size++;
            return;
        }
        size++;
        rear.next = getNewNode(val);
        rear = rear.next;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty...");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty...");
            return Integer.MIN_VALUE;
        }
        return rear.data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue already empty Nothing to remove.");
            return Integer.MIN_VALUE;
        }
        size--;
        int t = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return t;
    }

    public boolean isEmpty() {
        if (rear == null) return true;
        return false;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueLinkedListImpl queue = new QueueLinkedListImpl();
        queue.insert(12);
        queue.insert(3);
        queue.insert(32);
        queue.insert(10);
        queue.insert(99);

        System.out.println("Current Size: " + queue.getSize());
        System.out.println("Front: " + queue.getFront());
        System.out.println("Rear: " + queue.getRear());

        System.out.println("Dequeue Element: " + queue.remove());

        System.out.println("Current Size: " + queue.getSize());
        System.out.println("Front: " + queue.getFront());
        System.out.println("Rear: " + queue.getRear());


    }
}
