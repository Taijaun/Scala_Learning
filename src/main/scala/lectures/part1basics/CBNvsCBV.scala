package lectures.part1basics

object CBNvsCBV extends App {

  // exact value is computed before the function evaluates
  // X is evaluated once
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // call by name when you want to delay usage

  // arrow means called by name
  // Evaluated every time
  // X is evaluated two separate times
  // Useful in things that might fail, or lazy streams
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  //delays parameter call until its used
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)
  printFirst(34, infinite())
}
