
package indi_hyzhang;

public class SparseMatrix
{

	public TripleNode data[];
	public int rows;
	public int cols;
	public int nums;
	public StringBuffer strbf = new StringBuffer("");

	public SparseMatrix(int maxSize)
	{
		data = new TripleNode[maxSize];
		for (int i = 0; i < data.length; i++)
		{
			data[i] = new TripleNode();
		}
		rows = 0;
		cols = 0;
		nums = 0;
	}

	public SparseMatrix(int mat[][])
	{
		int i, j, k = 0, count = 0;
		rows = mat.length;
		cols = mat[0].length;
		for (i = 0; i < mat.length; i++)
		{
			for (j = 0; j < mat[i].length; j++)
			{
				if (mat[i][j] != 0)
				{
					count++;
				}
			}
		}
		nums = count;
		data = new TripleNode[nums];
		for (i = 0; i < mat.length; i++)
		{
			for (j = 0; j < mat[i].length; j++)
			{
				strbf.append(mat[i][j] + " ");
				if (mat[i][j] != 0)
				{
					data[k] = new TripleNode(i, j, mat[i][j]);
					k++;
				}
			}
			strbf.append("\r\n");
		}
		strbf.append("\r\n");
	}

	public int[][] transpose(int[][] matrix)
	{
		int a[][] = new int[matrix[0].length][matrix.length];

		for (int i = 0; i < matrix[0].length; i++)
			for (int j = 0; j < matrix.length; j++)
				a[i][j] = matrix[j][i];

		return a;
	}

	public SparseMatrix fasttranspose()
	{
		SparseMatrix tm = new SparseMatrix(nums);
		tm.cols = rows;
		tm.rows = cols;
		tm.nums = nums;
		int i, j = 0, k = 0;
		int[] num, cpot;
		if (nums > 0)
		{
			num = new int[cols];
			cpot = new int[cols];
			for (i = 0; i < cols; i++)
			{
				num[i] = 0;
			}
			for (i = 0; i < nums; i++)
			{
				j = data[i].column;
				num[j]++;
			}
			cpot[0] = 0;
			for (i = 1; i < cols; i++)
			{
				cpot[i] = cpot[i - 1] + num[i - 1];
			}

			for (i = 0; i < nums; i++)
			{
				j = data[i].column;
				k = cpot[j];
				tm.data[k].row = data[i].column;
				tm.data[k].column = data[i].row;
				tm.data[k].value = data[i].value;
				cpot[j]++;
			}
		}
		return tm;
	}

	public String printMatrix()
	{
		int i;

		strbf.append("稀疏矩阵的三元组存储结构:").append("\r\n");
		strbf.append("行数：" + rows + ", 列数：" + cols + ", 非零元素个数：" + nums).append("\r\n");
		strbf.append("行下标  列下标  元素值").append("\r\n");
		for (i = 0; i < nums; i++)
		{
			strbf.append(data[i].row + "\t" + data[i].column + "\t" + data[i].value).append("\r\n");
		}
		return strbf.toString();
	}

}
