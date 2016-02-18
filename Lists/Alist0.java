import java.util.Comparator;
import java.util.Iterator;

public class Alist0 <T extends Comparable<T>> implements EList <T>{
	@SuppressWarnings("unchecked")
	private T[] ar=(T[]) new Comparable[0];

	public Alist0  ()
	{

	}

	public Alist0 (T[] ini)
	{
		Init(ini);
	}

	@SuppressWarnings("unchecked")
	public void Init(T[] ini) 
	{
		if (ini == null)
		{
			ini =  (T[]) new Comparable[0];
		}

		ar =  (T[]) new Comparable[ini.length];
		for (int i = 0; i < ini.length; i++) 
		{
			ar[i] = ini[i];
		}
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() 
	{
		T[] tmp =   (T[]) new Comparable [ar.length];
		for (int i = 0; i < ar.length; i++) 
		{
			tmp[i] = (T) ar[i];
		}
		return  tmp;
	}

	public int Size()
	{

		return ar.length;
	}

	public void Clear()
	{
		ar=(T[]) new Comparable[0];
	}

	public void AddStart(T val)
	{

		T[] n=(T[]) new Comparable[ar.length+1];
		n[0]=val;
		for (int i=1;i<=ar.length;i++)
		{
			n[i]=(T) ar[i-1];
		}
		ar=n;
	}

	public void AddEnd(T val)
	{

		T[] n=(T[]) new Comparable[ar.length+1];
		n[ar.length]=val;
		for (int i=0; i<ar.length; i++)
		{
			n[i]=(T) ar[i];
		}
		ar=n;
	}

	public void AddPos(int pos, T val)
	{
		if (pos<0 || pos >= ar.length ) throw new IllegalArgumentException();

		T[] n= (T[]) new Comparable[ar.length+1];
		n[pos]=val;
		for (int i=0; i<ar.length; i++)
		{
			if (i < pos) 
			{
				n[i]=(T) ar[i];
			}
			else  
			{
				n[i+1]=(T) ar[i];
			}
		}
		ar=n;
	}

	public T DelStart()
	{ 
		if( ar.length == 0 )
			throw new IllegalArgumentException();
		T val;
		val=(T) ar[0];

		T[] n=(T[]) new Comparable[ar.length-1];

		for (int i=1; i < ar.length; i++)
		{
			n[i-1]=(T) ar[i];
		}
		ar=n;
		return val;
	}

	@SuppressWarnings("unchecked")
	public T DelEnd()
	{
		if( ar.length == 0 )
			throw new IllegalArgumentException();
		T val;
		val= ar[ar.length-1];

		T[] n=(T[]) new Comparable[ar.length-1];

		for (int i=0; i < ar.length-1; i++)
		{
			n[i]=(T) ar[i];
		}
		ar=n;
		return val;
	}

	@SuppressWarnings("unchecked")
	public T DelPos(int pos)
	{
		if( pos>=ar.length || pos<0)
			throw new IllegalArgumentException();
		T val;
		val= ar[pos];

		T[] n=(T[]) new Comparable[ar.length-1];

		for (int i=0; i < ar.length-1; i++)
		{
			n[i] = (i < pos ) ? (T) ar[i] : (T) ar[i+1];

		}
		ar=n;
		return val;
	}

	public void Set(int pos, T val)
	{
		if ( pos >= ar.length || pos<0)
			throw new IllegalArgumentException();
		ar[pos]=val;
	}

	public T Get (int pos)
	{
		if ( pos >= ar.length || pos<0 )
			throw new IllegalArgumentException();
		return (T) ar[pos];
	}

	public T Min()
	{
		if(  ar.length == 0 )
			throw new IllegalArgumentException();

		T min = (T) ar[0];
		
		for(int i=1;i<ar.length;i++)
		{
			if (min.compareTo(ar[i])==1)
			{
				min = ar[i];
			}
		}
		return min;
	}

	public T Max()
	{
		if(  ar.length == 0 )
			throw new IllegalArgumentException();

		T max=(T) ar[0];
		
		for(int i=1;i<ar.length;i++)
		{
			if (max.compareTo(ar[i])==-1)
			{
				max = ar[i];
			}
		}
		return max;
	}

	public int MinIndex()
	{
		if(  ar.length == 0 )
			throw new IllegalArgumentException();

		int ind_min=0;
		
		for(int i=1;i<ar.length;i++)
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
		if(  ar.length == 0 )
			throw new IllegalArgumentException();

		int ind_max=0;
		
		for(int i=1;i<ar.length;++i)
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
		for (int i = 0; i< ar.length/2; i++) 
		{
			T t = (T) ar[i];
			ar[i] = ar[ar.length-1-i];
			ar[ar.length-1-i] = t;
		}
	}

	public void HalfReverse()
	{
		int k= (ar.length%2 == 0)? 0 : 1;

		for (int i=0; i < ar.length/2; i++)
		{	
			T t=(T) ar[i];
			ar[i]=ar[ar.length/2+k+i];
			ar[ar.length/2+k+i]=t;
		}
	}

	public void Sort()
	{
		
		for (int i=1; i < ar.length; i++)
		{
			for (int j=ar.length-1; j>=i; j--)
			{
				if (ar[j-1].compareTo(ar[j])==1) 

				{ 	T t=(T) ar[j-1]; 
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
			
			return i < ar.length;
		}

		@Override
		public T next() {
			
			return (T) ar[i++];
		}

	} 
 }
