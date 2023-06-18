package cl.uchile.dcc
import cl.uchile.dcc.gwent.CardClasses.CardAbilities.{Ability, ClearWeather, MoralReinforcement, NoAbility, TightBond}
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import cl.uchile.dcc.gwent.Cards
import munit.{FunSuite, Slow}

import scala.None

class CardsTest extends FunSuite {
  var Melee1:MeleeCards=_
  var Ranged1:RangeCards = _
  var Siege1:SiegeCards = _
  var Weather:WeatherCards=_
  var NA:Ability=_
  var MR:Ability=_
  var TB:Ability=_
  var CW:Ability=_


  override def beforeEach(context: BeforeEach): Unit ={
    NA=new NoAbility
    MR=new MoralReinforcement
    TB=new TightBond
    CW=new ClearWeather
    Melee1 = MeleeCards("alejandro",5,NA)
    Ranged1 =RangeCards("Pepe",7,MR)
    Siege1 = SiegeCards("Catapulta",2,TB)
    Weather= WeatherCards("Nice weather",CW)
  }
  test("name"){
    assertEquals(Melee1.getName,"alejandro")
    assertEquals(Ranged1.getName,"Pepe")
    assertEquals(Siege1.getName, "Catapulta")
    assertEquals(Weather.getName,"Nice weather")

  }
  test("just strength"){
    assertEquals(Melee1.getStrenght, 5)
    assertEquals(Ranged1.getStrenght, 7)
    assertEquals(Siege1.getStrenght, 2)
  }


  test("some equals between the cards"){
    assertEquals(Melee1.equals(MeleeCards("alejandro",5,NA)),true)
    assertEquals(Melee1.equals(MeleeCards("pele",1,NA)),false)
    assertEquals(Ranged1.equals(RangeCards("Pepe",7,MR)),true)
    assertEquals(Ranged1.equals(RangeCards("pele",1,NA)),false)
    assertEquals(Siege1.equals(SiegeCards("Catapulta",2,TB)),true)
    assertEquals(Siege1.equals(SiegeCards("pele",1,NA)),false)
    assertEquals(Weather.equals(WeatherCards("Nice weather",CW)),true)
    assertEquals(Weather.equals(WeatherCards("pele",TB)),false)
    assertEquals(Melee1.equals(RangeCards("pele",1,CW)),false)
    assertEquals(Ranged1.equals(SiegeCards("pele",1,NA)),false)
    assertEquals(Siege1.equals(MeleeCards("pele",1,NA)),false)
    assertEquals(Weather.equals(MeleeCards("pele",1,NA)),false)
  }
  test("get ability names"){
    assertEquals(Melee1.getAbility(),"NoAbility")
    assertEquals(Ranged1.getAbility(),"MoralReinforcement")
    assertEquals(Siege1.getAbility(),"TightBond")
    assertEquals(Weather.getAbility(),"ClearWeather")
  }
  test("States"){
    Melee1.State.toTightBondState()
    assertEquals(Melee1.getActualStrenght,10)
    Melee1.State.toFrozenState()
    assertEquals(Melee1.getActualStrenght,2)
    Melee1.State.toMoralBState()
    assertEquals(Melee1.getActualStrenght,3)
    Melee1.State.toMoralBState()
    assertEquals(Melee1.getActualStrenght,4)
    Melee1.State.toRegularState()
    assertEquals(Melee1.getActualStrenght,12)
  }


}