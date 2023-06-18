package cl.uchile.dcc
package gwent.Visitor
import gwent.CardClasses.{MeleeCards, WeatherCards}

class getWeatherCardVisitor extends Visitor{

  private var weatherCardsList:List[WeatherCards]=_

  override def visitWeatherCard(weatherCards: WeatherCards): Unit = {
    weatherCardsList= weatherCards :: weatherCardsList
  }
  def getCards:List[WeatherCards]=weatherCardsList


}
