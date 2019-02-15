package threadDemo;

import java.util.Arrays;

public class MegerSort {
    public static void main(String[] args){
        //定义一个无序数组
        int[] arrays = {50,10,90,30,70,40,80,60,20};
        //对数组进行排序
        megerSort(arrays, 0, arrays.length-1);
        //打印排序后对数组
        System.out.println(Arrays.toString(arrays));
    }

    public static void megerSort(int[] a, int low, int high){
        if (low < high){
            //将数组划分为左右两个半子数组（二叉树）
            int mid = (low + high)/2;
            //对子数组进行递归划分为更小对子数组，知道无法继续分割
            megerSort(a, low, mid);
            megerSort(a, mid + 1,high);
            //将两个有序子数组进行合并，合并后对数组仍然为有序数组
            meger(a, low, mid, high);
        }
    }

    public static void meger(int[] a, int low, int mid, int high){
        //定义左侧指针
        int left = low;
        //定义右侧指针
        int right = mid + 1;
        //比较左子树对最大元素与右子树对最小元素，由于左右子树本身以为有序，
        // 故左子树最大元素<右子树最小元素时，不需要重新排序，直接返回即可
        if(a[mid] <= a[mid+1]){
            return;
        }
        //定义临时数组，长度为当前左右子树数组的长度和
        int[] temp = new int[high-low+1];
        //定义临时数组初始下标
        int k = 0;
        //从左右子树的最小元素对比取最小值放入临时数组中
        while (left <= mid && right<=high){
            temp[k++] = (a[left]<=a[right]) ? a[left++] : a[right++];
        }
        //当右子树放完，左子树剩余元素直接追加放入临时数组中
        while (left <= mid){
            temp[k++] = a[left++];
        }
        //当左子树放完，右子树剩余元素直接追加放入临时数组中
        while (right <= high){
            temp[k++] = a[right++];
        }
        //将临时数组中当数据更新到原数组的对应位置
        for(int k2 = 0; k2<temp.length; k2++){
            a[k2+low] = temp[k2];
        }
    }
}
