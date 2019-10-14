import java.util.Set;
import java.util.TreeSet;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: JewelsInStones
 * @Description:
 * 给定字符串J  代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * @author: 呆呆
 * @date: 2019/10/14
 */
public class JewelsInStones {
    /**
     * 思路：
     * 将我拥有的石头放到set中去
     * 遍历宝石J集合，
     * 若set中包含了J中的宝石，count++
     */
    public int numJewelsInStones(String J, String S) {
        //把所有宝石放到Set集合中
        Set<Character> jewels = new TreeSet<>();
       for (char j : J.toCharArray()){
           jewels.add(j);
       }
       //遍历所有的石头
        int count = 0;
        for (char s : S.toCharArray()){
           if (jewels.contains(s)){
               count++;
           }
        }
        return count;
    }
}
