package cl.uchile.dcc
package gwent.Players

class Hand (Principal_deck:Deck)  {
  private var mano:List[Cards]=List()
  def draw_card(Principal_deck: Deck):Unit={
    val x = Principal_deck.draw_card()
    mano = x :: mano
    }
   def use_card(index:Int):Unit={
    val carta= mano(index)
    carta.be_played()
    mano=mano.patch(index,Nil,1)
  }
  def incial(Principal_deck:Deck): Unit = {
    var x=0
    while(x<5) {
      mano.draw_card(Principal_deck)
      x=x+1
    }
  }
}
