package mrzhang.leecode;

import com.alibaba.fastjson.JSON;
import sun.java2d.pipe.SpanIterator;

/**
 * @author zhangnianlei
 * @date 2020/4/7
 */
public class Solution0407 {

	public static void swap(Integer num1, Integer num2) {
		int temp = num1;
		num1 = num2;
		num2 = temp;
	}

	public static int[][] rotatesout(int[][] matrix) {

		System.out.println("原始数据：" + JSON.toJSONString(matrix));
		int lenght = matrix.length;
		for (int i = 0; i< lenght; i ++) {
			for (int j = i+1; j < lenght; j ++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		System.out.println("以对角线为轴翻转：" + JSON.toJSONString(matrix));

		int mid = lenght >> 1;
		System.out.println("mid: "+ mid);
		for (int i = 0; i< lenght; i ++) {
			for (int j = 0; j < mid; j ++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][lenght-1-j];
				matrix[i][lenght-1-j] = tmp;
			}
		}
		return matrix;
	}


	public static int[][] rotate(int[][] matrix) {

		int lenght = matrix.length;
		for (int i = 0; i< lenght; i ++) {
			for (int j = i+1; j < lenght; j ++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		int mid = lenght >> 1;
		for (int i = 0; i< lenght; i ++) {
			for (int j = 0; j < mid; j ++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][lenght-1-j];
				matrix[i][lenght-1-j] = tmp;
			}
		}
		return matrix;
	}


	/**
	 * 示例1：
	 * 原始数据：
	 * [1,2,3],
	 * [4,5,6],
	 * [7,8,9]
	 * 以对角线为轴翻转：
	 * [1,4,7],
	 * [2,5,8],
	 * [3,6,9]
	 * 每一行以中心点为轴翻转：
	 * [7,4,1],
	 * [8,5,2],
	 * [9,6,3]
	 *
	 * 示例2：
	 * [1,2,3,4],
	 * [5,6,7,8],
	 * [9,10,11,12],
	 * [13,14,15,16]
	 * 以对角线为轴翻转：
	 * [1,5,9,13],
	 * [2,6,10,14],
	 * [3,7,11,15],
	 * [4,8,12,16]]
	 * 每一行以中心点为轴翻转：
	 * [13,9,5,1],
	 * [14,10,6,2],
	 * [15,11,7,3],
	 * [16,12,8,4]]
	 */


	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		System.out.println("每一行以中心点为轴翻转：" + JSON.toJSONString(rotate(matrix)));
	}
}