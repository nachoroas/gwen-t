package cl.uchile.dcc
package gwent.CardClasses.SiegeCards

/** A class which creates a Siege card with a specific name, strenght, ability and position
 *  and they are immutable so the card is unique
 *
 * @param Void no parameters
 *
 * @constructor Creates the card with a specific name, strenght, ability and position
 *
 * @example
 * {{{
 *   val x= new Siege6()
 * }}}
 */

class Siege6 extends SiegeCards(name="ariete de elite", strenght=11, ability=11, potition = 2) {

  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   * @return true or false
   * @example
   * {{{
   *   val x= new Siege6()
   *   x.UseAbility()=true
   * }}}
   */
  def UseAbility(): Boolean = true
}