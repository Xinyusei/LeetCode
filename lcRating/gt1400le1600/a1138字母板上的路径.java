package lcRating.gt1400le1600;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1138. 字母板上的路径
 */
public class a1138字母板上的路径 {
    class Solution {
        public String alphabetBoardPath(String target) {
            int px = 0, py = 0;
            StringBuilder res = new StringBuilder();
            char[] cs = target.toCharArray();
            for (char c : cs) {
                int cx = (c - 'a') / 5, cy = (c - 'a') % 5; //确定目标位置
                String v = cx < px ? "U".repeat(px - cx) : "D".repeat(cx - px);
                String h = cy < py ? "L".repeat(py - cy) : "R".repeat(cy - py);
                res.append(c != 'z' ? v + h : h + v).append("!");
                px = cx;
                py = cy;
            }
            return res.toString();
        }
    }
}
