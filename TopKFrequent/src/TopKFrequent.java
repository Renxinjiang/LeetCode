import java.util.*;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: TopKFrequent
 * @Description:
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 * @author: 呆呆
 * @date: 2019/10/14
 */
public class TopKFrequent {
    /**
     * 思路：
     * 即出前k个单词，出现次数优先于字母顺序
     * 先统计每个单词出现的次数
     * 单词与次数形成映射关系，相同次数的单词放在一个数组中
     * 对次数进行排序，从大到小
     * 按次数取出k个单词
     */
    //统计单词出现次数
    public static Map<String,Integer> calcCount(String[] words){
        Map<String,Integer> map = new HashMap<>();
        for (String w : words){
            int count =  map.getOrDefault(w,0);
            map.put(w,count+1);
        }
        return map;
    }
    //反转，得到每个次数下有多少个单词
    public static Map<Integer,List<String>> calcCountOfWords(Map<String,Integer> map){
        Map<Integer,List<String>> ret = new HashMap<>();
        for (Map.Entry<String,Integer> e : map.entrySet()){
            String word = e.getKey();
            int count = e.getValue();
            if (!ret.containsKey(count)){
                ret.put(count,new ArrayList<>());
            }
            ret.get(count).add(word);
        }
        return ret;
    }
    //对次数进行排序
    public static class IntegerComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        //获取每个单词出现次数
        Map<String,Integer> wordsCount = calcCount(words);
        //获取出现次数与单词的映射
        Map<Integer,List<String>> countToWordList = calcCountOfWords(wordsCount);
        //获取所有次数的集合
        Set<Integer> counts = countToWordList.keySet();
        //用比较器将次数从大到小排
        // 1.将counts放到一个数组中
        // 2.利用Collections接口的sort方法，进行排序（但为自然顺序、即升序）
        // 3.写一个比较器将count调整为降序
        List<Integer> countList = new ArrayList<>(counts);
        Collections.sort(countList,new IntegerComparator());
        /*
        Collections.sort(countList, new Comparator<Integer>() {
            //匿名类
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        */
        //取单词
        List<String> result = new ArrayList<>();
        int n = 0;
        int i = 0;
        while (n < k) {
            int count = countList.get(i);
            i++;
            List<String> ws = countToWordList.get(count);
            Collections.sort(ws);
            if (ws.size() <= k - n) {
                // 如果候选人数量小于需要人数，全部录取
                result.addAll(ws);
                n += ws.size();
            } else {
                // 否则，只录取需要的人数
                result.addAll(ws.subList(0, k - n));
                n += (k - n);
            }
        }
        return result;
    }
}
