package cl.uchile.dcc
import cl.uchile.dcc.gwent.Cards
import munit.FunSuite

class CardsTest extends FunSuite {
  var Archer:Cards=_

  override def beforeEach(context: BeforeEach): Unit ={
  Archer = new Cards("Arrow",0,2,"")
  }
  test("name"){
    assertEquals(Archer.getname(),"Arrow")
  }
  test("just strength"){
    assertEquals(Archer.getstrength(),2)
  }
  test("add S"){
    assertEquals(Archer.addS(1),2)
  }
  test("losing S"){
    assertEquals(Archer.loss(),1)
  }
  test("has ability"){
    assertEquals(Archer.hasabiliy(),false)
  }
  test("where is it"){
    assertEquals(Archer.getposition(),0)
  }

}