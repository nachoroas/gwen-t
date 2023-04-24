package cl.uchile.dcc
package gwent.CardClasses.WeatherCards

import gwent.Cards

abstract class WeatherCards(name:String,ability:Int,potition:4) extends Cards{
  
  // creare esta funcion cuando tenga para trabajar con el tablero
  // def beplayed : Void =

  def getName():String=name
  

}
