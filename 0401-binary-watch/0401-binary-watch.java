class Solution {
    public void binary(int hrs , int mins ,boolean[] hrvis, boolean[]minvis, int lights, List<String> res){
        if(lights ==0 ){
            if( hrs >11 ||mins >59) return;
            String result = "" + hrs;
            result =  mins < 10 ? result+":0" + mins: result +":"+ mins;
            if( res.contains(result))return;
            res.add( result);
            return;
        }
        for ( int i = 0 ; i < hrvis.length ; i ++){
            if( ! hrvis[i]){
                hrvis[i] = true;
                binary( hrs + (int)Math.pow(2,i), mins, hrvis, minvis, lights -1, res);
                hrvis[i] = false;
            }

        }
        for ( int i = 0 ; i < minvis.length ; i ++){
            if( ! minvis[i]){
                minvis[i] = true;
                binary( hrs,mins +(int) Math.pow(2,i), hrvis, minvis, lights -1, res);
                minvis[i] = false;
            }
            
        }


    }


    public List<String> readBinaryWatch(int turnedOn) {
        boolean[] hrvis = new boolean[4];
        boolean[] minvis = new boolean[6];

        List<String> res = new ArrayList<>();

        binary(0, 0 , hrvis, minvis, turnedOn, res);
        return res; 
    }
}