package cl.uchile.dcc
package CardsTests

import model.CardClasses.CardAbilities.*
import model.CardClasses.Effects.{Frozen, MoralReinforcementEffect, TightBondEffect}
import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import model.Cards

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
  test("effects on cards"){
    Melee1.addEffect(new Frozen)
    assertEquals(Melee1.getStrenght,1)
    Melee1.addEffect(new MoralReinforcementEffect)
    assertEquals(Melee1.getStrenght,2)
    Melee1.addEffect(new MoralReinforcementEffect)
    assertEquals(Melee1.getStrenght,3)
    Melee1.addEffect(new TightBondEffect)
    assertEquals(Melee1.getStrenght,6)
    Melee1.addEffect(new TightBondEffect)
    assertEquals(Melee1.getStrenght,12)
    Melee1.addEffect(new MoralReinforcementEffect)
    assertEquals(Melee1.getStrenght,16)
    Melee1.removeEffect()
    assertEquals(Melee1.getStrenght,32)
    Melee1.addEffect(new MoralReinforcementEffect)
    assertEquals(Melee1.getStrenght,36)
  }


}