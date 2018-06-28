package week4

import java.util.NoSuchElementException

/**
  * Created by himanshu on 20/4/18.
  */
trait List[T] {
  def isEmpty:Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head:T, val tail:List[T]) extends List[T]{
  override def isEmpty: Boolean = false

}
class Nil[T] extends List[T]{
  override def isEmpty: Boolean =true
  override def head: T = throw new NoSuchElementException("Nil.head");
  override def tail: List[T] = throw new NoSuchElementException("Nil.tail");
}


object List{
  //List(1,2)=List.apply(1,2)
  def apply[T](x1:T,x2:T):List[T]=new Cons(x1,new Cons(x2,new Nil))

  def apply[T]() = new Nil
}