package zhy.indi;

public class BiTree
{

	private BiTreeNode root;

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

	public void preRootTraverse(BiTreeNode T)
	{
		if (T != null)
		{
			System.out.print(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);
		}
	}

	public void preRootTraverse()
	{
		BiTreeNode T = root;
		if (T != null)
		{
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty())
			{
				T = (BiTreeNode) S.pop();
				System.out.print(T.data);
				while (T != null)
				{
					if (T.lchild != null)
						System.out.print(T.lchild.data);

					if (T.rchild != null)
						S.push(T.rchild);

					T = T.lchild;
				}
			}
		}
	}

	public void inRootTraverse(BiTreeNode T)
	{
		if (T != null)
		{
			inRootTraverse(T.lchild);
			System.out.print(T.data);
			inRootTraverse(T.rchild);
		}
	}

	public void inRootTraverse()
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
					System.out.print(T.data);
					S.push(T.rchild);
				}
			}
		}
	}

	public void postRootTraverse(BiTreeNode T)
	{
		if (T != null)
		{
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.print(T.data);
		}
	}

	public void postRootTraverse()
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
						System.out.print(T.data);
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
	}

	// level traverse
	public String levelTraverse()
	{
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
