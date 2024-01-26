package lcRating.le1200;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */

public class a1455检查单词是否为句中其他单词的前缀 {
    /*
    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] base = searchWord.toCharArray();
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
            int j = 0;
            for (; j < base.length && j < chars.length; j++) {
                if(base[j] != chars[j])
                    break;
            }
            if(j == base.length)
                return i + 1;
        }
        return -1;
    }*/

    /**
     * 1.split
     * 2.starstWith
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if(s.startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }
}
