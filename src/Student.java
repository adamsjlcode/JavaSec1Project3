import java.text.DecimalFormat;

/**
 * ---------------------------------------------------------------------------
 * File name: Student.java
 * Project name: Proj3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@goldmail.etsu.edu
 * Course:  CSCI 1250-003
 * Creation Date: Nov 4, 2015
 * ---------------------------------------------------------------------------
 */

/**
 * Program for a weighted calculator,LCM,and GCF for and from user input 
 *
 * <hr>
 * Date created: Nov 4, 2015
 * <hr>
 * @author Justin Adams
 */
public class Student
{
	private String name;					//Holds users name  
	private String Instructor;				//Holds users instructor
	private String courseDesc;				//Holds users course description
	private String courseNum;				//Holds users course number
	private int test1 = -1;					//Holds first test grade
	private int test2 = -1;					//Holds second test grade
	private int test3 = -1;					//Holds third test grade
	private int testGraded;					//Holds number of test graded
	private int Quiz1 = -1;					//Holds first quiz grade
	private int Quiz2 = -1;					//Holds second quiz grade
	private int Quiz3 = -1;					//Holds third quiz grade
	private int Quiz4 = -1;					//Holds fourth quiz grade
	private int Quiz5 = -1;					//Holds five quiz grade
	private int QuizGraded;					//Holds number of quiz graded
	private int proj1 = -1;					//Holds first project grade
	private int proj2 = -1;					//Holds second project grade
	private int proj3 = -1;					//Holds third project grade
	private int proj4 = -1;					//Holds fourth project grade
	private int projectsGraded;				//Holds number of project graded
	private int finalExam = -1;				//Holds first exam grade
	private boolean recordedFinalExam = false;//Whether final exam was recorded
	private double pctsT;					//Percent Of Tests
	private double pctsQ;					//Percent Of Quizzes
	private double pctsP;					//Percent Of Projects
	private double pctsF;					//Percent Of Final
/**
 * Set Name Of User Input         
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @param name
 * @return 0 Or -1 To Determine If Assignment
 */
public int setName(String name)
{
	if (name.length() > 0)
	{
		this.name = name;
		return 0;
	}
	else
	{
		return -1;
	}
}//End setName(String)
/**
 * Set Course Info Of User Input         
 *
 * <hr>
 * Date created: Nov 7, 2015
 *
 * <hr>
 * @param type 
 * @param courseDesc
 * @return
 */
public int setCourseDesc (char type,String courseDesc)
{
		int valid = -1;
		switch(type)
		{
			case 'D':
			case 'd':
				this.courseDesc =courseDesc;
				valid = 0;
				break;
			case 'N':
			case 'n':				
				this.courseNum = courseDesc;
				valid = 0;
				break;
			default:
			valid =-1;
		}
		return valid;
}//End setCourseDesc(char,String)
/**
 * Set Instructor Info Of User Input         
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @param instructor
 * @return 0 Or -1 To Determine If Assignment
 */
public int setInstructor (String instructor)
{
		if (instructor.length() > 0)
		{
			this.Instructor = instructor;
			return 0;
		}
		else
		{
			return -1;
		}
}//End setInstructor(String)
/**
 * Set Percent Info Of User Input         
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @param type which section percent is assigned
 * @param pctAmt amount of percent
 * @return 0 Or -1 To Determine If Assignment
 */
public int setPercent(char type,double pctAmt)
{
	int added = 0;				//Holds error value 
	double dAddpctAmt = 0;		//Holds percent original value for error checking
	double percentHolder = 0;	//Holds percent original value for error checking
	switch(type)
	{		
		case 'q':
		case 'Q':
			dAddpctAmt=pctsQ;
			if(pctsQ!=0)
			{	
			this.pctsQ=pctAmt;
			added = 0;
			if(pctsQ+pctsT+pctsP+pctsF>1.0)
			{
				if(recordedFinalExam!=false)
				{	
					percentHolder = pctsF;
					pctsF=0.0;
					pctsQ=pctAmt;
					if(pctsQ+pctsT+pctsP+pctsF>1.0)
						{
						added = -1;
						pctsQ=dAddpctAmt;
						pctsF=percentHolder;
						break;
						}
					else break;
				}
				else
				{
					System.out.print("Error\nValues Over Limit\nChange Anothor Percent First");
					pctsQ=dAddpctAmt;
					break;
				}
			}
			else
			{
				break;
			}
		}
		else 
		{
			pctsQ=pctAmt;
			added = 0;
			break;	
		}
		case 't':
		case 'T':
			if(pctsT!=0)
			{
			this.pctsT=pctAmt;
			added = 0;
			if(pctsQ+pctsT+pctsP+pctsF>1.0)
			{
				if(recordedFinalExam!=false)
				{	
					percentHolder = pctsF;
					pctsF=0.0;
					pctsT=pctAmt;
					if(pctsQ+pctsT+pctsP+pctsF>1.0)
						{
						added = -1;
						pctsT=dAddpctAmt;
						pctsF=percentHolder;
						break;
						}
					else 
					{
						break;
					}
				}
				else 
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		else 
		{
			pctsT=pctAmt;
			added = 0;
			break;	
		}
		case 'p':
		case 'P':
			if(pctsP!=0)
			{	
			this.pctsP=pctAmt;
			added = 0;
			if(pctsQ+pctsT+pctsP+pctsF>1.0)
			{
				if(recordedFinalExam!=false)
				{	
					percentHolder = pctsF;
					pctsF=0.0;
					pctsP=pctAmt;
					if(pctsQ+pctsT+pctsP+pctsF>1.0)
					{
						added = -1;
						pctsP=dAddpctAmt;
						pctsF=percentHolder;
						break;
					}
					else
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
			else
			{
				break;
			}
			}
			else 
			{
				pctsP=pctAmt;
				added = 0;
				break;	
			}
		case 'f':
		case 'F':
			if(pctAmt+pctsT+pctsP+pctsQ > 1.0)
			{
				dAddpctAmt = pctsF;
				pctsF = pctAmt;
				added = 0;
				if (pctAmt+pctsT+pctsP+pctsQ > 1.0)
				{
					pctsF = dAddpctAmt;
					added = -1;
				}
			}
			else
			{
			pctsF = pctAmt;
			recordedFinalExam=true;
			added = 0;
			break;
			}

		}
	return added;
}//End setPercent(char,pctAmt)
/**
 * Receive Name Variable          
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @return name User Input
 */
public String getName ( )
{
	return name;
}//End getName()
/**
 * Receive Instructor Variable        
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @return Instructor User Input
 */
public String getInstructor ( )
{
	return Instructor;
}//End getInstructor()
/**
 * Receive Course Info Variables        
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @param type which section of course is assigned
 * @return courseDesc Or courseNum From User Choice
 */
public String getCourseDesc (char type )
{
	String strCourseDesc = ""; //Holds user choice from input
	switch(type)
	{
		
		case 'D':
		case 'd':
		strCourseDesc = courseDesc;
		break;
		case 'N':
		case 'n':				
		strCourseDesc = courseNum;
		break;
		
	}
	return strCourseDesc;
}//End getCourseDesc(char)
/**
 * Receive Percent Info Variables          
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @param type which section percent is assigned
 * @return pctsT,pctP,pctsF,Or pctsQ From User Choice
 */
public double getPercent(char type)
{
	double dPercent = 0;		//Holds user return value
	switch (type)
	{
		case 'q':
		case 'Q':
			dPercent = pctsQ;
			break;
		case 't':
		case 'T':
			dPercent = pctsT;
			break;
		case 'p':
		case 'P':
			dPercent = pctsP;
			break;
		case 'f':
		case 'F':
			dPercent = pctsF;
			break;
	}	
	return dPercent;
}//End getPercent(char)
/**
 * Use User Input For Charging A Selected Grade          
 *
 * <hr>
 * Date created: Nov 7, 2015
 *
 * <hr>
 * @param type which section the grade is assigned
 * @param grade	holds grade from user input
 * @param numGrade holds determine grade user needs to change
 * @return added 0 Or -1 To Determine If Assignment
 */
public int changeGrade(char type, int grade, int numGrade)
{
	int iAdded = -1;	//Holds error value 
	
	if (grade >= 0 || grade <= 110)
	{
		switch(type)
		{
			case 'q':
			case 'Q':
				if (numGrade<=QuizGraded)
				{	
					switch(numGrade)
					{
						case 1:
							this.Quiz1=grade;
							iAdded = 0;
							break;
						case 2:
							this.Quiz2=grade;
							iAdded = 0;
							break;
						case 3:
							this.Quiz3=grade;
							iAdded = 0;
							break;
						case 4:
							this.Quiz4=grade;
							iAdded = 0;
							break;
						case 5:
							this.Quiz5=grade;
							iAdded = 0;
							break;
					}
				}
				else
				{
					iAdded=-1;
					break;
				}
		case 't':
		case 'T':
			if (numGrade<=testGraded)
			{	
				switch(numGrade)
				{
					case 1:
						this.test1=grade;
						iAdded = 0;
						break;
					case 2:
						this.test2=grade;
						iAdded = 0;
						break;
					case 3:
						this.test3=grade;
						iAdded = 0;
						break;
				}
			}
			else
			{
				iAdded = -1;
				break;
			}
		case 'p':
		case 'P':
			if (numGrade<=projectsGraded)
			{
				switch(numGrade)
				{
					case 1:
						this.proj1=grade;
						iAdded = 0;
						break;
					case 2:
						this.proj2=grade;
						iAdded = 0;
						break;
					case 3:
						this.proj3=grade;
						iAdded = 0;
						break;
					case 4:
						this.proj4=grade;
						iAdded = 0;
						break;
				}
			}
			else
			{
				iAdded = -1;
				break;
			}
		case 'f':
		case 'F':
			if (recordedFinalExam=false)
			{
				switch(numGrade)
				{
					case 1:
						this.finalExam=grade;
						recordedFinalExam=true;
						iAdded = 0;
						break;
				}
			}
			else
			{
				iAdded = -1;
				break;
			}
		}
	
	}
	return iAdded;
}//End changeGrade(char,int,int)
	
/**
 * Method to add integers to student class        
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @param type which section the grade is assigned
 * @param grade	holds grade from user input
 * @return
 */
public int addGrade(char type,int grade)
{
	int added = -1;
	if (grade >= 0 || grade <= 110)
	{
		switch(type)
	
		{
			case 'q':
			case 'Q':
				if (QuizGraded < 5)
				{
					if(Quiz1 == -1)
					{
						Quiz1 = grade;
						QuizGraded++;
						added = 0;
						break;
					}
					else if(Quiz2 == -1)
					{
						Quiz2 = grade;
						QuizGraded++;
						added = 0;
						break;
					}
					else if(Quiz3 == -1)
					{
						Quiz3 = grade;
						QuizGraded++;
						added = 0;
						break;
					}
					else if(Quiz4 == -1)
					{
						Quiz4 = grade;
						QuizGraded++;
						added = 0;
						break;
					}
					else if(Quiz5 == -1)
					{
						Quiz5 = grade;
						QuizGraded++;
						added = 0;
						break;
					}
					added = -1;
					break;
				}
				else
				{
					added = -2;
					break;	
				}
			case 't':
			case 'T':
				if (testGraded < 3)
				{

					if(test1 == -1)
					{
						test1 = grade;
						testGraded++;
						added = 0;
						break;
					}
					else if(test2 == -1)
					{
						test2 = grade;
						testGraded++;
						added = 0;
						break;
					}
					else if(test3 == -1)
					{
						test3 = grade;
						testGraded++;
						added = 0;
						break;
					}
					added = -1;
					break;
				}
				else
				{
					added = -2;
					break;	
				}
			case 'p':
			case 'P':
				if (projectsGraded < 4)
				{
					if(proj1 == -1)
					{
						proj1 = grade;
						projectsGraded++;
						added = 0;
						break;
					}
					else if(proj2 == -1)
					{
						proj2 = grade;
						projectsGraded++;
						added = 0;
						break;
					}
					else if(proj3 == -1)
					{
						proj3 = grade;
						projectsGraded++;
						added = 0;
						break;
					}
					else if(proj4 == -1)
					{
						proj4 = grade;
						projectsGraded++;
						added = 0;
						break;
					}
					added = -1;
					break;
				}
				else
				{
					added = -2;
					break;	
				}
			case 'f':
			case 'F':
				if (recordedFinalExam=true)
					{
						added = -1;
						break;
					}
				else
				{
					
					this.finalExam = grade;
					recordedFinalExam=true;
					added = 0;
					break;
				}

				
		}
	}
	return added;
}//End addGrade(char,int)
	
/**
 * Determine the average of grades from user input         
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 * @param type which section percent is assigned
 * @return average of Test,Quiz,Exams,Project
 */
public double average(char type)//Make All Value -1 or Something
{
	double dcourAverage = 0;	//Holds average of user selection
	int added = -1;				//Holds error checker
				switch(type)
				{
				case 'q':
				case 'Q':
						if(Quiz1 != -1)
						{
							dcourAverage+=Quiz1;
						}
						if(Quiz2 != -1)
						{
							dcourAverage+=Quiz2;
						}
						if(Quiz3 != -1)
						{
							dcourAverage+=Quiz3;
						}
						if(Quiz4 != -1)
						{
							dcourAverage+=Quiz4;
						}
						if(Quiz5 != -1)
						{
							dcourAverage+=Quiz5;
						}
						added = 0;
						dcourAverage/=QuizGraded;
						break;
					
				case 't':
				case 'T':
					if(test1 != -1)
					{
						dcourAverage+= test1;
					}
					if(test2 != -1)
					{
						dcourAverage+= test2;
					}
					if(test3 != -1)
					{
						dcourAverage+= test3;	
					}
					dcourAverage/=testGraded;
					added = 0;
					break;
				case 'p':
				case 'P':
					if(proj1 != -1)
					{
						dcourAverage+=proj1;
					}
					if(proj2 != -1)
					{
						dcourAverage+=proj2;
					}
					if(proj3 != -1)
					{
						dcourAverage+=proj3;	
					}
					if(proj4 != -1)
					{
						dcourAverage+=proj4;	
					}
					dcourAverage/=projectsGraded;
					added = 0;
					break;
				case 'f':
				case 'F':
					if (finalExam != -1)
					{
						dcourAverage+=finalExam;
					}	
					added = 0;
					break;
			}
	return dcourAverage;
}//End average (char)
/**
 * Determine the weighted averages of all with grades from user input         
 *
 * <hr>
 * Date created: Nov 4, 2015
 *
 * <hr>
 *
 * @return average of all Test,Quiz,Exams,Project
 */
public double courseAverage()	
{
	
	double dCourse = 0;			//Holds weighted average of all grades
	if(recordedFinalExam==false || pctsT+pctsP+pctsQ != 1.0)
	{	
		pctsF=0.0;
		pctsT = .70;
		dCourse = (average('q')*pctsQ)+(average('p')*pctsP)+(average('t')*pctsT);
		return dCourse;
	}
	else
	{
		dCourse = (average('q')*pctsQ)+(average('p')*pctsP)+(average('t')*pctsT)+(average('f')*pctsF);
		return dCourse;
	}

}//End courseAverage()
/**
 * Creates Sting Object Of Student To Display User Input         
 *
 * <hr>
 * Date created: Nov 5, 2015
 *
 * <hr>
 * @return studentInfo() String Object
 */
public String studentInfo()
{
	DecimalFormat percent = new DecimalFormat("#0%");	//Holds percent formatter
	DecimalFormat noDecimal = new DecimalFormat("#");	//Holds no decimal formatter
	String info = new String();							
										//Reference variable of student info method
	info +=
	("\n  Name: " + name +
	 "\nCourse: " + courseDesc +
	 "\nNumber: " + courseNum +
	 "\nGrades: "+
	"\n\t    Test: "+ test1 +","+test2+","+test3+
						"\t\tAverage: " +noDecimal.format(average('t'))+
						"\t\tPercent: " +percent.format (getPercent('t'))+
	"\n\t Quizzes: "+ Quiz1 +","+Quiz2+","+Quiz3+","+Quiz4+","+Quiz5)
	
	+("\tAverage: "+noDecimal.format(average('q'))+"\t\tPercent: " + percent.format (getPercent('q')));
	
	info +=("\n\tProjects: "+ proj1 +","+proj2+","+proj3+","+proj4);
	info +=("\t\tAverage: "+noDecimal.format(average('p'))+
			"\t\tPercent: " + percent.format (getPercent('p'))+
			"\n\nCourse Average: " +noDecimal.format(courseAverage ( )));
	return info;
}//End studentInfo()
}//End Student()