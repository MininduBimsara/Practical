class PassengerQueue {
    private Passenger[] queueArray;
    private int maxSize;
    private int first;
    private int last;

    public PassengerQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new Passenger[maxSize];
        first = 0;
        last = -1;
    }

    public void add(Passenger passenger) {
        if (!isFull()) {
            last = (last + 1) % maxSize;
            queueArray[last] = passenger;
        } else {
            System.out.println("Queue is full. Cannot add more passengers.");
        }
    }

    public Passenger remove() {
        if (!isEmpty()) {
            Passenger removedPassenger = queueArray[first];
            first = (first + 1) % maxSize;
            return removedPassenger;
        } else {
            System.out.println("Queue is empty. No passengers to remove.");
            return null;
        }
    }

    public void display() {
        if (!isEmpty()) {
            System.out.println("Passengers in the queue:");
            int index = first;
            do {
                System.out.println(queueArray[index].getFirstName() + " " + queueArray[index].getSurName());
                index = (index + 1) % maxSize;
            } while (index != (last + 1) % maxSize);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        return (last == -1);
    }

    public boolean isFull() {
        return ((last + 1) % maxSize == first);
    }
}