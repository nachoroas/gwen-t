package cl.uchile.dcc
package gwent.CardClasses.MeleeCards

/** A class which creates a Melee card with a specific name, strenght, ability and position
 *  and they are immutable so the card is unique
 *
 * @param Void no parameters
 *
 * @constructor Creates the card with a specific name, strenght, ability and position
 *
 * @example
 * {{{
 *   val x= new Melee2()
 * }}}
 */

class Melee2 extends MeleeCards (name="matias",strenght=5, ability=10, position = 0) {
  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   * @return true or false
   * @example
   * {{{
   *   val x= new Melee2()
   *   x.UseAbility()=true
   * }}}
   */
  def UseAbility(): Boolean = true

}