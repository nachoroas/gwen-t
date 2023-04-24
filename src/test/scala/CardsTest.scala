package cl.uchile.dcc
import cl.uchile.dcc.gwent.CardClasses
import cl.uchile.dcc.gwent.CardClasses.MeleeCards.{Melee1, Melee2, Melee3, Melee4, Melee5, Melee6, Melee7, MeleeCards}
import cl.uchile.dcc.gwent.CardClasses.RangedCards.{RangeCards, Ranged1, Ranged2, Ranged3, Ranged4, Ranged5, Ranged6, Ranged7}
import cl.uchile.dcc.gwent.CardClasses.SiegeCards.{Siege1, Siege2, Siege3, Siege4, Siege5, Siege6, Siege7, SiegeCards}
import cl.uchile.dcc.gwent.CardClasses.WeatherCards.{Biting_Frost, Clear_Weather, Impenetrable_Fog, Torrential_Rain, WeatherCards}
import cl.uchile.dcc.gwent.Cards
import munit.FunSuite

class CardsTest extends FunSuite {
  var Melee1:MeleeCards=_
  var Melee2:MeleeCards=_
  var Melee3:MeleeCards=_
  var Melee4:MeleeCards=_
  var Melee5:MeleeCards= _
  var Melee6:MeleeCards = _
  var Melee7:MeleeCards = _
  var Ranged1:RangeCards = _
  var Ranged2:RangeCards = _
  var Ranged3:RangeCards = _
  var Ranged4:RangeCards = _
  var Ranged5:RangeCards = _
  var Ranged6:RangeCards = _
  var Ranged7:RangeCards = _
  var Siege1:SiegeCards = _
  var Siege2:SiegeCards = _
  var Siege3:SiegeCards = _
  var Siege4:SiegeCards = _
  var Siege5:SiegeCards = _
  var Siege6:SiegeCards = _
  var Siege7:SiegeCards = _
  var Biting_Frost:WeatherCards = _
  var Clear_Weather:WeatherCards = _
  var Impenetrable_Fog:WeatherCards = _
  var torrential_Rain:WeatherCards = _

