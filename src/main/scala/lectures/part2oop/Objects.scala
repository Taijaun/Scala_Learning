package lectures.part2oop

object Objects extends App {

  // SCALA DOES not HAVE CLASS-LEVEL FUNCTIONALITY ("Static")
  object Person { // type + its only instance
    // "Static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary =  new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person2 == person1)

  // apply method used as a constructor
  val bobby = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

  /*
  Scala doesn't have static values/methods
  Scala objects:
    - are their own class
    - are singletons
  Scala companions
    - Can access each other's private members
    - Scala is more OO than Java
  Scala applications
    - extends App
    - def main(args: Array[String]): Unit
   */

}
