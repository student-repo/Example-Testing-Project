package pages

import com.relevantcodes.extentreports.ExtentReports

/**
  * Created by ubuntu-master on 23.07.17.
  */
object Main {
  var extentReport: ExtentReports = new ExtentReports("/home/ubuntu-master/Desktop/lern-automation.html")

  def main(args: Array[String]): Unit = {

//    println(fibonacci(5))
//
//    List(1,2,3,5).reduceLeft((x, y) => {
//      println("x = " + x + ", y = " + y)
//      x + y
//    })

//    val s = List(1, 2, 3, 4)
//    val sk = List("A", "B", "C", "D")
//    println(s)
//    println(sk)
//    s.zip(sk).foreach((eee: (Int, String)) => println(eee._1.toString + eee._2.toString))



    println(foo(foo1, 10))





  }

  def foo1(): Int = {
    10
  }

  def foo(f: () => Int, i: Int ): Int = {
    f() + i
  }

  def fibonacci(n: Int): Int = {
    def f(n: Int, acc: Int, b: Int): Int = {
      n match {
        case 0 => acc
        case _ => f(n - 1, acc + b, acc)
      }
    }
    f(n, 0, 1)
  }

  def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
    def go(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if(gt(as(n), as(n + 1))) false
      go(n + 1)
    }
    go(0)
  }

//  def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
//
//  }


}
