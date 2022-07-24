package mars.rover.domain

sealed class CommandResponse {

    object EmptyResponse : CommandResponse()
    data class PositionResponse(val position: Position) : CommandResponse()
}