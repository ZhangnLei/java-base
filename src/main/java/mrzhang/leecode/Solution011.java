package mrzhang.leecode;

/**
 * 最大容量的容器
 * @author zhangnianlei
 * @date 2020/1/1
 */
public class Solution011 {
	public static int maxArea1(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j-i));
			}
		}
		return maxArea;
	}

	public static int maxArea(int[] height){
		int maxArea = 0;
		int i = 0, j = height.length-1;
		while (i < j){
			maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j-i));
			if (height[i] < height[j]){
				i ++;
			}else {
				j --;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] x = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(x));
	}
}
