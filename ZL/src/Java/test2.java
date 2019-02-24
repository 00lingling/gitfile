package Java;

import java.util.Arrays;
/*给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，
那么整个数组都会变为升序排序。你找到的子数组应是最短的，请输出它的长度
 */

public class test2 {
    //方法1：复制原数组，然后对原数组进行排序，比较排序后的数组与原数组的重合情况。
    public int findUnsortedSubarray1(int[] nums) {
        int[] temp=nums.clone();
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(temp[i]!=nums[i]&&temp[j]!=nums[j])
                break;
            else if(temp[j]!=nums[j])
                i++;
            else if(temp[i]!=nums[i])
                j--;
            else
            { i++;
                j--;
            }

        }
        if(i>=j) return 0;
        return j-i+1;
    }
    /*方法2：因为是从小到大排序
    从左往右看，如果突然出现一个比前面小的数，则结束位置即在此；
    从右往左看，如果突然出现一个比后面大的数，则开始位置即在此；
    */
    public int findUnsortedSubarray2(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int max=nums[0];
        int min=nums[nums.length-1];
        int start=0;
        int end =-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<max)
                end=i;
            else
                max=nums[i];
            if(nums[nums.length-1-i]>min)
                start=nums.length-1-i;
            else
                min=nums[nums.length-1-i];
        }
        return end-start+1;
    }
}
