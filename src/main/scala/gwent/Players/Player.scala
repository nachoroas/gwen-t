package cl.uchile.dcc
package gwent.Players

/** A class representing the player
 *
 * its the entity who plays the game
 *
 * @param name the player has a name to differentiate from his oponent
 * @param mazo the player has a deck to get cards from it
 * @param mano the player has a hand to play cards from it
 *
 * @constructor the player is defined with 2 gems which are like his lives
 *
 * @example
 * {{{
 *   val a = new Deck()
 *   val b = new hand(a)
 *   val x = new Player("bruno",a,b)
 * }}}
 */
class Player (name:String,mazo:Deck,mano:Hand) {
    private var gem=2
  /** gets the name of the player
   *
   * @param void no parameters
   * @return the name of the player
   * @example
   * {{{
   *   val a = new Deck()
   *   val b = new hand(a)
   *   val x = new Player("bruno",a,b)
   *   x.getName()="bruno"
   *    }}}
   */
    def getName:String= name

  /** gets the actual number of gems of the player
   *
   * @param void no parameters
   * @return a number of gems
   * @example
   * {{{
   *   val a = new Deck()
   *   val b = new hand(a)
   *   val x = new Player("bruno",a,b)
   *   x.gemnumber()=2
   *     }}}
   */
    def gemnumber():Int=gem

  /** Decreases the number of gems of the player
   *
   * @param void no parameters
   *
   * @return the previous number of gems decreased by 1 or false if it has no enough gems
   * @example
   * {{{
   *   val a = new Deck()
   *   val b = new hand(a)
   *   val x = new Player("bruno",a,b)
   *   x.losegem()
   *   x.losegem()
   *   x.losegem()
   *   x.gemnumber()=false
   *      }}}
   */
    def losegem(): Boolean = {
        if (gem > 0) {
            gem = gem - 1
            true
        }
        else {
            false
        }
    }

  /** Draw a card from the deck
   *
   * this funtion check if the deck has cards and draws cards from it,
   * if it has no cards it returns false
   *
   * @param mazo to get the cards from
   *
   * @return true or false
   *
   * @example
   * {{{
   *   val a = new Deck()
   *   val b = new hand(a)
   *   val x = new Player("bruno",a,b)
   *   x.DrawCard(a)=false //the deck has no cards
   *       }}}
   */
    def DrawCard(mazo:Deck):Boolean={
        if (mazo.GetLarge()>0){
         mano.draw_card(mazo)
            true
        }
        else{
            false
        }
    }

  /** It "plays" a card from the hand, but for this homework i dont have it implemented
   * so it return true if it can and false if not
   *
   * @param index the position of the card in the hand to play
   * @return true or false
   *         
   * @example
   * {{{
   *   val a = new Deck()
   *   val b = new hand(a)
   *   val x = new Player("bruno",a,b)
   *   x.PlayCard(3)=false //hand have no cards
   *        }}}      
   */
    def PlayCard(index: Int): Boolean = {
        if (mano.Largu()>0){
            mano.use_card(index)
          }
        else{
            false
        }
    }

  /** get the large of the list of the hand
   *
   * @param void no parameters
   *             
   * @example
   * {{{
   *   val a = new Deck()
   *   val b = new hand(a)
   *   val x = new Player("bruno",a,b)
   *   x.handnumer()=0
   *      }}}
   */
    def handnumer():Int=mano.Largu()

    override def equals(o: Any): Boolean = {
      if (o.isInstanceOf[Player]) {
        val otherCard = o.asInstanceOf[Player]
        this.getName == otherCard.getName
      } 
      else false
  }


}
