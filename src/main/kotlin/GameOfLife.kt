/**
 *
1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2. Any live cell with more than three live neighbours dies, as if by overcrowding.
3. Any live cell with two or three live neighbours lives on to the next generation.
4. Any dead cell with exactly three live neighbours becomes a live cell.
 * A generation is one iteration over the board
 * */

fun createBoard(boardSize: Int): Array<Array<Boolean>> {
    val board = Array(boardSize) {
        Array(boardSize) { false }
    }

    board[0][0] = true
    board[0][1] = true
    board[0][2] = true
    board[1][0] = true

    return board
}

class GameOfLife(val board: Array<Array<Boolean>>) {
    fun nextGen() {
        for (row in board.indices) {
            for (column in board[row].indices) {
                val aliveNeighbours = countAliveNeighbours(row, column)
                if (board[row][column] && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
                    board[row][column] = true
                } else {
                    board[row][column] = !board[row][column] && aliveNeighbours == 3
                }
            }
        }
        printBoard()
    }

    fun countAliveNeighbours(row: Int, column: Int) : Int {
        var aliveNeighbours = 0
            if (column - 1 >= 0) {
                if (board[row][column - 1]) aliveNeighbours++
            }
            if (column + 1 < board[row].size) {
                if (board[row][column + 1]) aliveNeighbours++
            }
            if (row - 1 >= 0) {
                if (board[row - 1][column]) aliveNeighbours++
            }
            if (row + 1 < board.size) {
                if (board[row + 1][column]) aliveNeighbours++
            }
            if (row - 1 >= 0 && column - 1 >= 0) {
                if (board[row - 1][column - 1]) aliveNeighbours++
            }
            if (row - 1 >= 0 && column + 1 < board[row].size) {
                if (board[row - 1][column + 1]) aliveNeighbours++
            }
            if (row + 1 < board.size && column + 1 < board[row].size) {
                if (board[row + 1][column + 1]) aliveNeighbours++
            }
            if (row + 1 < board.size && column - 1 >= 0) {
                if (board[row + 1][column - 1]) aliveNeighbours++
            }
        return aliveNeighbours
    }

    private fun printBoard() {
        for (row in board.indices) {
            for (col in board[row].indices) {
                print("${board[row][col]} |")
            }
            println()
        }
    }
}