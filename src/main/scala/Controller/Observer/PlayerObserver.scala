package cl.uchile.dcc
package Controller.Observer

import model.Players.Player

trait PlayerObserver extends Observer{
  
  def update(player:Player): Unit
}
