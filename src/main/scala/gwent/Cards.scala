package cl.uchile.dcc
package gwent

/**Trait for the cards which can be in the hand or deck*/
trait Cards{
  //to get names not implemented here
def getName:String
  //to use abilities not implemented here
def UseAbility():Boolean
  //to use the cards not implemented here
def be_played():Boolean
}
