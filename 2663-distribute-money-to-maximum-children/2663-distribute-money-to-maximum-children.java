class Solution {
    public int distMoney(int money, int children) {
        if ( money / children == 8 && money % children == 0) return children;
        if( money < children ) return -1;
        if( money == 4 && children ==  1) return -1;
       int[] childs = new int[children];
        int index = 0 ;
       while( money > 0 && index< childs.length  ){
           childs[index] ++;
           money--;
           index ++;
       }
        index = 0;
       while( money >=7  && index< childs.length  ){
           childs[index] += 7 ;
           money-=7;
           index ++;
       }

        if (money>=7)
         return children -1;      

        if(childs[childs.length -1 ]  + money  != 4){
            childs[childs.length - 1] +=money;
        }

        else{
            childs[childs.length - 1] +=money -1;
             childs[childs.length - 2] ++;
        }

        int res = 0 ;

        for( int x : childs){
            if ( x ==8 ) res++;
        }

        System.out.print( Arrays.toString(childs));
        return res;
        
    }
}