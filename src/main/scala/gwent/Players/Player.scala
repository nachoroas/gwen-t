package cl.uchile.dcc
package gwent.Players

class Player (name:String,mazo:Deck,mano:Hand) {
    private var gem=2
    def getName:String= name
    def gemnumber():Int=gem

    def losegem(): Boolean = {
        if (gem > 0) {
            gem = gem - 1
            true
        }
        else {
            false
        }
    }
    def DrawCard(mazo:Deck):Boolean={
        if (mazo.GetLarge()>0){
         mano.draw_card(mazo)
            true
        }
        else{
            false
        }
    }
    def PlayCard(index: Int): Boolean = {
        if (mano.Largu()>0){
            mano.use_card(index)
          }
        else{
            false
        }
    }
    def handnumer():Int=mano.Largu()


}
