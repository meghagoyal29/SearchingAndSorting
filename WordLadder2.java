package LeetCode.searchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadder2 {
	//needs some work
	public static void main(String[] args) {
		String[] input = {"hot","dot","dog","lot","log","cog"};
		List<String> words = Arrays.asList(input);
		int[]visited = new int[words.size()];
		for(int i=0;i<visited.length;i++) {
			if(!words.get(i).equals("hit"))
			visited[i]=0;
			else visited[i]=1;
		}
		System.out.println(findLadders("hit","cog",words,visited));
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList, int[] visited) {
		List<List<String>> ladders = new ArrayList<>();
		if(!wordList.contains(endWord)) {
			return ladders;
		}
		if(isOneCharAway(beginWord, endWord)) {
			List<String> answer = new ArrayList<>();
			answer.add(beginWord);
			answer.add(endWord);
			ladders.add(answer);
			return ladders;
		}
		List<String> potentialsFromBeginWord = new ArrayList<>();
		for(int j=0;j<wordList.size();j++) {
			String word = wordList.get(j);
			if(isOneCharAway(beginWord,word)&&visited[j]==0) {
				potentialsFromBeginWord.add(word);
			}
	}
		//System.out.println(potentialsFromBeginWord);
		for(String beginPotential:potentialsFromBeginWord) {
			visited[wordList.indexOf(beginPotential)]=1;
			List<List<String>> beginLadders = findLadders(beginPotential,endWord,wordList,visited);
			if(beginLadders!=null) {
				for(List<String> nextLadder:beginLadders) {
				List<String> completeLadder = new ArrayList<>();
				completeLadder.add(beginWord);
				completeLadder.addAll(nextLadder);
				ladders.add(completeLadder);
				visited[wordList.indexOf(beginPotential)]=0;
				}
			}
			
		}
		return ladders;
	}
	

	static boolean isOneCharAway(String word1, String word2){
		int count = 0;
		for(int i=0;i<word1.length();i++) {
			if(word1.charAt(i)!=word2.charAt(i)) {
				count++;
			}
			
		}
	return count==1;	
	}
}
