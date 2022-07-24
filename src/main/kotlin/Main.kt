package mars.rover

import mars.rover.infra.USATranslator
import mars.rover.mars.rover.MarsRover
import mars.rover.mars.rover.infra.URSSTranslator

fun main(args: Array<String>) {

    // USA version
    val usaOrdersTranslator = USATranslator()
    val usaMarsRover = MarsRover(usaOrdersTranslator)
    val usaResult = usaMarsRover.invoke("10,10", "0,0,N", "MMRMMLM")
    println(usaResult)

    val urssOrdersTranslator = URSSTranslator()
    val urssMarsRover = MarsRover(urssOrdersTranslator)

    // USA version
    val urssResult = urssMarsRover.invoke("10,10", "0,0,A", "XXYXXZX")
    println(urssResult)



}
