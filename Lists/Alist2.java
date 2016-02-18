import java.util.Comparator;
import java.util.Iterator;


class Alist2 <T extends Comparable<T>> implements EList <T> {

	private T[] ar=(T[]) new Comparable[30];

	private int start, end;


	public Alist2()
	{

	}

	public Alist2(T[] ini)
	{
		Init(ini);
	}

	public void Init(T[] ini) 
	{
		if (ini == null)
		{
			ini = (T[]) new Comparable[0];
		}
		int s=ini.length;
		while (s > ar.length)
		{
			ReSize();
		}

		int k=(ini.length%2==0) ? 0 : 1;
		start=ar.length/2-ini.length/2;
		end=ar.length/2+ini.length/2+k;
		for (int i = start, j=0; i < end && j<ini.length; i++, j++) 
		{
			ar[i] = ini[j];
		}
	}

	void ReSize()
	{
		T[] tmp=(T[]) new Comparable[ar.length+ar.length*3/10];
		ar=tmp;
		return;
	}

	public T[] toArray() 
	{
		T[] tmp = (T[]) new Comparable[end-start];
		for (int i = 0; i < end-start; i++) 
		{
			tmp[i] = ar[start+i];
		}
		return tmp;
	}


	public int Size()
	{
		return end-start;
	}

	public void Clear()
	{
		start=end=ar.length/2;
	}

	public void AddStart(T val)
	{
		if ( start == 0 && end==ar.length) 
		{
			ReSize();
		}
		if (start==0) 
		{
			for (int i=end-1; i>=0; i--)
			{
				ar[i+1]=ar[i];
			}
			++end;
		}
		else
		{
			--start;
		}
		ar[start]=val;
	}

	public void AddEnd(T val)
	{
		if ( start == 0 && end==ar.length) 
		{
			ReSize();
		}

		if ( end == ar.length && start != 0) 
		{
			for (int i=start; i<end; i++)
			{
				ar[i-1]=ar[i];
			}
			--start;
		}
		ar[end]=val;
		++end;
	}

	public void AddPos(int pos, T val)
	{
		if (pos < 0 || pos>=(end-start) ) throw new IllegalArgumentException();

		if (end-start == ar.length)
		{
			ReSize();
		}

		if	(end==ar.length) 

		{
			for (int i=start; i < start+pos; i++)
			{
				ar[i-1]=ar[i];
			}
			--start;
		}
		else 
		{

			for (int i=end; i >= start+pos; i--)
			{
				ar[i]=ar[i-1];
			}
			++end;	
		}

		ar[start+pos]=val;
	}

	public T DelStart()
	{ 
		if( end-start == 0 )
			throw new IllegalArgumentException();
		T val=ar[start];
		++start;
		return val;
	}

	public T DelEnd()
	{
		if( end-start == 0 )
			throw new IllegalArgumentException();
		T val=ar[end-1];
		--end;				
		return val;
	}

	public T DelPos(int pos)
	{
		if(  pos>=end-start || pos<0)
			throw new IllegalArgumentException();
		T val=ar[start+pos];
		for (int i=start+pos; i<end-1; i++)
		{
			ar[i]=ar[i+1];
		}
		--end;
		return val;
	}

	public void Set(int pos, T val)
	{
		if ( pos >= end-start || pos<0)
							throw new IllegalArgumentException();
		ar[start+pos]=val;
	}

	public T Get (int pos)
	{
		if (pos >= end-start || pos<0 )
			throw new IllegalArgumentException();

		return ar[start+pos];
	}

	public T Min()
	{
		if( end-start == 0 )
			throw new IllegalArgumentException();

		
		T min = ar[start];
		for(int i=start+1; i<end; i++)
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
		if( end-start == 0 )
			throw new IllegalArgumentException();

		
		T max=ar[start];
		for(int i=start+1;i<end;i++)
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
		if( end-start == 0 )
			throw new IllegalArgumentException();
		
		int ind_min=start;
		for(int i=start+1;i<end;i++)
		{
			if (ar[ind_min].compareTo(ar[i])==1)
			{
				ind_min=i;
			}
		}
		;
		return ind_min-start;
	}

	public int MaxIndex()
	{
		if( end-start == 0 )
			throw new IllegalArgumentException();

		
		int ind_max=start;
		for(int i=start+1;i<end;++i)
		{
			if (ar[ind_max].compareTo(ar[i])==-1) 
			{
				ind_max=i;
			}
		}
		return ind_max-start;
	}

	public void Reverse()
	{
		for (int i = start; i< start+Size()/2; i++) 
		{
			T t = ar[i];
			ar[i] = ar[end-1-i+start];
			ar[end-1-i+start] = t;
		}
	}

	public void HalfReverse()
	{
		int k= ((end-start)%2 == 0)? 0 : 1;

		for (int i=start; i <start+Size()/2; i++)
		{	
			T t=ar[i];
			ar[i]=ar[(end-start)/2+k+i];
			ar[(end-start)/2+k+i]=t;
		}
	}

	public void Sort()
	{
		
		for (int i=start+1; i < end; i++)
		{
			for (int j=end-1; j>=i; j--)
			{
				if (ar[j-1].compareTo(ar[j])==1) 
				{ 	
					T t=ar[j-1]; 
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
		int i=start;
		@Override
		public boolean hasNext() {
			
			return i < end;
		}

		@Override
		public T next() {
			
			return (T) ar[i++];
		}

	} 
}
