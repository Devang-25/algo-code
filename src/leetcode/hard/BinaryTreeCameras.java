package leetcode.hard;

import util.Tree.TreeNode;

public class BinaryTreeCameras {
    private enum CameraStatus {
        HAS_CAMERA,
        NO_CAMERA,
        NOT_NEEDED,
    }
    private int cnt;
    public int minCameraCover(TreeNode root) {
        cnt = 0;
        if(dfs(root) == CameraStatus.NO_CAMERA)
            cnt++;
        return cnt;
    }

    private CameraStatus dfs (TreeNode root){
        if(root == null){
            return CameraStatus.NOT_NEEDED;
        }

        CameraStatus left = dfs(root.left);
        CameraStatus right = dfs(root.right);

        if(left == CameraStatus.NO_CAMERA || right==CameraStatus.NO_CAMERA){
            cnt++;
            return CameraStatus.HAS_CAMERA;
        }else if(left == CameraStatus.HAS_CAMERA || right == CameraStatus.HAS_CAMERA){
            return CameraStatus.NOT_NEEDED;
        }else{
            return CameraStatus.NO_CAMERA;
        }

    }
}
