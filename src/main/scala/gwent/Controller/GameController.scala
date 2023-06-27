package cl.uchile.dcc
package gwent.Controller

import gwent.Board.{Board, BoardSide}
import gwent.Cards
import gwent.Players.{Deck, Hand, Player}
import cl.uchile.dcc.gwent.Controller.States.{GameState, StartGame}

import scala.collection.mutable
import scala.util.Random


class GameController() {

  var state: GameState = new StartGame(this)
  private val Side1: BoardSide = new BoardSide
  private val Side2: BoardSide = new BoardSide
  private val Board: Board = new Board(Side1,Side2)
  Board.setSides()
  private val mazoP: Deck = new Deck
  private val mazoCPU: Deck = new Deck
  mazoP.initiator()
  mazoCPU.initiator()
  private val ManoP:Hand = new Hand(mazoP) //not private for testing
  private val ManoCPU:Hand = new Hand(mazoCPU)
  ManoP.incial(mazoP)
  ManoCPU.incial(mazoCPU)
  private val player: Player = Player("Player",mazoP,ManoP,Side1)
  private val CPU: Player = Player("CPU",mazoCPU,ManoCPU,Side2)

  
  def getBoardNcards:Int={
    Board.Ncards
  }
  def getManoPLength:Int={
    ManoP.Largu()
  }
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
  def getState():String={
    state.getState()
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

}
