# Approach

We solve the problem in three parts:

1) Single Character Case  
Traverse the string and count consecutive same characters.  
Update the maximum length.

2) Balance Between Any Two Characters  
Skip one character (a, b, or c).  
For the remaining two:
- Maintain (count1 - count2)
- Store first occurrence in a HashMap
- If the same difference appears again, the substring between them is balanced

Repeat for all three skip options.

3) Balance Among All Three Characters  
Maintain:
- diff1 = countA - countB
- diff2 = countA - countC

Store the first occurrence of (diff1, diff2).  
If the same pair appears again, the substring between them has equal a, b, c.

Time Complexity: O(n)  
Space Comp
