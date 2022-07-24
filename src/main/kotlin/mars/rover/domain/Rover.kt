package mars.rover.domain

data class Rover(var position: Position) {

    fun move(order: Command.MovementOrder) {
        position = when (order) {
            Command.MovementOrder.MOVE_FORWARD -> position.add(position.direction.moveForward)
            Command.MovementOrder.TURN_RIGHT -> position.add(position.direction.turnRight)
            Command.MovementOrder.TURN_LEFT -> position.add(position.direction.turnLeft)
        }
    }
}
