// When compiled to byte code new coupling is introduced,
// 1. The closure class will have a reference to the class created for the anonymous function
// 2. The class created for the anonymous function will have a reference back to the closure class
class Closure2 {
  val x : Int = 0 // Immutable
  def printer(): Unit = {
    () => { println(x) }
  }
}
