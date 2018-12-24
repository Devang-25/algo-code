package medium;

/**
 * Created by mns on 11/18/18.
 */
public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        if(heights == null || heights.length == 0){
            return heights;
        }

        while(V != 0){
            boolean found = false;
            int pos = K;
            for(int i=K-1;i>=0;i--){
                if(heights[i] < heights[pos]){
                    pos = i;
                    found = true;
                }else if(heights[i] > heights[pos]){
                    break;
                }
            }

            if(found){
                heights[pos]++;
                V--;
                continue;
            }

            for(int i=K+1;i<heights.length;i++){
                if(heights[i] < heights[pos]){
                    pos = i;
                    found = true;
                }else if(heights[i] > heights[pos]){
                    break;
                }
            }

            if(found){
                heights[pos]++;
                V--;
            }else{
                heights[K]++;
                V--;
            }
        }

        return heights;
    }
}
