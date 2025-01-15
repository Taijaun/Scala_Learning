package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // PRIORITISE TAIL RECURSION, use recursive call as the last expression
  // Use @tailrec to check if tail recursive

  // When loops are needed, use TAIL RECURSION

  // Keep doing recursive questions

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
    Use accumulator to store intermediate results
   */

  def aGreetingFunction(name: String, age: Int): String = {s"Hi, my name is $name, and I am $age years old"}

  // Recursive that prints directly
  def aRecursiveGreeting(n: Int): Unit = {
    @tailrec
    def helper(n: Int): Unit = {
      if (n > 0) {
        println("Hi, my name is Taijaun")
        helper(n-1)
      }
    }
    helper(n)
  }
  aRecursiveGreeting(5)

  // Recursive that doesn't print
  def aSecondGreeting(n: Int): String = {
    @tailrec
      // Helper function to perform the recursion
    def helper(n:Int, accumulator: String): String = {
      // As long as n is greater than 0, print whatever value the accumulator is, and the string value
      // decrement the value of n for the loop
      // If n is not greater than 0, print the value of the accumulator
      if (n > 0) helper(n - 1, accumulator + "Hi, my name is Taijaun ")
      else accumulator
    }

    helper(n, " ")
  }

  def simpleRecursiveLoop(n: Int): String = {
    @tailrec
    def helper(n:Int, accumulator: String): String = {
      if (n > 0) helper(n - 1, accumulator + n)
      else accumulator
    }
    helper(n,"")
  }

  println(simpleRecursiveLoop(7))

  @tailrec
    def isPrime(n: Int, x: Int): Boolean =
    if(x > n/2) true
    else if (n % x == 0) false
    else isPrime(n, x + 1)

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)


  def tailFibonacci(n: Int): BigInt = {
    @tailrec
      // Initialise helper function with first two fibonacci numbers: a = 0 b = 1
      // helper maintains two variables, which represent two most recent Fibonacci numbers
    def helper(n: Int, a: BigInt, b: BigInt): BigInt = {
      /*
      Base cases:
      If n == 0, return a (0th fibonacci is 0)
      If n == 1, return b (1st Fibonacci is 1)
       */
      if (n == 0) a
      else if (n == 1) b
        // For all other cases, decrement n, and call helper function
        // b becomes the new a, a + b becomes the new b
      else helper(n - 1, b, a + b)
    }
    helper(n, 0, 1)
  }

  println(aSecondGreeting(6))

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)


  def factorialRecursive(n: Int): Int = {
    def helper(n: Int, accumulator: Int): Int = {
      // as long as n is higher than 1, continue looping
      // decrement n by 1 for every loop
      // accumulate the value by multiplying accumulator by n
    if (n > 1) helper(n - 1, accumulator * n)
      // when n reaches 1, end the operation and return the value of accumulator
    else accumulator
    }
    helper(n, 1)
  }

  // as long as n is greater than 1, print a value
  def printNumbers(n:Int): String = {
    def helper(n: Int, accumulator: String): String = {
      // if n > 0, print n, then decrement n by 1
      if (n > 0) helper(n-1, accumulator + n)
        // if n smaller than 0, print accumulator (empty string)
      else accumulator
    }

    helper(n, "")
  }

  println(printNumbers(8))


}



