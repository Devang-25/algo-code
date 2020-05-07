package leet.may30day;

public class MajorityElement {
  public int majorityElement(int[] nums) {
    int majorityElement = nums[0];
    int cnt = 1;

    for (int i = 1; i < nums.length; i++) {
      if (majorityElement == nums[i]) {
        cnt++;
      } else {
        cnt--;
        if (cnt < 0) {
          cnt = 0;
          majorityElement = nums[i];
        }
      }
    }
    return majorityElement;
  }

  public static void main(String[] args) {
    MajorityElement m = new MajorityElement();
    System.out.println(m.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
  }
}
