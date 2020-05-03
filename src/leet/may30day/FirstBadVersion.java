package leet.may30day;

import java.lang.reflect.Field;

abstract class VersionControl {
  abstract boolean isBadVersion(int version);
}

public class FirstBadVersion extends VersionControl {
  private int y;

  FirstBadVersion(int y) {
    this.y = y;
  }

  public int firstBadVersion2(int n) {
    int left = 1;
    int right = n;
    int firstBadVersion = -1;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (this.isBadVersion(mid)) {
        firstBadVersion = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return firstBadVersion;
  }

  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    int firstBadVersion = -1;
    while (left <= right) {
      int rand = left + (int) (Math.random() * (right - left));
      if (this.isBadVersion(rand)) {
        firstBadVersion = rand;
        right = rand - 1;
      } else {
        left = rand + 1;
      }
    }

    return firstBadVersion;
  }

  public int firstBadVersionHack() throws IllegalAccessException, IllegalArgumentException {
    Field[] fields = this.getClass().getDeclaredFields();
    return fields[0].getInt(this);
  }

  @Override
  boolean isBadVersion(int version) {
    return version >= y;
  }

  public static void main(String[] args) throws IllegalAccessException {
    FirstBadVersion fb = new FirstBadVersion(1702766719);
    System.out.println(fb.firstBadVersion(2126753390));
    System.out.println(fb.firstBadVersion(2126753390));
  }
}
