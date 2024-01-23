package Ev2024_1;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/maximum-swap/?envType=daily-question&envId=2024-01-22
 * 670. 最大交换
 */


public class a1_22MID {
    public int maximumSwap(int Num) {
        int num = Num,ans = 0;
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; num > 0; i++, num /= 10) {
            int x = num % 10;
            array.addFirst(x);
        }
        //array : 9 8 3 6 8
        for (int i = 0; i < array.size(); i++) {
            int x = array.get(i),maxNum = x,pos = i;
            for (int j = i + 1; j < array.size(); j++) {
                int find = array.get(j);
                if(find > x && find >= maxNum){
                    maxNum = find;
                    pos = j;
                }
            }
            if(pos != i) {
                array.set(i, maxNum);
                array.set(pos, x);
                break;
            }
        }
        for (int i = 0; i < array.size(); i++) {
            int x = array.get(array.size() - 1 - i);
            ans += x * Math.pow(10, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        a1_22MID test = new a1_22MID();
        System.out.println(test.maximumSwap(98368));
    }
}
