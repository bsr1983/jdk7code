class CashFlow(amt:Double,curr:String) {
	def this(amt:Double)=this(amt,"GBP")
	def this(curr:String)=this(0,curr);
	def amount=amt
	def currency=curr
	
}
object demo
{
def main(args:Array[String])
	{
	  val wages=new CashFlow(200.0)
	  println(wages.amount)
	  println(wages.currency)
	}  
}
class Pet(name:String)
trait Chipped
{
	var chipName:String
	def getName=chipName
}
class Cat(name:String)extends Pet (name:String) with Chipped
{
	var chipName=name
}
class Dog(name:String)extends Pet(name:String)with Chipped
{
	var chipName=name
}