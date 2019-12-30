package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2019/11/29
 */
public class Solution {
	public static int removeDuplicates(int[] nums) {
		int i = 1;
		int n = 0;
		while (i < nums.length){
			if(nums[n] == nums[i]){
				i ++;
			}else {
				nums[n+1] =nums[i];
				n++;
				i++;
			}
		}
		return n+1;
	}

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int i = removeDuplicates(nums);
		System.out.println(i);
	}
}
