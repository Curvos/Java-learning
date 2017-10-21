package indi_hyzhang;

public class Resolver
{
	int nrow;
	int ncol;

	public Resolver()
	{
		nrow = 0;
		ncol = 0;
	}

	public int[][] resolve(String str)
	{
		String[] dim1 = str.split("\r\n");
		nrow = dim1.length;
		String[] temp = dim1[0].split(" ");
		ncol = temp.length;
		int[][] result = new int[nrow][ncol];
		for (int i = 0; i < nrow; i++)
		{
			temp = dim1[i].split(" ");
			for (int j = 0; j < ncol; j++)
			{
				result[i][j] = Integer.parseInt(temp[j]);
			}
		}
		return result;
	}

}
