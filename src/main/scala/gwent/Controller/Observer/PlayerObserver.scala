package cl.uchile.dcc
package gwent.Controller.Observer

import gwent.Players.Player

trait PlayerObserver extends Observer{
  
  def update(player:Player): Unit
}
