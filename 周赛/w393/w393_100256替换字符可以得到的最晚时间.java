package 周赛.w393;

import java.util.HashMap;
import java.util.Map;

public class w393_100256替换字符可以得到的最晚时间 {
    class Solution {
        public String findLatestTime(String s) {
            StringBuffer sb = new StringBuffer();
            char[] chars = s.toCharArray();
            if (chars[0] != '?' && chars[1] != '?')
                sb.append(chars[0]).append(chars[1]);
            if (chars[0] == '?' && chars[1] == '?')
                sb.append("11");
            if (chars[0] == '?' && chars[1] != '?'){
                if(chars[1] >= '2')
                    sb.append('0').append(chars[1]);
                else
                    sb.append('1').append(chars[1]);
            }
            if (chars[1] == '?' && chars[0] != '?') {
                if (chars[0] == '0')
                    sb.append("09");
                else
                    sb.append("11");
            }
            sb.append(':');
            if (chars[3] != '?' && chars[4] != '?')
                sb.append(chars[3]).append(chars[4]);
            if (chars[3] == '?' && chars[4] == '?')
                sb.append("59");
            if (chars[3] == '?' && chars[4] != '?')
                sb.append('5').append(chars[4]);
            if (chars[4] == '?' && chars[3] != '?')
                sb.append(chars[3]).append('9');

            return sb.toString();
        }
    }
}

