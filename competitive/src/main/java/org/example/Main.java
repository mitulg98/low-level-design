package org.example;

class MRUQueue {
    private static final int N = 4002;
    private int [] BIT;
    private int [] arr;
    private int n;

    public MRUQueue(int n) {
        this.n = n;
        BIT = new int[N];
        arr = new int[N];

        for(int i = 0; i < n; i++) {
            arr[i + 1] = i + 1;
            update(i + 1, 1);
        }
    }

    private void update(int x, int change) {
        for(; x < N; x += (x&(-x))) {
            BIT[x] += change;
        }
    }

    private int query(int x) {
        int sum = 0;
        for(; x > 0; x -= (x&(-x))) {
            sum += BIT[x];
        }
        return sum;
    }

    private int search(int k) {
        int lo = 1, hi = n;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = query(mid);

            if(sum >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int fetch(int k) {
        int idx = search(k);
        int value = arr[idx];

        n++;
        arr[n] = value;
        update(n, 1);
        update(idx, -1);
        return value;
    }

    public static void main(String [] args) {
        MRUQueue queue = new MRUQueue(8);
        System.out.println(queue.fetch(3));
        System.out.println(queue.fetch(5));
        System.out.println(queue.fetch(2));
        System.out.println(queue.fetch(8));
    }
}