package cl.uchile.dcc
import cl.uchile.dcc.gwent.Player
import munit.FunSuite


class PlayersTest extends FunSuite {
  var Jugador1:Player=_

  override def beforeEach(context: BeforeEach):Unit= {
    Jugador1 = new Player("j1",2,"","")
  }
  test("name") {
     assertEquals(Jugador1.getname(), "j1")
  }
  test("gem number"){
     assertEquals(Jugador1.gemnumber(),2)
  }
  test("losing gems"){
     Jugador1.losegem()
     assertEquals(Jugador1.gemnumber(),1)
  }
  test("deck"){
    assertEquals(Jugador1.hasdeck(),false)
  }
  test("hand"){
    assertEquals(Jugador1.hashand(),false)
  }
  test("get a card from the deck"){
    assertEquals(Jugador1.getcard(),true)
  }
  test("play a card"){
    assertEquals((Jugador1.playcard(),true)
  }
}