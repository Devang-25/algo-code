package java8.interfaces;

public interface MyInterface {
  default public void printDefault() {
    System.out.println("From default implementation in interface");
  }

  public static void printStatic() {
    System.out.println("From myInterface static method");
  }

  public void overidableMethod();
}
