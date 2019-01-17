// When compiled to byte code new coupling is introduced,
// 1. The closure class will have a reference to the class created for the anonymous function
// 2. The class created for the anonymous function will have a reference back to the closure class
// 3. If x becomes mutable, it can be mutated from another function which will result in the anonymous function returning
// different results for the same call
class Closure3 {
  var x : Int = 0 // Mutable
  def printer(): Unit = {
    () => { println(x) }
  }

  def addOne(): Unit = {
    x += 1
  }
}
