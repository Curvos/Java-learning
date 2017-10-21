
package datastructure;

public class SparseMatrix
{

	public TripleNode data[];
	public int rows;
	public int cols;
	public int nums;

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
				if (mat[i][j] != 0)
				{
					data[k] = new TripleNode(i, j, mat[i][j]);
					k++;
				}
			}
		}
	}

	public SparseMatrix transpose()
	{
		SparseMatrix tm = new SparseMatrix(nums);
		tm.cols = rows;
		tm.rows = cols;
		tm.nums = nums;
		int q = 0;
		for (int col = 0; col < cols; col++)
		{
			for (int p = 0; p < nums; p++)
			{
				if (data[p].column == col)
				{
					tm.data[q].row = data[p].column;
					tm.data[q].column = data[p].row;
					tm.data[q].value = data[p].value;
					q++;
				}
			}
		}
		return tm;
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
				tm.data[k].row = data[i].column; // 转置
				tm.data[k].column = data[i].row;
				tm.data[k].value = data[i].value;
				cpot[j]++;
			}
		}
		return tm;
	}

	public void printMatrix()
	{
		int i;
		System.out.println("稀疏矩阵的三元组存储结构:");
		System.out.println("行数：" + rows + ", 列数：" + cols + ", 非零元素个数：" + nums);
		System.out.println("行下标  列下标  元素值");
		for (i = 0; i < nums; i++)
		{
			System.out.println(data[i].row + "\t" + data[i].column + "\t" + data[i].value);
		}
	}
}
