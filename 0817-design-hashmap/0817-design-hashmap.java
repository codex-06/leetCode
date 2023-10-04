class MyHashMap {

    int[] map = new int[10];

    public MyHashMap() {
        Arrays.fill(map, -1);
    }

    
    public void put(int key, int value) {
        if(map.length > key){
            map[key] = value;
        }
        else{
            int[] newmap = new int[key *2];
            Arrays.fill(newmap, -1);
            for( int i = 0 ; i < map.length ; i ++){
                newmap[i] = map[i];
            }
            newmap[key] = value;
            map = newmap;
        }
    }
    
    public int get(int key) {   
        if (key >= map.length || map[key] == -1){
            return -1;
        }
        return map[key];
    }
    
    public void remove(int key) {
        if( key < map.length ){
            map[key] = -1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */