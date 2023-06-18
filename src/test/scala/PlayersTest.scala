package cl.uchile.dcc

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}
import cl.uchile.dcc.gwent.CardClasses.CardAbilities.NoAbility
import cl.uchile.dcc.gwent.CardClasses.MeleeCards
import cl.uchile.dcc.gwent.Players.{Deck, Hand, Player}
import munit.FunSuite


class PlayersTest extends FunSuite {
  var Jugador1:Player=_
  var Jugador2:Player=_
  var Mazo:Deck=_
  var Mano:Hand=_
  var Side1:BoardSide=_
  var Side2:BoardSide=_
  var Board:Board=_

  override def beforeEach(context: BeforeEach):Unit= {
    Mazo = new Deck()
    Mazo.initiator()
    Mano = new Hand(Mazo)
    Mano.incial(Mazo)
    Side1= new BoardSide
    Side2= new BoardSide
    Board= new Board(Side1,Side2)
    Board.setSides()

    Jugador1 = Player("j1",Mazo,Mano,Side1)
    Jugador2 = Player("j2",Mazo,Mano,Side1)
  }
  test("name") {
     assertEquals(Jugador1.getName, "j1")
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
  test("you can't draw a card with no deck") {
    Mazo= new Deck()
    Jugador1 = new Player("j1",Mazo,Mano,Side1)
    assertEquals(Jugador1.DrawCard(),false)
  }
  test("you can't play a card with no hand"){
    Mazo= new Deck()
    Mano= new Hand (Mazo)
    Jugador1 = new Player("j1",Mazo,Mano,Side1)
    assertEquals(Jugador1.PlayCard(10),false)
  }
  test("When you play a card you lose a card in the hand"){
    assertEquals(Jugador1.PlayCard(3),true)
    assertEquals(Jugador1.PlayCard(7),false)
    assertEquals(Jugador1.handnumer(),4)
  }

  test("equals between players"){
    assertEquals(Jugador1.equals(Jugador2),false)
    assertEquals(Jugador1.equals(Jugador1),true)
    assertEquals(Jugador1.equals(new MeleeCards("j1",1,new NoAbility)),false)
  }
  test("playing 6 cards of a 5-cards hand"){
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    Jugador1.PlayCard(0)
    assertEquals(Jugador1.PlayCard(0),false)
  }
  test("drawing cards from a no cards deck"){
    Mazo=new Deck()
    Mano=new Hand(Mazo)
    assertEquals(Mano.draw_card(Mazo),false)
  }
  test("Playing a card saying the card"){
    

  }
  test("Total strenght"){
    
  }
  
}