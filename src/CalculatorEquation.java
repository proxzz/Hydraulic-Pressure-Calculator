import java.lang.Math;
public class CalculatorEquation
{
  private double diameter;
  private double hazenWilliamsCoefficient;
  private double flowRate;

  
  public CalculatorEquation() 
  {
    diameter = 0.0;
    hazenWilliamsCoefficient = 0.0;
    flowRate = 0.0;

  }
  public CalculatorEquation(double diameter, double hazenWilliamsCoefficient, double flowRate) 
  {
    this.diameter = diameter;
    this.hazenWilliamsCoefficient = hazenWilliamsCoefficient;
    this.flowRate = flowRate;

  }
  public double getDiameter()
  {
    return diameter;
  }
  public void setDiameter(int diameter2) 
  {
    this.diameter = diameter2;
  }
   public double getHazenWilliamsCoefficient()
  {
    return hazenWilliamsCoefficient;
  }
  public void setHazenWilliamsCoefficient(double hazenWilliamsCoefficient2) 
  {
    this.hazenWilliamsCoefficient = hazenWilliamsCoefficient2;
  }
   public double getFlowRate()
  {
    return flowRate;
  }
  public void setFlowRate(double flowRate2) 
  {
    this.flowRate = flowRate2;
  }

  public double hydraulicPressure()
  {
    double a = 1.85;
    double b = 4.87;
   double pressure = ((4.25*Math.pow(flowRate,a))/(Math.pow(hazenWilliamsCoefficient,a)*Math.pow(diameter,b)));
   return pressure;
  }

      public String toString()
      {
        
          String sum  = "The hydraulic pressure is " + hydraulicPressure();
          return sum;
        }
        
       }  
            
      
    

