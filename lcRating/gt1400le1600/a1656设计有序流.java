package lcRating.gt1400le1600;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * @Author: ZJX
 * @Date: 2024/09/04
 * @Description:
 */
public class a1656设计有序流 {
    class OrderedStream {

        private final String[] stream;

        private int ptr;

        public OrderedStream(int n) {
            stream = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            ArrayList<String> res = new ArrayList<>();
            while (ptr < stream.length && stream[ptr] != null) {
                res.add(stream[ptr++]);
            }
            return res;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
}


