package Ev2024.Ev2024_1;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/description/?envType=daily-question&envId=2024-01-07
 * 哈希表
 * 字符串
 * 计数
 */
public class 赎金信 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char exist = magazine.charAt(i);
            map[exist - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char need = ransomNote.charAt(i);
            map[need - 'a']--;
            if (map[need - 'a'] < 0)
                return false;
        }
        return true;
    }


}
