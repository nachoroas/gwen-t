package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

/**
 * An abstract base class representing a unit card in the game.
 *
 * @param name The name of the unit card.
 * @param strength The strength of the unit card.
 * @param ability The ability of the unit card.
 */
abstract class AbstractUnitClass (protected val name:String,protected var strenght:Int,protected val ability:Int) extends Cards{

  /**
   * Gets the name of the unit card.
   *
   * @return The name of the unit card.
   * @example
   * val card = new ConcreteUnitClass("Soldier", 5, 0)
   * card.getName  // Returns "Soldier"
   */
  def getName: String = name

  /**
   * Gets the strength of the unit card.
   *
   * @return The strength of the unit card.
   * @example
   * val card = new ConcreteUnitClass("Soldier", 5, 0)
   * card.getStrength  // Returns 5
   */
  def getStrenght: Int = strenght

  /**
   * Uses the ability of the unit card.
   * Note: This method is not yet implemented
   *
   * @return True if the card has an ability, false otherwise.
   * @example
   * val card = new ConcreteUnitClass("Soldier", 5, 1)
   * card.UseAbility()  // Returns true
   */
  def UseAbility(): Boolean = {
    if (this.ability == 0) {
      false
    }
    else true
  }
}
