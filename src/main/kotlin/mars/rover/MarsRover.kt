package mars.rover.mars.rover

import mars.rover.application.MarsRoverService
import mars.rover.domain.Command
import mars.rover.domain.CommandResponse
import mars.rover.domain.Position
import mars.rover.infra.Translator

class MarsRover(private val translator: Translator) {

    private val service = MarsRoverService()

    fun invoke(size: String, initialPosition: String, orders: String): Position {

        val sizeTranslated = translator.translateSize(size)
        service.handle(Command.CreatePlateauCommand(sizeTranslated.first, sizeTranslated.second))

        val positionTranslated = translator.translatePosition(initialPosition)
        service.handle(
            Command.PlaceMarsRoverCommand(
                Position(
                    x = positionTranslated.x,
                    y = positionTranslated.y,
                    direction = positionTranslated.direction
                )
            )
        )

        var result: Position? = null
        val orders = translator.translateOrders(orders)
        orders.forEach {
            result = (service.handle(Command.MoveMarsRoverCommand(it)) as CommandResponse.PositionResponse).position
        }
        return result!!
    }


}