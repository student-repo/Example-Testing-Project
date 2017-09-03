package pages

/**
  * Created by ubuntu-master on 28.08.17.
  */
class SomeMenu {

  def methodFirst(option: String): Unit =
    println(option + " methodFirst")

  def methodSecond(option: String): Unit =
    println(option + " methodSecond")

  def methodThird(option: String): Unit =
    println(option + " methodThird")

  def methodFourth(option: String): Unit =
    println(option + " methodFourth")

}

trait SomeMethodHandler {
  protected def someMenu: SomeMenu

  def method1 = someMenu.methodFirst("1")

  def method2 = someMenu.methodSecond("2")

  def method3 = someMenu.methodThird("3")

  def method4 = someMenu.methodFourth("4")

//  def method1 = methodFirst("1")
//
//  def method2 = methodSecond("2")
//
//  def method3 = methodThird("3")
//
//  def method4 = methodFourth("4")

}
