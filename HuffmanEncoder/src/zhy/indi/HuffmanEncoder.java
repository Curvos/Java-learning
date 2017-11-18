package zhy.indi;

public class HuffmanEncoder
{

	public String encode(String text)
	{
		StringBuffer sb = new StringBuffer("");
		int[][] HN = GUI.HN;
		char[] code = text.toCharArray();
		int[] weights = RandomAscii.dict;
		for (int i = 0; i < code.length; i++)
		{
			int ascii = (int) code[i] - 32;
			int weight = weights[ascii];
			int index = 0;
			for (int j = 0; j < weights.length; j++)
			{
				if (weight == weights[j])
				{
					index = j;
					break;
				}
			}

			for (int j = 0; j < HN[index].length; j++)
			{
				if (HN[index][j] == -1)
				{
					for (int k = j + 1; k < HN[index].length; k++)
						sb.append(HN[index][k]);
					break;
				}
			}
		}
		return sb.toString();
	}
}
