package java8.interfaces;

public interface MyInterface2 {
  default public void printDefault() {
    System.out.println("From default implementation in interface 2");
  }

  public static void printStatic() {
    System.out.println("From MyInterface 2 static method");
  }

  public void overidableMethod();
}
