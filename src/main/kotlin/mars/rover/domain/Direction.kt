package mars.rover.domain

enum class Direction {

    NORTH {
        override val moveForward: Position
            get() = Position(0, 1, NORTH)
        override val turnRight: Position
            get() = Position(0, 0, EAST)
        override val turnLeft: Position
            get() = Position(0, 0, WEST)
    },
    EAST {
        override val moveForward: Position
            get() = Position(1, 0, EAST)
        override val turnRight: Position
            get() = Position(0, 0, SOUTH)
        override val turnLeft: Position
            get() = Position(0, 0, NORTH)
    },
    SOUTH {
        override val moveForward: Position
            get() = Position(0, -1, SOUTH)
        override val turnRight: Position
            get() = Position(0, 0, WEST)
        override val turnLeft: Position
            get() = Position(0, 0, EAST)
    },
    WEST {
        override val moveForward: Position
            get() = Position(-1, 0, WEST)
        override val turnRight: Position
            get() = Position(0, 0, NORTH)
        override val turnLeft: Position
            get() = Position(0, 0, SOUTH)
    };


    abstract val moveForward: Position
    abstract val turnRight: Position
    abstract val turnLeft: Position
}
