import java.util.*;

public class code049 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            if(map.containsKey(sort(str))){
                map.get(sort(str)).add(str);
            }
            else {
                map.put(sort(str),new ArrayList<>(){});
                map.get(sort(str)).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String sort(String strs) {
        char[] strArray=strs.toCharArray();
        Arrays.sort(strArray);
        strs=new String(strArray);
        return strs;
    }

    //优化下

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] strArray=str.toCharArray();
            Arrays.sort(strArray);
            String key=new String(strArray);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}

