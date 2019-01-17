// When compiled to byte code new coupling is introduced,
// 1. The closure class will have a reference to the class created for the anonymous function
class Closure1 {
  val x : Int = 0 // Immutable
  def printer(): Unit = {
    () => { println(1) }
  }
}
