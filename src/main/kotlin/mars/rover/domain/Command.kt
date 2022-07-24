package mars.rover.domain

sealed class Command {

    data class CreatePlateauCommand(val width: Int, val height: Int) : Command()
    data class MoveMarsRoverCommand(val order: MovementOrder) : Command()

    enum class MovementOrder {
        MOVE_FORWARD,
        TURN_RIGHT,
        TURN_LEFT
    }
}
