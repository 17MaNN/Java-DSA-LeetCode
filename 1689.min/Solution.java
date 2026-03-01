class Solution {
    public int minPartitions(String n) {
        int result = 0;

        for(char m : n.toCharArray()){
            result = Math.max(result, Integer.parseInt(Character.toString(m)));
        }
        return result;
    }
}
