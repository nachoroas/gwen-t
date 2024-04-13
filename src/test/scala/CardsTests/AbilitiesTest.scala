package cl.uchile.dcc
package CardsTests

import model.CardClasses.CardAbilities.{Ability, BitingFrost, ClearWeather, ImpenetrableFog, MoralReinforcement, NoAbility, TightBond, TorrentialRain}
import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.model.Board.{Board, BoardSide}
import cl.uchile.dcc.model.Players.{Deck, Hand, Player}
import munit.FunSuite

class AbilitiesTest extends FunSuite {
  var Jugador1: Player = _
  var Mazo: Deck = _
  var Mano: Hand = _
  var Side1: BoardSide = _
  var Side2: BoardSide = _
  var Board: Board = _
  var Melee1: MeleeCards = _
  var Melee2: MeleeCards = _
  var Melee3: MeleeCards = _
  var Ranged1: RangeCards = _
  var Ranged2: RangeCards = _
  var Ranged3: RangeCards = _
  var Siege1: SiegeCards = _
  var Siege3: SiegeCards = _
  var Siege2: SiegeCards = _
  var Weather1: WeatherCards = _
  var Weather2: WeatherCards = _
  var Weather3: WeatherCards = _
  var Weather4: WeatherCards = _
  var NA: Ability = _
  var NA2: Ability = _
  var MR: Ability = _
  var MR2: Ability = _
  var TB: Ability = _
  var TB2: Ability = _
  var BT: Ability = _
  var BT2: Ability = _
  var IF: Ability = _
  var IF2: Ability = _
  var TR: Ability = _
  var TR2: Ability = _
  var CW: Ability = _
  var CW2: Ability = _


  override def beforeEach(context: BeforeEach): Unit = {
    NA = new NoAbility
    NA2 = new NoAbility
    MR = new MoralReinforcement
    MR2 = new MoralReinforcement
    TB = new TightBond
    TB2 = new TightBond
    BT = new BitingFrost
    BT2 = new BitingFrost
    IF = new ImpenetrableFog
    IF2 = new ImpenetrableFog
    TR = new TorrentialRain
    TR2 = new TorrentialRain
    CW = new ClearWeather
    CW2 = new ClearWeather
    Melee1 = MeleeCards("alejandro", 5, TB)
    Melee2 = MeleeCards("alendronate", 5, MR)
    Melee3 = MeleeCards("alejandro", 5, TB)
    Ranged1 = RangeCards("Pepe", 7, TB)
    Ranged2 = RangeCards("Pep", 7, MR)
    Ranged3 = RangeCards("Pepe", 7, TB)
    Siege1 = SiegeCards("Catapulta", 2, TB)
    Siege2 = SiegeCards("Catapult", 2, MR)
    Siege3 = SiegeCards("Catapulta", 2, TB)
    Weather1 = WeatherCards("Nice their", CW)
    Weather2 = WeatherCards("Nice weather", TR)
    Weather3 = WeatherCards("Nice death", IF)
    Weather4 = WeatherCards("Nice", BT)
    Mazo = new Deck()
    Mazo.addCard(Weather3)
    Mazo.addCard(Weather2)
    Mazo.addCard(Weather1)
    Mazo.addCard(Weather4)
    Mazo.addCard(Melee1)
    Mazo.addCard(Melee2)
    Mazo.addCard(Melee3)
    Mazo.addCard(Ranged1)
    Mazo.addCard(Ranged2)
    Mazo.addCard(Ranged3)
    Mazo.addCard(Siege1)
    Mazo.addCard(Siege2)
    Mazo.addCard(Siege3)
    Mano = new Hand(Mazo)
    Mano.incial(Mazo)
    Side1 = new BoardSide
    Side2 = new BoardSide
    Board = new Board(Side1, Side2)
    Board.setSides()
    Jugador1 = Player("j1", Mazo, Mano, Side1)
  }
  test("Equals between Cards"){
    //this test is because the equals in the cards does a equals between the abilities
    assertEquals(NA,NA2)
    assertNotEquals(NA,MR)
    assertNotEquals(NA,TB)
    assertNotEquals(NA,CW)
    assertEquals(MR,MR2)
    assertNotEquals(MR,TB)
    assertNotEquals(MR,CW)
    assertEquals(TB,TB2)
    assertNotEquals(TB,CW)
    assertEquals(CW,CW2)
    assertEquals(BT,BT2)
    assertEquals(IF,IF2)
    assertEquals(TR,TR2)
    assertNotEquals(BT,IF)
    assertNotEquals(BT,TR)
    assertNotEquals(BT,CW)
    assertNotEquals(IF,TR)
    assertNotEquals(IF,CW)
    assertNotEquals(TR,CW)
    assertNotEquals(CW,NA)
  }
  test("activation of abilities in melee zone"){
    Jugador1.PlayCard(Ranged1)
    Jugador1.PlayCard(Melee1)
    Jugador1.PlayCard(Melee2)
    Jugador1.PlayCard(Melee3)
    //the abilities are activated when the card is played so the side strength is 27 (melee)+7 (ranged) not simply 22
    assertEquals(Jugador1.getSideStrenght, 27+7)
    Jugador1.DrawCard()
    Jugador1.PlayCard(Weather4)
    assertEquals(Jugador1.getSideStrenght, 7+7)
    Jugador1.PlayCard(Weather1)
    assertEquals(Jugador1.getSideStrenght, 27+7)
  }
  test("activation of abilities in ranged zone"){
    Jugador1.PlayCard(Siege1)
    Jugador1.PlayCard(Ranged1)
    Jugador1.PlayCard(Ranged2)
    Jugador1.PlayCard(Ranged3)
    Jugador1.DrawCard()
    Jugador1.DrawCard()
    assertEquals(Jugador1.getSideStrenght, 37+2)
    Jugador1.DrawCard()
    Jugador1.PlayCard(Weather3)
    assertEquals(Jugador1.getSideStrenght, 7+2)
    Jugador1.PlayCard(Weather2)
    assertEquals(Jugador1.getSideStrenght, 37+1)
  }
  test("activation of abilities in siege zone"){
    Jugador1.PlayCard(Melee1)
    Jugador1.PlayCard(Siege1)
    Jugador1.PlayCard(Siege2)
    Jugador1.PlayCard(Siege3)
    Jugador1.DrawCard()
    Jugador1.DrawCard()
    assertEquals(Jugador1.getSideStrenght, 12+5)
    Jugador1.DrawCard()
    Jugador1.PlayCard(Weather2)
    assertEquals(Jugador1.getSideStrenght, 7+5)
    Jugador1.PlayCard(Weather1)
    assertEquals(Jugador1.getSideStrenght, 12+5)
  }
}
