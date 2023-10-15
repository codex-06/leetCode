class Solution {
    public String reverseWords(String s) {
        s.trim();
        String[] string = s.split(" ");

        String res = "";

        for( String x : string){
            if (!x.matches("^\s*$"))
                res = x.trim() + " " + res;
        }
        System.out.print(Arrays.toString(string));
        return res.trim();
    }
}