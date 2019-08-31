import java.lang.Math;
import java.util.*; 

class global
{
public static int noOfVariables=2,maxBit=0,noOfMinTerms=0;
public static int gone=0,gzero=0,gtwo=0,gthree=0,gfour=0;
public static int hzero=0,hone=0,htwo=0,hthree=0; 
public static int izero=0,ione=0,itwo=0;	
public static int[] minTermsDec=new int[16];
public static int[] noOfOnes=new int[16];
public static int[][] minTermsBin=new int[16][5];
public static int[][] g0=new int[16][5];
public static int[][] g1=new int[16][5];
public static int[][] g2=new int[16][5];
public static int[][] g3=new int[16][5];
public static int[][] g4=new int[16][5];
public static int[][] h0=new int[16][5];
public static int[][] h1=new int[16][5];
public static int[][] h2=new int[16][5];
public static int[][] h3=new int[16][5];
public static int[][] i0=new int[50][5];
public static int[][] i1=new int[50][5];
public static int[][] i2=new int[50][5];
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

	/*public int calcNoOfOnes(int num[])
		{
		    int flag=0;

		    
		    
		    for(i=0;i<global.noOfVariables;i++)
		    {
		    System.out.println(num[i]);
			if(num[i]==1)
				flag++;
		    }

		    return flag;
		}*/

		void inputMinTerms()
			{
			
			int inp=0;
			int i,j;    
			for(i=0;i<global.maxBit;i++)
			{	System.out.println("enter the minterm "+(i+1));
				inp=sc.nextInt();
				if(inp>=(global.maxBit))
				{
					
					return;
				}
				if(inp == (-1))
				{
					
					return;
				}

				else
				{	
					
					global.minTermsDec[i] = inp;
					global.noOfMinTerms++;	
				}
				System.out.println(" ");
			
			}
}


		void minTermsDectoBin()
		{	 
		int temp,i,j,l,flagnew=0;
		    for(i=0;i<=global.noOfMinTerms;i++)
		    {
		    	
					for(j=0;j<global.noOfMinTerms;j++)
					{
		        		temp=global.minTermsDec[j];
						for(l=4-1;l>=0;l--)
						{
						global.minTermsBin[j][l]=temp%2;
						if(temp%2==1)
							flagnew++;
						temp=temp/2;
						}
					global.noOfOnes[j]=flagnew;
					flagnew=0;
		  			
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
					System.out.println("enter the 0 if");
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



	int compare(int a[][],int b[][],int h[][],int first,int second)
{
			int i,j,y=0,t=0;
		while(t!=first)
		{
			for(i=0;i<second;i++)
			{

				int flag=0;
				for(j=0;j<4;j++)
				{
					if(a[t][j]==b[i][j])
					{
						h[y][j]=b[i][j];
					}
					else
					{
						flag++;
						h[y][j]=9;
					}
				}
				if(flag==1)
				{
					y++;
				}

			}
			t++;
		}
			return y;
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
		c1.displayArray(global.minTermsBin,global.maxBit);
		System.out.println("STAGE 1");
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
		System.out.println(" ");
		System.out.println("STAGE 2");
		System.out.println(" ");
		System.out.println("STAGE 2.1");
		global.hzero=c1.compare(global.g0,global.g1,global.h0,global.gzero,global.gone);
		c1.displayArray(global.h0,global.hzero);
		System.out.println(" ");
		System.out.println("STAGE 2.2");
		global.hone=c1.compare(global.g1,global.g2,global.h1,global.gone,global.gtwo);
		c1.displayArray(global.h1,global.hone);
		System.out.println(" ");
		System.out.println("STAGE 2.3");
		global.htwo=c1.compare(global.g3,global.g2,global.h2,global.gthree,global.gtwo);
		c1.displayArray(global.h2,global.htwo);
		System.out.println(" ");
		System.out.println("STAGE 2.4");
		global.hthree=c1.compare(global.g4,global.g3,global.h3,global.gfour,global.gthree);
		c1.displayArray(global.h3,global.hthree);
		System.out.println("STAGE 3");
		System.out.println(" ");
		System.out.println("STAGE 3.1");
		global.izero=c1.compare(global.h0,global.h1,global.i0,global.hzero,global.hone);
		c1.displayArray(global.i0,global.izero);
		System.out.println(" ");
		System.out.println("STAGE 3.2");
		global.ione=c1.compare(global.h1,global.h2,global.i1,global.hone,global.htwo);
		c1.displayArray(global.i1,global.ione);
		System.out.println(" ");
		System.out.println("STAGE 3.3");
		global.itwo=c1.compare(global.h3,global.h2,global.i2,global.htwo,global.hthree);
		c1.displayArray(global.i2,global.itwo);
	}

}
