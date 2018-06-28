package week4

/**
  * Created by himanshu on 20/4/18.
  */
object nth extends App{
  def nth[T](n:Int,xs:List[T]):T={

      if(n==0) xs.head
      else nth(n-1,xs.tail)
  }

  val list=new Cons(1,new Cons(2,new Cons(3,new Nil)))
  print(nth(2,list))
}
