package cl.uchile.dcc
package gwent.CardClasses.RangedCards

import gwent.Cards

/** A abstract class to define all the Ranged unit classes
 *
 * this class defines almost every method for the Ranged unit classes
 *
 * @param name the name of the card
 *
 * @param strenght the strenght of the card
 *
 * @param ability the ability of the card, it is not yet implemented
 *                but i want to separate the abilities by numbers
 *
 * @param position the position of the card in the board
 *
 * ideally i won't use a abstract class to create a object so i will don't write a example
 */

abstract class RangeCards (protected val name:String,protected var strenght:Int, protected val ability:Int,protected val position:1) extends Cards {

  /** gets the name of the Range card
   *
   * @param void no parameters
   * @return the name of the Range card
   * @example
   * {{{
   * for a card which extend from here named "a"
   * a.getName="card's name"   *
   * }}}
   */
  def getName: String = name

  /** gets the strenght of the Range card
   *
   * @param void no parameters
   * @return the Strenght of the Range card
   * @example
   * {{{
   * for a card which extend from here named "a"
   * a.getStrenght="card's Strenght"   *
   * }}}
   */

  def getStrenght: Int = strenght

  /** sets the strenght of the card to 1
   *
   * it is for a ability not yet implemented but written in the parameters of the homework
   *
   * @param void no parameters
   * @return nothing but the Strenght of the card is set to 1
   * @example
   * {{{
   * for a card which extend from here named "a"
   * a.loseStrenght()
   * a.getStrenght="1"   *
   * }}}
   *
   */
  def loseStrenght(): Unit = {
    strenght = 1
  }

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
  def be_played() : Boolean=true

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[RangeCards]) {
      val otherCard = o.asInstanceOf[RangeCards]
      this.getName == otherCard.getName
    } else false
  }
}