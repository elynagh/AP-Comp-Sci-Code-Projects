public class Dashboard implements Comparable
{

    private int odometer;
    private int speedometer;
    private boolean checkEngine;


    /*
    No miles
    odometer = 0
    speedometer = 0
    no check engine light
    */
    public Dashboard() 
    {
        odometer = 0;
        speedometer = 0;
        checkEngine = false;
    }

    /*
    if milesTravelled >= 0 and milesTravelled <= 999 odometer = miles travelled
    if speed >= 0 and <= 100 speedometer = speed
    otherwise set milesTravelled and speedometer = 0 and turn on check engine
    */
    public Dashboard(int milesTravelled, int speed)
    {
      boolean checkMiles = false;
      boolean checkSpeed = false;

      if(milesTravelled >= 0 && milesTravelled <= 99999)
      {
        odometer = milesTravelled;
        checkMiles = true;
      }
      else
      {
        odometer = 0;
      }

      if(speed >= 0 && speed <= 100)
      {
        speedometer = speed;
        checkSpeed = true;
      }
      else
      {
        speedometer = 0;
      }

      if(checkMiles == true && checkSpeed == true)
      {
          checkEngine = false;
      }
      else
      {
          checkEngine = true;
      }

    }

    /*
    speed++ as long as it is <= 100
    else speed = 0 and light on
    */
    public void accelerate() 
    {
      this.speedometer++;
      if(this.speedometer > 100)
      {
        this.speedometer = 0;
        this.checkEngine = true;
      }
    }
    /*
    numMinutes = time
    rounds down miles
    time * speed = distance
    distance = odometer
    */
    public void drive(int numMinutes) 
    {
      double mph = (double)this.speedometer/60;
      double totalMiles = mph * numMinutes;
      this.odometer += (int)totalMiles;
      if(this.odometer > 99999)
      {
        this.odometer = 0;
        this.checkEngine = true;
      }

    }


    public String toString() 
    {
      String prt = null;
      prt = "Speedometer: " + speedometer + " MPH\n" + "Odometer: ";

      if(odometer >= 0 && odometer <= 9)
      {
        prt = prt + "0000";
      }
      else if(odometer >= 10 && odometer <= 99)
      {
        prt = prt + "000";
      }
      else if(odometer >= 100 && odometer <= 999)
      {
        prt = prt + "00";
      }
      else if(odometer >= 1000 && odometer <= 9999)
      {
        prt = prt + "0";
      }
      else
      {
        prt = prt;
      }

      prt = prt + odometer + "\n";


      if(checkEngine == true)
      {
        prt = prt + "Check Engine: On";
      }
      else
      {
        prt = prt + "Check Engine: Off";
      }

      return prt;
    }

    /*
    A Dashboard object should be considered less than another if it 
    has lower total mileage, or lower speed, or does not have a 
    check engine light on, in that order of priority. This method 
    should return -1 if the dashboard being checked is less than 
    the other, 0 if they are the same, and 1 if the one being 
    checked is greater than the other.
    */
    public int compareTo(Object other)
    {
      Dashboard temp = (Dashboard) other;
      int prt = 0;

      if(this.odometer < temp.odometer)
      {
        prt = -1;
      }
      else if(this.odometer > temp.odometer)
      {
        prt = 1;
      }
      else if(this.odometer == temp.odometer)
      {
        if(this.speedometer < temp.speedometer)
        {
          prt = -1;
        }
        else if(this.speedometer > temp.speedometer)
        {
          prt = 1;
        }
        else if(this.speedometer == temp.speedometer)
        {
          if(this.checkEngine == false && temp.checkEngine == true)
          {
            prt = -1;
          }
          else if(this.checkEngine == true && temp.checkEngine == false)
          {
            prt = 1;
          }
          else if(this.checkEngine == true && temp.checkEngine == true)
          {
            prt = 0;
          }
        }
      }

      return prt;
    }

    /*
    This method should simulate a race between this dashboard and another
    dashboard called "other". Each dashboard will accelerate in increments
    of 1 mph n1 and n2 times, respectively (i.e. dashboard 1 will accelerate
    () acc1 times, and dashboard 2 ("other") will accelerate() acc2 times). 
    If the first ("this") dashboard stalls out (exceeds 100 mph at any point
    ), the method should return “First car stalled out!”. If the second 
    ("other") dashboard stalls out at any point, the method should return 
    “Second car stalled out!”. Then, the method should return the status of 
    both dashboards and the result of the race. If one dashboard stalls, the
    one that did not should be declared the winner. If neither dashboard 
    stalls, you can assume the winner is the dashboard with the higher final
    speed. If both dashboards stalled or neither stalls but they have the 
    same speed, the result should be "It’s a tie!" See the sample run of the
    student runner file for the proper return formatting. 
    */


    public String race(Dashboard o, int acc1, int acc2)
    {

      String prt = "";
      if(this.speedometer + acc1 > 100)
      {
        prt += "First car stalled out!\n";
        this.speedometer = 0;
        this.checkEngine = true;
        prt += "\n" + this.toString() + "\n";
        prt += "\n" + o.toString() + "\n";
        prt += "\nCar 2 has won the race!";
      }
      else
      {
        for(int a = 0; a < acc1; a++)
        {
          accelerate();
        }
      }

      if(o.speedometer + acc2 > 100)
      {
        prt += "\nSecond car stalled out! \n";
        o.speedometer = 0;
        o.checkEngine = true;
        prt += "\n" + this.toString() + "\n";
        prt += "\n" + o.toString() + "\n";
        prt += "\nCar 1 has won the race!";

      }
      else
      {
        for(int b = 0; b < acc2; b++)
        {
          o.accelerate();
        }
      }

      prt += "\n" + this.toString() + "\n\n";
      prt += "\n" + o.toString() + "\n\n";

      if(this.speedometer > o.speedometer)
      {
        prt += "Car 1 has won the race!";
      }
      else if(o.speedometer > this.speedometer)
      {
        prt += "Car 2 has won the race!";
      }
      else if(this.speedometer == o.speedometer)
      {
        prt += "It's a tie!";
      }

      return prt;
    }

    /*
    This method should calculate how long the dashboard with 
    fewer miles would need to drive at its
    current speed to have the same number of miles on 
    its odometer as the dashboard with more miles.
    For the output, the dashboard that this method is 
    being called on should be labeled as "first 
    car", and the "other" dashboard should be labeled 
    "second car".
    */

    public String difference(Dashboard o)
    {

      String prt = "";

      if(this.odometer >= o.odometer)
        {
        prt += "Second car will need to drive for ";
        double dif = (this.odometer - o.odometer);
        int min = (int)((dif / o.speedometer)*60);
        prt += min + " minutes to catch first car.";
      }

      else
     {
        prt += "First car will need to drive for ";

        double dif = (o.odometer - this.odometer);
        int min = (int)((dif / this.speedometer)*60);

        prt += min + " minutes to catch second car.";

      }

      return prt;
    }


}
