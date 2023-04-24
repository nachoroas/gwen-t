package cl.uchile.dcc

import cl.uchile.dcc.gwent.Players.Player
import munit.FunSuite


class PlayersTest extends FunSuite {
  var Jugador1:Player=_
  var Mazo:Deck=_
  var Mano:hand=_

  override def beforeEach(context: BeforeEach):Unit= {
    Mazo = new Deck()
    Mano = new Hand()
    Jugador1 = new Player("j1",2,Mazo,Mano)
  }
  test("name") {
     assertEquals(Jugador1.getName(), "j1")
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
    Jugador1.DrawCard()
    Jugador1.DrawCard()
    assertEquals(Jugador1.handnumer(),7)
  }
  test("play a card"){
    assertEquals((Jugador1.PlayCard(3)),true)
    assertEquals(Jugador1.handnumer(),4)
  }
}