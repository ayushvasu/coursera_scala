package week4

/**
  * Created by himanshu on 23/4/18.
  */

//Peano numbers
abstract class Nat {
  def isZero:Boolean
  def predecessor:Nat
  def successor:Nat=new Succ(this)
  def +(that:Nat):Nat
  def -(that:Nat):Nat
}

object Zero extends Nat{
  def isZero=true
  def predecessor=throw new Error("0.predecessor")
  //def successor=new Succ(this)
  def +(that:Nat)=that
  def -(that:Nat)= if(that.isZero) this else throw new Error("0.predecessor")

  //override def toString: String = "0"
}
class Succ(n:Nat) extends Nat{
  def isZero =false
  def predecessor=n
  //def successor=new Succ(this)
  def +(that:Nat)= new Succ(n+that)
  def -(that:Nat)= if(that.isZero) this else n -that.predecessor

  //override def toString: String = "{"+"}"
}

object main extends App{
  var x=new Succ(Zero)
  val y=x.successor
  println(y)
}