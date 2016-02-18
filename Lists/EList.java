
public interface EList <T> extends Iterable<T>
{
	int   Size();
	void  Clear();
	void  Init(T[] ini);
	T[] toArray();
	void  AddStart(T val);
	void  AddEnd(T val);
	void  AddPos (int pos, T val);
	T   DelStart();
	T   DelEnd();
	T   DelPos(int pos);
	void  Set(int pos, T val);
	T   Get(int pos);
	T   Min();
	T   Max();
	int   MinIndex();
	int   MaxIndex();
	void  Sort ();
	void  Reverse();
	void  HalfReverse();
}
