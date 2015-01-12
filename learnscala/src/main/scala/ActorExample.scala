/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/8
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
import scala.actors.Actor._;
object ActorExample {
  val myact=actor{
    while(true)
    {
      receive{
        case incoming=>println(" i got mail "+incoming)
      }
    }
  }
  def main(args: Array[String]) {
    myact! "Hello Actor"
    myact! "Hello T coming"
    myact! "Hello Bye"
  }
}
