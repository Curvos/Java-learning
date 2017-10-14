package examples;

class Info3<K>
{
	private K key=null;
	public K getKey()
	{
		return key;
	}
	public void setKey(K key)
	{
		this.key=key;
	}
	public String toString()
	{
		return this.key.toString();
	}
	
}

public class Eg_10_15 {

	public static void main(String[] args) {
		Info3<String> info=new Info3<String>();
		info.setKey("Scathach");
		fun(info);

	}
	public static void fun(Info3<?> temp)
	{
		System.out.println("Content:"+temp);
	}

}
