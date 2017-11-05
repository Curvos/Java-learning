package ver2;

public class BiTree
{

	private BiTreeNode root;
	public StringBuffer str = new StringBuffer("");

	public BiTree()
	{
		this.root = null;
	}

	public BiTree(BiTreeNode root)
	{
		this.root = root;
	}

	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count)
	{
		if (count > 0)
		{
			char r = preOrder.charAt(preIndex);
			int i = 0;
			for (; i < count; i++)

				if (r == inOrder.charAt(i + inIndex))
					break;

			root = new BiTreeNode(r);
			root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;
			root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root;
		}
	}

	private static int index = 0;

	public BiTree(String preStr)
	{
		char c = preStr.charAt(index++);
		if (c != '#')
		{
			root = new BiTreeNode(c);
			root.lchild = new BiTree(preStr).root;
			root.rchild = new BiTree(preStr).root;
		} else
			root = null;
	}

	public String preRootTraverse(BiTreeNode T)
	{
		
		if (T != null)
		{			
			str.append(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);			
		}
		StringBuffer temp = str;		
		return temp.toString();
	}

	public String preRootTraverse()
	{
		BiTreeNode T = root;
		if (T != null)
		{
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty())
			{
				T = (BiTreeNode) S.pop();
				str.append(T.data);
				while (T != null)
				{
					if (T.lchild != null)
						str.append(T.data);

					if (T.rchild != null)
						S.push(T.rchild);

					T = T.lchild;
				}
			}
		}
		return str.toString();
	}

	public String inRootTraverse(BiTreeNode T)
	{
		if (T != null)
		{
			inRootTraverse(T.lchild);
			str.append(T.data);
			inRootTraverse(T.rchild);
		}
		return str.toString();
	}

	public String inRootTraverse()
	{
		BiTreeNode T = root;
		if (T != null)
		{
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty())
			{
				while (S.peek() != null)

					S.push(((BiTreeNode) S.peek()).lchild);
				S.pop();
				if (!S.isEmpty())
				{
					T = (BiTreeNode) S.pop();
					str.append(T.data);
					S.push(T.rchild);
				}
			}
		}
		return str.toString();
	}

	public String postRootTraverse(BiTreeNode T)
	{
		if (T != null)
		{
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			str.append(T.data);
		}
		return str.toString();
	}

	public String postRootTraverse()
	{
		BiTreeNode T = root;
		if (T != null)
		{
			LinkStack S = new LinkStack();
			S.push(T);
			Boolean flag;
			BiTreeNode p = null;
			while (!S.isEmpty())
			{
				while (S.peek() != null)
					S.push(((BiTreeNode) S.peek()).lchild);
				S.pop();
				while (!S.isEmpty())
				{
					T = (BiTreeNode) S.peek();
					if (T.rchild == null || T.rchild == p)
					{
						str.append(T.data);
						S.pop();
						p = T;
						flag = true;
					} else
					{
						S.push(T.rchild);
						flag = false;
					}
					if (!flag)
						break;
				}
			}
		}
		return str.toString();
	}

	// level traverse
	public String levelTraverse()
	{
		// StringBuffer to store return value
		StringBuffer str = new StringBuffer("");
		BiTreeNode T = root;
		if (T != null)
		{
			LinkQueue L = new LinkQueue();
			L.offer(T);
			while (!L.isEmpty())
			{
				T = (BiTreeNode) L.poll();
				str.append(T.data);
				if (T.lchild != null)
					L.offer(T.lchild);
				if (T.rchild != null)
					L.offer(T.rchild);
			}
		}
		return str.toString();

	}

	public BiTreeNode getRoot()
	{
		return root;
	}

	public void setRoot(BiTreeNode root)
	{
		this.root = root;
	}

	public int countLeafNode(BiTreeNode T)
	{
		int count = 0;
		if (T != null)
		{
			if (T.lchild == null && T.rchild == null)
			{
				++count;
			} else
			{
				count += countLeafNode(T.lchild);
				count += countLeafNode(T.rchild);
			}
		}
		return count;
	}

	public int countNode(BiTreeNode T)
	{
		int count = 0;
		if (T != null)
		{
			++count;
			count += countNode(T.lchild);
			count += countNode(T.rchild);
		}
		return count;
	}

}
