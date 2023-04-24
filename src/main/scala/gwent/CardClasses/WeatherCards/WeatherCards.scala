package cl.uchile.dcc
package gwent.CardClasses.WeatherCards

import gwent.Cards

abstract class WeatherCards(protected val name:String, protected val ability:Int,protected val position:4) extends Cards{
  
  // creare esta funcion cuando tenga para trabajar con el tablero
  // def beplayed : Void =

  def getName:String=name
  
  def be_played() : Boolean=true

}
