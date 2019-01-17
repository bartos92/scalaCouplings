// When compiled to byte code new coupling is introduced,
// 1. The closure class will have a reference to the class created for the anonymous function
// 2. The class created for the anonymous function will have a reference back to the closure class
// 3. If x becomes mutable, it can be mutated from another function which will result in the anonymous function returning
// different results for the same call
// 4. The getter for x can return unexpected results if x is mutated as an side effect of the anonymous function
class Closure4 {
  var x : Int = 0 // Mutable
  def printer(): Unit = {
    () => {
      x += 1
      println(x)
    }
  }

  def getX: Int = {
    x
  }
}
