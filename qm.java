import java.lang.Math;
import java.util.*; 

class global
{
public static int noOfVariables=2,maxBit=0,noOfMinTerms=0;
public static int gone=0,gzero=0,gtwo=0,gthree=0,gfour=0; 	
public static  int[] minTermsDec=new int[16];
public static  int[] noOfOnes=new int[16];
public static  int[][] minTermsBin=new int[16][5];
public static  int[][] g0=new int[16][5];
public static  int[][] g1=new int[16][5];
public static  int[][] g2=new int[16][5];
public static  int[][] g3=new int[16][5];
public static  int[][] g4=new int[16][5];

}


class functions
{	
	Scanner sc = new Scanner(System.in);
	
	int i,mb;	
	void totalSizeCalc()
	{ 
	    for (i = 0; i < global.noOfVariables; i++)
	    	{
	        mb =mb + (int)Math.pow(2, i);
	    	}
	    global.maxBit=mb+1;
	}

	public int calcNoOfOnes(int num[])
		{
		    int flag=0;

		    
		    
		    for(i=0;i<global.noOfVariables;i++)
		    {
		    System.out.println(num[i]);
			if(num[i]==1)
				flag++;
		    }

		    return flag;
		}

		void inputMinTerms()
			{
			
			int inp=0;
			int i,j;    
			for(i=0;i<global.maxBit;i++)
			{	

				if(inp>=(global.maxBit))
				{
					
					return;
				}
				if(inp == (-1))
				{
					global.noOfMinTerms--;
					return;
				}

				else
				{	System.out.println("enter the minterm "+i);
					inp=sc.nextInt();
					global.minTermsDec[i] = inp;
					global.noOfMinTerms++;	
				}
				System.out.println(" ");
			
			}
}


		void minTermsDectoBin()
		{	 
		int temp,i,j,l;
		    for(i=0;i<=global.noOfMinTerms;i++)
		    {
		    	
					for(j=0;j<global.noOfMinTerms;j++)
					{
		        		temp=global.minTermsDec[j];
						for(l=4-1;l>=0;l--)
						{
						global.minTermsBin[j][l]=temp%2;
						temp=temp/2;
						}
					global.noOfOnes[j]=calcNoOfOnes(global.minTermsBin[j]);
		  			
					}
					
				
				
		    }
		}

		void displayArray(int a[][],int n)
			{	int i,j;
				for(i=0;i<n;i++)
				{
					for(j=0;j<4;j++)
					{
					System.out.print(a[i][j]);
					}
					System.out.println(" ");
				}

			}



			void firstStage()
			{int i,j;
			for(i=0;i<global.noOfMinTerms;i++)
			{	
				if(global.noOfOnes[i]==0)
				{	

					for(j=0;j<4;j++)
					{
					global.g0[global.gzero][j]=global.minTermsBin[i][j];
					}
					global.gzero++;
				}

				if(global.noOfOnes[i]==1)
				{	

					for(j=0;j<4;j++)
					{
					global.g1[global.gone][j]=global.minTermsBin[i][j];
					}
					global.gone++;
				}
				if(global.noOfOnes[i]==2)
				{	

					for(j=0;j<4;j++)
					{
					global.g2[global.gtwo][j]=global.minTermsBin[i][j];
					}
					global.gtwo++;
				}
				if(global.noOfOnes[i]==3)
				{	

					for(j=0;j<4;j++)
					{
					global.g3[global.gthree][j]=global.minTermsBin[i][j];
					}
					global.gthree++;
				}

				if(global.noOfOnes[i]==4)
				{	

					for(j=0;j<4;j++)
					{
					global.g4[global.gfour][j]=global.minTermsBin[i][j];
					}
					global.gfour++;
				}


			}
	}




}

class qm
{
	public static void main(String[] args) {
		functions c1= new functions();
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NO OF VARIABLES");
		global.noOfVariables=sc.nextInt();
		c1.totalSizeCalc();
		c1.inputMinTerms();
		c1.minTermsDectoBin();
		
		c1.firstStage();
		System.out.println(" ");
		System.out.println("group of 0s");
		c1.displayArray(global.g0,global.gzero);
		System.out.println(" ");
		System.out.println("group of 1s");
		c1.displayArray(global.g1,global.gone);
		System.out.println(" ");
		System.out.println("group of 2s");
		c1.displayArray(global.g2,global.gtwo);
		System.out.println(" ");
		System.out.println("group of 3s");
		c1.displayArray(global.g3,global.gthree);
		System.out.println(" ");
		System.out.println("group of 4s");
		c1.displayArray(global.g4,global.gfour);

	}

}