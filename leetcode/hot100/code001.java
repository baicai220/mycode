import java.util.HashMap;

public class code001 {

    // 纯纯的暴力
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = 0; j <= nums.length-1; j++) {
                if (nums[i] + nums[j] == target && i!=j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 暴力
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            for(int j = i+1; j <= nums.length-1; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //使用哈希表
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey((target-nums[i]))){
                return new int[]{hashMap.get(target-nums[i]), i};
            }
            hashMap.put(nums[i], i); //这里是吧数组对应元素的值作为键，索引作为值
        }
        return null;
    }
}
