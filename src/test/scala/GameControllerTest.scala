package cl.uchile.dcc

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Controller.States.{InvalidActionException, InvalidTransitionException}
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
  var Controller: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    Mazo = new Deck()
    Mazo.initiator()
    Mano = new Hand(Mazo)
    Mano.incial(Mazo)
    Side1 = new BoardSide
    Side2 = new BoardSide
    Board = new Board(Side1, Side2)
    Board.setSides()
    Controller= new GameController()
  }
  test("Changing states and doing actions in StartGame"){
    assertEquals(Controller.getState(),"StartGame")
    try{
      Controller.toEndGame()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from StartGame to toEndGame")
    }
    try{
      Controller.toEndRound()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from StartGame to toEndRound")
    }
    try{
      Controller.toCpu_turn()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from StartGame to toCpu_turn")
    }
    try{
      Controller.toPlayer_turn()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from StartGame to toPlayerTurn")
    }
    try{
      Controller.doDrawCard()
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doDrawCard in StartGame")
    }
    try{
      Controller.doPlayCard(Melee1)
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doPlayCard in StartGame")
    }
    try{
      Controller.doPass_turn()
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doPass_turn in StartGame")
    }
    try{
      Controller.doPlayCard(0)
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doPlayCard in StartGame")
    }
    try{
      Controller.doCPU_turn()
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doCPU_turn in StartGame")
    }
    Controller.toStartRound()
    assertEquals(Controller.getState(),"StartRound")
  }

  test("Changing states and doing action in StartRound"){
    Controller.toStartRound()
    assertEquals(Controller.getState(),"StartRound")
    try{
      Controller.toEndGame()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from StartRound to toEndGame")
    }
    try{
      Controller.toCpu_turn()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from StartRound to toCpu_turn")
    }
    try{
      Controller.toEndRound()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from StartRound to toEndRound")
    }
    try{
      Controller.doPlayCard(0)
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doPlayCard in StartRound")
    }
    try {
      Controller.doPass_turn()
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doPass_turn in StartRound")
    }
    try{
      Controller.doCPU_turn()
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doCPU_turn in StartRound")
    }
    try{
      Controller.doPlayCard(Melee1)
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doPlayCard in StartRound")
    }
    assertEquals(Controller.getManoPLength,5)
    Controller.doDrawCard()
    assertEquals(Controller.getManoPLength,6)
    assertEquals(Controller.getState(),"PlayerTurn")
  }
  test("Changing states between player and Cpu"){
    Controller.toStartRound()
    assertEquals(Controller.getState(),"StartRound")
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(),"PlayerTurn")
    try{
      Controller.toEndGame()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from PlayerTurn to toEndGame")
    }
    try{
      Controller.toStartRound()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from PlayerTurn to toStartRound")
    }
    try{
      Controller.toEndRound()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from PlayerTurn to toEndRound")
    }
    Controller.doPlayCard(0)
    assertEquals(Controller.getManoPLength,4)
    assertEquals(Controller.getBoardNcards,1)
    assertEquals(Controller.getState(),"CPU_turn")
    try{
      Controller.doDrawCard()
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doDrawCard in CPU_turn")
    }
    try {
      Controller.toStartRound()
    }
    catch {
      case e: InvalidTransitionException => assertEquals(e.getMessage,"Cannot transition from CPU_turn to toStartRound")
    }
    try {
      Controller.doPlayCard(0)
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage,"Cannot do doPlayCard in CPU_turn")
    }
    try {
      Controller.doPlayCard(Melee1)
    }
    catch {
      case e: InvalidActionException => assertEquals(e.getMessage, "Cannot do doPlayCard in CPU_turn")
    }
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(),"PlayerTurn")
  }
  test("Changing to posible states only"){
    Controller.toStartRound()
    assertEquals(Controller.getState(),"StartRound")
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(),"PlayerTurn")
    Controller.toCpu_turn()
    assertEquals(Controller.getState(),"CPU_turn")
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(),"PlayerTurn")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"PerpetualCPU")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"EndRound")
    Controller.toStartRound()
    assertEquals(Controller.getState(),"StartRound")
    Controller.doDrawCard()
    assertEquals(Controller.getState(),"PlayerTurn")
    Controller.doPlayCard(0)
    assertEquals(Controller.getState(),"CPU_turn")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"PerpetualPlayer")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"EndRound")
    Controller.toEndGame()
    assertEquals(Controller.getState(),"EndGame")
  }
}