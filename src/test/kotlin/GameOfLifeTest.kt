import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameOfLifeTest {

    private val game = GameOfLife(createBoard(5))

    @Test
    fun `board contains first generation of cells`() {
        val board = createBoard(5)

        assertThat(board[0][0]).isEqualTo(true)
        assertThat(board[0][1]).isEqualTo(true)
        assertThat(board[0][2]).isEqualTo(true)
        assertThat(board[1][0]).isEqualTo(true)
    }

    @Test
    fun `cell has two live neighbours`() {
        val aliveNeighbours = game.countAliveNeighbours(0,0)

        assertThat(aliveNeighbours).isEqualTo(2)
    }

    @Test
    fun `live cell with fewer than two live neighbours dies`() {
        game.nextGen()

        assertThat(game.board[0][2]).isEqualTo(false)
    }

    @Test
    fun `live cell with more than three live neighbours dies as if by overcrowding`() {
        game.nextGen()

        assertThat(game.board[0][0]).isEqualTo(true)
        assertThat(game.board[0][1]).isEqualTo(true)
        assertThat(game.board[1][0]).isEqualTo(true)
    }

    @Test
    fun `Any live cell with two or three live neighbours lives on to the next generation`() {
        game.nextGen()

        assertThat(game.board[0][0]).isEqualTo(true)
        assertThat(game.board[0][1]).isEqualTo(true)
        assertThat(game.board[1][0]).isEqualTo(true)
    }

    @Test
    fun `dead cell with exactly three live neighbours becomes a live cell`() {

        game.nextGen()

        assertThat(game.board[0][0]).isEqualTo(true)
        assertThat(game.board[0][1]).isEqualTo(true)
        assertThat(game.board[1][0]).isEqualTo(true)
        assertThat(game.board[1][1]).isEqualTo(true)
    }
}