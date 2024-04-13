package cl.uchile.dcc
package Controller

import model.Board.{Board, BoardSide}
import model.Cards
import model.Players.{Deck, Hand, Player}
import model.CardClasses.CardAbilities.{MoralReinforcement, NoAbility}
import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.Controller.Observer.PlayerObserver
import cl.uchile.dcc.Controller.States.{EndGame, GameState, StartGame}

import scala.collection.mutable
import scala.util.Random

/**
 * The `GameController` class manages the game flow and interactions between the players, board, and game states.
 *
 * @constructor Create a new game controller instance.
 */
class GameController() extends PlayerObserver {

  var state: GameState = new StartGame(this)
  private val Side1: BoardSide = new BoardSide
  private val Side2: BoardSide = new BoardSide
  private val Board: Board = new Board(Side1,Side2)
  Board.setSides()
  private val mazoP: Deck = new Deck
  private val mazoCPU: Deck = new Deck
  mazoP.initiator()
  mazoCPU.initiator()
  private val ManoP:Hand = new Hand(mazoP)
  private val ManoCPU:Hand = new Hand(mazoCPU)
  ManoP.incial(mazoP)
  ManoCPU.incial(mazoCPU)
  private var player: Player = Player("Player",mazoP,ManoP,Side1)
  private var CPU: Player = Player("CPU",mazoCPU,ManoCPU,Side2)
  player.registerObserver(this)
  CPU.registerObserver(this)
  /**
   * Returns the total number of cards on the board.
   *
   * @return The total number of cards on the board.
   */
  def getBoardNcards:Int={
    Board.Ncards
  }

  /**
   * Returns the length of the player's hand.
   *
   * @return The length of the player's hand.
   */
  def getManoPLength:Int={
    ManoP.Largu()
  }
  /**
   * Plays the Cpu turn if its possible
   */
  def doCPU_turn():Unit = {
    state.doCPU_turn(CPU,player,ManoCPU)
  }
  def doDrawCard():Unit={
    state.doDrawCard(player)
  }
  def doPlayCard(input:Int):Unit={
    state.doPlayCard(input,player)
  }
  def doPlayCard(card:Cards):Unit={
    state.doPlayCard(card,player)
  }
  def doPass_turn():Unit={
    state.doPass_turn()
  }
  def LoseGems():Unit={
    state.LoseGems(player,CPU)
  }
  def getState():String={
    state.getState
  }
  def toCpu_turn():Unit={
    state.toCpu_turn()
  }
  def toPlayer_turn():Unit={
    state.toPlayerTurn()
  }
  def toStartRound():Unit={
    state.toStartRound()
  }
  def toEndRound():Unit={
    state.toEndRound()
  }
  def toEndGame():Unit={
    state.toEndGame()
  }
  def ShuffleDeck():Unit={
    state.ShuffleDeck(player,CPU)
  }
  def ClearBoard():Unit={
    state.ClearBoard(Board)
  }
  // no documentation because i created this method only for test how the cpu plays
  // and is not part of the game
  def TestsMode():Unit={
    //this is for a test only and is like giving the player a god card to win
    val MegaMelee: MeleeCards = MeleeCards("Melee1", 100, new MoralReinforcement)
    val Test2: SiegeCards = SiegeCards("Melee1", 0, new NoAbility)
    val mazoPp: Deck = new Deck
    mazoPp.initiator()
    mazoPp.addCard(MegaMelee)
    val ManoPp:Hand = new Hand(mazoPp)
    ManoPp.draw_card(mazoPp)
    player=Player("Player",mazoPp,ManoPp,Side1)
    //this is for also testing how the cpu plays
    val mazoCC: Deck = new Deck
    mazoCC.initiator()
    val a: MeleeCards = MeleeCards("alejandro", 5, new NoAbility)
    val d: WeatherCards = WeatherCards("Nice weather", new NoAbility)
    mazoCC.addCard(a)
    mazoCC.addCard(d)
    val ManoCC: Hand = new Hand(mazoCC)
    ManoCC.draw_card(mazoCC)
    ManoCC.draw_card(mazoCC)
    CPU = Player("Player", mazoCC, ManoCC, Side2)


  }

  /**
   * Updates the game state based on the given player.
   * This method is called when a player loses the game.
   * It handles the necessary actions and transitions the game state accordingly.
   *
   * @param player The player who lost the game.
   */
  def update(player: Player): Unit ={
    if (player.equals(CPU)){
      println("El Jugador ha Ganado")
      state= new EndGame(this)
    }
    else{
      println("La CPU ha Ganado")
      state= new EndGame(this)
    }
  } 
}
