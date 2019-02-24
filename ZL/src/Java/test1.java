package Java;
/*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
找出那个只出现了一次的元素。
思路：把所有元素异或后即可得到
 */
public class test1 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums){
            result = result^n;
        }
        return result;
    }
}
