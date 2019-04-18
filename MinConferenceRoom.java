import java.util.*;

class Time {
    int start;
    int end;

    public Time(int s, int e) {
        start = s;
        end = e;
    }
}

class TimePoint {
    int time;
    boolean isStart;

    public TimePoint(int t, boolean b) {
        time = t;
        isStart = b;
    }
}

class MinConferenceRoom {
    public int findMinConferenceRoom(List<Time> slots) {
        List<TimePoint> points = new ArrayList<TimePoint>();

        for(Time slot : slots) {
            points.add(new TimePoint(slot.start, true));
            points.add(new TimePoint(slot.end, false));
        } 

        Collections.sort(points, new Comparator<TimePoint>() {
            public int compare(TimePoint s1, TimePoint s2) {
                if (s1.time < s2.time) {
                    return -1;
                } else if (s1.time > s2.time) {
                    return 1;
                }

                if (!s1.isStart && s2.isStart) {
                    return -1;
                }

                return 0;
            }
        });


        int max = 0;
        int count = 0;

        for(TimePoint point : points) {
            if (point.isStart) {
                count++;
            } else {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Time> slots = new ArrayList<Time>();

        slots.add(new Time(1,4));
        slots.add(new Time(10,11));
        slots.add(new Time(9,13));
        slots.add(new Time(5,10));
        slots.add(new Time(3,7));
        slots.add(new Time(8,12));
        slots.add(new Time(11,15));

        MinConferenceRoom rooms = new MinConferenceRoom();
        
        System.out.println(rooms.findMinConferenceRoom(slots));
    }
}
