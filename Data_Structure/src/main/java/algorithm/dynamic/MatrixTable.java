package algorithm.dynamic;
/** * @author  wenchen 
 * @date 创建时间：2017年11月29日 下午1:18:50 
 * @version 1.0 
 * @parameter */
public class MatrixTable {

	//m[i][j]表示矩阵Ai到Aj链乘所需要的次数
	private int[][] matrix;
	
	//括号所在位置(括号在bracket[][]后面)
	private int[][] bracket;
	
	public MatrixTable (int n){
		this.matrix = new int[n][n];
		this.bracket = new int[n][n];
	}
	 
	public int[][] getBracket() {
		return bracket;
	}

	public void setBracket(int[][] bracket) {
		this.bracket = bracket;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public static MatrixTable newInstance(int[][] matrix,int[][] bracket){
		MatrixTable table = new MatrixTable(matrix.length);
		table.setMatrix(matrix);
		table.setBracket(bracket);
		return table;
	}
}
