package cl.uchile.dcc
package model.CardClasses.CardAbilities
/**
 * The `NoAbility` class represents a card ability that has no effect.
 * It extends the `ComposerAbility` class and provides the implementation for the `equals` method.
 */
class NoAbility extends ComposerAbility {
  /**
   * Checks if the given object is equal to this NoAbility instance.
   *
   * @param obj The object to compare for equality.
   * @return True if the object is a NoAbility instance, false otherwise.
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: NoAbility => true
      case _ => false
    }
  }
  
}
