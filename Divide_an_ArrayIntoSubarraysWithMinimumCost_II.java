import java.util.*;

class Solution {

    // Maintains sum of smallest K elements in a sliding window
    static class SmartWindow {
        int K;
        TreeMap<Integer, Integer> low = new TreeMap<>();   // smallest K elements
        TreeMap<Integer, Integer> high = new TreeMap<>();  // remaining elements
        long sumLow = 0;
        int szLow = 0, szHigh = 0;

        SmartWindow(int k) {
            this.K = k;
        }

        int windowSize() {
            return szLow + szHigh;
        }

        private void addMap(TreeMap<Integer, Integer> map, int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        private boolean removeMap(TreeMap<Integer, Integer> map, int x) {
            Integer cnt = map.get(x);
            if (cnt == null) return false;
            if (cnt == 1) map.remove(x);
            else map.put(x, cnt - 1);
            return true;
        }

        private int popLast(TreeMap<Integer, Integer> map) {
            int x = map.lastKey();
            removeMap(map, x);
            return x;
        }

        private int popFirst(TreeMap<Integer, Integer> map) {
            int x = map.firstKey();
            removeMap(map, x);
            return x;
        }

        void rebalance() {
            int need = Math.min(K, windowSize());

            while (szLow > need) {
                int x = popLast(low);
                szLow--;
                sumLow -= x;
                addMap(high, x);
                szHigh++;
            }

            while (szLow < need && szHigh > 0) {
                int x = popFirst(high);
                szHigh--;
                addMap(low, x);
                szLow++;
                sumLow += x;
            }
        }

        void add(int x) {
            if (szLow == 0 || x <= low.lastKey()) {
                addMap(low, x);
                szLow++;
                sumLow += x;
            } else {
                addMap(high, x);
                szHigh++;
            }
            rebalance();
        }

        void remove(int x) {
            if (removeMap(low, x)) {
                szLow--;
                sumLow -= x;
            } else {
                removeMap(high, x);
                szHigh--;
            }
            rebalance();
        }

        long query() {
            return sumLow;
        }
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        // nums[0] is always taken
        int need = k - 1;
        SmartWindow window = new SmartWindow(need);

        // Initial window: nums[1 ... dist+1]
        for (int i = 1; i <= dist + 1 && i < n; i++) {
            window.add(nums[i]);
        }

        long ans = window.query();

        // Slide the window
        for (int i = 2; i + dist < n; i++) {
            window.remove(nums[i - 1]);
            window.add(nums[i + dist]);
            ans = Math.min(ans, window.query());
        }

        return ans + nums[0];
    }
}
