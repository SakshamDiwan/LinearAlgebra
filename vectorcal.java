/* The following program is a Vector Calculator which computes the
 * x and y component of the sum vector of two two-dimensional vectors. 
 * Only the magnitude and direction(in degrees) of the two vectors have 
 * been given.
 */
import java.util.*;
class vectorcal
{
    double x;
    double y;
    double mag;
    double ang;
    vectorcal(double mag1,double ang1)
    {
        x=0.0;
        y=0.0;
        mag=mag1;
        ang=ang1;
    }
    void x_value()
    {
        double ang2=ang%360;
        if(ang2==0.0)
        x=mag;
        else if(ang2>0.0 && ang2<90.0)
        x=(mag*Math.sin(radian_value(ang2)))/(Math.tan(radian_value(ang2)));
        else if(ang2==90.0)
        x=0.0;
        else if(ang2>90.0 && ang2<180.0)
        x=((mag*Math.sin(radian_value(180.0-ang2)))/(Math.tan(radian_value(180.0-ang2))))*(-1);
        else if(ang2==180.0)
        x=(-1)*mag;
        else if(ang2>180.0 && ang2<270.0)
        x=((mag*Math.sin(radian_value(ang2-180.0)))/(Math.tan(radian_value(ang2-180.0))))*(-1);
        else if(ang2==270.0)
        x=0.0;
        else if(ang2>270.0 && ang2<360.0)
        x=mag*Math.sin(radian_value(ang2-270.0));
    }
    void y_value()
    {
       double ang2=ang%360;
       if(ang2==0.0)
       y=0.0;
       else if(ang2>0.0 && ang2<90.0)
       y=mag*Math.sin(radian_value(ang2));
       else if(ang2==90.0)
       y=mag;
       else if(ang2>90.0 && ang2<180.0)
       y=mag*Math.sin(radian_value(180.0-ang2));
       else if(ang2==180.0)
       y=0.0;
       else if(ang2>180.0 && ang2<270.0)
       y=(mag*Math.sin(radian_value(ang2-180.0)))*(-1);
       else if(ang2==270.0)
       y=(-1)*mag;
       else if(ang2>270.0 && ang2<360.0)
       y=(mag*Math.sin(radian_value(360.0-ang2)))*(-1); 
    }
    double radian_value(double deg)
    {
        return ((22.0/7.0)*deg*(1.0/180.0));
    }
    vectorcal add(vectorcal X,vectorcal Y)
    {
        vectorcal Z=new vectorcal(0.0,0.0);
        Z.x=X.x+Y.x;
        Z.y=X.y+Y.y;
        return Z;
    }
    public void display()
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println();
    }
    public void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the magnitude of the first vector");
        double mag3=sc.nextDouble();
        System.out.println("Enter the direction of the first vector");
        double ang3=sc.nextDouble();
        vectorcal A=new vectorcal(mag3,ang3);
        System.out.println("Enter the magnitude of the second vector");
        double mag4=sc.nextDouble();
        System.out.println("Enter the direction of the second vector");
        double ang4=sc.nextDouble();
        vectorcal B=new vectorcal(mag4,ang4);
        System.out.println("VECTOR 1:");
        A.x_value();
        A.y_value();
        A.display();
        System.out.println("VECTOR 2:");
        B.x_value();
        B.y_value();
        B.display();
        vectorcal C=add(A,B);
        System.out.println("RESULTANT VECTOR:");
        C.display();
    }
}