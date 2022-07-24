package mars.rover.application

import mars.rover.domain.Command
import mars.rover.domain.CommandResponse

interface MarsRoverApi {

    fun handle(command: Command): CommandResponse

}