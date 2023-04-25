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
 *   val x= new Melee1()
 * }}}
 */
class Melee1 extends MeleeCards (name="juan",strenght=3, ability=0, position = 0) {

  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   *
   * @return true or false
   *
   * @example
   * {{{
   *   val x= new Melee1()
   *   x.UseAbility()=false
   * }}}
   */
  def UseAbility():Boolean ={
    false
  }

}
