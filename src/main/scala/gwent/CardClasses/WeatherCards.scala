package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}

/**
 * Represents a weather card in the game.
 *
 * @param name The name of the weather card.
 * @param ability The ability of the weather card.
 */

class WeatherCards(protected val name:String, protected val ability:Int) extends Cards{

  /**
   * Gets the name of the weather card.
   *
   * @return The name of the weather card.
   * @example
   * val card = new WeatherCards("Rain", 1)
   * card.getName  // Returns "Rain"
   */
  def getName:String=name

  /**
   * Plays the weather card on the specified board side..
   *
   * @param Board The board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new WeatherCards("Rain", 1)
   * card.be_played(boardSide)  // Returns true or false
   */

  def be_played(Side: BoardSide): Unit = {
    Side.playcard(this)
  }

  /**
   * Determines if the weather card's ability can be used.
   * Note: This method is not yet implemented.
   *
   * @return True if the ability can be used, false otherwise.
   * @example
   * val card = new WeatherCards("Rain", 1)
   * card.UseAbility()  // Returns true or false
   */
  def UseAbility():Boolean={
    if (this.ability==0){
      false
    }
    else true
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[WeatherCards]) {
      val otherCard=o.asInstanceOf[WeatherCards]
      this.getName== otherCard.getName
    }else false
  }

}
