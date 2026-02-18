class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        for(int i=0; i<s.length(); i++){
            if(char1[i] != char2[i]){
                return false;
            }
        }
        return true;
    }
}
