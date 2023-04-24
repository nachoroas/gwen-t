package cl.uchile.dcc
package gwent.Players
import cl.uchile.dcc.gwent.CardClasses.MeleeCards.{Melee1, Melee2, Melee3, Melee4, Melee5, Melee6, Melee7}
import cl.uchile.dcc.gwent.CardClasses.RangedCards.{Ranged1, Ranged2, Ranged3, Ranged4, Ranged5, Ranged6, Ranged7}
import cl.uchile.dcc.gwent.CardClasses.SiegeCards.{Siege1, Siege2, Siege3, Siege4, Siege5, Siege6, Siege7}
import cl.uchile.dcc.gwent.CardClasses.WeatherCards.{Biting_Frost, Clear_Weather, Impenetrable_Fog, Torrential_Rain}
import cl.uchile.dcc.gwent.Cards
import scala.util.Random



class Deck (){
  private var mazo:List[Cards]=List()
  private var large:Int=0

  def initiator()={
    val Carta1 =new Melee1
    val Carta2 =new Melee2
    val Carta3 =new Melee3
    val Carta4 =new Melee4
    val Carta5 =new Melee5
    val Carta6 = new Melee6
    val Carta7 = new Melee7
    val Carta8 = new Ranged1
    val Carta9 = new Ranged2
    val Carta10 = new Ranged3
    val Carta11 = new Ranged4
    val Carta12 = new Ranged5
    val Carta13 = new Ranged6
    val Carta14 = new Ranged7
    val Carta15 = new Siege1
    val Carta16 = new Siege2
    val Carta17 = new Siege3
    val Carta18 = new Siege4
    val Carta19 = new Siege5
    val Carta20 = new Siege6
    val Carta21 = new Siege7
    val Carta22 = new Biting_Frost
    val Carta23 = new Clear_Weather
    val Carta24 = new Impenetrable_Fog
    val Carta25 = new Torrential_Rain
    
    mazo= Carta1 :: mazo
    mazo= Carta2 :: mazo
    mazo= Carta3 :: mazo
    mazo= Carta4 :: mazo
    mazo= Carta5 :: mazo
    mazo= Carta6 :: mazo
    mazo= Carta7 :: mazo
    mazo= Carta8 :: mazo
    mazo= Carta9 :: mazo
    mazo= Carta10 :: mazo
    mazo= Carta11 :: mazo
    mazo= Carta12 :: mazo
    mazo= Carta13 :: mazo
    mazo= Carta14 :: mazo
    mazo= Carta15 :: mazo
    mazo= Carta16 :: mazo
    mazo= Carta17 :: mazo
    mazo= Carta18 :: mazo
    mazo= Carta19 :: mazo
    mazo= Carta20 :: mazo
    mazo= Carta21 :: mazo
    mazo= Carta22 :: mazo
    mazo= Carta23 :: mazo
    mazo= Carta24 :: mazo
    mazo= Carta25 :: mazo
    mazo=Random.shuffle(mazo)
    large=25
  }

  def draw_card():Cards={
    val carta=mazo.head
    mazo=mazo.tail
    large=large-1
    carta
  }
  def GetLarge():Int=large


}
