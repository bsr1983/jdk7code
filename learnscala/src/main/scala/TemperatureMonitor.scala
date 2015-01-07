import scala.actors.Actor

case object Heartbeat
case class TemperatureAlarm(temp:Double)

class TemperatureMonitor extends Actor{
	var tripped:Boolean =false;
	var tripTemp:Double=0.0
	def act()={
	  while(true){
	    receive{
	      case Heartbeat=>0
	      case TemperatureAlarm(temp)=>
	        tripped=true
	        tripTemp=temp
	      case _ => println("No match")
	    }
	  }
	}
	def fact(base:Int):Int={
	  if(base<=0)
	    return 1
	    else
	      return base*fact(base-1)
	}
	println(fact(10))
}