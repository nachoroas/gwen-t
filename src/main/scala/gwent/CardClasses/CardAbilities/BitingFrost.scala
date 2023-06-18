package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.Cards

import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, UnitCard}

class BitingFrost extends ComposerAbility {

  override def activateM(list:List[MeleeCards]): Unit = {
    for(r<-list){
      r.State.toFrozenState()
    }
  }

}
