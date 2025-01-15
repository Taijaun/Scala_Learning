package lectures.part1basics

import scala.annotation.tailrec

object RecursionExamples extends App{

  /*
  1. Factorial Calculation

  Base case: Factorial(0) or Factorial(1) return accumulator which is 1
  Recursive case: Factorial(n) is calculated as n * factorial(n-1)
   */
  def factorial(n: Int): BigInt = {
    @tailrec
    def helper(n: Int, acc: BigInt): BigInt = {
      if (n <= 1) acc
      else helper(n - 1, acc * n)
    }
    helper(n, 1)
  }

  /*
  2. Sum of Digits

  Base case: if n == 0, return acc (sum of the digits so far)
  Recursive case: Add the last digit (n % 10) to accumulator, and call helper with n / 10
   */

  // This works because there is no decimal
  def sumOfDigits(n: Int): Int = {
    @tailrec
    def helper(accumulator: Int, n: Int): Int = {
      if (n == 0) accumulator
        // n % 10, takes away all digits but the last one
        // so n becomes that digit, eg 1095, becomes 5
        // Then call helper again with n/10
        // which removes the final digit, making it 109
      else helper(accumulator + n % 10, n / 10)
    }
    helper(0, n)
  }

  /*
  3. Print Numbers

  Base case: If current <= 0
  recursive case: print current, call helper with current -1
   */

  def printNumbers(n: Int): Unit = {
    def helper(current: Int): Unit = {
      // If current number is higher than 0, print, then call helper again with reduced counter.
      if (current > 0) {
        println(current)
        helper(current - 1)
      }
    }

    helper(n)
  }

  printNumbers(17)

  /*
  4. Reverse a String

  Base Case: If remaining is empty, return accumulator
  Recursive case: Add first character of remaining to acc, then call helper with remaining.tail
   */

  def reverseString(s: String): String = {
    @tailrec
    def helper(accumulator: String, remaining: String): String = {
      // If the remaining string is empty, return the accumulator
      if(remaining.isEmpty) accumulator
        // If remaining string is not empty
      else helper(remaining.head + accumulator, remaining.tail)
    }
    helper("", s)
  }

  println(reverseString("Olive"))


  /*
  5. Check Palindrome
  Checks if a string is a palindrome, by comparing characters from both ends one at a time
  Base case: If start >= end, return true (all characters matched
  Base case 2: If start != end, return false
  Recursive case: Compare s(Start) and s(end), then call helper with start + 1 and end - 1

   */

  def isPalindrome(s: String): Boolean = {
    @tailrec
      // define helper function that takes in the first and last characters
    def helper(start: Int, end: Int): Boolean = {
      // Check if start index is greater than or equal to end index
      // If true, all characters have been checked, return true
      if (start >= end) true
        // If the two characters being checked do not match, return false
      else if (s(start) != s(end)) false
      else helper(start + 1, end - 1)
    }
    helper(0, s.length - 1)
  }

  println(isPalindrome("racecar"))


}