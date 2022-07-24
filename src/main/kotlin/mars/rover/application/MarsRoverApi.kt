package mars.rover.application

import mars.rover.domain.Command

interface MarsRoverApi {

    fun handle(command: Command)

}