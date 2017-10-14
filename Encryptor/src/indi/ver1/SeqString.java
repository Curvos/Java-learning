package indi.ver1;

public class SeqString implements IString {

	private char[] strvalue;
	private int curlen;


    public SeqString() {
        strvalue = new char[0];
        curlen = 0;
    }


    public SeqString(String str) {
        if (str != null) {
            char[] tempchararray = str.toCharArray();
            strvalue = tempchararray;
            curlen = tempchararray.length;
        }
    }


    public SeqString(char[] value) {
        this.strvalue = new char[value.length];
        for (int i = 0; i < value.length; i++) { //复制数组
            this.strvalue[i] = value[i];
        }
        curlen = value.length;
    }


    public void clear() {
        this.curlen = 0;
    }


    public boolean isEmpty() {
        return curlen == 0;
    }


    public int length() {
		return curlen;
    }


    public char charAt(int index) {
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue[index];
    }


    public void setCharAt(int index, char ch) {
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        strvalue[index] = ch;
    }

	public void allocate(int newCapacity)
    {
		char[] temp = strvalue;
        strvalue = new char[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            strvalue[i] = temp[i];
        }
    }


    public IString substring(int begin, int end) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度:" + curlen);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
        }
        if (begin == 0 && end == curlen) {
            return this;
        } else {
            char[] buffer = new char[end - begin];
			for (int i = 0; i < buffer.length; i++)
            {
                buffer[i] = this.strvalue[i + begin];
            }
            return new SeqString(buffer);
        }
    }


    public IString substring(int begin) {
        return substring(begin, strvalue.length);
    }


    public IString insert(int offset, IString str) {
        if ((offset < 0) || (offset > this.curlen)) {
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        }
        int len = str.length();
        int newCount = this.curlen + len;
        if (newCount > strvalue.length) {
			allocate(newCount);
        }
        for (int i = this.curlen - 1; i >= offset; i--) {
			strvalue[len + i] = strvalue[i];
        }
		for (int i = 0; i < len; i++)
        {
            strvalue[offset + i] = str.charAt(i);
        }
        this.curlen = newCount;
        return this;
    }


    public IString delete(int begin, int end) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度:" + curlen);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
        }
		for (int i = 0; i < curlen - end; i++)
        {
            strvalue[begin + i] = strvalue[end + i];
        }
		curlen = curlen - (end - begin);
        return this;
    }


    public IString concat(IString str) {
        return insert(curlen, str);
    }


    public IString concat(char c) {
        int newCount = curlen + 1;
        if (newCount > strvalue.length) {
            allocate(newCount);
        }
        strvalue[curlen++] = c;
        return this;
    }


    public int compareTo(IString str) {
        return compareTo((SeqString) str);
    }

	public int compareTo(SeqString str)
	{

        int len1 = curlen;
        int len2 = str.curlen;
        int n = Math.min(len1, len2);
        for (int k = 0; k < n; k++) {
            if (strvalue[k] != str.strvalue[k]) {
                return (strvalue[k] - str.strvalue[k]);
            }
        }
		return len1 - len2;
    }

    public String toString() {
		return new String(strvalue, 0, curlen);
    }


    public int index_BF(SeqString t, int start) {
		if (this != null && t != null && t.length() > 0 && this.length() >= t.length())
		{
			int slen, tlen, i = start, j = 0;
            slen = this.length();
            tlen = t.length();
            while ((i < slen) && (j < tlen)) {
				if (this.charAt(i) == t.charAt(j))
                {
                    i++;
                    j++;
				}
                else {
					i = i - j + 1;
					j = 0;
                }
            }
			if (j >= t.length())
            {
				return i - tlen;
            } else {
                return -1;
            }
        }
		return -1;
    }


    public int indexOf(IString t, int start) {
        return index_KMP(t, start);
    }


    public int index_KMP(IString T, int start) {

		int[] next = getNext(T);
		int i = start;
		int j = 0;

        while (i < this.length() && j < T.length()) {

			if (j == -1 || this.charAt(i) == T.charAt(j))
			{
                i++;
				j++;
			} else
            {
				j = next[j];
            }
        }
        if (j < T.length()) {
			return -1;
        } else {
			return (i - T.length());
        }
    }


    protected int[] getNext(IString T) {
		int[] next = new int[T.length()];
		int j = 1;
		int k = 0;
        next[0] = -1;
        if (T.length() > 1) {
            next[1] = 0;
        }
        while (j < T.length() - 1) {
			if (T.charAt(j) == T.charAt(k))
			{
                next[j + 1] = k + 1;
                j++;
                k++;
			} else if (k == 0)
			{
                next[j + 1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return (next);
    }


    protected int[] getNextVal(IString T) {
		int[] nextval = new int[T.length()];
        int j = 0;
        int k = -1;
        nextval[0] = -1;
        while (j < T.length() - 1) {
            if (k == -1 || T.charAt(j) == T.charAt(k)) {
                j++;
                k++;
                if (T.charAt(j) != T.charAt(k)) {
                    nextval[j] = k;
                } else {
                    nextval[j] = nextval[k];
                }
            } else {
                k = nextval[k];
            }
        }
        return (nextval);
    }
}
