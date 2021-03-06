package week3

/**
  * Created by himanshu on 17/4/18.
  */
class Rational(x:Int,y:Int) {
  require(y!=0,"denominator must be non-zero")

  def this(x:Int)=this(x,1)

  private def gcd(a:Int,b:Int):Int=if(b==0) a else gcd(b,a%b)
  private val g=gcd(x,y)
  def numer=x/g
  def denom=y/g

  def < (that:Rational) =numer*that.denom < that.numer*denom

  def max(that:Rational)=if(this<that) that else this

  def + (that:Rational)=
    new Rational(
        numer*that.denom + that.numer*denom,
        denom*that.denom
    )

}