  override def beforeEach(context: BeforeEach): Unit ={
    Melee1 = new Melee1
    Melee2 = new Melee2
    Melee3 = new Melee3
    Melee4 = new Melee4
    Melee5 = new Melee5
    Melee6 = new Melee6
    Melee7 = new Melee7
    Ranged1 = new Ranged1
    Ranged2 = new Ranged2
    Ranged3 = new Ranged3
    Ranged4 = new Ranged4
    Ranged5 = new Ranged5
    Ranged6 = new Ranged6
    Ranged7 = new Ranged7
    Siege1 = new Siege1
    Siege2 = new Siege2
    Siege3 = new Siege3
    Siege4 = new Siege4
    Siege5 = new Siege5
    Siege6 = new Siege6
    Siege7 = new Siege7
    Biting_Frost = new Biting_Frost
    Clear_Weather  = new Clear_Weather
    Impenetrable_Fog  = new Impenetrable_Fog
    torrential_Rain= new Torrential_Rain
  }
  test("name"){
    assertEquals(Melee1.getName,"juan")
    assertEquals(Melee2.getName,"matias")
    assertEquals(Melee3.getName,"jose")
    assertEquals(Melee4.getName,"luis")
    assertEquals(Melee5.getName,"lucas")
    assertEquals(Melee6.getName,"Pedro")
    assertEquals(Melee7.getName,"Roberto")
    assertEquals(Ranged1.getName,"pepe")
    assertEquals(Ranged2.getName,"federico")
    assertEquals(Ranged3.getName,"felipe")
    assertEquals(Ranged4.getName, "tomas")
    assertEquals(Ranged5.getName, "marcelo")
    assertEquals(Ranged6.getName, "pablo")
    assertEquals(Ranged7.getName, "eduardo")
    assertEquals(Siege1.getName, "ariete")
    assertEquals(Siege2.getName, "Torre")
    assertEquals(Siege3.getName, "tortuga")
    assertEquals(Siege4.getName, "muscolo")
    assertEquals(Siege5.getName, "ballista")
    assertEquals(Siege6.getName, "ariete de elite")
    assertEquals(Siege7.getName, "Onagro")
    assertEquals(Biting_Frost.getName,"Biting Frost")
    assertEquals(Clear_Weather.getName,"Clear Weather")
    assertEquals(Impenetrable_Fog.getName,"Impenetrable Fog")
    assertEquals(torrential_Rain.getName,"Torrential Rain")

  }
  test("just strength"){
    assertEquals(Melee1.getStrenght, 3)
    assertEquals(Melee2.getStrenght, 5)
    assertEquals(Melee3.getStrenght, 5)
    assertEquals(Melee4.getStrenght, 5)
    assertEquals(Melee5.getStrenght, 1)
    assertEquals(Melee6.getStrenght, 2)
    assertEquals(Melee7.getStrenght,10)
    assertEquals(Ranged1.getStrenght, 2)
    assertEquals(Ranged2.getStrenght, 7)
    assertEquals(Ranged3.getStrenght, 2)
    assertEquals(Ranged4.getStrenght, 22)
    assertEquals(Ranged5.getStrenght, 1)
    assertEquals(Ranged6.getStrenght, 2)
    assertEquals(Ranged7.getStrenght, 1)
    assertEquals(Siege1.getStrenght, 7)
    assertEquals(Siege2.getStrenght, 10)
    assertEquals(Siege3.getStrenght, 3)
    assertEquals(Siege4.getStrenght, 7)
    assertEquals(Siege5.getStrenght, 3)
    assertEquals(Siege6.getStrenght, 11)
    assertEquals(Siege7.getStrenght, 2)
  }
  test("losing strength"){
    Melee1.loseStrenght()
    Melee2.loseStrenght()
    Melee3.loseStrenght()
    Melee4.loseStrenght()
    Melee5.loseStrenght()
    Melee6.loseStrenght()
    Melee7.loseStrenght()
    Ranged1.loseStrenght()
    Ranged2.loseStrenght()
    Ranged3.loseStrenght()
    Ranged4.loseStrenght()
    Ranged5.loseStrenght()
    Ranged6.loseStrenght()
    Ranged7.loseStrenght()
    Siege1.loseStrenght()
    Siege2.loseStrenght()
    Siege3.loseStrenght()
    Siege4.loseStrenght()
    Siege5.loseStrenght()
    Siege6.loseStrenght()
    Siege7.loseStrenght()
    assertEquals(Melee1.getStrenght,1)
    assertEquals(Melee2.getStrenght,1)
    assertEquals(Melee3.getStrenght,1)
    assertEquals(Melee4.getStrenght,1)
    assertEquals(Melee5.getStrenght,1)
    assertEquals(Melee6.getStrenght,1)
    assertEquals(Melee7.getStrenght,1)
    assertEquals(Ranged1.getStrenght,1)
    assertEquals(Ranged2.getStrenght,1)
    assertEquals(Ranged3.getStrenght,1)
    assertEquals(Ranged4.getStrenght,1)
    assertEquals(Ranged5.getStrenght,1)
    assertEquals(Ranged6.getStrenght,1)
    assertEquals(Ranged7.getStrenght,1)
    assertEquals(Siege1.getStrenght,1)
    assertEquals(Siege2.getStrenght,1)
    assertEquals(Siege3.getStrenght,1)
    assertEquals(Siege4.getStrenght,1)
    assertEquals(Siege5.getStrenght,1)
    assertEquals(Siege6.getStrenght,1)
    assertEquals(Siege7.getStrenght,1)
  }
  test("using ability"){
    assertEquals(Melee1.UseAbility(), false)
    assertEquals(Melee2.UseAbility(), true)
    assertEquals(Melee3.UseAbility(), false)
    assertEquals(Melee4.UseAbility(), false)
    assertEquals(Melee5.UseAbility(), true)
    assertEquals(Melee6.UseAbility(), true)
    assertEquals(Melee7.UseAbility(), true)
    assertEquals(Ranged1.UseAbility(),true )
    assertEquals(Ranged2.UseAbility(), true)
    assertEquals(Ranged3.UseAbility(), true)
    assertEquals(Ranged4.UseAbility(), true)
    assertEquals(Ranged5.UseAbility(), true)
    assertEquals(Ranged6.UseAbility(), true)
    assertEquals(Ranged7.UseAbility(), true)
    assertEquals(Siege1.UseAbility(), true)
    assertEquals(Siege2.UseAbility(), true)
    assertEquals(Siege3.UseAbility(), true)
    assertEquals(Siege4.UseAbility(), true)
    assertEquals(Siege5.UseAbility(), true)
    assertEquals(Siege6.UseAbility(), true)
    assertEquals(Siege7.UseAbility(), true)
    assertEquals(Biting_Frost.UseAbility(), true)
    assertEquals(Clear_Weather.UseAbility(), true)
    assertEquals(Impenetrable_Fog.UseAbility(), true)
    assertEquals(torrential_Rain.UseAbility(), true)
  }
  test("calling to use even if it is not implemented"){
    assertEquals(Melee1.be_played(), true)
    assertEquals(Melee2.be_played(), true)
    assertEquals(Melee3.be_played(), true)
    assertEquals(Melee4.be_played(), true)
    assertEquals(Melee5.be_played(), true)
    assertEquals(Melee6.be_played(), true)
    assertEquals(Melee7.be_played(), true)
    assertEquals(Ranged1.be_played(), true)
    assertEquals(Ranged2.be_played(), true)
    assertEquals(Ranged3.be_played(), true)
    assertEquals(Ranged4.be_played(), true)
    assertEquals(Ranged5.be_played(), true)
    assertEquals(Ranged6.be_played(), true)
    assertEquals(Ranged7.be_played(), true)
    assertEquals(Siege1.be_played(), true)
    assertEquals(Siege2.be_played(), true)
    assertEquals(Siege3.be_played(), true)
    assertEquals(Siege4.be_played(), true)
    assertEquals(Siege5.be_played(), true)
    assertEquals(Siege6.be_played(), true)
    assertEquals(Siege7.be_played(), true)
    assertEquals(Biting_Frost.be_played(), true)
    assertEquals(Clear_Weather.be_played(), true)
    assertEquals(Impenetrable_Fog.be_played(), true)
    assertEquals(torrential_Rain.be_played(), true)
  }
  test("some equals between the cards"){
    assertEquals(Melee1.equals(new Melee1),true)
    assertEquals(Melee1.equals(new Ranged1),false)
    assertEquals(Melee1.equals(new Siege1),false)
    assertEquals(Melee1.equals(new Biting_Frost),false)
    assertEquals(Ranged1.equals(new Ranged1),true)
    assertEquals(Ranged1.equals(new Melee1),false)
    assertEquals(Ranged1.equals(new Ranged2),false)
    assertEquals(Siege1.equals(new Siege1),true)
    assertEquals(Siege1.equals(new Siege2),false)
    assertEquals(Siege1.equals(new Ranged2),false)
    assertEquals(Impenetrable_Fog.equals(new Impenetrable_Fog),true)
    assertEquals(Impenetrable_Fog.equals(new Biting_Frost),false)
    assertEquals(Impenetrable_Fog.equals(new Siege1),false)

  }


}