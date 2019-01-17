// When compiled to byte code new coupling is introduced,
// 1. The closure class will have a reference to the class created for the anonymous function
// 2. The class created for the anonymous function will have a reference back to the closure class
// 3. If x becomes mutable, it can be mutated from another function which will result in the anonymous function returning
// different results for the same call
// 4. The getter for x can return unexpected results if x is mutated as an side effect of the anonymous function
// 5. An 'anonymous function that mutates a class variable' within a function that is called from another class
// 6. Partial application introduced, which might results into a new way of coupling?
class Closure6 {
  var x : Int = 0 // Mutable
  def partialApp(y: Int, z: Int): Unit = {
    () => {
      x += (y + z)
      println(x)
    }
  }

  def addOne(): Unit = {
    x += 1
  }

  def getX: Int = {
    x
  }
}

class Closure6Caller {
  val a = 1
  def main(args: Array[String]): Unit = {
    val closure5 = new Closure6
    val partialCall = (y: Int) => { closure5.partialApp(a, y) }
    partialCall(5)
  }
}
