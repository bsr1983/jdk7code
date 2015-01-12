/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/8
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
object MapExample {
  def main(args: Array[String]) {
    var m=Map(1->"one",2->"Two",3->"Three")
    println(m)
    m+=(5->"Five")
    println(m)
    println(m get(5))
    //def junk(x:List)=println(m)
  }
}
