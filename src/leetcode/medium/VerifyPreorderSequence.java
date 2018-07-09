package leetcode.medium;

public class VerifyPreorderSequence {

    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorderUtil(preorder,0, preorder.length-1);
    }

    private boolean verifyPreorderUtil(int[] preorder, int left, int right) {
        if(right - left < 1){
            return true;
        }

        int root = preorder[left];
        int rightSubTree = right+1;
        for(int i=left+1;i<=right;i++){
            if(preorder[i] > root){
                rightSubTree = i;
                break;
            }
        }

        for(int i=rightSubTree+1;i<=right;i++){
            if(preorder[i] < root){
                return false;
            }
        }

        return verifyPreorderUtil(preorder,left+1,rightSubTree-1) && verifyPreorderUtil(preorder,rightSubTree,right);
    }

    public static void main(String[] args) {
        VerifyPreorderSequence vs = new VerifyPreorderSequence();
        System.out.println(vs.verifyPreorder(new int[]{5,2,1,3,6}));
        System.out.println(vs.verifyPreorder(new int[]{3,1,2}));
        System.out.println(vs.verifyPreorder(new int[]{4,2,3,1}));

    }

}
