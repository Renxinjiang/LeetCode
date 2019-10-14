import java.util.Scanner;
import java.util.Set;
import java.util.SplittableRandom;
import java.util.TreeSet;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: BrokenKeyboard
 * @Description:
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
 * 现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
 *
 * 输入
 * 7_This_is_a_test
 * _hs_s_a_es
 * 输出
 * 7TI
 * @author: 呆呆
 * @date: 2019/10/14
 */
public class BrokenKeyboard {
    /**
     * 思路：
     * 将输入的错误字符串放到一个set中
     * 将要打印的坏掉的键放到一个Set类型的written中
     * 若set中不包含正确字符且written中也不包含
     * 则打印它的大写
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String right = scanner.nextLine();
        String wrong = scanner.nextLine();

        Set<Character> set = new TreeSet<>();
        for (char c : wrong.toCharArray()){
            set.add(c);
        }

        Set<Character> written = new TreeSet<>();
        for (char c : right.toCharArray()){
            if (! set.contains(c)){
                //字符转成大写
                c = Character.toUpperCase(c);
                /*
                if (c >= 'a' && c <= 'z'){
                    c += ('A'-'a');
                }
                */
                if (! written.contains(c)){
                    System.out.print(c);
                    written.add(c);
                }
            }
        }
        System.out.println();
    }
}
