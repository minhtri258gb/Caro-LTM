package ltm.caro.server;


public class Caro  {

	public final static int h_row = 18;
	public final static int h_col = 18;

	private int m_matrix[][];
	private int m_win;


	public Caro() {
		m_matrix = new int[h_row + 2][h_col + 2];
		m_win = 0;
	}

	public int[][] getMatrix() {
		return m_matrix;
	}
	public int getWin() {
		return m_win;
	}

	public boolean update(boolean useCross, int x, int y) {
		if (x < 0 || x > 16 || y < 0 || y > 16) {
			Engine.error("x, y ngoai pham vi ban co!");
			return false;
		}

		int row = x + 1;
		int col = y + 1;
		short player = (short) (useCross ? 1 : 2);

		if (m_matrix[row][col] == 0) {
			m_matrix[row][col] = player;
		} else {
			Engine.error("Vi tri nay da duoc chon truoc do!");
			return false;
		}

		m_win = checkWin(row, col);
		return true;
	}

	private int checkWin(int row, int col) {
		int[][] rc = { { 0, -1, 0, 1 }, { -1, 0, 1, 0 }, { 1, -1, -1, 1 }, { -1, -1, 1, 1 } };
		int i = row, j = col;
		for (int direction = 0; direction < 4; direction++)
		{
			int count = 0;

			i = row;
			j = col;
			while ( i > 0 && i < m_matrix.length &&
					j > 0 && j < m_matrix.length &&
					m_matrix[i][j] == m_matrix[row][col])
			{
				count++;
				if (count == 5)
					return m_matrix[row][col];

				i += rc[direction][0];
				j += rc[direction][1];
			}

			count--;
			i = row;
			j = col;
			while ( i > 0 && i < m_matrix.length &&
					j > 0 && j < m_matrix.length &&
					m_matrix[i][j] == m_matrix[row][col])
			{
				count++;
				if (count == 5) {
					return m_matrix[row][col];
				}
				i += rc[direction][2];
				j += rc[direction][3];
			}
		}
		return 0;
	}

}
