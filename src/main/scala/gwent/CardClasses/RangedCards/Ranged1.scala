package cl.uchile.dcc
package gwent.CardClasses.RangedCards

/** A class which creates a Ranged card with a specific name, strenght, ability and position
 *  and they are immutable so the card is unique
 *
 * @param Void no parameters
 *
 * @constructor Creates the card with a specific name, strenght, ability and position
 *
 * @example
 * {{{
 *   val x= new Ranged1()
 * }}}
 */
class Ranged1 extends RangeCards(name="pepe", strenght=2, ability=5, position = 1) {
  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   * @return true or false
   * @example
   * {{{
   *   val x= new Ranged1()
   *   x.UseAbility()=true
   * }}}
   */
  def UseAbility(): Boolean = true
}
