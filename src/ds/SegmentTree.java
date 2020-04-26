/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

/**
 *
 * @author mns
 */
public class SegmentTree {
    
    int [] array;
    int originalSize;
    
    public SegmentTree(int [] arr){
        int height = (int)Math.ceil(Math.log(arr.length)/ Math.log(2));
        this.originalSize = arr.length;
        int size =  Math.max((int)Math.pow(2, height+1) - 1 , 0);
        //or int size = 2*originalSize-1;
        this.array = new int[size];
        
        constructSegmentTree(arr, 0,originalSize-1,0);
    }
    
    private int constructSegmentTree(int [] arr, int start, int end, int index){
        int subTreeLength = end - start;
        
        if(subTreeLength == 0){
            this.array[index] = arr[start];
            return arr[start];
        }
        
        if(subTreeLength > 0){
            int mid = start + (end - start)/2;
            
            int leftVal = constructSegmentTree(arr, start, mid,2*index+1);
            int rightVal = constructSegmentTree(arr,mid+1, end,2*index+2);
            
            this.array[index] = leftVal+rightVal;
            return this.array[index];
        }
        
        return 0;
    }
    
    public void update(int ind, int newVal) {
        this.updateUtil(ind, newVal, 0, this.originalSize-1,0);
    }
    
    private int updateUtil(int ind, int newVal, int start, int end, int index){        
        int mid = start + (end-start)/2;
        
        if(start == end){
            this.array[index] = newVal;
            return this.array[index];
        }
        
        int leftVal,rightVal;
        if(ind <= mid){
            leftVal = updateUtil(ind, newVal, start, mid, 2*index+1);
            rightVal = this.array[2*index+2];
            
        }else{
            leftVal = this.array[2*index+1];
            rightVal = updateUtil(ind,newVal,mid+1,end,2*index+2);
        }
        
        this.array[index] = leftVal+rightVal;
        return leftVal+rightVal;
        
    }
    
    public int getVal(int start, int end){
        return getValUtil(start,end,0,this.originalSize-1,0);
    }
    
    private int getValUtil(int start, int end, int left, int right, int index){
        
        if(start <= left && end >= right){
            return this.array[index];
        }
        
        if((start > right && end > right) || (start < left && end <left))
            return 0;
        
        int mid = left + (right -left)/2;
        int leftVal = getValUtil(start,end,left,mid,2*index+1);
        int rightVal = getValUtil(start,end,mid+1,right,2*index+2);
        
        return leftVal + rightVal;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i=0;i<this.array.length;i++){
            s+=this.array[i] + ",";
        }
        
        return s;
    }
    
    public static void main(String[] args) {
        SegmentTree st = new SegmentTree(new int [] {1,2,3,4,5,6,7,8});
        System.out.println(st);
        System.out.println(st.getVal(0, 5));
        System.out.println(st.getVal(0, 4));
        System.out.println(st.getVal(1, 2));
        System.out.println(st.getVal(5, 5));
        st.update(7, 0);
        st.update(6, 0);
        st.update(5, 0);
        st.update(4, 0);
        st.update(3, 0);
        st.update(2, 0);
        st.update(1, 0);
        st.update(0, 0);
        
        System.out.println(st);
    }
}
