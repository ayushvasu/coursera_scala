val t1=new NonEmpty(3,new Empty,new Empty)
val t2=t1 incl 4
val t3 =new NonEmpty(7,new  Empty,new Empty)
val t4=t3 incl 8
val t5=t2 union t4

abstract class IntSet{
  def incl(x:Int):IntSet
  def contains(x:Int):Boolean
  def union (other:IntSet):IntSet
}

class Empty extends IntSet{
//object Empty extends IntSet{  //creating a singleton object for Empty
  def contains(x:Int):Boolean=false
  def incl(x:Int):IntSet=new NonEmpty(x,new Empty,new Empty)

  override def toString: String = "."

   def union(other: IntSet): IntSet = other
}

class NonEmpty(elem:Int,left:IntSet,right:IntSet) extends IntSet{
  def contains(x:Int):Boolean=
    if(x<elem) left contains x
    else if(x>elem) right contains x
    else true

  def incl(x:Int):IntSet=
    if(x<elem) new NonEmpty(elem,left incl x,right)
    else if(x>elem) new NonEmpty(elem,left,right incl x)
    else this

  override def toString: String = "{"+left +elem+ right + "}"

   def union(other: IntSet): IntSet =
     ((left union right) union other) incl elem
}
/** Empty and NonEmpty both extend the class IntSet.
  * This implies that the types Empty or NonEmpty can be used wherever an object of type IntSet is required.
  * An object of type Empty or NonEmpty can be used wherever an object of type IntSet is required.
  */
