package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie)

    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def isAlive: Boolean = true
    def learns(subject: String): String = s"${this.name} learns $subject"
    def learnsScala: String = learns("Scala")

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(times: Int): String = s"$name watched $favouriteMovie $times times"
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "inception") // equivalent
  // infix notation = operator notation (Syntactic sugar)
  // works with methods that have a single parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Control space
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  // println(mary isAlive)

  // apply
  // calling object like a method, looks for an apply method
  println(mary.apply())
  println(mary()) // equivalent

  //1 overload the plus operator, receives string, returns person with nickname
  /*
  1. overload the + operator
    mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the Person class
    Add a unary + operator => new person with age + 1

  3. Add a "learns" method in Person class => Mary learns "passed in string"
    Add a learnsScala method, calls learns method with "Scala"
    in postfix notation

  4. Overload the apply method
    mary.apply(2) => "Mary watched inception 2 times"

   */

  println((mary + "The Rockstar")())
  println((+mary).age)
  println(mary learns("Magic"))
  println(mary learnsScala)
  println(mary(6))

  /*
  Method notation
  1 parameter method can be called = mary likes "Inception
  - Infix notation

  Unary Operators
  !mary (prefix notation
  mary.unary_!
  + - ~ !

  postfix notation
  methods with no parameters can be called with a space inbetweeb (not used often cos confusing)

  apply methods, allow u to call object like a function
   */
}
