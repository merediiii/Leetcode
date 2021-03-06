package 哈希表;

import java.util.*;
/*
所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。

示例：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC", "CCCCCAAAAA"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/repeated-dna-sequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findRepeatedDnaSequences {
    public static List<String> f(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] tmp = new char[10];
        for (int i = 0; i < chars.length - 9; i++) {
            for (int j = 0; j < 10; j++) {
                tmp[j] = chars[i + j];
            }
            String string = String.valueOf(tmp);
            System.out.println(string);
            if (!map.containsKey(string))
                map.put(string + "", 1);
            else
                map.put(string + "", map.get(string) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                list.add(entry.getKey());
        }
        return list;
    }
    public static List<String> g(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String string = s.substring(i,i+10);
            if (!map.containsKey(string))
                map.put(string, 1);
            else
                map.put(string, map.get(string) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                list.add(entry.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(f("AAAAAAAAAAA"));
    }
}
