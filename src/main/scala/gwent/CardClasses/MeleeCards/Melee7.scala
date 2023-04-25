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
 *   val x= new Melee7()
 * }}}
 */
class Melee7 extends MeleeCards (name="Roberto",strenght=10, ability=0, position = 0) {
  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   * @return true or false
   * @example
   * {{{
   *   val x= new Melee7()
   *   x.UseAbility()=true
   * }}}
   */
  def UseAbility():Boolean=true
}