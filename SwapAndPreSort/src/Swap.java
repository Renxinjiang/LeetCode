/**
 * 给你一个正整数的数组 A（其中的元素不一定完全不同），
 * 请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
 *如果无法这么操作，就请返回原数组。
 *
 * 示例 1：
 * 输入：[3,2,1]
 * 输出：[3,1,2]
 * 解释：
 * 交换 2 和 1
 *  
 * 示例 2：
 * 输入：[1,1,5]
 * 输出：[1,1,5]
 * 解释：
 * 这已经是最小排列
 *  
 * 示例 3：
 * 输入：[1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：
 * 交换 9 和 7
 *  
 * 示例 4：
 * 输入：[3,1,1,3]
 * 输出：[1,3,1,3]
 * 解释：
 * 交换 1 和 3
 *
 * 链接：https://leetcode-cn.com/problems/previous-permutation-with-one-swap/submissions/
 */
public class Swap {
    //思路：
    //从后往前遍历
    //遇到第一个升序的数将其与遍历过的数中的最大且小于本数的一个交换即可
    //若有两个相同的则取左边进行交换
    //没有升序的则输出原数组
    public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2;i >= 0;i--){
            if (A[i] > A[i+1]){
                //1.A[i]是要交换的数
                //2.maxInde是遍历过的数中最大
                //3.如果相等，取左边
                int maxIndex = -1;
                int max = Integer.MIN_VALUE;
                for (int j = i+1;j<A.length;j++){
                    if (A[j] < A[i] && A[j] > max){
                        max = A[j];
                        maxIndex = j;
                    }
                }
                //i是要交换的位置
                //maxIndex就是要交换的位置
                if (maxIndex != -1){
                    int t = A[i];
                    A[i] = A[maxIndex];
                    A[maxIndex] = t;
                    return A;
                }
            }
        }
        return A;
    }
}
