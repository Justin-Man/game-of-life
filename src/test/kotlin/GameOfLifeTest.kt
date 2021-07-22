import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameOfLifeTest {

    @Test
    fun `a live cell with fewer than two live neighbours dies`() {
        // pass in list of cells rather than just the dimension
        val gameBoard = GameBoard(10)
        gameBoard.setAliveCells()

        val board = gameBoard.step()

        assertThat(board.isCellAlive(0, 0)).isEqualTo(false)
    }
}