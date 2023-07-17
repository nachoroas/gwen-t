package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

class NoAbility extends ComposerAbility {
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: NoAbility => true
      case _ => false
    }
  }
  
}
