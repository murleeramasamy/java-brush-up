class Log implements Comparable<Log> {
    protected int machineNumber = -1;
    protected int timestamp = -1;
    private String message = null;

    public Log(int mNo, int time, String msg) {
        machineNumber = mNo;
        timestamp = time;
        message = msg;
    }

    public String toString() {
        return "Log time: " + timestamp + "; Machine Number: " + machineNumber + "; Message: " + message;
    }

    @Override
    public int compareTo(Log log) {
        return this.timestamp - log.timestamp;
    }
}
