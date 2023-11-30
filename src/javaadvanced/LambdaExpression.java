package javaadvanced;


@FunctionalInterface
interface FuncInterface
{
    // An abstract function
    void abstractFunc(int x);

    // A non-abstract (or default) function
    default void normalFunc()
    {
       System.out.println("Hello");
    }
}

public class LambdaExpression {

  // Lambda Expressions implement the only abstract function
  public static void main(String[] args)
    {
        // lambda expression to implement above functional interface.
        // This interface by default implements abstractFun()
        FuncInterface fobj = (int x) -> System.out.println(2*x);

        // This calls above lambda expression and prints 10.
        fobj.abstractFunc(5);
    }
}
