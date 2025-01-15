package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Taijaun", 26)
  println(person.x)
  person.greet("Bob")
  person.greet()

  val writer = new Writer("Taijaun", "Pitt", 1997)
  writer.fullname()

//  val novel = new Novel(name = "How to not be poor", release = 2010, author = writer)
//  val rerelease = novel.copy(2015)
//  println(rerelease.release)

  val author = new Writer(firstname = "Charles", "Dickens", 1812)
  val imposter = new Writer(firstname = "Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy())

  val counter = new Counter(8)
  counter.increment(6).print
  counter.decrement(6).print


}

// Constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  // method
  // this refers to the class
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading, method with same name but different signatures
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
Novel and Writer class

Writer: first name, surname, year
  - method fullname

Novel: name, year of release, author
- authorAge - returns age of author at year of release
- iswrittenBy(author)
- copy ( new year of release) = returns new instance of Novel with new year of release
*/

// class parameters are NOT FIELDS

class Writer(firstname: String, surname: String, val year: Int) {

  def fullname(): String = s"${this.firstname} ${this.surname}"
}

class Novel(val name: String, val release: Int, author: Writer) {

  def authorAge(): Int = release - author.year

  def isWrittenBy(): String = author.fullname()

  def copy(year: Int): Novel = new Novel(name, year, author)
}

// instances should be fixed, not modified inside
// always return a new instance
class Counter(val num: Int = 0) {

  def currentCount = this.num

  def increment = {
    println("Incrementing")
    new Counter(num + 1)
  }

  def increment(by: Int): Counter = {
    if (by <= 0) this
    else increment.increment(by - 1)
  }

  def decrement = {
    println("Decrementing")
    new Counter(num - 1)
  }

  def decrement(by: Int): Counter = {
    if (by <= 0) this
    else decrement.decrement(by - 1)
  }

  def print = println(currentCount)


}