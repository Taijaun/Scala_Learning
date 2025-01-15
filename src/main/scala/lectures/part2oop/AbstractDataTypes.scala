package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract, no values supplied
  // made to be extended later
  // can have abstract and non-abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("Crunch crunch")
  }

  // traits
  // can have abstract and non-abstract
  // traits do not have constructor paramenters
  trait Carnivore {
    def eat (animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  /*
  Traits vs abstract classes
    1 - traits do not have constructor parameters (possible in scala 3)
    2 - multiple traits may be inherited by the same class (single class inheritance, multiple trait inheritance)
    3 - traits = behaviour, abstract class = "thing"
   */

}
