package mars.rover.mars.rover.infra

import mars.rover.domain.Command
import mars.rover.domain.Direction
import mars.rover.domain.Position
import mars.rover.infra.Translator

class URSSTranslator : Translator {

    override fun translateSize(size: String): Pair<Int, Int> = Pair(
        first = size.split(",")[0].toInt(),
        second = size.split(",")[1].toInt()
    )

    override fun translatePosition(position: String): Position =
        Position(
            x = position.split(",")[0].toInt(),
            y = position.split(",")[1].toInt(),
            direction = translateDirection(position.split(",")[2])
        )

    private fun translateDirection(direction: String): Direction =
        when (direction) {
            "A" -> Direction.NORTH
            "B" -> Direction.EAST
            "C" -> Direction.SOUTH
            "D" -> Direction.WEST
            else -> throw RuntimeException("error")
        }

    override fun translateOrders(orders: String): List<Command.MovementOrder> {

        val list = mutableListOf<Command.MovementOrder>()
        orders.forEach {
            when (it) {
                'X' -> list.add(Command.MovementOrder.MOVE_FORWARD)
                'Y' -> list.add(Command.MovementOrder.TURN_RIGHT)
                'Z' -> list.add(Command.MovementOrder.TURN_LEFT)
                else -> throw RuntimeException("error")
            }
        }
        return list
    }
}