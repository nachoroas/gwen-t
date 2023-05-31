package cl.uchile.dcc

import gwent.Board.{Board, BoardSide}
import gwent.Players.{Deck, Hand, Player}

import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import munit.FunSuite

class BoardTest extends FunSuite {
  var Jugador1: Player = _
  var Mazo: Deck = _
  var Mano: Hand = _
  var Side1: BoardSide = _
  var Side2: BoardSide = _
  var Board: Board = _
  var Melee1: MeleeCards = _
  var Ranged1: RangeCards = _
  var Siege1: SiegeCards = _
  var Weather: WeatherCards = _

  override def beforeEach(context: BeforeEach): Unit = {
    Mazo = new Deck()
    Mazo.initiator()
    Mano = new Hand(Mazo)
    Mano.incial(Mazo)
    Side1 = new BoardSide
    Side2 = new BoardSide
    Board = new Board(Side1, Side2)
    Board.setSides()
    Jugador1 = new Player("j1", Mazo, Mano, Side1)
  }
  test("p1 playing cards"){
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    assertEquals(Board.Ncards,4)
  }
  test("Playing cards in the two sides"){
    Side1.playcard(Melee1)
    Side2.playcard(Ranged1)
    assertEquals(Board.Ncards,2)
  }
  test("Clearing one side"){
    Side1.playcard(Melee1)
    Side1.playcard(Ranged1)
    Side1.playcard(Siege1)
    assertEquals(Side1.getNcards,3)
    Side1.ClearSide()
    assertEquals(Side1.getNcards,0)
  }
}
