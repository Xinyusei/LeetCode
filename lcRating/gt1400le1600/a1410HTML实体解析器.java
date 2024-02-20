package lcRating.gt1400le1600;

import java.util.HashMap;

public class a1410HTML实体解析器 {
    public String entityParser(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        StringBuilder sb = new StringBuilder();

        int left = 0, n = text.length();
        for (; left < n; ) {
            if (text.charAt(left) == '&') {
                int right = left + 1;
                while (right < n && text.charAt(right) != ';')
                    right++;
                if (right < n && map.containsKey(text.substring(left, right + 1))) {
                    sb.append(map.get(text.substring(left, right + 1)));
                    left = right + 1;
                    continue;
                }
            }
            sb.append(text.charAt(left));
            left++;
        }
        return new String(sb);
    }
}
