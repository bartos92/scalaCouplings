// When compiled to byte code new coupling is introduced,
// 1.The closure class will have a reference to the class created for the anonymous function
// 2. The class created for the anonymous function will have a reference back to the closure class
// 3. If x becomes mutable, it can be mutated from another function which will result in the anonymous function returning
// different results for the same call
// 4. The getter for x can return unexpected results if x is mutated as an side effect of the anonymous function
// 5. An 'anonymous function that mutates a class variable' within a function that is called from another class

class Closure5 {
  var x : Int = 0 // Mutable
  def partialApp(y: Int): Unit = {
    () => {
      x += y
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

class Closure5Caller {
  val a = 1
  def main(args: Array[String]): Unit = {
    val closure5 = new Closure5
    closure5.partialApp(a)
  }
}
