import java.util.Scanner;
public class DiningDollar {
 

    public static void main(String[] args) {
     int dinLeft;
  double dinAll;
  double dinPerWeek;
  int spendPerWeek;
  int outByWeek;
  int dinShould;
  int week;
  int weekMath;
  int ros;
  int weeksLeftOfMoney = 0;
  boolean tooFarFromMark;
  String quarter = ""; 
  String quarterL = "";
  String idc = "";
  String outByQuarter;
  Scanner scan = new Scanner(System.in);
        //What quarter is it?
 System.out.print( "What quarter is it? (Fall, Winter, or Spring): ");
 quarter = scan.next();
 quarterL = quarter;
 quarterL = quarterL.toLowerCase();
 //to lowercase
 /*for(int i = 0; quarter[i] != '\0'; i++){
  quarterL[i] = tolower(quarter[i]);
 }*/

 while(!quarterL.equals("fall") && !quarterL.equals("winter") && !quarterL.equals("spring") )
        // && !quarterL.equals("Fall") && !quarterL.equals("Winter") && !quarterL.equals("Spring"))
 {
  System.out.print( "\n" +"\"" + quarter + "\" is not a valid quarter dummy!" 
   + "\n" +"Please input what quarter you are in. (Ex. Fall, Winter, Spring): ");
  quarter = scan.next();
  quarterL = quarter;
  quarterL.toLowerCase();
  /*for(int i = 0; quarter[i] != '\0'; i++){
   quarterL[i] = tolower(quarter[i]);
  }*/
 }
 
 //What week is it?
 System.out.print( "\n" +"What week is it in this quarter: ");
 week = scan.nextInt();

 //week check for fall
 if(quarterL.equals("fall") || quarterL.equals("Fall"))
 {
  while(week < 0 || week > 11)
  {
   System.out.print( "\n" +"Don't be a smartass, there is no such thing as week " + week
    + " in " + quarterL + ". " + "\n"
    + "What week is it in this quarter? (Finals week is 11): ");
   week = scan.nextInt();
  }
 }

 //week check for spring and winter
 if(quarterL.equals("winter") || quarterL.equals("spring") || quarterL.equals("Winter") ||
    quarterL.equals("Spring"))
 {
  while(week < 1 || week > 11)
  {
   System.out.print( "\n" +"Don't be a smartass, there is no such thing as week " + week
    + " in " + quarterL + ". What week is it in this quarter? (Finals week is 11): ");
   week = scan.nextInt();
  }
 }

 //Dining dollars Start
 System.out.print( "\n" +"How many dining dollars have you bought in total?"
  + " (Estimate if unsure) (Standard dining plans are $3060 for Res Halls, "
  +"$2350 for Apartments/Village, $3800 for Buy up option): $");
 dinAll = scan.nextInt();

 //Dining dollar check
 while(dinAll < 0)
 {
  System.out.print( "\n" +"Don't be an idiot... you can't buy $" + dinAll 
   + " dining dollars." + "\n"
   + "Put a real number or 0 if you don't know: ");
  dinAll = scan.nextInt();
 }
 
 //Dining dollar comment
 if(dinAll > 2000)
 {
  System.out.print( "\n" +"You bought $" + dinAll + " dining dollars in total. " 
   + "That sucks huh? This school is sucking us dry!" + "\n");
 }

 if(dinAll <= 2000)
 {
  System.out.print( "\n" +"... whaaat? How did you get manage to get less?... "
  + "\n" +"Whatever, I'm a program. I don't really give a shit." + "\n");
 }

 //How many dining dollars left
 System.out.print( "\n" +"How many dining dollars do you have now: $");
 dinLeft = scan.nextInt();

 if(dinLeft == 0)
 {
  System.out.print( "\n" +"Bro you're out of cash, use this app when"
   + " you're not shit broke!");

  System.out.print( "\n" +"\n" +"Thank you for using the Jesus Dining Dollar Calculator"
  + " 9000. I hope this helps you figure shit out!" + "\n" +"\n");

 return;

 }


 while(dinLeft > dinAll || dinLeft < 0)
 {
  if(dinLeft> dinAll)
  {
   System.out.print( "\n" +"Again, don't be an ass. You can't have "
    + "more dining dollars than you have bought. How many do you "
    + "really have?: ");
   dinLeft = scan.nextInt();
  }

  if(dinLeft < 0)
  {
   System.out.print( "\n" +"We don't have to do this if you don't want"
    + " to." + "\n" +"I'm only trying to help you out..." 
    + "\n" +"Please enter at least a POSITIVE number!: ");
   dinLeft = scan.nextInt();
  }
 }

 dinPerWeek = dinAll/34;

 if(quarterL.equals("fall"))
  weekMath = week + 1;

 else if(quarterL.equals("winter"))
  weekMath = week + 12;
 
 else//(quarterL.equals("spring"))
  weekMath = week + 23;

 dinShould = (int)(dinAll - dinPerWeek * (double) weekMath);

 //rate of spending
 ros = (int)((dinAll - dinLeft)/weekMath);

 // if zero weeks left
 if(ros > 0)
  weeksLeftOfMoney = dinLeft/ros;

 //what week will they be out
 outByWeek = weeksLeftOfMoney + weekMath;
 
 if(outByWeek == 35)
 {
  outByQuarter = "spring";
  outByWeek = 35;
 }
 else if(outByWeek > 23)
 {
  outByQuarter = "spring";
  outByWeek = outByWeek - 23;
 }
 else if(outByWeek > 12)
 {
  outByQuarter = "winter";
  outByWeek = outByWeek - 12;
 }
 else
 {
  outByQuarter = "fall";
 }

 if(34 - weekMath > 0)
  spendPerWeek = dinLeft/(34 - weekMath);
 else 
  spendPerWeek = 0;

 if(dinLeft < dinShould)
 {
  System.out.print( "Initially you should have been spending $" + (int)dinPerWeek 
   + " per week... " + "\n");

  if (dinShould - dinLeft > 100)
  {
  System.out.print( "\n" +"You fucked up. By the end of this week you should"
   + " have at least $" + dinShould + " dining dollars, and you don't"
   + " seem to be close to that!" + "\n");

  System.out.print( "\n" +"This puts you behind the mark at $" 
   + (dinLeft - dinShould) + "!");

  System.out.print( "\n" +"If you keep up this BS pace, you're gonna be"
   + " out of dining dollars by " + outByQuarter + " quarter on week "
   + outByWeek + "!");

  System.out.print( "\n" +"If you want shit to last you till the end of"
   + " the year, you're gonna have to spend at most $" + spendPerWeek
   + " dining dollars per week to survive.");
  }

  else
  {
   System.out.print( "\n" +"Well, I guess you're kinda close. By the end of this "
    + "week you should have at least $" + (int)dinShould + " dining dollars, and "
    + "if you watch yourself you might be able to catch up." + "\n");

   System.out.print( "\n" +"This puts you behind the mark at $" 
   + (dinLeft - dinShould) + "!");

  System.out.print( "\n" +"If you keep at this pace, you're gonna be"
   + " out of dining dollars by " + outByQuarter + " quarter at the start of week "
   + outByWeek + ".");

  System.out.print( "\n" +"If you keep this pace you should kinda finish"
   + " off you dining dollars by the end of the year. Just spend at most $" + spendPerWeek
   + " dining dollars per week and you'll be fine.");
  }
 }

 else if(dinLeft > dinShould)
 {
  System.out.print( "\n" +"Hen hao! (Very good!) By the end of this week you"
   + " should have at most $" + dinShould + " dining dollars, and you're"
   + " on track. You saavy spender you!" + "\n" +"Initially you should"
   + " have been spending $" + (int)dinPerWeek + " per week" + "\n");

  System.out.print( "\n" +"This puts you at a surplus of $" + (dinLeft - dinShould)
   + "!");

  System.out.print( "\n" +"Feel free to fill up with food to your gut's"
   + " content! If you spend $" + spendPerWeek + " dining dollars "
   + "per week you will squeeze every penny that you paid out of"
   + " this institution.");
 }

 else
 {
  System.out.print( "\n" +"Hen hao! (Very good!) By the end of this week you"
   + " should have at most $" + dinShould + " dining dollars, and you're"
   + " on track. You saavy spender you!" + "\n" +"Initially you should"
   + " have been spending $" + dinPerWeek + " per week..." + "\n");

  System.out.print( "\n" +"This puts you right on the mark!");

  System.out.print( "\n" +"DUUUDE, you're right smack where you should be!"
   + " Keep eating that same shit. If you spend $" + spendPerWeek + " dining dollars "
   + "per week you will squeeze every penny that you paid out of"
   + " this institution.");
 }


 System.out.print( "\n" +"\n" +"Thank you for using the Jesus Dining Dollar Calculator"
  + " 9000. I hope this helps you figure shit out!" + "\n" +"\n");

    }

}