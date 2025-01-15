package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  // private, protected, no modifier
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String = "domestic") extends Animal {
//    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRiding vs overLoading (multiple methods with diff signatures with the same name in same class)

  // super - uses method from super class

  // preventing overrides
  // 1 - use keyword final on member
  // 2 - final on entire class
  // 3 - seal the class, can extend classes in THIS FILE, prevents extension in other files (exhaustive in hierachy)


}
