package mars.rover.infra

import mars.rover.domain.Command
import mars.rover.domain.Position

interface Translator {

    fun translateSize(size: String): Pair<Int, Int>

    fun translatePosition(position: String): Position

    fun translateOrders(orders: String): List<Command.MovementOrder>
}