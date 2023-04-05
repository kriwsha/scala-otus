package module1

import sun.security.util.Password

import java.io.{Closeable, File}
import scala.io.{BufferedSource, Source}
import scala.util.{Try, Using}


object type_system {

  /**
   * Scala type system
   *
   */



  def absurd(v: Nothing) = ???


  // Generics

  // работа с ресурсом

//  lazy val file: File = ???
//
//  lazy val source: BufferedSource = Source.fromFile(file)
//
//  lazy val lines: List[String] = source.getLines().toList
//
//  source.close()
//
//  val lines2 = try{
//    source.getLines().toList
//  } finally {
//    source.close()
//  }
//
//
//  def ensureClose[S <: Closeable, R](source: S)(f: S => R): R = {
//    try{
//      f(source)
//    } finally {
//      source.close()
//    }
//  }
//
//  val result1: List[String] = ensureClose(source)(s => s.getLines().toList)



  // ограничения связанные с дженериками


    /**
     *
     * class
     *
     * конструкторы / поля / методы / компаньоны
     */

    class User private (val email: String, val password: String){

      def this(email: String) = this(email, "123")

    }

    val user: User = User.from("foo@foo.com", "123")

    object User {
      def from(email: String, password: String): User =
        new User(email, password)
    }






    /**
     * Задание 1: Создать класс "Прямоугольник"(Rectangle),
     * мы должны иметь возможность создавать прямоугольник с заданной
     * длиной(length) и шириной(width), а также вычислять его периметр и площадь
     *
     */


    /**
     * object
     *
     * 1. Паттерн одиночка
     * 2. Ленивая инициализация
     * 3. Могут быть компаньоны
     */


    /**
     * case class
     *
     */

    case class User2(email: String, password: String)

    val u2 = User2("foo@foo.com", "123")

    val u3 = u2.copy(password = "345")


    // создать case класс кредитная карта с двумя полями номер и cvc


    /**
     * case object
     *
     * Используются для создания перечислений или же в качестве сообщений для Акторов
     */


    /**
     * trait
     *
     */

    trait WithId{
      def id: String
    }

    sealed trait UserService{
      def getUserById(id: String): User
      def save(u: User): Unit
    }

    class UserServiceImpl extends UserService with WithId {
      def getUserById(id: String): User = ???

      def save(u: User): Unit = ???

      def id: String = ???
    }

    val uu = new UserService with WithId {
      override def getUserById(id: String): User = ???

      override def save(u: User): Unit = ???

      def id: String = ???
    }






  class A {
    def foo() = "A"
  }

  trait B extends A {
    override def foo() = "B" + super.foo()
  }

  trait C extends B {
    override def foo() = "C" + super.foo()
  }

  trait D extends A {
    override def foo() = "D" + super.foo()
  }

  trait E extends C {
    override def foo(): String = "E" + super.foo()
  }

  //CBDA
  // A -> D -> B -> C
  val v = new A with D with C with B


  val v1 = new A with E with D with C with B


  /**
   * Value classes и Universal traits
   */

}