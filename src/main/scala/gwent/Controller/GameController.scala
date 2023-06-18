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
  mazoP.initiator()//si añado fabricas seguro cambio esto
  mazoCPU.initiator()// lo mismo que arriba
  private val ManoP:Hand = new Hand(mazoP)
  private val ManoCPU:Hand = new Hand(mazoCPU)
  private val player: Player = new Player("Player",mazoP,ManoP,Side1)
  private val CPU: Player = new Player("CPU",mazoCPU,ManoCPU,Side2)

  def doCPU_turn():Unit ={
    if (CPU.getTotalStrenght > player.getTotalStrenght ){
      CPU.PlayCard(Random.nextInt(ManoCPU.Largu()))
      state.toPlayerTurn()//MM
    }
    else{
      val WC=CPU.getWeathersCard
      if(WC.nonEmpty){
        CPU.PlayCard(WC.head)
        state.toPlayerTurn()//MMM
      }
      else{
        state.doPass_turn()//mmm
      }
    }

  }
  def doDrawCard():Unit={
    player.DrawCard()
    state.toCpu_turn()
  }
  def doPlayCard(input:Int):Unit={
    player.PlayCard(input)
    state.toCpu_turn()
  }
  def doPass_turn():Unit={
    
  }

}
