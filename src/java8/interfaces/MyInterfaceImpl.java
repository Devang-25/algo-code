package java8.interfaces;

public class MyInterfaceImpl implements MyInterface, MyInterface2 {

  public void overidableMethod() {
    System.out.println("Overidable method in Implementation class");
  }

  @Override
  public void printDefault() {
    MyInterface.super.printDefault();
    MyInterface2.super.printDefault();
  }
}
