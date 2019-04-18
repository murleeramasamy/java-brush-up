class LogHeap {
    Log[] array = null;
    int size = 0;
    int maxSize = 0;

    public LogHeap(int size) {
        array = new Log[size];
        maxSize = size;
    }

    public Log poll() {
        if (size <= 0) {
            return null;
        }

        Log topLog = array[0];
        size--;
        array[0] = array[size];
        heapify(0);
        return topLog;
    }

    public void add(Log log) {
        if (size >= maxSize) {
            return;
        }

        array[size] = log;
        int pos = size;
        size++;

        while (array[parent(pos)].compareTo(array[pos]) >= 1) {
            swap(pos, parent(pos));
            pos = parent(pos);
        } 
    }

    public int size() {
        return size;
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int left(int pos) {
        return (2 * pos) + 1;
    }

    private int right(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        return (pos >= size / 2) && (pos < size);
    }

    private void swap(int pos1, int pos2) {
        Log tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }

    private void heapify(int pos) {
        if (!isLeaf(pos)) {
            if ((left(pos) < size && array[pos].compareTo(array[left(pos)]) >= 1) ||
                (right(pos) < size && array[pos].compareTo(array[right(pos)]) >= 1)
            ) {
                /* If right child is greater than left child swap with parent */
                if (array[left(pos)].compareTo(array[right(pos)]) >= 1){
                    swap(pos, right(pos));
                    heapify(right(pos));
                } else {
                    swap(pos, left(pos));
                    heapify(left(pos));
                }
            }
        }
    }
}
