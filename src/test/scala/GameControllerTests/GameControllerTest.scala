package cl.uchile.dcc
package GameControllerTests

import model.Board.{Board, BoardSide}
import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import model.Players.{Deck, Hand, Player}
import cl.uchile.dcc.Controller.GameController
import cl.uchile.dcc.Controller.States.{InvalidActionException, InvalidTransitionException}

import cl.uchile.dcc.model.CardClasses.CardAbilities.{Ability, ClearWeather, MoralReinforcement, NoAbility, TightBond}
import munit.FunSuite

class GameControllerTest extends FunSuite {
  var Melee1: MeleeCards = _
  var Ranged1: RangeCards = _
  var Siege1: SiegeCards = _
  var Weather: WeatherCards = _
  var Controller: GameController = _
  var NA: Ability = _
  var MR: Ability = _
  var TB: Ability = _
  var CW: Ability = _

  override def beforeEach(context: BeforeEach): Unit = {
    Controller= new GameController()
    NA = new NoAbility
    MR = new MoralReinforcement
    TB = new TightBond
    CW = new ClearWeather
    Melee1 = MeleeCards("alejandro", 5, NA)
    Ranged1 = RangeCards("Pepe", 7, MR)
    Siege1 = SiegeCards("Catapulta", 2, TB)
    Weather = WeatherCards("Nice weather", CW)
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
    try {
      Controller.LoseGems()
    }
    catch {
      case e:InvalidActionException => assertEquals(e.getMessage,"Cannot do LoseGems in StartGame")
    }
    try {
      Controller.ShuffleDeck()
    }
    catch {
      case e:InvalidActionException => assertEquals(e.getMessage,"Cannot do ShuffleDeck in StartGame")
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
    assertEquals(Controller.getManoPLength,10)
    Controller.doDrawCard()
    assertEquals(Controller.getManoPLength,10)
    Controller.doPlayCard(0)
    assertEquals(Controller.getManoPLength,9)
    Controller.doPass_turn()
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"StartRound")
    Controller.doDrawCard()
    assertEquals(Controller.getManoPLength,10)
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
    assertEquals(Controller.getManoPLength,9)
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
  test("Changing to possible states only"){
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
    assertEquals(Controller.getState(),"StartRound")
    Controller.doDrawCard()
    assertEquals(Controller.getState(),"PlayerTurn")
    Controller.doPlayCard(0)
    assertEquals(Controller.getState(),"CPU_turn")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"PerpetualPlayer")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"EndGame")
  }
  test("Player won the game"){
    Controller.toStartRound()
    assertEquals(Controller.getState(),"StartRound")
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(),"PlayerTurn")
    Controller.doPlayCard(0)
    assertEquals(Controller.getState(),"CPU_turn")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"PerpetualPlayer")
    Controller.doPlayCard(0)
    Controller.doPlayCard(0)
    Controller.doPlayCard(0)
    Controller.doPlayCard(0)
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"StartRound")
    Controller.doDrawCard()
    assertEquals(Controller.getState(),"PlayerTurn")
    Controller.doPlayCard(0)
    assertEquals(Controller.getState(),"CPU_turn")
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"PerpetualPlayer")
    Controller.doPlayCard(0)
    Controller.doPlayCard(0)
    Controller.doPlayCard(0)
    Controller.doPlayCard(0)
    Controller.doPass_turn()
    assertEquals(Controller.getState(),"EndGame")
    //"El Jugador ha Ganado"
  }
  test("CPU won the game"){
    Controller.toStartRound()
    assertEquals(Controller.getState(), "StartRound")
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(), "PlayerTurn")
    Controller.doPass_turn()
    assertEquals(Controller.getState(), "PerpetualCPU")
    Controller.doCPU_turn()
    assertEquals(Controller.getState(), "StartRound")
    Controller.toPlayer_turn()
    Controller.doPlayCard(0)
    Controller.doCPU_turn()
    Controller.doPlayCard(0)
    Controller.doCPU_turn()
    Controller.doPlayCard(0)
    Controller.doCPU_turn()
    Controller.doPlayCard(0)
    Controller.doCPU_turn()
    Controller.doPlayCard(0)
    Controller.doCPU_turn()
    Controller.doPass_turn()
    Controller.doCPU_turn()
    assertEquals(Controller.getState(),"EndGame")
    //"La CPU ha Ganado"
  }
  test("How the cpu plays in CPU_turn also checking the cleanBoard method"){
    val MegaMelee: MeleeCards = MeleeCards("Melee1", 100, new MoralReinforcement)
    val Test2: SiegeCards = SiegeCards("Melee1", 0, new NoAbility)
    //this card is only used to test the methods
    Controller.toStartRound()
    assertEquals(Controller.getState(), "StartRound")
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(), "PlayerTurn")
    Controller.doPlayCard(0)
    assertEquals(Controller.getState(), "CPU_turn")
    Controller.doPass_turn()
    assertEquals(Controller.getState(), "PerpetualPlayer")
    Controller.doPass_turn()
    assertEquals(Controller.getBoardNcards, 0)
    assertEquals(Controller.getState(), "StartRound")
    Controller.toPlayer_turn()
    assertEquals(Controller.getState(), "PlayerTurn")
    Controller.TestsMode()
    //this is to test the methods of the CPU
    Controller.doPlayCard(MegaMelee)
    //player has 100 strenght in side
    Controller.doCPU_turn()
    //cpu plays a weather card
    Controller.doPlayCard(0)
    //player plays a random card
    Controller.doCPU_turn()
    //cpu has no weather card so passes turn
    assertEquals(Controller.getState(), "PerpetualPlayer")
    Controller.doPlayCard(Test2)
  }
  test("How the cpu plays in Perpetual CPU"){

    Controller.toStartRound()
    Controller.toPlayer_turn()
    Controller.TestsMode()
    //this is to test the methods of the CPU
    Controller.doPlayCard(0)
    //player has 100 strenght in side
    Controller.toPlayer_turn()
    Controller.doPass_turn()
    assertEquals(Controller.getState(), "PerpetualCPU")
    Controller.doCPU_turn()
    //cpu plays a weather card
    Controller.doCPU_turn()
    //cpu has no weather card so passes turn
    assertEquals(Controller.getState(), "StartRound")

  }
}