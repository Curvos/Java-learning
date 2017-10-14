package examples;

class Notepad<K,V>
{
	private K key;
	private V value;
	public K getKey()
	{
		return key;
	}
	public void setKey(K key)
	{
		this.key=key;
	}
	public V getValue()
	{
		return value;
	}
	public void setValue(V value)
	{
		this.value=value;
	}
}

public class Eg_10_10 {

	public static void main(String[] args) {
		Notepad<String,Integer> t=null;
		t = new Notepad<String,Integer>();
		t.setKey("Scathach");
		t.setValue(100);
		System.out.println(t.getKey());
		System.out.println(t.getValue());

	}

}
