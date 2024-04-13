package cl.uchile.dcc
package PlayerTests

import model.Board.{Board, BoardSide}
import model.CardClasses.CardAbilities.*
import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import model.Players.{Deck, Hand, Player}

import munit.FunSuite

import javax.print.attribute.standard.MediaSize.NA


class PlayersTest extends FunSuite {
  var Melee1: MeleeCards = _
  var Ranged1: RangeCards = _
  var Siege1: SiegeCards = _
  var NA: Ability = _
  var MR: Ability = _
  var TB: Ability = _
  var CW: Ability = _
  var Jugador1:Player=_
  var Jugador2:Player=_
  var Mazo:Deck=_
  var Mano:Hand=_
  var Side1:BoardSide=_
  var Side2:BoardSide=_
  var Board:Board=_
  var Weather:WeatherCards=_

  override def beforeEach(context: BeforeEach):Unit= {
    NA = new NoAbility
    MR = new MoralReinforcement
    TB = new TightBond
    CW = new ClearWeather
    Melee1 = MeleeCards("alejandro", 5, NA)
    Ranged1 = RangeCards("Pepe", 7, MR)
    Siege1 = SiegeCards("Catapulta", 2, TB)
    Weather= WeatherCards("Nice weather",CW)
    Mazo = new Deck()
    Mazo.initiator()
    Mano = new Hand(Mazo)
    Mano.incial(Mazo)
    Side1= new BoardSide
    Side2= new BoardSide
    Board= new Board(Side1,Side2)
    Board.setSides()
    Jugador1 = Player("j1",Mazo,Mano,Side1)
    Jugador2 = Player("j2",Mazo,Mano,Side1)
  }
  test("name") {
     assertEquals(Jugador1.getName, "j1")
  }
  test("gem number"){
     assertEquals(Jugador1.gemnumber(),2)
  }
  test("losing gems"){
     Jugador1.losegem()
     assertEquals(Jugador1.gemnumber(),1)
  }
  test("Can't draw with 10 cards but can draw with less than 10 cards"){
    assertEquals(Jugador1.handnumer(),10)
    Jugador1.DrawCard()
    assertEquals(Jugador1.handnumer(),10)
    Jugador1.PlayCard(0)
    assertEquals(Jugador1.handnumer(),9)
    Jugador1.DrawCard()
    assertEquals(Jugador1.handnumer(),10)
  }
  test("you can't draw a card with no deck") {
    Mazo= new Deck()
    Jugador1 = Player("j1",Mazo,Mano,Side1)
    assertEquals(Jugador1.DrawCard(),false)
  }
  test("you can't play a card with no hand"){
    Mazo= new Deck()
    Mano= new Hand (Mazo)
    Jugador1 = Player("j1",Mazo,Mano,Side1)
    assertEquals(Jugador1.PlayCard(10),false)
  }
  test("equals between players"){
    assertEquals(Jugador1.equals(Jugador2),false)
    assertEquals(Jugador1.equals(Jugador1),true)
    assertEquals(Jugador1.equals(MeleeCards("j1",1,new NoAbility)),false)
  }
  test("playing 6 cards of a 5-cards hand"){
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    assertEquals(Jugador1.PlayCard(0),false)
  }
  test("drawing cards from a no cards deck"){
    Mazo=new Deck()
    Mano=new Hand(Mazo)
    assertEquals(Mano.draw_card(Mazo),false)
  }
  test("Playing a card saying the card"){
    Mazo.addCard(Melee1)
    Mano.draw_card(Mazo)
    Jugador1.PlayCard(Melee1)
    assertEquals(Side1.getNcards,1)
  }
  test("Total strenght"){
    Mazo=new Deck()
    Mazo.addCard(Melee1)
    Mazo.addCard(Ranged1)
    Mano=new Hand(Mazo)
    Mano.draw_card(Mazo)
    Mano.draw_card(Mazo)
    val j1: Player = Player("juan", Mazo, Mano, Side1)
    j1.PlayCard(Melee1)
    assertEquals(j1.getTotalStrenght,12)
  }
  test("get any weather card on hand"){
    Mazo.addCard(Weather)
    Mano=new Hand(Mazo)
    Mano.draw_card(Mazo)
    val J1: Player = Player("pepe", Mazo, Mano, Side1)
    assertEquals(J1.getWeathersCard.head,Weather)
  }
  test("playing a Card out of the hand large"){
    assertEquals(Jugador1.PlayCard(11),false)
  }
}