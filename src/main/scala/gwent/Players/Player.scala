package cl.uchile.dcc
package gwent.Players

//i forgot i didn't have to do this :(
//therefore this is not completed
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
        //devolver booleand es por mientras
        // deberia perder pero necesito tener mucho mas trabajado para ver una partida terminada

    }
    def DrawCard():Unit={
         mano.draw_card(mazo)
    }

    def PlayCard(index: Int): Boolean = {
        mano.use_card(index)
        true
    }
    def handnumer():Int={
        //len(list)
    }


}
