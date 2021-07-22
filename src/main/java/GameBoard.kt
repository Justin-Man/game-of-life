
/**
 *
1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2. Any live cell with more than three live neighbours dies, as if by overcrowding.
3. Any live cell with two or three live neighbours lives on to the next generation.
4. Any dead cell with exactly three live neighbours becomes a live cell.
 * A generation is one iteration over the board
 * */
class GameBoard(val dimension: Int) {

    val board : MutableList<Cell> = mutableListOf()

    init {
        for (y in 0 until dimension) {
            for (x in 0 until dimension) {
                board.add(Cell(false, x, y))
            }
        }
    }

    fun step(): GameBoard {
        TODO()
    }

    fun isCellAlive(x: Int, y: Int): Boolean {
        TODO("Not yet implemented")
    }
}

data class Cell(
    val isAlive: Boolean,
    val xPosition: Int,
    val yPosition: Int
)
