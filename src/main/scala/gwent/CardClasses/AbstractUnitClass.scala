package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

abstract class AbstractUnitClass (protected val name:String,protected var strenght:Int,protected val ability:Int) extends Cards{

  /** gets the name of the card
   *
   * @param void no parameters
   * @return the name of the card
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

  def UseAbility(): Boolean = {
    if (this.ability == 0) {
      false
    }
    else true
  }
}
