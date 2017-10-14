import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//��ں���
public class Delegate
{

	public static void main(String[] args) throws Exception
	{
		// ͨ�����Eclipse�������·����ȡ�ļ��������������ж�����������
		File f1 = new File("res\\no1genes.txt");
		File f2 = new File("res\\no2genes.txt");
		File f3 = new File("res\\no3genes.txt");
		Scanner scanner1 = new Scanner(f1);
		Scanner scanner2 = new Scanner(f2);
		Scanner scanner3 = new Scanner(f3);
		List<String> Set1 = new ArrayList<String>();
		List<String> Set2 = new ArrayList<String>();
		List<String> Set3 = new ArrayList<String>();

		while (scanner1.hasNext())
		{
			Set1.add(scanner1.next());
		}
		scanner1.close();
		while (scanner2.hasNext())
		{
			Set2.add(scanner2.next());
		}
		scanner2.close();
		while (scanner3.hasNext())
		{
			Set3.add(scanner3.next());
		}
		scanner3.close();

		Genes g = new Genes();

		List<String> List = g.Search(Set1, Set2);

		System.out.println(List);
		System.out.println("��" + g.getCont() + "����ͬ����");
		// ��res�ļ����´�����ΪResult��txt�ļ�
		File f = new File("res\\Result.txt");

		// ʹ���ַ����������
		Writer o = null;
		o = new FileWriter(f);
		for (int i = 0; i < List.size(); i++)
		{
			String str = List.get(i) + "\r\n";
			o.write(str);
		}
		o.close();
	}
}
