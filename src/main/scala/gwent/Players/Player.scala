package cl.uchile.dcc
package gwent.Players

//i forgot i didn't have to do this :(
//therefore this is not completed
class Player (name:String,private var gem:Int,mazo:Deck,hand:Hand) {
    def getName():String= name
    def gemnumber():Int=gem
    def losegem():Unit= {
        if (gem > 0) {
            gem = gem - 1
            //else pierde (necesito tener mucho mas trabajado para ver una partida terminada)
        }
    }
    def DrawCard():Unit={
        hand.drawcard()
    }
    def PlayCard():Unit={
        hand.usecard()
        hand.loseCard()
    }
    def handnumer():Int={
        //len(list)
    }


}
