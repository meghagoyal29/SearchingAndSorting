package LeetCode.searchingAndSorting;

public class MaxSubArray {
	public static void main(String[] args) {
		int[] input = {-2,-1};
		System.out.println(maxSubArray(input));
	}
	public static int maxSubArray(int[] nums) {
		if(nums==null||nums.length==0) {
			return 0;
		}

        int sum=0; int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
        	sum+=nums[i];
        	if(sum>maxSum) {
            	maxSum=sum;
            }
        	if(sum<0)
            	sum=0;
        }
        return maxSum;
    }
}
