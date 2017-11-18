package zhy.indi;

public class HuffmanDecoder
{

	public String decode(String text)
	{
		String str = text;
		HuffmanTree T = GUI.T;
		HuffmanNode nextNode = T.root;
		StringBuffer sb = new StringBuffer("");

		int p = 0;

		while (p < str.length())
		{
			while (!nextNode.isLeaf())
			{
				if (str.charAt(p) == '0')
				{
					nextNode = nextNode.lchild;
					p++;
					continue;
				}
				if (str.charAt(p) == '1')
				{
					nextNode = nextNode.rchild;
					p++;
					continue;
				}
			}

			int weight = nextNode.weight;
			int[] weights = RandomAscii.dict;
			int index = 0;
			for (int j = 0; j < weights.length; j++)
			{
				if (weight == weights[j])
				{
					index = j;
					break;
				}
			}

			int ascii = index + 32;
			sb.append((char) ascii);
			nextNode = T.root;
			continue;
		}

		return sb.toString();

	}
}
