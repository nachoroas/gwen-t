package cl.uchile.dcc
package gwent

class Player (
  private val name:String,
  private val pos:Int,
  private var gem:Int,
  private var deck:String,
  private var hand:String
  ){
    def getname():String= name
    def getposition():Int=pos
    def gemnumber():Int=gem
    def losegem():Unit={
      if (gem>0){
        gem=gem-1
      }
    }

}
