package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of words and a width maxWidth, format the text such that each line has exactly 
maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a 
line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified because it contains only one word.

Example 3:
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 */
public class n068_Text_Justification {
	//https://www.youtube.com/watch?v=ENyox7kNKeY
	//MIT: Introduction to Algorithms 
	//20. Dynamic Programming II: Text Justification, Blackjack

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		int index = 0;

		while(index < words.length) {
			int count = words[index].length();		//words length in the line
			int last = index + 1;					//latest word index for the line
			
			while(last < words.length) {
				//out of bound, why 1, for one space
				if(words[last].length() + count + 1 > maxWidth) {
					break;
				}
				//plus one for the space, if its a perfect fit it will fit
				count = count + words[last].length() + 1;
				last++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(words[index]);						//append first word for the line

			//rest of the words after removed the first append word in the line
			int rest = last - index - 1;					//rest# from index to last-1

			//if last line or number of words in the line is 1 (only one word), left-justified 
			if(last == words.length || rest == 0) {
				//last line
				for(int i=index+1; i<last; i++) {
					sb.append(" ");
					sb.append(words[i]);
				}
				//only rest of the one word in the line or rest of the spaces in the line
				for(int i=sb.length(); i<maxWidth; i++) {
					sb.append(" ");
				}
			} else {
				//not last line, do middle justified
				//total spaces# in the line (maxWidth  - count)
				int space = (maxWidth - count) / rest;		//the space for add after each words
				int extraSpace = (maxWidth - count) % rest;			//ave extra space add for each words
				
				for(int i=index+1; i<last; i++) {			//F: why index+1, cuz first word already append. last not rest!!!
					for(int k=space; k>0; k--) {			//>0 not >=0 !!! careful !
						sb.append(" ");
					}
					if(extraSpace > 0) {								//F: > 0  , if!!!
						sb.append(" ");
						extraSpace--;									//-- 
					}
					sb.append(" ");
					sb.append(words[i]);
				}
			}
			res.add(sb.toString());
			index = last;									//update index!!!
		}
		return res;
	}

	public static void main(String[] args) {
		n068_Text_Justification obj = new n068_Text_Justification();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(obj.fullJustify(words, 16));
		String[] words1 = {"What","must","be","acknowledgment","shall","be"};
		System.out.println(obj.fullJustify(words1, 16));
	}
}
