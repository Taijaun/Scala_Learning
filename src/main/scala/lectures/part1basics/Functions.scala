package lectures.part1basics

object Functions extends App {

  // single expression function
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))


  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }


  println(aRepeatedFunction("hello", 4))

  // WHEN YOU NEED LOOPS, USE RECURSION. (FUNDAMENTAL FOR FUNCTIONAL PROGRAMMING)

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }


  /*
    1. A greeting function (name, age) => "Hi, my name is $name, and I am $age years old"
    2. A Factorial function, compute product of all numbers up to a given number
    3. fibonacci function
      f(1)
      f(2)
      f(n) = f(n - 1) + f(n - 2)
    4. Tests if a number is prime
   */

  def aGreetingFunction(name: String, age: Int): String = {s"Hi, my name is $name, and I am $age years old"}
  println(aGreetingFunction("Taijaun", 27))

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  println(fibonacci(8))


  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
}
