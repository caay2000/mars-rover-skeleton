package mars.rover.application

import mars.rover.domain.Command
import mars.rover.domain.CommandResponse
import mars.rover.domain.Plateau
import mars.rover.domain.Rover

class MarsRoverService : MarsRoverApi {

    private var map: Plateau? = null

    override fun handle(command: Command) = when (command) {
        is Command.CreatePlateauCommand -> createPlateau(command)
        is Command.PlaceMarsRoverCommand -> placeMarsRover(command)
        is Command.MoveMarsRoverCommand -> moveMarsRover(command)
    }

    private fun createPlateau(command: Command.CreatePlateauCommand): CommandResponse {
        map = Plateau(command.width.toUInt(), command.height.toUInt())
        return CommandResponse.EmptyResponse
    }

    private fun placeMarsRover(command: Command.PlaceMarsRoverCommand): CommandResponse {
        map!!.rover = Rover(command.position)
        return CommandResponse.EmptyResponse
    }

    private fun moveMarsRover(command: Command.MoveMarsRoverCommand): CommandResponse {
        map!!.rover!!.move(command.order)
        return CommandResponse.PositionResponse(map!!.rover!!.position)
    }

}