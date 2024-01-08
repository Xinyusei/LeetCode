package 周赛.w379;

public class a10035 {
    /**
     * https://leetcode.cn/problems/maximum-area-of-longest-diagonal-rectangle/description/
     * 10035. 对角线最长的矩形的面积
     *
     * @param dimensions
     * @return
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        double len = 0;
        for (int i = 0; i < dimensions.length; i++) {
            int[] couple = dimensions[i];
            double clen = gt(couple[0], couple[1]);
            if (clen > len) {
                area = couple[0] * couple[1];
                len = clen;
            } else if (clen == len) {
                area = Math.max(area, couple[0] * couple[1]);
            }
        }
        return area;
    }

    private double gt(int height, int width) {
        return height * height + width * width;
    }

}
