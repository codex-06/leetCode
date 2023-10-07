class Solution {
    
    
    public boolean valid(String a, String b){
        
        boolean flag = false;

        for (int i = 0 ; i < a.length(); i ++){
            if(a.charAt(i) != b.charAt(i)){
                if(flag){
                    return false;
                }
                else flag = true;
            }
        }

        return true;
    }

    public void add(String a, String b,  HashMap <String, ArrayList<String>> adj){
        if(adj.containsKey(a)){
            adj.get(a).add(b);
        }
        else{
            ArrayList<String> temp = new ArrayList<>();
            temp.add(b);
            adj.put(a,temp);
        }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashMap <String, ArrayList<String>> adj = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(wordList.get(0),Integer.MAX_VALUE);


        boolean flag = false;

        for(int i = 0 ; i < wordList.size() -1; i ++){
            for ( int j = i + 1; j< wordList.size() ; j++){
                String a = wordList.get(i);
                String b = wordList.get(j);

                if ( b.equals(endWord)) flag = true;    

                distance.put(b,Integer.MAX_VALUE);
                if(valid(a,b)){
                    add(a,b,adj);
                    add(b,a,adj);
                }
            }
        }

        if( ! wordList.get(0).equals(endWord) && !flag) return 0;

        distance.put(beginWord,0);

        // for(String x : adj.keySet()){
        //     System.out.print(x + " :");
        //     System.out.print(adj.get(x));
        // }


        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while (!q.isEmpty()){
            String curr = q.poll();
            for( String x : adj.get(curr)){
                if(distance.get(x) > distance.get(curr) +1){
                    distance.put(x,distance.get(curr) +1);
                    q.add(x);
                }
            }
        }

        return distance.get(endWord) == Integer.MAX_VALUE ? 0:distance.get(endWord) +1;
    }
}