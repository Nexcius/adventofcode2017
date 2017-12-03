import kotlin.math.abs

class Day3(val targetStep: Int) {
    data class Pos(var x: Int, var y: Int) {
        fun add(pos: Pos) {
            this.x += pos.x
            this.y += pos.y
        }
    }

    var pos = Pos(0, 0)
    var steps = 0
    var currentCircle = 0
    var targetFound = false

    fun diameter(circleNo: Int) = 2 * circleNo + 1

    fun step(delta: Pos) {
        steps++
        pos.add(delta)

        if (steps == targetStep) {
            println("Found target $targetStep at (${pos.x}, ${pos.y})")
            println("Distance is ${abs(pos.x) + abs(pos.y)}")
            targetFound = true
        }
    }

    fun walkCircle() {
        step(Pos(1, 0))

        val d = diameter(++currentCircle)
        (1..(d-2)).forEach {step(Pos(0, 1)) }
        (1..(d-1)).forEach { step(Pos(-1, 0)) }
        (1..(d-1)).forEach {step(Pos(0, -1)) }
        (1..(d-1)).forEach { step(Pos(1, 0)) }
    }

    fun findTarget() {
        step(Pos(0, 0))
        while (!targetFound) {
            walkCircle()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Day3(1).findTarget()
            Day3(12).findTarget()
            Day3(23).findTarget()
            Day3(1024).findTarget()
            Day3(289326).findTarget()
        }
    }
}
