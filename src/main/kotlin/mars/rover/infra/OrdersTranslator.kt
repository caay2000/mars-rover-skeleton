package mars.rover.infra

import mars.rover.domain.Command

interface OrdersTranslator {

    fun translate(orders: String) : List<Command.MovementOrder>
}