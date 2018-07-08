package LeetCode.searchingAndSorting;

public class BestTimeToBuyAndSell {
	public static void main(String[] args) {
		int[] prices = {7,6,4,3,1,5};
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		if(prices==null|| prices.length==0) {
			return 0;
		}
		int sum=0, maxSum=0;
		for(int i=1;i<prices.length;i++) {
			sum+=prices[i]-prices[i-1];
			if(sum>maxSum)
				maxSum=sum;
			else if(sum<0)
				sum=0;
		}
		
		return maxSum;
	}
}
