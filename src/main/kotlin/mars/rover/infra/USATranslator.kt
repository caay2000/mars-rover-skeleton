package mars.rover.infra

import mars.rover.domain.Command
import mars.rover.domain.Direction
import mars.rover.domain.Position

class USATranslator : Translator {

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
            "N" -> Direction.NORTH
            "E" -> Direction.EAST
            "S" -> Direction.SOUTH
            "W" -> Direction.WEST
            else -> throw RuntimeException("error")
        }

    override fun translateOrders(orders: String): List<Command.MovementOrder> {

        val list = mutableListOf<Command.MovementOrder>()
        orders.forEach {
            when (it) {
                'M' -> list.add(Command.MovementOrder.MOVE_FORWARD)
                'R' -> list.add(Command.MovementOrder.TURN_RIGHT)
                'L' -> list.add(Command.MovementOrder.TURN_LEFT)
                else -> throw RuntimeException("error")
            }
        }
        return list
    }
}