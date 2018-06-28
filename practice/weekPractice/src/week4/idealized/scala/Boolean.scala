package week4.idealized.scala

/**
  * Created by himanshu on 11/6/18.
  */
abstract class Boolean {
    def ifThenElse[T](t: => T,e: => T): T

    def && (x: => Boolean): Boolean =ifThenElse(x,false)

}
