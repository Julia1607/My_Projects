import javax.swing.JOptionPane;

public class XandO 
{
	private int[][] arr={{4,4,4},
						 {4,4,4},
						 {4,4,4}};
	private boolean flag=false;
	
	boolean winnerExist()
	{
		return flag;
	}

	void checkOfWinner()
	{
		int sum3=arr[0][0]+arr[1][1]+arr[2][2];
		int sum4=arr[2][0]+arr[1][1]+arr[0][2];
		for(int i=0;i<=2;i++)
		{	
			int sum1=0;
			int sum2=0;

			for (int j=0;j<=2;j++)
			{
				sum1+=arr[i][j];
				sum2+=arr[j][i];

			}
			if (sum3==0 || sum4==0 || sum1==0 || sum2==0) 
			{
				JOptionPane.showMessageDialog(null, "Winner is 0");
				System.exit(0);
				flag=true;
				break;
			}
			else if (sum1==3 || sum2==3 || sum3==3 || sum4==3) 
			{	JOptionPane.showMessageDialog(null, "Winner is X");
				System.exit(0);
				flag= true;
				break;
			}
		}
	}

	void set(int quater, int val)
	{
		switch (quater)
		{
		case 0: {arr[0][0]=val;break;} 
		case 1: {arr[0][1]=val;break;}
		case 2: {arr[0][2]=val;break;}
		case 3: {arr[1][0]=val;break;}
		case 4: {arr[1][1]=val;break;}
		case 5: {arr[1][2]=val;break;}
		case 6: {arr[2][0]=val;break;}
		case 7: {arr[2][1]=val;break;}
		case 8: {arr[2][2]=val;break;}
		}
	}

	int get(int quater)
	{
		int ret=4;
		switch (quater)
		{
		case 0: {ret=arr[0][0];break;} 
		case 1: {ret=arr[0][1];break;}
		case 2: {ret=arr[0][2];break;}
		case 3: {ret=arr[1][0];break;}
		case 4: {ret=arr[1][1];break;}
		case 5: {ret=arr[1][2];break;}
		case 6: {ret=arr[2][0];break;}
		case 7: {ret=arr[2][1];break;}
		case 8: {ret=arr[2][2];break;}
		}
		return ret;
	}

}


