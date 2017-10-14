import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Genes
{
	private int cont;

	public int getCont()
	{// 返回计数
		return cont;
	}

	public List<String> Search(List<String> Set1, List<String> Set2)
	{
		// 创建计数变量

		List<String> List = new ArrayList<String>();

		// Iterator<String> iter3 = List.iterator();
		for (int i = 0; i < Set1.size(); i++)
			for (int j = 0; j < Set2.size(); j++)
				if (Set1.get(i).equals(Set2.get(j)))
					List.add(Set1.get(i));

		Iterator<String> iter1 = List.iterator();
		Set<String> temp_set = new TreeSet<String>();
		while (iter1.hasNext())
			temp_set.add(iter1.next());

		List<String> return_list = new ArrayList<String>();
		Iterator<String> iter2 = temp_set.iterator();
		while (iter2.hasNext())
			return_list.add(iter2.next());

		this.cont = return_list.size();
		return return_list;
	}
}
