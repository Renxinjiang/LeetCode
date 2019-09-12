import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        //1.创建好一个list 是数组类型[]，其中存放的元素也是数组类型，类似二维数组
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            //2.放入numRows个[]
            //现在[[],[],[]...]
            list.add(new ArrayList<>());
        }
        //3.先用1占位，每行多少个元素，放入多少个1
        //现在[[1],[1,1,],[1,1,1]...]
        for (int i = 0;i < numRows;i++){
            for (int j = 0;j <= i;j++){
                list.get(i).add(1);
            }
        }
        //4.修改需要更改的下标
        //行的下标[2,numRows)
        //列的下标[1,i)
        for (int i = 2;i < numRows;i++){
            for (int j = 1;j < i;j++){
                int a = list.get(i - 1).get(j - 1);
                int b = list.get(i - 1).get(j);
                list.get(i).set(j,a + b);
            }
        }
        return list;
    }

    //方法2
    //与方法1不同的是，开辟好空间后，不再全部插入1，而是边计算边插入计算好的值
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows >= 1) {
            //1.第一行插入一个1
            //先开辟1个空间
            list.add(new ArrayList<>());
            //插入1
            list.get(0).add(1);
        }
        if (numRows >= 2) {
            //2.第二行插入两个1；
            list.add(new ArrayList<>());
            list.get(1).add(1);
            list.get(1).add(1);
        }
        //3.除j=0和j=i的位置插入1，其余都计算后再插入
        for (int i = 2;i < numRows;i++){
            list.add(new ArrayList<>());
            list.get(i).add(1);
            for (int j = 1;j < i;j++){
                int a = list.get(i - 1).get(j - 1);
                int b = list.get(i - 1).get(j);
                list.get(i).add(a + b);
            }
            list.get(i).add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(0));
        System.out.println(new PascalTriangle().generate2(0));
    }
}
