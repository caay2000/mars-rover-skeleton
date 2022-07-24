package mars.rover.infra

import mars.rover.domain.Command

class EnglishTranslator : OrdersTranslator {

    override fun translate(orders: String): List<Command.MovementOrder> {

        val list = mutableListOf<Command.MovementOrder>()
        orders.forEach {
            when (it) {
                'M' -> list.add(Command.MovementOrder.MOVE_FORWARD)
                'R' -> list.add(Command.MovementOrder.TURN_RIGHT)
                'L' -> list.add(Command.MovementOrder.TURN_LEFT)
                else -> Unit
            }
        }
        return list
    }
}