package 周赛.w392;

public class w392_100242 {
    class Solution {
        public String getSmallestString(String s, int k) {
            StringBuffer sb = new StringBuffer();
            //a b c d e f g h i j k l m n o p q r s t u v w x y z a
            for (int i = 0; i < s.toCharArray().length; i++) {
                char c = s.charAt(i);
                if (k == 0) {
                    sb.append(c);
                    continue;
                }
                int dis;
                if (c <= 'm')
                    dis = c - 'a';
                else
                    dis = 'z' - c + 1;
                if (dis <= k) {
                    sb.append('a');
                    k -= dis;
                } else {
                    sb.append((char) (c - k));
                    k = 0;
                }
            }
            return sb.toString();

        }

    }
}




