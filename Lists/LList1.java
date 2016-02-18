import java.util.Iterator;

public class LList1 <T extends Comparable<T>> implements EList <T>
{
	class Node
	{
		T val;
		Node next = null;

		public Node(T val) 
		{
			this.val = val;
		}
		public Node(T val, Node next) 
		{
			this.val = val;
			this.next=next;
		}
	}

	Node root = null;

	@Override
	public int Size()
	{
		int ret = 0;
		Node p = root;
		while(p != null)
		{
			ret++;
			p = p.next;
		}
		return ret;
	}

	@Override
	public void Clear() 
	{
		root = null;	
	}

	@Override
	public void Init(T[] ini) 
	{
		if(ini == null)
		{
			ini = (T[]) new Comparable[0];
		}

		for (int i = ini.length-1; i >= 0; i--)
		{
			AddStart(ini[i]);
		}
	}

	@Override
	public T[] toArray() 
	{
		T[] ret = (T[]) new Comparable[Size()];
		int i = 0;
		Node p = root;
		while(p != null)
		{
			ret[i++] = p.val;
			p = p.next;
		}

		return ret;
	}

	@Override
	public void AddStart(T val) 
	{
		Node tmp = new Node(val);
		tmp.next = root;
		root = tmp;
	}

	@Override
	public void AddEnd(T val)
	{
		Node p = root;
		Node n=new Node(val);
		if (Size()==0) 
		{	
			root=n;
		}
		else 
		{	while (p.next != null)
			{	
				p = p.next;
			}
			p.next=n;
		}
	}

	@Override
	public void AddPos(int pos, T val)
	{
		if (pos>=Size() || pos<0) throw new IllegalArgumentException(); 
		int count = 0;
		Node p = root;
		
		while (count<pos)
		{
			++count;
			p = p.next;
		}
		Node n=new Node(p.val, p.next);
		p.val=val;
		p.next=n;
	}

	@Override
	public T DelStart() 
	{
		if (Size()==0) throw new IllegalArgumentException(); 
		T ret=root.val;
		root=root.next;
		return ret;
	}

	@Override
	public T DelEnd()
	{
		if (Size()==0)	throw new IllegalArgumentException(); 
		Node p =root;
		T ret=null;
		if (p.next==null) 
		{
			ret=DelStart(); 
		}
		else 
		{	while (p.next.next != null)
			{	
				p=p.next;
			}
		 	ret=p.next.val;
		 	p.next=null;
		}
		return ret;
	}

	@Override
	public T DelPos(int pos) 
	{
		if (pos>=Size() || pos<0) throw new IllegalArgumentException();
		T ret=null;
		if (pos==0)
		{
			ret=DelStart();
		}
		else
		{
			int count = 1;
			Node p = root;
			while (count<pos)
			{
				++count;
				p = p.next;
			}	
			ret=p.next.val;
			p.next=p.next.next;
		}
		return ret;
	}

	@Override
	public void Set(int pos, T val)
	{
		if (pos<0 || pos>=Size()) throw new IllegalArgumentException();
		int count = 0;
		Node p = root;
		while (count<pos)
		{
			++count;
			p = p.next;
		}	
		p.val=val;
	}

	@Override
	public T Get(int pos)
	{
		if (pos<0 || pos>=Size()) throw new IllegalArgumentException();
		int count = 0;
		Node p = root;
		while (count<pos)
		{
			++count;
			p = p.next;
		}	
		T ret=p.val;
		return ret;
	}

	@Override
	public T Min()
	{
		if (Size()==0) throw new IllegalArgumentException();
		T min=root.val;
		Node p=root.next;
		while (p!=null)
		{
			if (min.compareTo(p.val)==1) 
			{
				min=p.val;
			}
			p=p.next;
		}
		return min;
	}

	@Override
	public T Max()
	{
		if (Size()==0) throw new IllegalArgumentException();
		T max=root.val;
		Node p=root.next;
		while (p!=null)
		{
			if (max.compareTo(p.val)==-1) 
			{
				max=p.val;
			}
			p=p.next;
		}
		return max;
	}

	@Override
	public int MinIndex() 
	{
		if (Size()==0) throw new IllegalArgumentException();
		int ind=0, count=0;
		T min=root.val;
		Node p=root.next;
		while (p!=null)
		{	
			++count;
			if (min.compareTo(p.val)==1) 
			{
				ind=count;
				min=p.val;
			}
			p=p.next;
		}
		return ind;
	}

	@Override
	public int MaxIndex()
	{
		if (Size()==0) throw new IllegalArgumentException();
		int ind=0, count=0;
		T max=root.val;
		Node p=root.next;
		while (p!=null)
		{	
			++count;
			if (max.compareTo(p.val)==-1) 
			{
				ind=count;
				max=p.val;
			}
			p=p.next;
		}
		return ind;
	}

	@Override
	public void Sort()
	{
		Node p=root;

		for (int i=1; i < Size(); i++)
		{					
			for (int j=Size()-1; j>=i; j--)
			{	
				Node n=p;
				int k=i;
				while (k<j)
				{
					++k;
					n=n.next;
				}
				if (n.val.compareTo(n.next.val)==1) 
				{ 	T tmp=n.val; 
				n.val=n.next.val;
				n.next.val=tmp;
				}
			}
			p=p.next;
		}
	}

	@Override
	public void Reverse()
	{
		Node p=root, n=root;
		for (int i = 0; i<Size()/2; i++) 
		{	
			T tmp = p.val;
			int j=i;
			while (j<Size()-1-i)
			{
				++j;
				n=n.next;
			}
			p.val=n.val;
			n.val=tmp;
			p=p.next;
			n=p;
		}
	}

	@Override
	public void HalfReverse()
	{
		Node p=root, n=root;
		int k= (Size()%2 == 0)? 0 : 1;
		for (int i = 0; i<Size()/2; i++) 
		{	
			T tmp = p.val;
			int j=i;
			while (j<Size()/2+k+i)
			{
				++j;
				n=n.next;
			}
			p.val=n.val;
			n.val=tmp;
			p=p.next;
			n=p;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		
		return new MyIter();
	}
	
	public class MyIter<T> implements Iterator<T> {
		
		Node p=root;
		@Override
		public boolean hasNext() {
			
			return (p!=null);
		}

		@Override
		public T next() {
			T ret=(T) p.val;
			p=p.next;
			return ret;
		}

	} 
}
