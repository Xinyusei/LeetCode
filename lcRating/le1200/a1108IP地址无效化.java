package lcRating.le1200;

/**
 * 1108. IP 地址无效化
 * https://leetcode.cn/problems/defanging-an-ip-address/
 */
public class a1108IP地址无效化 {
    /*
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if(c != '.'){
                sb.append(c);
            }
            else{
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
    */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
