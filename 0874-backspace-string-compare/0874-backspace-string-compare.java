class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for( int i =0 ; i < s.length(); i ++){
            String temp = s.substring(i,i +1);

            if(temp.equals("#") && ! stack1.isEmpty()){
                stack1.pop();
            }
            else if(! temp.equals("#")){
                stack1.push(temp);
            }
        }

        for( int i =0 ; i < t.length(); i ++){
            String temp = t.substring(i,i +1);

            if(temp.equals("#") && ! stack2.isEmpty()){
                stack2.pop();
            }
            else if(! temp.equals("#")){
                stack2.push(temp);
            }
        }

        if( stack1.size() !=  stack2.size()) return false;

        while(! stack1.isEmpty()){
            if(! stack1.pop().equals(stack2.pop())) return false;
        }
        return true;
    }
}