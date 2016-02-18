import java.util.Comparator;
import java.util.Iterator;

class Alist1 <T extends Comparable<T>> implements EList <T> {

	private T[] ar=(T[]) new Comparable[10];

	private int top;

	public Alist1()
	{

	}

	public Alist1(T[] ini)
	{
		Init(ini);
	}

	public void Init(T[] ini) 
	{
		if(ini == null)
		{
			ini = (T[]) new Comparable[0];
		}
		top=ini.length;
		while (top >= ar.length)
		{
			ReSize();
		}
		for (int i = 0; i < top; i++) 
		{
			ar[i] = (T) ini[i];
		}
	}

	public T[] toArray() 
	{
		T[] tmp = (T[]) new Comparable[top];
		for (int i = 0; i < top; i++) 
		{
			tmp[i] = (T) ar[i];
		}
		return tmp;
	}


	public int Size()
	{
		return top;
	}

	public void Clear()
	{
		top=0;
	}

	void ReSize()
	{
		T[] tmp=(T[]) new Comparable[ar.length+ar.length*3/10];
		ar=tmp;
	}

	public void AddStart(T val)
	{
		if ( top == ar.length)
		{
			ReSize();
		}
		++top;
		for (int i=top-1;i>0;i--)
		{
			ar[i]=ar[i-1];
		}
		ar[0]=val;

	}

	public void AddEnd(T val)
	{

		if ( top == ar.length)
		{
			ReSize();
		}
		++top;
		ar[top-1]=val;
	}

	public void AddPos(int pos, T val)
	{
		if (pos < 0 || pos >= top) throw new IllegalArgumentException();
		if (top == ar.length) 
		{
			ReSize();
		} 
		++top;
		for (int i=top; i>pos; i--)
		{
			ar[i]=ar[i-1];
		}
		ar[pos]=val;
	}

	public T DelStart()
	{ 
		if( top == 0 )
			throw new IllegalArgumentException();
		T val=ar[0];

		for (int i=1; i < top; i++)
		{
			ar[i-1]=ar[i];
		}
		--top;
		return val;
	}

	public T DelEnd()
	{
		if( top == 0 )
			throw new IllegalArgumentException();
		T val=ar[top-1];
		--top;				
		return val;
	}

	public T DelPos(int pos)
	{
		if ( pos >= top || pos < 0)
			throw new IllegalArgumentException();
		T val=ar[pos];

		for (int i=pos; i<top-1; i++)
		{
			ar[i]=ar[i+1];
		}
		--top;
		return val;
	} 

	public void Set(int pos, T val)
	{
		if ( pos >= top || pos<0)
			throw new IllegalArgumentException();
		ar[pos]=val;
	}

	public T Get (int pos)
	{
		if (pos >= top || pos<0 )
			throw new IllegalArgumentException();

		return ar[pos];
	}

	public T Min()
	{
		if( top == 0 ) throw new IllegalArgumentException();

		T min = ar[0];
		

		for(int i=1; i<top; i++)
		{
			if (min.compareTo(ar[i])==1)
			{
				min=ar[i];
			}
		}
		return min;
	}

	public T Max()
	{
		if( top == 0 ) 	throw new IllegalArgumentException();

		T max=ar[0];
		

		for(int i=1;i<top;i++)
		{
			if (max.compareTo(ar[i])==-1)
			{
				max=ar[i];
			}
		}
		return max;
	}

	public int MinIndex()
	{
		if( top == 0 ) 	throw new IllegalArgumentException();

		int ind_min=0;
		
		for(int i=1;i<top;i++)
		{
			if (ar[ind_min].compareTo(ar[i])==1)
			{
				ind_min=i;
			}
		}
		return ind_min;
	}

	public int MaxIndex()
	{
		if( top == 0 )
			throw new IllegalArgumentException();

		int ind_max=0;
		
		for(int i=1;i<top;++i)
		{
			if (ar[ind_max].compareTo(ar[i])==-1) 
			{
				ind_max=i;
			}
		}
		return ind_max;
	}

	public void Reverse()
	{
		for (int i = 0; i< top/2; i++) 
		{
			T t = ar[i];
			ar[i] = ar[top-1-i];
			ar[top-1-i] = t;
		}
	}

	public void HalfReverse()
	{
		int k= (top%2 == 0)? 0 : 1;

		for (int i=0; i < top/2; i++)
		{	
			T t=ar[i];
			ar[i]=ar[top/2+k+i];
			ar[top/2+k+i]=t;
		}
	}

	public void Sort()
	{
			
		for (int i=1; i < top; i++)
		{
			for (int j=top-1; j>=i; j--)
			{
				if (ar[j-1].compareTo(ar[j])==1) 

				{ 	T t=ar[j-1]; 
				ar[j-1]=ar[j];
				ar[j]=t;
				}

			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		
		return new MyIter();
	}
	
	public class MyIter<T> implements Iterator<T> {
		int i=0;
		@Override
		public boolean hasNext() {
			
			return i < top;
		}

		@Override
		public T next() {
			
			return (T) ar[i++];
		}

	} 
	
	
}
