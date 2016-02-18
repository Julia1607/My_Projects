import java.util.Iterator;

public class LList2 <T extends Comparable<T>> implements EList <T>
{
	class Node
	{
		T val;
		Node prev = null;
		Node next = null;
		
		public Node (T val)
		{
			this.val=val;
		}
		public Node(T val, Node prev, Node next) 
		{
			this.val = val;
			this.prev=prev;
			this.next=next;
		}
	}

	Node start = null;
	Node end = null;

	@Override
	public int Size()
	{
		int ret = 0;
		Node p = start;
		while (p != null)
		{
			ret++;
			p = p.next;
		}
		return ret;
	}

	@Override
	public void Clear() 
	{
		start = null;
		end = null;
	}

	@Override
	public void Init(T[] ini) 
	{
		if (ini == null)
		{
			ini = (T[]) new Comparable[0];
		}
		for (int i = ini.length-1; i >= 0; i--)
		{
			AddStart(ini[i]);
		}
		end=start;
	    if (Size()>=2) 
		{
			Node p=start;
			while (p.next!=null)
			{
				p=p.next;
			}
			end=p;
	    }
	}

	@Override
	public T[] toArray() 
	{
		T[] ret = (T[]) new Comparable[Size()];
		int i = 0;
		Node p = start;
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
		Node n = new Node(val, null, start);
		if (Size()>0)
		{	
			start.prev=n;
		}
		start=n;
		 if (Size()>=3) 
			{
				Node p=start;
				while (p.next!=null)
				{
					p=p.next;
				}
				start.prev=p;
			}
	}

	@Override
	public void AddEnd(T val)
	{
		if (start==null) 
		{
			Node n=new Node(val);
			start=n;
			end=n;
		}
		else
		{	Node n=new Node(val, end, null);
			end.next=n;
			end=n;
		}
		if (Size()>=3)
		{
			start.prev=end;
		}
	}

	@Override
	public void AddPos(int pos, T val)
	{
		if (pos>=Size() || pos<0) throw new IllegalArgumentException();
		if (pos==0)
		{	
			AddStart(val);
		}
		else
		{	
			int count = 0;
			Node p = start;
			while (count<pos)
			{
				++count;
				p = p.next;
			}
			Node n=new Node(p.val, p, p.next);
			p.val=val;
			p.next=n;
			if (Size()>=3) 
			{
				start.prev=end;
			}
		}
	}

	@Override
	public T DelStart() 
	{
		if (Size()==0) throw new IllegalArgumentException(); 
		T ret=start.val;
		if (Size()>1)
			start=start.next;
		else 
		{
			start=null;
			end=null;
			return ret;
		}
		if (Size()<=2)
		{
			start.prev=null;
		}
		else 
		{	
			start.prev=end;
		}	
		return ret;
	}

	@Override
	public T DelEnd()
	{
		if (Size()==0)	throw new IllegalArgumentException(); 
		T ret;
		if (Size()==1) 
		{
			ret=DelStart();
		}
		else
		{	
			ret=end.val;
			end=end.prev;
			end.next=null;
			if (Size()==2)
			{	
				start.prev=null;
			}
			else
			{	
				start.prev=end;
			}
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
		else if (pos==Size()-1) 
		{
			ret=DelEnd();
		}
		else		
		{
			int count = 1;
			Node p = start;
			while (count<pos)
			{
				++count;
				p = p.next;
			}	
			ret=p.next.val;
			if (p.next.next==null)
			{
				p.next=null;
			}
			else
			{
				p.next=p.next.next;
				p.next.prev=p;
			}
			if (Size()==2)
			{
				start.prev=null;
			}
		}
		return ret;
	}

	@Override
	public void Set(int pos, T val)
	{
		if (pos<0 || pos>=Size()) throw new IllegalArgumentException();
		int count = 0;
		Node p = start;
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
		Node p = start;
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
		T min=start.val;
		Node p=start.next;
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
		T max=start.val;
		Node p=start.next;
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
		T min=start.val;
		Node p=start.next;
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
		T max=start.val;
		Node p=start.next;
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
		Node p=start;

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
		Node p=start, n=start;
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
		Node p=start, n=start;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator<T> iterator() {
		
		return new MyIter();
	}
	
	@SuppressWarnings("hiding")
	public class MyIter<T> implements Iterator<T> {
		
		Node p=start;
		@Override
		public boolean hasNext() {
			
			return p!=null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			T ret=(T) p.val;
			p=p.next;
			return ret;
		}

	} 
	
}
