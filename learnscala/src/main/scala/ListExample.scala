import java.util

import scala.collection.mutable.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/7
 * Time: 18:15
 * To change this template use File | Settings | File Templates.
 */
object ListExample {
  class Pet(name:String)
  class Cat(name:String) extends Pet(name:String)
  class Dog(name:String) extends Pet(name:String)
  class BengalKitten(name:String) extends Cat(name:String)
  class Queue[T](elts:T*)
  {
    var elems=List[T](elts:_*)
    def enqueue(elem:T)=elems:::List(elem)
    def dequeue={
      var result=elems.head
      elems=elems.tail
      result
    }
  }
  def examine(q:Queue[Cat]): Unit =
  {
    println("Examining:"+q.dequeue)
  }
   def main (args: Array[String]) {
    var list=List(1,2,3)
     list=list:+4
     println(list)
     val linkList=LinkedList(1,2,3)
     linkList.append(LinkedList(4))
     println(linkList)
     val jlist=new util.ArrayList[String]()
     jlist.add("some")
     val slist=jlist.clone()
     println(slist)
     var x=7::8::Nil;
     println(x)
     var y=List(2,3,4,5,6)
     y=1::y;
     println(y)
     println(y:::x)
     examine(new Queue(new Cat("tomcat")))
     //examine(new Queue(new Pet("Dog")))
     examine(new Queue(new BengalKitten("tomcat kitten")))
     //var kitties=new Queue(new BengalKitten("tomcat kitten"));
     //examine(kitties)
  }
}
