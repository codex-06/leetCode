class Solution {
   public String convert(String s, int numRows){
       HashMap<Integer, String> map = new HashMap<>();
        for( int i = 0 ; i < numRows; i ++){
           map.put(i, "");
        }

        int index = 0;
        while( index < s.length()){
           for(int j = 0 ; j < numRows && index < s.length(); j ++){
               map.put(j, map.get(j) + s.charAt(index));
               index++;
           }

           for( int j = numRows -2; j >0 && index < s.length() ; j--){
               map.put(j, map.get(j) + s.charAt(index));
               index++;
           }
        }

       String res = "";

       for(int k = 0 ; k < numRows; k ++){
           res+=map.get(k);
       }

       return res;
    }
}