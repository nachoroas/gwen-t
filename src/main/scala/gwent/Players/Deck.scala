package cl.uchile.dcc
package gwent.Players
import scala.collection.inmutable.List

class Deck (cards:List()) extends Gcards{
  def shuffle():Unit={
    Ramdom.shuffle()
  }
  def drawcard():Unit={
    //
  }

}
