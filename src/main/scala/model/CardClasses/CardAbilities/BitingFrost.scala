package cl.uchile.dcc
package model.CardClasses.CardAbilities

import model.Cards
import cl.uchile.dcc.Controller.Observer.CardObserver

import cl.uchile.dcc.model.CardClasses.Effects.Frozen
import cl.uchile.dcc.model.CardClasses.{MeleeCards, UnitCard}

/**
 * The `BitingFrost` class represents the ability of the Biting Frost weather card in the Gwent game.
 * It extends the `ComposerAbility` class and provides the implementation to activate the Biting Frost ability on melee cards.
 */
class BitingFrost extends ComposerAbility {

  /**
    * Adds the Frozen effect to all melee cards on the board.
    * @param list is the list of melee cards on the board.
    */
  override def activateM(list:List[MeleeCards]): Unit = {
    for(r<-list){
      r.addEffect(new Frozen)
    }
  }

  /**
   * Notifies a card observer about the Biting Frost ability.
   *
   * This method is called to update the observer about the Biting Frost ability being activated.
   *
   * @param r The card observer to notify.
   */
  override def notify(r: CardObserver): Unit={
    r.update(this)
  }
  /**
   * Checks if the given object is equal to this BitingFrost instance.
   *
   * @param obj The object to compare for equality.
   * @return True if the object is a BitingFrost instance, false otherwise.
   */
  override def equals(obj: Any): Boolean ={
    obj match {
    case _: BitingFrost => true
    case _ => false
  }
}
}
