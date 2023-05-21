package cl.uchile.dcc
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import cl.uchile.dcc.gwent.Cards
import munit.{FunSuite, Slow}

class CardsTest extends FunSuite {
  var Melee1:MeleeCards=_
  var Ranged1:RangeCards = _
  var Siege1:SiegeCards = _
  var Weather:WeatherCards=_

  override def beforeEach(context: BeforeEach): Unit ={
    Melee1 = new MeleeCards("alejandro",5,0)
    Ranged1 = new RangeCards("Pepe",7,3)
    Siege1 = new SiegeCards("Catapulta",2,4)
    Weather= new WeatherCards("Nice weather",1)
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

  test("using ability"){
    assertEquals(Melee1.UseAbility(), false)
    assertEquals(Ranged1.UseAbility(),true )
    assertEquals(Siege1.UseAbility(), true)
    assertEquals(Weather.UseAbility(), true)
  }
  test("some equals between the cards"){
    assertEquals(Melee1.equals(new MeleeCards("alejandro",5,0)),true)
    assertEquals(Melee1.equals(new MeleeCards("pele",1,1)),false)
    assertEquals(Ranged1.equals(new RangeCards("Pepe",7,3)),true)
    assertEquals(Ranged1.equals(new RangeCards("pele",1,1)),false)
    assertEquals(Siege1.equals(new SiegeCards("Catapulta",2,4)),true)
    assertEquals(Siege1.equals(new SiegeCards("pele",1,1)),false)
    assertEquals(Weather.equals(new WeatherCards("Nice weather",1)),true)
    assertEquals(Weather.equals(new WeatherCards("pele",0)),false)

  }


}