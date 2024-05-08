package Ev2024.Ev2024_5;

/**
 * 2079. 给植物浇水
 * https://leetcode.cn/problems/watering-plants/description/?envType=daily-question&envId=2024-05-08
 */
public class a2079给植物浇水 {
    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int ans = 0;
            int water = capacity;
            for (int i = 0; i < plants.length; i++) {
                int val = plants[i];
                if(water >= val){
                    water -= val;
                    ans++;
                }
                else{
                    water = capacity;
                    ans += i * 2 + 1;
                }
            }
            return ans;
        }
    }
}
