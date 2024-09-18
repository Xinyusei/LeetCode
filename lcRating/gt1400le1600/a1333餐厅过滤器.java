package lcRating.gt1400le1600;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Author: ZJX
 * @Date: 2024/09/18
 * @Description:
 */
public class a1333餐厅过滤器 {
    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            //restaurants[i] = [id, rating, veganFriendly, price, distance]

            return Arrays.stream(restaurants)
                    .filter(rs -> {
                        if (veganFriendly == 0)
                            return rs[3] <= maxPrice && rs[4] <= maxDistance;
                        return veganFriendly == rs[2] && rs[3] <= maxPrice && rs[4] <= maxDistance;
                    })
                    .sorted((rs1, rs2) -> {
                        if (rs1[1] != rs2[1])
                            return rs2[1] - rs1[1];
                        return rs2[0] - rs1[0];
                    })
                    .map(rs -> rs[0])
                    .collect(Collectors.toList());
        }
    }
}
