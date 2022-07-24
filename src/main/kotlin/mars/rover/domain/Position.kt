package mars.rover.domain

data class Position(val x: Int, val y: Int, val direction: Direction) {

    fun add(position: Position): Position =
        Position(
            x = this.x + position.x,
            y = this.y + position.y,
            direction = position.direction
        )
}