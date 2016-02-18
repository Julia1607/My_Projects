import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EListTest
{
	EList <Integer> data = null;
	
	public EListTest(EList<Integer>  ee) 
	{
		data = ee;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() 
	{
		return Arrays.asList(new Object[][] 
				{
			{ new Alist0<Integer>() },
			{ new Alist1<Integer>() },
			{ new Alist2<Integer>() },
			{ new LList1<Integer>() },
			{ new LList2<Integer>() }
				});
	}

	@Before
	public void SetUp()
	{
		data.Clear();
	}

	//===================================
	// Init
	//===================================
	@Test
	public void testInit_null()
	{
		Integer[] ini = null;
		data.Init(ini);
		assertEquals(0, data.Size());
		Integer[] exp={};
		assertArrayEquals( exp,data.toArray());
	} 
	
	@Test
	public  void testInit_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		assertEquals(0, data.Size());
		Integer[] exp={};
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testInit_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		assertEquals(1, data.Size());
		Integer[] test={10};
		assertArrayEquals(test, data.toArray());
	} 

	@Test
	public void testInit_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		Integer[] test={10,20};
		assertArrayEquals(test, data.toArray());
	} 
	@Test
	public void testInit_many()
	{
		Integer[] ini = {10,20,24,77,11,50};
		data.Init(ini);
		Integer[] test={10,20,24,77,11,50};
		assertArrayEquals(test,data.toArray());
	} 
	
	//===================================
	// Size
	//===================================
	@Test
	public void testSize_null()
	{
		Integer[] ini = null;
		data.Init(ini);
		assertEquals(0, data.Size());
	} 
	@Test
	public void testSize_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		assertEquals(0, data.Size());
	} 
	@Test
	public void testSize_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		assertEquals(1, data.Size());
	} 
	@Test
	public void testSize_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		assertEquals(2, data.Size());
	} 
	@Test
	public void testSize_many()
	{
		Integer[] ini = {10,20,24,77,11,50};
		data.Init(ini);
		assertEquals(6, data.Size());
	} 

	//===================================
	// toArray
	//===================================

	@Test
	public void testtoArray_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer[] test={};
		assertEquals(0, data.Size());
		assertArrayEquals(ini, test);
	}

	@Test
	public void testtoArray_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		assertEquals(1, data.Size());
		Integer[] test={10};
		assertArrayEquals(test, ini);
	}
	
	@Test
	public void testtoArray_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		assertEquals(2, data.Size());
		Integer[] test={10,20};
		assertArrayEquals(test, ini);
	} 

	@Test
	public void testtoArray_many()
	{
		Integer[] ini = {10,20,24,77,11,50};
		data.Init(ini);
		assertEquals(6, data.Size());
		Integer[] test={10,20,24,77,11,50};
		assertArrayEquals(test, ini);
	} 
	//===================================
	// Clear
	//===================================
	@Test
	public void testClear_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.Clear();
		assertEquals(0, data.Size());
		Integer[] test={};
		assertArrayEquals(test, data.toArray());
	}

	@Test
	public void testClear_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		data.Clear();
		assertEquals(0,data.Size());
		Integer[] test={};
		assertArrayEquals(test, data.toArray());
	}
	@Test
	public void testClear_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		data.Clear();
		assertEquals(0,data.Size());
		Integer[] test={};
		assertArrayEquals(test, data.toArray());
	}
	@Test
	public void testClear_many()
	{
		Integer[] ini = {4,6,7,8,3,6,4,9};
		data.Init(ini);
		data.Clear();
		assertEquals(0,data.Size());
		Integer[] test={};
		assertArrayEquals(test, data.toArray());
		
	}

	//===================================
	// AddStart
	//===================================
	@Test
	public void testAddStart_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.AddStart(33);
		assertEquals(1, data.Size());
		assertEquals((Integer)33, data.Get(0));
		Integer[] exp = {33};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testAddStart_1()
	{
		Integer[] ini = {5};
		data.Init(ini);
		data.AddStart(33);
		assertEquals(2, data.Size());
		assertEquals((Integer)33, data.Get(0));
		Integer[] exp = {33,5};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testAddStart_2()
	{
		Integer[] ini = {5,9};
		data.Init(ini);
		data.AddStart(33);
		assertEquals(3, data.Size());
		assertEquals((Integer)33, data.Get(0));
		Integer[] exp = {33,5,9};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testAddStart_many()
	{
		Integer[] ini = {10,20,24,77,11,50};
		data.Init(ini);
		data.AddStart(33);
		assertEquals(7, data.Size());
		assertEquals((Integer)33, data.Get(0));
		Integer[] exp = {33,10,20,24,77,11,50};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	//===================================
	// AddEnd
	//===================================
	@Test
	public void testAddEnd_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.AddEnd(33);
		assertEquals(1, data.Size());
		assertEquals((Integer)33, data.Get(0));
		Integer[] exp = {33};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testAddEnd_1()
	{
		Integer[] ini = {5};
		data.Init(ini);
		data.AddEnd(33);
		assertEquals(2, data.Size());
		assertEquals((Integer)33, data.Get(1));
		Integer[] exp = {5,33};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testAddEnd_2()
	{
		Integer[] ini = {5,9};
		data.Init(ini);
		data.AddEnd(33);
		assertEquals(3, data.Size());
		assertEquals((Integer)33, data.Get(2));
		Integer[] exp = {5,9,33};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testAddEnd_many()
	{
		Integer[] ini = {10,20,24,77,11,50};
		data.Init(ini);
		data.AddEnd(33);
		assertEquals(7, data.Size());
		assertEquals((Integer)33, data.Get(6));
		Integer[] exp = {10,20,24,77,11,50,33};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	//===================================
	// AddPos
	//===================================
	@Test (expected = IllegalArgumentException.class)
	public void testAddPos_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.AddPos(0,16);
	}

	@Test (expected = IllegalArgumentException.class)
	public void AddPos_n()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.AddPos(-1,16);
	}

	@Test
	public void testAddPos_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		data.AddPos(0,33);
		assertEquals(2, data.Size());
		assertEquals((Integer)33, data.Get(0));
		Integer[] exp = {33,10};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testAddPos_2()
	{
		Integer[] ini = {10,78};
		data.Init(ini);
		data.AddPos(1,33);
		assertEquals(3, data.Size());
		assertEquals((Integer)33, data.Get(1));
		Integer[] exp = {10,33,78};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp,data.toArray());
	} 

	@Test
	public void testAddPos_many()
	{
		Integer[] ini = {10,78,4,7,2,0,67};
		data.Init(ini);
		data.AddPos(5,33);
		assertEquals(8, data.Size());
		assertEquals((Integer)33, data.Get(5));
		Integer[] exp = {10,78,4,7,2,33,0,67};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	//===================================
	// DelStart
	//===================================
	@Test (expected = IllegalArgumentException.class)
	public void DelStart_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer a=(Integer) data.DelStart();
	}

	@Test
	public void testDelStart_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		Integer a=(Integer) data.DelStart();
		assertEquals((Integer)10,a);
		assertEquals(0, data.Size());
		Integer[] exp = {};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testDelStart_2()
	{
		Integer[] ini = {10,67};
		data.Init(ini);
		Integer a=(Integer) data.DelStart();
		assertEquals((Integer)10,a);
		assertEquals(1, data.Size());
		Integer[] exp = {67};
		//Integer[] act =  data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testDelStart_many()
	{
		Integer[] ini = {10,67,4,7,2,0};
		data.Init(ini);
		Integer a=(Integer) data.DelStart();
		assertEquals((Integer)10,a);
		assertEquals(5, data.Size());
		Integer[] exp = {67,4,7,2,0};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	//===================================
	// DelEnd
	//===================================
	@Test (expected = IllegalArgumentException.class)
	public void DelEnd_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer a=(Integer) data.DelEnd();
	}

	@Test
	public void testDelEnd_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		Integer a=(Integer) data.DelEnd();
	//	assertEquals(10, a);
		assertEquals(0, data.Size());
		Integer[] exp = {};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testDelEnd_2()
	{
		Integer[] ini = {10,67};
		data.Init(ini);
		Integer a=(Integer) data.DelEnd();
	//	assertEquals(67, a);
		assertEquals(1, data.Size());
		Integer[] exp = {10};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testDelEnd_many()
	{
		Integer[] ini = {10,67,4,7,2,0};
		data.Init(ini);
		Integer a=(Integer) data.DelEnd();
	//	assertEquals(0, a);
		assertEquals(5, data.Size());
		Integer[] exp = {10,67,4,7,2};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	//===================================
	// DelPos
	//===================================
	@Test (expected = IllegalArgumentException.class)
	public void DelPos_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer t=(Integer) data.DelPos(0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void DelPos_n()
	{
		Integer[] ini = {7,9,75,4};
		data.Init(ini);
		Integer t=(Integer) data.DelPos(-1);
	}
	
	@Test
	public void testDelPos_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		Integer t=(Integer) data.DelPos(0);
		assertEquals(0, data.Size());
	//	assertEquals(10, t);
		Integer[] exp = {};
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testDelPos_2()
	{
		Integer[] ini = {10,67};
		data.Init(ini);
		Integer t=(Integer) data.DelPos(1);
		assertEquals(1, data.Size());
	//	assertEquals(67, t);
		Integer[] exp = {10};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testDelPos_many()
	{
		Integer[] ini = {10,67,4,7,2,0};
		data.Init(ini);
		Integer t=(Integer) data.DelPos(3);
	//	assertEquals(7, t);
		assertEquals(5, data.Size());
		Integer[] exp = {10,67,4,2,0};
		//Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	//===================================
	// Set
	//===================================
	@Test (expected = IllegalArgumentException.class)
	public void Set_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.Set(0,3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void Set_n()
	{
		Integer[] ini = {7,9};
		data.Init(ini);
		data.Set(8,3);
	}

	@Test
	public void testSet_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		data.Set(0,3);
		assertEquals((Integer)3,data.Get(0));
		Integer[] exp = {3};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	@Test
	public void testSet_2()
	{
		Integer[] ini = {10,78};
		data.Init(ini);
		data.Set(1,3);
		assertEquals((Integer)3,data.Get(1));
		Integer[] exp = {10,3};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 

	@Test
	public void testSet_many()
	{
		Integer[] ini = {10,78,56,5,2,0,3};
		data.Init(ini);
		data.Set(6,8);
		assertEquals((Integer)8,data.Get(6));
		Integer[] exp = {10,78,56,5,2,0,8};
	//	Integer[] act = (Integer[]) data.toArray();
		assertArrayEquals(exp, data.toArray());
	} 
	//===================================
	// Get
	//===================================
	@Test (expected = IllegalArgumentException.class)
	public void Get_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer val=(Integer) data.Get(5);

	}

	@Test (expected = IllegalArgumentException.class)
	public void Get_n()
	{
		Integer[] ini = {7,4,0};
		data.Init(ini);
		Integer val=(Integer) data.Get(-4);
	}

	@Test
	public void testGet_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		Integer val=(Integer) data.Get(0);
		assertEquals((Integer)10,val);
	} 
	@Test
	public void testGet_2()
	{
		Integer[] ini = {10,78};
		data.Init(ini);
		Integer val=(Integer) data.Get(1);
		assertEquals((Integer)78,val);
	} 

	@Test
	public void testGet_many()
	{
		Integer[] ini = {10,78,56,5,2,0,3};
		data.Init(ini);
		Integer val=(Integer) data.Get(4);
		assertEquals((Integer)2,val);
	} 

	//=================================
	// Test min array value
	//=================================	

	@Test (expected = IllegalArgumentException.class)
	public void min_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer val=(Integer) data.Min();
	}
	@Test
	public void min_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		Integer val=(Integer) data.Min();
		assertEquals((Integer)10,val);
	}
	@Test
	public void min_2()
	{
		Integer[] ini = {10,3,20};
		data.Init(ini);
		Integer val=(Integer) data.Min();
		assertEquals((Integer)3,val);
	}
	@Test
	public void min_many()
	{
		Integer[] ini = {10,20,33,78,99,11,0};
		data.Init(ini);
		Integer val=(Integer) data.Min();
		assertEquals((Integer)0,val);
	}
	//=================================
	// Test  max array value
	//=================================	

	@Test (expected = IllegalArgumentException.class)
	public void max_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer val=(Integer) data.Max();
	}

	@Test
	public void max_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		Integer val=(Integer) data.Max();
		assertEquals((Integer)10,val);
	}
	@Test
	public void max_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		Integer val=(Integer) data.Max();
		assertEquals((Integer)20,val);
	}
	@Test
	public void max_many()
	{
		Integer[] ini = {10,20,33,78,99,11};
		data.Init(ini);
		Integer val=(Integer) data.Max();
		assertEquals((Integer)99,val);
	}

	//=================================
	// Test index_min array value
	//=================================	

	@Test (expected = IllegalArgumentException.class)
	public void indexMin_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Integer val=data.MinIndex();
	}
	@Test
	public void indexMin_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		int val=data.MinIndex();
		assertEquals(0,val);
	}
	@Test
	public void indexMin_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		int val=data.MinIndex();
		assertEquals(0,val);
	}
	@Test
	public void indexMin_many()
	{
		Integer[] ini = {19,20,33,78,99,11};
		data.Init(ini);
		int val=data.MinIndex();
		assertEquals(5,val);
	}
	//=================================
	// Test index_max array value
	//=================================	
	@Test (expected = IllegalArgumentException.class)
	public void indexMax_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		int val=data.MaxIndex();
	}

	@Test
	public void indexMax_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		assertEquals(1,data.Size());
		int val=data.MaxIndex();
		assertEquals(0,val);
	}
	@Test
	public void indexMax_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		assertEquals(2,data.Size());
		int val=data.MaxIndex();
		assertEquals(1,val);
	}
	@Test
	public void indexMax_many()
	{
		Integer[] ini = {19,20,33,78,99,11};
		data.Init(ini);
		int val=data.MaxIndex();
		assertEquals(4,val);
	}
	//=================================
	// Test reverse array 
	//=================================	

	@Test
	public void reverse_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.Reverse();
		Integer[] exp = {};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void reverse_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		data.Reverse();
		Integer[] exp = {10};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void reverse_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		data.Reverse();
		Integer[] exp = {20,10};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void reverse_many_odd()
	{
		Integer[] ini = {10,20,33,7,78,99,11};
		data.Init(ini);
		data.Reverse();
		Integer[] exp = {11,99,78,7,33,20,10};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void reverse_many_even()
	{
		Integer[] ini = {10,20,33,78,99,11};
		data.Init(ini);
		data.Reverse();
		Integer[] exp = {11,99,78,33,20,10};
		assertArrayEquals(exp, data.toArray());
	}

	//=================================
	// Test HalfReverse array 
	//=================================	

	@Test
	public void HalfReverse_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.HalfReverse();
		Integer[] exp = {};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void HalfReverse_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		data.HalfReverse();
		Integer[] exp = {10};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void HalfReverse_2()
	{
		Integer[] ini = {10,20};
		data.Init(ini);
		data.HalfReverse();
		Integer[] exp = {20,10};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void HalfReverse_many_odd()
	{
		Integer[] ini = {10,20,33,7,78,99,11};
		data.Init(ini);
		data.HalfReverse();
		Integer[] exp = {78,99,11,7,10,20,33};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void HalfReverse_many_even()
	{
		Integer[] ini = {10,20,33,78,99,11};
		data.Init(ini);
		data.HalfReverse();
		Integer[] exp = {78,99,11,10,20,33};
		assertArrayEquals(exp, data.toArray());
	}
	//=================================
	// Test Sort array 
	//=================================	

	@Test
	public void Sort_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		data.Sort();
		Integer[] exp = {};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void Sort_1()
	{
		Integer[] ini = {10};
		data.Init(ini);
		data.Sort();
		Integer[] exp = {10};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void Sort_2()
	{
		Integer[] ini = {20,10};
		data.Init(ini);
		data.Sort();
		Integer[] exp = {10,20};
		assertArrayEquals(exp, data.toArray());
	}
	@Test
	public void Sort_many()
	{
		Integer[] ini = {10,20,33,7,78,99,11};
		data.Init(ini);
		data.Sort();
		Integer[] exp = {7,10,11,20,33,78,99};
		assertArrayEquals(exp, data.toArray());
	}
	//=================================
	// test Iterator
	//=================================	
	@Test
	public void Iterator_0()
	{
		Integer[] ini = {};
		data.Init(ini);
		Iterator<Integer> ii = data.iterator();
		while(ii.hasNext())
		{
			Integer i  = ii.next();
			assertEquals(null,i);
			
		}
	}
	@Test
	public void Iterator_1()
	{
		Integer[] ini = {6};
		data.Init(ini);
		Iterator<Integer> ii = data.iterator();
		int j=0;
		while(ii.hasNext())
		{
			Integer i  = ii.next();
			assertEquals(ini[j++],i);
		}
	}
	@Test
	public void Iterator_2()
	{
		Integer[] ini = {6,9};
		data.Init(ini);
		Iterator<Integer> ii = data.iterator();
		int j=0;
		while(ii.hasNext())
		{
			Integer i  = ii.next();
			assertEquals(ini[j++],i);
		}
	}
	@Test
	public void Iterator_many()
	{
		Integer[] ini = {6,8,6,4,2,7,5};
		data.Init(ini);
		Iterator<Integer> ii = data.iterator();
		int j=0;
		while(ii.hasNext())
		{
			Integer i  = ii.next();
			assertEquals(ini[j],i);
			j++;
		}
	}
	
}