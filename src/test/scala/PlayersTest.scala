package cl.uchile.dcc
import cl.uchile.dcc.gwent.Player
import munit.FunSuite


class PlayersTest extends FunSuite {
  var Jugador1:Player=null

  override def beforeEach(context: BeforeEach):Unit= {
    Jugador1 = new Player("j1", 0,2,"","")
  }
  test("name") {
     assertEquals(Jugador1.getname(), "j1")
  }
  test("position"){
     assertEquals(Jugador1.getposition(),0)
  }
  test("gem number"){
     assertEquals(Jugador1.gemnumber(),2)
  }
  test("losing gems"){
     Jugador1.losegem()
     assertEquals(Jugador1.gemnumber(),1)
  }


}