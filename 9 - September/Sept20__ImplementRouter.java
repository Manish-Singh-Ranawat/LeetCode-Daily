// Implement Router - https://leetcode.com/problems/implement-router/description/?envType=daily-question&envId=2025-09-20

// Design a data structure that can efficiently manage data packets in a network router. Each data packet consists of the following attributes:
// - source: A unique identifier for the machine that generated the packet.
// - destination: A unique identifier for the target machine.
// - timestamp: The time at which the packet arrived at the router.

// Implement the Router class:

// - Router(int memoryLimit): Initializes the Router object with a fixed memory limit.
//  -- If adding a new packet would exceed this limit, the oldest packet must be removed to free up space.
//  -- memoryLimit is the maximum number of packets the router can store at any given time.

// - bool addPacket(int source, int destination, int timestamp): Adds a packet with the given attributes to the router.
//  -- A packet is considered a duplicate if another packet with the same source, destination, and timestamp already exists in the router.
//  -- Return true if the packet is successfully added (i.e., it is not a duplicate); otherwise return false.

// - int[] forwardPacket(): Forwards the next packet in FIFO (First In First Out) order.
//  -- Remove the packet from storage.
//  -- Return the packet as an array [source, destination, timestamp].
//  -- If there are no packets to forward, return an empty array.

// - int getCount(int destination, int startTime, int endTime):
//  -- Returns the number of packets currently stored in the router (i.e., not yet forwarded) that have the specified destination and have timestamps in the inclusive range [startTime, endTime].

// Note that queries for addPacket will be made in increasing order of timestamp.

// Input:
// ["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
// [[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]

// Output:
// [null, true, true, false, true, true, [2, 5, 90], true, 1]

// Explanation :
// Router router = new Router(3); // Initialize Router with memoryLimit of 3.
// router.addPacket(1, 4, 90); // Packet is added. Return True.
// router.addPacket(2, 5, 90); // Packet is added. Return True.
// router.addPacket(1, 4, 90); // This is a duplicate packet. Return False.
// router.addPacket(3, 5, 95); // Packet is added. Return True
// router.addPacket(4, 5, 105); // Packet is added, [1, 4, 90] is removed as number of packets exceeds memoryLimit. Return True.
// router.forwardPacket(); // Return [2, 5, 90] and remove it from router.
// router.addPacket(5, 2, 110); // Packet is added. Return True.
// router.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range [100, 110] is [4, 5, 105]. Return 1.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Router {
    private int size;
    private Map<Integer, List<Integer>> counts;
    private Map<Long, int[]> packets;
    private Queue<Long> queue;

    public Router(int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        long key = encode(source, destination, timestamp);
        if (packets.containsKey(key))
            return false;
        if (packets.size() >= size)
            forwardPacket();
        packets.put(key, new int[] { source, destination, timestamp });
        queue.offer(key);
        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty())
            return new int[] {};
        long key = queue.poll();
        int[] packet = packets.remove(key);
        if (packet == null)
            return new int[] {};
        int destination = packet[1];
        List<Integer> list = counts.get(destination);
        list.remove(0);
        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = counts.get(destination);
        if (list == null || list.isEmpty())
            return 0;
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }

    private long encode(int source, int destination, int timestamp) {
        return ((long) source << 40) | ((long) destination << 20) | timestamp;
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int upperBound(final List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}

public class Sept20__ImplementRouter {
    public static void main(String[] args) {
        Router router = new Router(3);
        System.out.println(router.addPacket(1, 4, 90)); // true
        System.out.println(router.addPacket(2, 5, 90)); // true
        System.out.println(router.addPacket(1, 4, 90)); // false
        System.out.println(router.addPacket(3, 5, 95)); // true
        System.out.println(router.addPacket(4, 5, 105)); // true
        System.out.println(Arrays.toString(router.forwardPacket())); // [2, 5, 90]
        System.out.println(router.addPacket(5, 2, 110)); // true
        System.out.println(router.getCount(5, 100, 110)); // 1
    }
}
