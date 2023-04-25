package cl.uchile.dcc
package gwent.CardClasses.WeatherCards

/** A class which creates a Siege card with a specific name, strenght, ability and position
 *  and they are immutable so the card is unique
 *
 * @param Void no parameters
 *
 * @constructor Creates the card with a specific name, strenght, ability and position
 *
 * @example
 * {{{
 *   val x= new Clear_Weather()
 * }}}
 */

class Clear_Weather extends WeatherCards(name="Clear Weather", ability=1, position = 4) {

  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   * @return true or false
   * @example
   * {{{
   *   val x= new Clear_Weather()
   *   x.UseAbility()=true
   * }}}
   */
  def UseAbility(): Boolean =true

}
