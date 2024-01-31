package lcRating.gt1400le1600;

import java.util.*;

public class a1700无法吃午餐的学生数量 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] countType = new int[2];
        for (int stuType : students) {
            countType[stuType]++;
        }
        //students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
        //遍历students得到countType[0] = 2,countType[1] = 4
        for (int sandwichType : sandwiches) {
            if (countType[sandwichType] == 0)
                break;
            else
                countType[sandwichType]--;
            System.out.println("Type(0) : " + countType[0] + " Type(1): " + countType[1]);
        }
        return countType[0] + countType[1];
    }

}
