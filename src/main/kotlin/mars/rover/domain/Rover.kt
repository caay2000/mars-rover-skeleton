package mars.rover.domain

data class Rover(var position: Position, var direction: Direction) {

    fun move(order: Command.MovementOrder) {
        when(order){
            Command.MovementOrder.MOVE_FORWARD -> TODO()
            Command.MovementOrder.TURN_RIGHT -> TODO()
            Command.MovementOrder.TURN_LEFT -> TODO()
        }
    }
}
