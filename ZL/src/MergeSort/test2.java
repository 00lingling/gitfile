package MergeSort;

import java.util.ArrayList;
import java.util.List;

/*
给定一个整数数组 nums，按要求返回一个新数组 counts。
数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */

public class test2 {
    //方法1：暴力破解
    public List<Integer> countSmaller1(int[] nums) {
        int[] result=new int[nums.length];
        for(int i=0;i<=nums.length-1;i++){
            for(int j=i+1;j<=nums.length-1;j++){
                if(nums[i]>nums[j])
                    result[i]++;
            }
        }
        List<Integer> zz=new ArrayList<>(result.length);
        for(int i=0;i<result.length;i++)
            zz.add(result[i]);
        return zz;
    }
    //方法2：利用归并
    public List<Integer> countSmaller2(int[] nums) {
        int[] counts = new int[nums.length];
        int[] pos = new int[nums.length];
        for(int i=0; i<pos.length; i++) pos[i] = i;
        sort(nums, pos, counts, 0, nums.length);
        List<Integer> results = new ArrayList<>(nums.length);
        for(int count : counts) results.add(count);
        return results;
    }
    public void sort(int[] nums, int[] pos, int[] counts, int from, int to) {
        if (from+1>=to) return;
        int m=(from+to)/2;
        sort(nums, pos, counts, from, m);
        sort(nums, pos, counts, m, to);
        int[] merged = new int[to-from];
        int smaller = 0;
        for(int i=from, j=m, k=0; k<merged.length; k++) {
            if (i>=m) {
                merged[k] = pos[j++];
            } else if (j>=to) {
                counts[pos[i]] += smaller;
                merged[k] = pos[i++];
            } else if (nums[pos[i]] <= nums[pos[j]]) {
                counts[pos[i]] += smaller;
                merged[k] = pos[i++];
            } else {
                smaller ++;
                merged[k] = pos[j++];
            }
        }
        for(int i=0; i<merged.length; i++) pos[from+i] = merged[i];
    }
}
