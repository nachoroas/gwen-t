package cl.uchile.dcc
package gwent
//i forgot i didn't have to do this :(
//therefore this is not completed
class UCards (
private val name:String,
private val position:Int,
private var strenght:Int,
private val clasification:String
           ) extends Cards{
  def getname():String=name
  def getposition():Int=position
  def getstrength():Int=strenght
  def getclas():String=clasification
  def addS(number:Int):Unit={
    strenght=strenght+number
  }
  def loss():Unit={
    strenght=1
  }

}
