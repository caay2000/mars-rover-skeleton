package mars.rover

import mars.rover.application.MarsRoverImpl
import mars.rover.domain.Command
import mars.rover.domain.CommandResponse
import mars.rover.domain.Direction
import mars.rover.domain.Position
import mars.rover.infra.EnglishTranslator
import mars.rover.infra.OrdersTranslator

fun main(args: Array<String>) {

    val service = MarsRoverImpl()
    val translator: OrdersTranslator = EnglishTranslator()

    service.handle(Command.CreatePlateauCommand(10, 10))
    service.handle(Command.PlaceMarsRoverCommand(Position(0, 0, Direction.NORTH)))

    var result: Position? = null
    val orders = translator.translate("MMRMMLM")
    orders.forEach {
        result = (service.handle(Command.MoveMarsRoverCommand(it)) as CommandResponse.PositionResponse).position
    }
    println(result)

}
