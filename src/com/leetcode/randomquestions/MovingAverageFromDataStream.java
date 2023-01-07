/*https://leetcode.com/problems/moving-average-from-data-stream/solutions/ */
//Approach 1: Array or List
class MovingAverage {
    int size;
    List queue = new ArrayList<Integer>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        // calculate the sum of the moving window
        int windowSum = 0;
        for (int i = Math.max(0, queue.size() - size); i < queue.size(); ++i)
            windowSum += (int) queue.get(i);

        return windowSum * 1.0 / Math.min(queue.size(), size);
    }
}

// Approach 2: Double-ended Queue
class MovingAverage {
    private Deque<Integer> theSlidingArray;
    private int size;
    private int sum = 0;

    public MovingAverage(int size) {
        theSlidingArray = new ArrayDeque<Integer>();
        this.size = size;
    }

    public double next(int val) {
        theSlidingArray.add(val);
        sum = sum + val;
        int thrownOutValue = theSlidingArray.size() > size ? theSlidingArray.poll() : 0;
        sum = sum - thrownOutValue;
        return 1.0 * sum / theSlidingArray.size();
    }
}

// Approach 3: Circular Queue with Array
class MovingAverage {
    int size, head = 0, windowSum = 0, count = 0;
    int[] queue;

    public MovingAverage(int size) {
        this.size = size;
        queue = new int[size];
    }

    public double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        int tail = (head + 1) % size;
        windowSum = windowSum - queue[tail] + val;
        // move on to the next head
        head = (head + 1) % size;
        queue[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}
