import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * ---------------------------------------------------------------------------
 * File name: Proj3.java
 * Project name: Proj3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@goldmail.etsu.edu
 * Course:  CSCI 1250-003
 * Creation Date: Nov 5, 2015
 * ---------------------------------------------------------------------------
 */

/**
 * Use methods to display info from student class
 *
 * <hr>
 * Date created: Nov 5, 2015
 * <hr>
 * @author Justin Adams
 */
public class Proj3
{

	/**
	 *  Driver For Student Class
	 *
	 * <hr>
	 * Date created: Nov 5, 2015
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		String strName;		//Holds user input for name
		String strDate;		//Holds user input for date
		String strAssign;	//Holds user input for Assignment
		String strLetter;	//Holds user input for cSection
		char cSection=0;	//Holds user input for which section
		int iValid = -1;	//Holds error value
		int iNum;			//Holds users first integer
		int iNum2;			//Holds users second integer
		int iGrade;			//Holds users input for grade
		int iNumGrade;		//Holds the number of grades
		int iUserChoice;	//Holds users input for menu
		double dPercent;	//Holds percent value of weighted average
		char [] gradeSection ={'q','Q','T','t','f','F','p','P'};
							//Holds array cSection checker
		char cRepeat = 't';	//Holds value for repeating program
		DecimalFormat percent = new DecimalFormat("0%");	//Percent formater
		DecimalFormat noDecimal = new DecimalFormat("#");	//No decimal formatter
		Utility u1 = new Utility();
							//Reference variable of Utility class
		StringBuffer sb = new StringBuffer();
							//Reference Variable for StringBuffer class
		Scanner kb = new Scanner(System.in);				//input from keyboard
		Student s1 = new Student();
							//Reference variable for Student Class
		u1.clearScreen();
		System.out.print("What is this due date: ");
		strDate = kb.nextLine();
		System.out.print("What is the assignment: ");
		strAssign = kb.nextLine();
		do
		{
			System.out.print ("What is the student name: ");
			strName = kb.nextLine();
			iValid = s1.setName(strName);
			if (iValid == -1)
			{
				System.out.println("Error");
			}
		}while(iValid == -1);
		strName = s1.getName ( );
		do
		{
			System.out.print ("What is the Instructor: ");
			strName = kb.nextLine();
			iValid = s1.setInstructor(strName);
			if (iValid == -1)
			{
				System.out.println ("Error");
			}
		}while(iValid == -1);
		strName = s1.getInstructor ( );
		u1.theProgrammerInfo(strAssign,strDate);
		do
		{
			iUserChoice = u1.menu();
			switch(iUserChoice)
			{
			case 1: 	//Add Grades
				do
				{
					System.out.println("Input Grade");
					iGrade = kb.nextInt ( );
					if (iGrade <= 0 || iGrade >= 110)
					{
						System.out.println ("Error\nCheck Value");
						iValid = -1;
					}
					System.out.println("Which Section Like To Add A Grade");
					cSection = kb.next().charAt(0);
					iValid = -1;
					for(int i =0; i<gradeSection.length;i++)
					{
						if(gradeSection[i]== cSection)
						{
							iValid=s1.addGrade (cSection, iGrade);
							System.out.println ("Added");
							break;
						}
					}
					if(iValid==-1)
					{
						System.out.println ("Error\nValue Was Not Assigned");
						iValid = -1;
						break;
					}
					else if (iValid==-2)
					{
						System.out.println ("Error\nOver Limit Of Graded "+
											"Assignment\nTry Changing The Grade");
					}
					System.out.println("Would You Like To Add More Grades" +
									" Enter Yes Or No");
					cRepeat = kb.next().charAt(0);
					}while(cRepeat == 'y' || cRepeat == 'Y');
					break;
				case 2:	//Change Grade
					System.out.println("What Is The New Grade");
					iGrade = kb.nextInt ( );
					System.out.println("Which Section Like To Change A Grade");
					cSection = kb.next().charAt(0);
					System.out.println("Which Assignment Would You Like"+
										" To Change A Grade");
					iNumGrade = kb.nextInt ( );
					if (iGrade < 0 || iGrade > 110)
					{
						System.out.println ("Error\nCheck Value");
						break;
					}
					for(int i =0; i<gradeSection.length;i++)
					{
						if(gradeSection[i]== cSection)
						{
							iValid=s1.changeGrade (cSection, iGrade,iNumGrade);
						}
					}
					if(iValid == -1)
					{
						System.out.println ("Error\nValue Was Not Assigned");
						break;
					}
					else
					{
						System.out.println ("Added");
					}
					break;
				case 3:
					do
					{
						do
						{
						System.out.println("Which Weighted Percent Would You Like To"
										+" Enter/Change Quiz, Test, Exam,or Project"
										+"\nEnter 'Q' For Quiz\t"
										+percent.format(s1.getPercent('q'))+
										 "\nEnter 'T' For Test\t"
										+percent.format(s1.getPercent('t'))+
										 "\nEnter 'P' For Project\t"
										+percent.format(s1.getPercent('p'))+
										 "\nEnter 'F' For Final\t"
										+percent.format(s1.getPercent('f')));
						cSection = kb.next().charAt(0);
						for(int i =0; i<gradeSection.length;i++)
						{
							if(gradeSection[i]== cSection)
							{
								iValid = 0;
							}

						}
						}while(iValid == -1);
						System.out.println(	"How Percent Would You Like To Enter " +
										"\nEnter A Decimal And Not Exceded 1.0 " +
										"Between All Percents\nExample: 52% = 0.52");
						dPercent = kb.nextDouble ( );
						if (dPercent >= 1.0 ||dPercent < 0.00)
						{
							System.out.println("Error\nCheck Value");
							iValid = -1;
						}
						else
						{
							iValid = s1.setPercent (cSection, dPercent);
							if (iValid == -1)
							{
								System.out.println("Error\nNot Assigned");
							}
						}
					System.out.println("Would You Like To Add/Change Percent" +
									 	 " Enter Yes Or No");
					cRepeat = kb.next().charAt(0);
					}while(iValid == -1||cRepeat == 'y' || cRepeat == 'Y');
					break;
				case 4:		//Course Average
					System.out.println ("Quizzes Average: " +
									noDecimal.format(s1.average('q'))+"%");
					System.out.println ("   Test Average: " +
									noDecimal.format(s1.average('t'))+"%");
					System.out.println ("Project Average: " +
									noDecimal.format(s1.average('p'))+"%");
					break;
				case 5:
					System.out.println(noDecimal.format(s1.courseAverage ( ))+"%");
					break;
				case 6:
					do
					{
						iValid = -1;
						while(iValid == -1)
						{
							System.out.println("Which Would You Like To Enter " +
										 	"Class Name Or Class Number " +
										 	"\nEnter 'N' For Number " +
										 	"\nEnter 'D' For Class Name");
							try
							{
								strLetter = kb.nextLine();
								cSection = strLetter.charAt(0);
								iValid = 0;
							}
							catch(StringIndexOutOfBoundsException e)
							{
								System.out.println
								("Error\n\nCheck Value\n\nEther N or D\n");

							}
						}

						if (cSection == 'd'||cSection == 'D'||cSection == 'n'
							||cSection == 'N')
						{
							switch (cSection)
							{
								case 'd':
								case 'D':
								System.out.println ("What is The Class: ");
								strName = kb.nextLine();
								if(0==strName.charAt (0))
								{
									System.out.println ("Error");
								}
								else
								{
									iValid = s1.setCourseDesc(cSection,strName);
									break;
								}
							case 'N':
							case 'n':
								System.out.println ("What is The Class Number: ");
								strName = kb.nextLine();
								if(0==strName.length ( ))
								{
									System.out.println ("Error");
									break;
								}
								else
								{
									iValid = s1.setCourseDesc(cSection,strName);
									iValid = 0;
									break;
								}
							}
						}
						else
						{
							System.out.println ("Not Assigned\n\nCheck Value");

						}
						System.out.println	("Would You Like To Add/Change Info" +
										 	 " Enter Yes Or No");
						strLetter = kb.nextLine();
						cRepeat = strLetter.charAt(0);
					}while(cRepeat == 'y' || cRepeat == 'Y');
					break;
				case 7:					//Binary/Octal/Hex
					do
					{
						System.out.print("Whats is the Interger: ");
						iNumGrade = kb.nextInt();
						u1.BinOctHex(iNumGrade);
						u1.pressEnterToContinue();
						cRepeat = u1.startOver();
					}while(cRepeat == 'Y' || cRepeat == 'y');
					break;
				case 8:					//GCF
					System.out.print("Whats is the first Interger: ");
					iNum = kb.nextInt();
					System.out.print("Whats is second Interger: ");
					iNum2= kb.nextInt();
					System.out.print("Greatest Common Factor Of " + iNum +
											"," + iNum2 + " Is ");
					iNum = u1.GCF (iNum, iNum2);
					System.out.println(iNum);
					u1.pressEnterToContinue ( );
					break;
				case 9:					//LCM
					System.out.print("Whats is the first Interger: ");
					iNum = kb.nextInt();
					System.out.print("Whats is second Interger: ");
					iNum2= kb.nextInt();
					System.out.print("Leastest Common Multiple Of " + iNum +
						"," + iNum2 + " Is ");
					iNum = u1.LCM (iNum, iNum2);
					System.out.println(iNum);
					u1.pressEnterToContinue ( );
					break;
				case 10:				//Student Info
					System.out.println(s1.studentInfo());
					u1.pressEnterToContinue( );
					break;
				case 11:				//Exit The Program
					System.exit(0);
				}
			}while(iUserChoice!=-1);
		kb.close ( );
	}//End main(String)
}//End Proj3.java
