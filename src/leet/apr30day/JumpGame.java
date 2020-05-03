package leet.apr30day;

class JumpGame {
  public boolean canJump(int[] nums) {
    int maxReachableIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (maxReachableIndex >= nums.length - 1) {
        return true;
      }
      if (i > maxReachableIndex) {
        return false;
      }
      maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);
    }
    return true;
  }

  public static void main(String[] args) {
    JumpGame jg = new JumpGame();
    System.out.println(jg.canJump(new int[] { 2, 3, 1, 1, 4 }));
    System.out.println(jg.canJump(new int[] { 3, 2, 1, 0, 4 }));
  }
}
