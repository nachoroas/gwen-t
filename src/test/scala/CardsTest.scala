package cl.uchile.dcc
import munit.FunSuite

class CardsTest extends FunSuite {
  var Archer:Card=null

  override def beforeEach(context: BeforeEach): Unit ={
  Archer = new Card("Arrow",2,0,0)
  }
  test("name"){
    assertEquals(Archer.getname(),"Arrow")
  }
  test("just strength"){
    assertEquals(Archer.getStrength(),2)
  }
  test("add S"){
    assertEquals(Archer.addS(1),3)
  }
  test("losing S"){
    assertEquals(Archer.loss(),1)
  }

}