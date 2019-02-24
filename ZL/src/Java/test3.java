package Java;
/*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
思路：
利用二维数组由上到下，由左到右递增的规律，
那么选取左下角的元素a[i][j]与target进行比较，
当target小于元素a[i][j]时，那么target必定在元素a所在列的上面,
即i--；
当target大于元素a[i][j]时，那么target必定在元素a所在行的右边,
即j++；
 */

public class test3 {
    public boolean Find(int target, int [][] array) {
        int row=array.length;
        int col=array[0].length;
        for(int i=row-1,j=0;i>=0&&j<=col-1;){
            if(target==array[i][j])
                return true;
            if(target<array[i][j]){
                i--;
                continue;
            }
            if(target>array[i][j]){
                j++;
                continue;
            }
        }
        return false;
    }
}
