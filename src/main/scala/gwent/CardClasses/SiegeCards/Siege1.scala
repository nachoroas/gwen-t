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
 *   val x= new Siege1()
 * }}}
 */

class Siege1 extends SiegeCards(name="ariete", strenght=7, ability=6, potition = 2) {

  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   * @return true or false
   * @example
   * {{{
   *   val x= new Siege1()
   *   x.UseAbility()=true
   * }}}
   */
  def UseAbility(): Boolean = true
}
