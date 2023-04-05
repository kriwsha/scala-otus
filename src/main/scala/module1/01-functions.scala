package module1

object functions {


  /**
   * Функции
   */


  /**
   * Реализовать ф-цию  sum, которая будет суммировать 2 целых числа и выдавать результат
   */

   def sum(x: Int, y: Int): Int = x + y

   sum(3, 5) // 8

   val sum2: (Int, Int) => Int = (a, b) => a + b
  // val x2: Int => Int => Int = ???



  val _: Int = sum2(5, 6) // 11
  //val _: Int => Int = x2(5)

//  def hof(f: (Int, Int) => Int) = ???

  val sum3: (Int, Int) => Int = sum

  // hof(sum)

  // (Int, Int) => Int == Int => Int => Int

  val sumCurried: Int => Int => Int = sum2.curried

  def sum4(x: Int, f: Int => Int) = f(x)

  sum(3, 4)
  sum4(3, { y =>
    y + 1
  })


  
  // Partial function

  val divide: PartialFunction[(Int, Int), Int] = {
    case x if x._2 != 0 => x._1 / x._2
  }

  val l = List((4, 2), (5, 0), (9, 3))

  l.collect(divide)



  // SAM Single Abstract Method

  trait Printer {
    def apply(s: String): Unit
  }

  val p: Printer = a => println(a)


  /**
   *  Задание 1. Написать ф-цию метод isEven, которая будет вычислять является ли число четным
   */


  /**
   * Задание 2. Написать ф-цию метод isOdd, которая будет вычислять является ли число нечетным
   */


  /**
   * Задание 3. Написать ф-цию метод filterEven, которая получает на вход массив чисел и возвращает массив тех из них,
   * которые являются четными
   */



  /**
   * Задание 4. Написать ф-цию метод filterOdd, которая получает на вход массив чисел и возвращает массив тех из них,
   * которые являются нечетными
   */


  /**
   * return statement
   *
   */
}
