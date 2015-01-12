import java.util.{Date => UDate}
case class Point(x:Int,y:Int)
object HelloWorld {
	def main(args:Array[String])
	{
		val hello="Hello world!"
	    println(hello)
	  var chinaDayOfWeek=args(0) match{
			case "Sunday"	=> "星期日"
			case "Monday" =>"星期一"
			case "Tuesday" =>"星期二"
			case "Wednesday"=>"星期三"
			case "Thurday"=>"星期四"
			case "Friday"=>"星期五"
			case "Saturday"=>"星期六"
			case _ => "出错了 ：'"+args(0)+"' 不是英文中用来表示星期的单词"
		}
		println(chinaDayOfWeek)
		println(storageSize(100))
		println(storageSize("String Object"))
		println(storageSize(10.0))
		println(fact(3))
		println(fact2(10))
		var counter=1
		while(counter<=10)
		{
		  println("."*counter)
		  counter=counter+1;
		}
		do
		{
		  println("."*counter)
		  counter=counter+1;
		}
		while(counter<=20);
		for(i<-1 to 10) println("i="+i)
		for(i<-1 to 10;if i%2==0) println("i="+i)
		for(x<-1 to 5;y<-1 to x)
		{
		  println(" "*(x-y)+x.toString*y)
		}
		val xs=for(x<-2 to 11) yield fact(x)
		for(factx<-xs) println(factx)
		val adder=(n:Int)=>{ (x:Int)=>x+n}
		var plus10=adder(10);
		var plus20=adder(20);
		println(plus10(11));
		println(plus20(plus10(100)));
    val xaxis=Point(2,0)
    val yaxis=Point(0,3)
    var somewhere=Point(3,4)
    val whereami=(p:Point) =>p match
    {
      case Point(x,0)=>"On the x-axis"
      case Point(0,y)=>"On the y-axis"
      case _ =>"Out in the plane"
    }
    println(whereami(xaxis))
    println(whereami(yaxis))
    println(whereami(somewhere))
	}
	def storageSize(obj:Any)=obj match
	{
	  case s:String=>s.length
	  case i:Int =>4
	  case _  => -1
	}
	def fact(base:Int):Int={
	  if(base<=0)
	    return 1
	    else
	      return base*fact(base-1)
	}
	def fact2(base:Int):Int={
	   def factHelper(n:Int):Int={
	     return fact2(n-1);
	   }
	   if (base<=0)
	     return 1;
	     else
	       return base*factHelper(base);
	}
}
