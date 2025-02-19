import java.util.*;


public class code128 {

    // 这个超时了
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        int tmpans = 0;
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                tmpans += 1;
            } else {
                if (ans < tmpans) ans = tmpans;
                tmpans = 0;
            }
        }
        if (ans < tmpans) ans = tmpans;
        return ans;
    }

    // 优化下
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 将键存储到 List 中
        List<Integer> keys = new ArrayList<>(map.keySet());

        // 对列表进行排序
        Collections.sort(keys);

        int ans = 0;
        int tmpans = 1;
        int pre = keys.get(0);
        for (int i = 1; i <= keys.size() - 1; i++) {
            if (keys.get(i) == pre + 1) {
                tmpans += 1;
            } else {
                if (ans < tmpans) ans = tmpans;
                tmpans = 1;
            }
            pre = keys.get(i);
        }
        if (ans < tmpans) ans = tmpans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new code128().longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

    // 官方题解
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); //去重
        }
        int ans = 0;
        for (int num : set) {
            if(!set.contains(num - 1)) {
                int tmpans=1;
                int nowsite=num;

                while (set.contains(nowsite +1)) {
                    nowsite++;
                    tmpans++;
                }
                ans = Math.max(ans, tmpans);
            }
        }
        return ans;
    }
}
