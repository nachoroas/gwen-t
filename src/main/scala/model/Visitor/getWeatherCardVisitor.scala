package cl.uchile.dcc
package model.Visitor
import model.CardClasses.{MeleeCards, WeatherCards}

import scala.collection.mutable.ListBuffer

class getWeatherCardVisitor extends Visitor{

  private val weatherCardsList:ListBuffer[WeatherCards]=ListBuffer[WeatherCards]()

  override def visitWeatherCard(weatherCards: WeatherCards): Unit = {
      weatherCardsList += weatherCards
    }

  def getCards:ListBuffer[WeatherCards]=weatherCardsList


}
