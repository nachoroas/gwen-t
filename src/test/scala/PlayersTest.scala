package cl.uchile.dcc

import cl.uchile.dcc.gwent.Players.{Deck, Hand, Player}
import munit.FunSuite


class PlayersTest extends FunSuite {
  var Jugador1:Player=_
  var Mazo:Deck=_
  var Mano:Hand=_

  override def beforeEach(context: BeforeEach):Unit= {
    Mazo = new Deck()
    Mazo.initiator()
    Mano = new Hand(Mazo)
    Mano.incial(Mazo)
    Jugador1 = new Player("j1",Mazo,Mano)
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
  test("losing too much gems"){
    Jugador1.losegem()
    Jugador1.losegem()
    assertEquals(Jugador1.losegem(),false)
  }
  test("how many cards the player have in the hand"){
    Jugador1.DrawCard(Mazo)
    Jugador1.DrawCard(Mazo)
    assertEquals(Jugador1.handnumer(),7)
  }
  test("you can't draw a card with no deck") {
    Mazo= new Deck()
    assertEquals(Jugador1.DrawCard(Mazo),false)
  }
  test("you can't play a card with no hand"){
    Mazo= new Deck()
    Mano= new Hand (Mazo)
    assertEquals(Jugador1.PlayCard(10),false)
  }
  test("play a card"){
    assertEquals(Jugador1.PlayCard(3),true)
    assertEquals(Jugador1.PlayCard(7),false)
    assertEquals(Jugador1.handnumer(),4)
  }
}