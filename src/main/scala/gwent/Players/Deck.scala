package cl.uchile.dcc
package gwent.Players
import cl.uchile.dcc.gwent.CardClasses.MeleeCards.{Melee1, Melee2, Melee3, Melee4, Melee5, Melee6, Melee7}
import cl.uchile.dcc.gwent.CardClasses.RangedCards.{Ranged1, Ranged2, Ranged3, Ranged4, Ranged5, Ranged6, Ranged7}
import cl.uchile.dcc.gwent.CardClasses.SiegeCards.{Siege1, Siege2, Siege3, Siege4, Siege5, Siege6, Siege7}
import cl.uchile.dcc.gwent.CardClasses.WeatherCards.{Biting_Frost, Clear_Weather, Impenetrable_Fog, Torrential_Rain}
import cl.uchile.dcc.gwent.Cards
import scala.util.Random



class Deck ()  {
  private var mazo:List[Cards]=List()

  def inciador()={
    val C1 =new Melee1
    val C2 =new Melee2
    val C3 =new Melee3
    val C4 =new Melee4
    val C5 =new Melee5
    val C6 = new Melee6
    val C7 = new Melee7
    val C8 = new Ranged1
    val C9 = new Ranged2
    val C10 = new Ranged3
    val C11 = new Ranged4
    val C12 = new Ranged5
    val C13 = new Ranged6
    val C14 = new Ranged7
    val C15 = new Siege1
    val C16 = new Siege2
    val C17 = new Siege3
    val C18 = new Siege4
    val C19 = new Siege5
    val C20 = new Siege6
    val C21 = new Siege7
    val C22 = new Biting_Frost
    val C23 = new Clear_Weather
    val C24 = new Impenetrable_Fog
    val C25 = new Torrential_Rain
    
    mazo= C1 :: mazo
    mazo= C2 :: mazo
    mazo= C3 :: mazo
    mazo= C4 :: mazo
    mazo= C5 :: mazo
    mazo= C6 :: mazo
    mazo= C7 :: mazo
    mazo= C8 :: mazo
    mazo= C9 :: mazo
    mazo= C10 :: mazo
    mazo= C11 :: mazo
    mazo= C12 :: mazo
    mazo= C13 :: mazo
    mazo= C14 :: mazo
    mazo= C15 :: mazo
    mazo= C16 :: mazo
    mazo= C17 :: mazo
    mazo= C18 :: mazo
    mazo= C19 :: mazo
    mazo= C20 :: mazo
    mazo= C21 :: mazo
    mazo= C22 :: mazo
    mazo= C23 :: mazo
    mazo= C24 :: mazo
    mazo= C25 :: mazo
    mazo=Random.shuffle(mazo)
  }

  def draw_card():Cards={
    val carta=mazo.head
    mazo=mazo.tail
    carta
  }


}
