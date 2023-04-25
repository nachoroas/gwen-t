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
 *   val x= new Impenetrable_Fog()
 * }}}
 */

class Impenetrable_Fog extends WeatherCards(name="Impenetrable Fog", ability=2, position = 4) {

  /** "uses" the ability for the class but it is yet not implemented so it only return true or false
   *
   * @param void
   * @return true or false
   * @example
   * {{{
   *   val x= new Impenetrable_Fog()
   *   x.UseAbility()=true
   * }}}
   */
  def UseAbility(): Boolean= true

}
