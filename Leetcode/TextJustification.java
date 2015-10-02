/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.

��������ڴ�����ַ���������Ҫ��һ�����ʰ��ųɶ����޶����ȵ��ַ�������Ҫ�ѵ����ڿո�İ��ţ�����ÿ������֮������пո������������ǰ�зŲ��¸���ĵ��ʲ����ַ��ֲ�����������Lʱ��
����Ҫ�ѿո���ȵ�����ڵ���֮�䡣���ʣ��Ŀո����պ��Ǽ��������ô�;��ȷ��伴�ɣ����򻹱���Ѷ��һ���ո�ŵ�ǰ��ļ�����档ʵ��������ά��һ��count������¼��ǰ���ȣ�
����֮�����Ǽ��㹲ͬ�Ŀո����Լ����һ���Ŀո�����Ȼ�󽫵����ַ���������������һ��ϸ�ھ������һ�в���Ҫ���ȷ���ո񣬾�β���վͿ��ԣ�����Ҫ��������һ�¡�ʱ����������Ҫɨ�赥��һ�飬
Ȼ�����ҵ���β��ʱ����ɨ��һ�鵱ǰ�еĵ��ʣ���������ÿ�����ʲ��ᱻ���ʳ������飬��������ʱ�临�Ӷ���O(n)�����ռ临�Ӷ����ǽ���Ĵ�С�������������ͳ����йأ�����׼ȷ���壬���֪���������r������O(r*L)��
 */
package Leetcode;

import java.util.ArrayList;

public class TextJustification {
		   public ArrayList<String> fullJustify(String[] words, int L) {
		    ArrayList<String> res = new ArrayList<String>();
		    if(words==null || words.length==0)
		        return res;
		    int count = 0;
		    int last = 0;
		    for(int i=0;i<words.length;i++)
		    {
		        if(count+words[i].length()+(i-last)>L)
		        {
		            int spaceNum = 0;
		            int extraNum = 0;
		            if(i-last-1>0)
		            {
		                spaceNum = (L-count)/(i-last-1);
		                extraNum = (L-count)%(i-last-1);
		            }
		            StringBuilder str = new StringBuilder();
		            for(int j=last;j<i;j++)
		            {
		                str.append(words[j]);
		                if(j<i-1)//���һ�����ʲ�����Ҫ�ո�
		                {
		                    for(int k=0;k<spaceNum;k++)
		                    {
		                        str.append(" ");
		                    }
		                    if(extraNum>0)
		                    {
		                        str.append(" ");
		                    }
		                    extraNum--;
		                }
		            }
		            for(int j=str.length();j<L;j++)
		            {
		                str.append(" ");
		            }       
		            res.add(str.toString());
		            count=0;
		            last=i;
		        }
		        count += words[i].length();
		    }
		    
		    //This is for the case with the word[].length==0 and L>0
		    StringBuilder str = new StringBuilder();
		    for(int i=last;i<words.length;i++)
		    {
		        str.append(words[i]);
		        if(str.length()<L)
		            str.append(" ");
		    }
		    for(int i=str.length();i<L;i++)
		    {
		        str.append(" ");
		    }
		    res.add(str.toString());
		    return res;
		}
		
	
	public static void main(String[] args){
		TextJustification t=new TextJustification();
		String[] words={"This", "is", "an", "example", "of", "text", "justification."};
		t.fullJustify(words, 16);
	}
}
