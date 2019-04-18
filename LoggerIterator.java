/*
 * Design an iterator for orderng streams of logs from different machines.
 * You can assume that each log stream is ordered and contains the timestamp as int.
 */

import java.util.*;

class LoggerIterator {
    private List<List<Log>> logLists = null;
//    PriorityQueue<Log> heap = null;
    LogHeap heap = null;

    public LoggerIterator(List<List<Log>> logLists) {
        this.logLists = logLists;

        /* Assume that all loglist in logLists have atleast one log */
//        heap = new PriorityQueue<Log>(logLists.size());
        heap = new LogHeap(logLists.size());

        for(List<Log> list : logLists) {
            heap.add(list.remove(0));
        }
    }

    public Log next() {
        Log min = heap.poll();
        List<Log> list = logLists.get(min.machineNumber);

        if (list.size() > 0) {
            heap.add(list.remove(0));
        }

        return min;
    }

    public boolean hasNext() {
        return heap.size() > 0;
    }

    protected void generateLogs(int machineNumber, List<List<Log>> logLists) {
    }

    public static void main(String[] arr) {
        List<List<Log>> logLists = new ArrayList<List<Log>>();
        int totalMachines = 5;

        for (int machineNumber = 0; machineNumber < totalMachines; machineNumber++) {
            List<Log> list = new LinkedList<Log>();

            for (int i = 0; i < 10; i++) {
                int timestamp = (int) (Math.random() * 100) + 1;
                Log log = new Log(machineNumber, timestamp, "Message from " + machineNumber);
                list.add(log);            
            }   

            Collections.sort(list);

            logLists.add(list);
        }

        LoggerIterator iterator = new LoggerIterator(logLists);

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
