package LeetCode.searchingAndSorting;

import java.util.Random;

public class KthLargestElement {
	public static void main(String[] args) {
	//int[] nums = {3,2,3,1,2,4,5,6};
	int[] nums = {3,2,1,5,6,4};
	int k=2; 
	System.out.println(findKthLargest(nums,k));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		return rank(nums,k-1, 0, nums.length-1);
	}
	public static int rank(int[] nums, int k, int start, int end) {
		int pivot = nums[randomIntInRange(start,end)]; 
		int[] partition = partition(nums,start,end,pivot);
		int leftSize = partition[0];
		int middleSize = partition[1];
		if(k<leftSize) {
			return rank(nums,k,start,start+leftSize-1);
		}else if(k<leftSize+middleSize) {
			return pivot;
		}else {
			return rank(nums,k-leftSize-middleSize,start+leftSize+middleSize,end);
		}
		
	}
	private static int randomIntInRange(int start, int end) {
		Random rand = new Random();
		return rand.nextInt(end+1-start)+start;
	}

	public static int[] partition(int[]nums,int start,int end,int pivot){
		//returns array with 2 elements:1 containing end of elements less than mid and size of aray equal to mid
		
		int left = start;//stays at right end of left
		int mid = start;// stays at right end of middle
		int right = end;// stays at left end of right
		int[] partitions = {0,0};
		while(mid<=right) {
			if(nums[mid]>pivot) {
			swap(nums,left,mid);
			left++;
			mid++;
			}else if(nums[mid]<pivot) {
				swap(nums,mid,right);
				right--;
			}else if(nums[mid]==pivot){
				mid++;
			}
		}
		partitions[0] = left-start;
		partitions[1]= right-left+1;
		return partitions;
	}
	static void swap(int[] nums, int left,int right) {
		int temp = nums[left];
		nums[left]=nums[right];
		nums[right] = temp;
	}
}