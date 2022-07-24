package mars.rover.application

import mars.rover.domain.Command
import mars.rover.domain.Plateau
import mars.rover.domain.Position
import mars.rover.domain.Rover

class MarsRoverImpl : MarsRoverApi {

    private var map: Plateau? = null

    override fun handle(command: Command) = when (command) {
        is Command.CreatePlateauCommand -> createPlateau(command)
        is Command.PlaceMarsRoverCommand -> placeMarsRover(command)
        is Command.MoveMarsRoverCommand -> moveMarsRover(command)
    }

    private fun createPlateau(command: Command.CreatePlateauCommand) {
        map = Plateau(command.width.toUInt(), command.height.toUInt())
    }

    private fun placeMarsRover(command: Command.PlaceMarsRoverCommand) {
        map!!.rover = Rover(command.x, command.y, command.direction)
    }

    private fun moveMarsRover(command: Command.MoveMarsRoverCommand): Position {
        map!!.rover!!.move(command.order)
    }

}