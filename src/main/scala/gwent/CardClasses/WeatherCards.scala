package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}

/** a abstract class to define all the weather classes
 *
 * this class defines almost every method for the Siege unit classes
 *
 * @param name the name of the card
 *
 * @param ability the ability of the card, it is not yet implemented
 *                but i want to separate the abilities by numbers
 *
 * ideally i won't use a abstract class to create a object so i will don't write a example
 */

class WeatherCards(protected val name:String, protected val ability:Int) extends Cards{

  /** gets the name of the Weather card
   *
   * @param void no parameters
   * @return the name of the Weather card
   * @example
   * {{{
   * for a card which extend from here named "a"
   * a.getName="card's name"   *
   * }}}
   */
  def getName:String=name

  /** its tell the card to play itself but its not yet implented
   *
   * @param void no parameters
   * @return true of false
   * @example
   * {{{
   * for a card which extend from here named "a"
   * a.be_played()=true
   * }}}
   */

  def be_played(B: BoardSide): Unit = {
    B.playcard(this)
  }
  def UseAbility():Boolean={
    if (this.ability==0){
      false
    }
    else true
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[WeatherCards]) {
      val otherCard=o.asInstanceOf[WeatherCards]
      this.getName== otherCard.getName
    } else false
  }

}
