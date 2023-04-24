package cl.uchile.dcc
import cl.uchile.dcc.gwent.CardClasses
import cl.uchile.dcc.gwent.CardClasses.MeleeCards.{Melee1, MeleeCards}
import cl.uchile.dcc.gwent.CardClasses.RangedCards.{RangeCards, Ranged1}
import cl.uchile.dcc.gwent.CardClasses.SiegeCards.{Siege1, SiegeCards}
import cl.uchile.dcc.gwent.CardClasses.WeatherCards.{Biting_Frost, WeatherCards}
import cl.uchile.dcc.gwent.Cards
import munit.FunSuite

class CardsTest extends FunSuite {
  var Espada:MeleeCards=_
  var Arco:RangeCards=_
  var Ariete:SiegeCards=_
  var Tormenta:WeatherCards=_

  override def beforeEach(context: BeforeEach): Unit ={
  Espada = new Melee1()
  Arco = new Ranged1()
  Ariete = new Siege1()
  Tormenta= new Biting_Frost()
  }
  test("name"){
    assertEquals(Espada.getname(),"juan")
  }
  test("just strength"){
    assertEquals(Espada.getstrength(),3)
  }
  test("which ability"){
    assertEquals(Espada.UseAbility(),false)
  }


}