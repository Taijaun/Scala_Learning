package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2 // Expression
  println(x)

  // + - * / & | ^ << >> >>>
  // ^ (exclusive or)
  // >>> (right shift with zero extension


  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  //Loops

  var i = 0
  while (i < 10){
    println(i)
    i += 1
  }

  // NEVER USE THIS AGAIN ( AVOID WHILE LOOPS )

  // EVERYTHING in Scala is an Expression!!!!!
  // Had an error for this
  var aVariable: Int = 0
  val aWeirdValue: Unit = (aVariable = 3) // Unit === void
  println(aWeirdValue)


  // side effects: println(), whiles, reassigning, return unit

  val aCOdeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // Instructions are executed, expressions are evaluated

  // 1. Difference between "hello world" vs println("hello world")?
  //    string is a value of type string (string literal)
  //    println is a side effect, expression returning unit
  // 2.
  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

}
