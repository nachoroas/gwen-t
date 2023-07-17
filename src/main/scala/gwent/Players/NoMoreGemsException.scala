package cl.uchile.dcc
package gwent.Players

/**
 * Exception thrown when a player has no more gems.
 *
 * This exception is thrown when a player attempts to decrease the number of gems,
 * but the player has no more gems available.
 *
 * @example
 * val player = new Player("bruno", deck, hand)
 * player.loseGem() // Throws NoMoreGemsException if the player has no more gems.
 */
class NoMoreGemsException extends Exception