package cl.uchile.dcc
package gwent.Players

import gwent.Cards

class Hand (Principal_deck:Deck)  {
  private var mano:List[Cards]=List()
  private var largo:Int=0
  def draw_card(Principal_deck: Deck):Boolean={
    if (Principal_deck.GetLarge()>0) {
      val x = Principal_deck.draw_card()
      mano = x :: mano
      largo = largo + 1
      true
    }
    else{
      false
    }
    }
   def use_card(index:Int):Boolean={
     if (index<largo) {
       val carta = mano(index)
       carta.be_played()
       mano =mano.patch(index, Nil, 1)
       largo=largo-1
       true
     }
     else{
       false
     }
  }
  def Largu(): Int = largo
  def incial(Principal_deck:Deck): Unit = {
    var x=0
    largo=5
    while(x<5) {
      val y=Principal_deck.draw_card()
      mano = y :: mano
      x=x+1
    }
  }
}
