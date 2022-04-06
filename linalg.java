/* The following program is a Linear Algebra Calculator which performs addition, 
 * subtraction and multiplication between two matrices depending on what the user wants.
 */
import java.util.*;
class linalg
{
    Scanner sc=new Scanner(System.in);
    int mat1[][];
    int mat2[][];
    int r1;
    int c1;
    int r2;
    int c2;
    linalg()
    {
        r1=0;
        c1=0;
        r2=0;
        c2=0;
    }
    linalg(int r3,int c3, int r4,int c4)
    {
        r1=r3;
        c1=c3;
        r2=r4;
        c2=c4;
        mat1=new int[r1][c1];
        mat2=new int[r2][c2];
    }
    public void input()
    {
        int i,j;
        System.out.println("Enter the elements of the first vector or matrix");
        for(i=0;i<r1;i++)
        {
            for(j=0;j<c1;j++)
            mat1[i][j]=sc.nextInt();
        }
        System.out.println("Enter the elements of the second vector or matrix");
        for(i=0;i<r2;i++)
        {
            for(j=0;j<c2;j++)
            mat2[i][j]=sc.nextInt();
        }
        System.out.println("FIRST VECTOR OR MATRIX:");
        display(mat1);
        System.out.println("SECOND VECTOR OR MATRIX:");
        display(mat2);
    }
    void add()
    {
        if(r1!=r2 || c1!=c2)
        System.out.println("THE VECTORS OR MATRICES CANNOT BE ADDED");
        else
        {
            int mat3[][]=new int[r1][c1];
            int i,j;
            for(i=0;i<r1;i++)
            {
                for(j=0;j<c1;j++)
                mat3[i][j]=mat1[i][j]+mat2[i][j];
            }
            System.out.println("RESULTANT VECTOR OR MATRIX:");
            display(mat3);
        }
    }
    void subtract()
    {
        if(r1!=r2 || c1!=c2)
        System.out.println("THE VECTORS OR MATRICES CANNOT BE SUBTRACTED");
        else
        {
            int mat4[][]=new int[r1][c1];
            int i,j;
            for(i=0;i<r1;i++)
            {
                for(j=0;j<c1;j++)
                mat4[i][j]=mat1[i][j]-mat2[i][j];
            }
            System.out.println("RESULTANT VECTOR OR MATRIX:");            
            display(mat4);
        }
    }
    void multiply()
    {
        if(c1!=r2)
        System.out.println("THE VECTORS OR MATRICES CANNOT BE MULTIPLIED");
        else
        {
            int mat5[][]=new int[r1][c2];
            int i,j,k;
            for (i=0;i<r1;i++) 
            {
                for(j=0;j<c2;j++)
                {
                    for(k=0;k<r2;k++)
                    mat5[i][j]=mat5[i][j]+(mat1[i][k]*mat2[k][j]);
                }
            }
            System.out.println("RESULTANT VECTOR OR MATRIX:");
            display(mat5);
        }
    }
    public void display(int x[][])
    {
        int i,j;
        for(i=0;i<x.length;i++)
        {
            for(j=0;j<x[0].length;j++)
            {
                if(Integer.toString(x[i][j]).length()==1)
                System.out.print(x[i][j]+"    ");
                else if(Integer.toString(x[i][j]).length()==2)
                System.out.print(x[i][j]+"   ");
                else if(Integer.toString(x[i][j]).length()==3)
                System.out.print(x[i][j]+"  ");
                else
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
     }
    public void main()
    {
        System.out.println("Enter the number of rows of the first vector or matrix");
        int r5=sc.nextInt();
        System.out.println("Enter the number of columns of the first vector or matrix");
        int c5=sc.nextInt();
        System.out.println("Enter the number of rows of the second vector or matrix");
        int r6=sc.nextInt();
        System.out.println("Enter the number of columns of the second vector or matrix");
        int c6=sc.nextInt();
        linalg ob1=new linalg();
        linalg ob=new linalg(r5,c5,r6,c6);
        ob.input();
        System.out.println("PRESS 1 TO ADD THE VECTORS OR MATRICES");
        System.out.println("PRESS 2 TO SUBTRACT THE VECTORS OR MATRICES");
        System.out.println("PRESS 3 TO MULTIPLY THE VECTORS OR MATRICES");
        System.out.println("Enter your choice:");
        int h=sc.nextInt();
        switch(h)
        {
            case 1:
            ob.add();
            break;
            case 2:
            ob.subtract();
            break;
            case 3:
            ob.multiply();
            break;
            default:
            System.out.println("WRONG CHOICE");
        }
    }
}