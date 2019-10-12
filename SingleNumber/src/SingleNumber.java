import java.util.Map;
import java.util.TreeMap;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: SingleNumber
 * @Description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * @author: 呆呆
 * @date: 2019/10/12
 */
public class SingleNumber {
    /**
     * 思路：
     * 方法一：
     * key-value模型，数字是key，出现次数是val
     * 将数组放入map中
     * 用map找到val为1的key
     *
     * 方法二：
     * 两个相同的数异或后结果为0
     * 任意数与0异或还是自己
     * 所有数异或结果就是只出现一次的数
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int n : nums){
            int count = map.getOrDefault(n,0);
            map.put(n,count+1);
        }
        for (Map.Entry<Integer,Integer> e : map.entrySet()){
            int n = e.getKey();
            int c = e.getValue();
            if (c == 1){
                return n;
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int r = 0;
        for (int n : nums){
            r = r ^ n;
        }
        return r;
    }
}
