package cl.uchile.dcc

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import cl.uchile.dcc.gwent.Players.{Deck, Hand, Player}
import munit.FunSuite

class GameControllerTest extends FunSuite {
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
  }
}