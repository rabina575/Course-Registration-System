
/**
 * A class representing Academic Course.
 * Academic Course is used as a subclass of Course.
 * @author (Rabina Shrestha)
 * @version (5.0.0)
 */
public class AcademicCourse extends Course
{
    // Seven Attributes / Instance Variables of Academic Course.
    
    private String LecturerName;
    private String Level;
    private String Credit;
    private String StartingDate;
    private String CompletionDate;
    private int NumberOfAssessments;
    private boolean isRegistered;
    
    /*
     Creating Constructor of Academic Course which has six parameters.
     */
    
    AcademicCourse(String CourseID,String CourseName, int Duration,String Level, String Credit, int NumberOfAssessments)
    {
        super(CourseID, CourseName, Duration);
        this.LecturerName = "";
        this.StartingDate = "";
        this.CompletionDate = "";
        this.Level = Level;
        this.Credit = Credit;
        this.NumberOfAssessments = NumberOfAssessments;
        this.isRegistered = false;
    }
    
    // Using Accessor Method / Getters Method for each attributes.
    
    /*
     Return the Lecturer Name of the Academic Course.
     */
    
    public String getLecturerName()
    {
        return this.LecturerName;
    }
    
    /*
     Return the Level of the Academic Course.
     */
    
    public String getLevel()
    {
        return this.Level;
    }
    
    /*
     Return the Credit of the Academic Course.
     */
    
    public String getCredit()
    {
        return this.Credit;
    }
    
    /*
     Return the Starting Date of the Academic Course.
     */
    
    public String getStartingDate()
    {
        return this.StartingDate;
    }
    
    /*
     Return the Completion Date of the Academic Course.
     */
    
    public String getCompletionDate()
    {
        return CompletionDate;
    }
    
    /*
     Return the Number of Assessments of the Academic Course.
     */
    
    public int getNumberOfAssessments()
    {
        return this.NumberOfAssessments;
    }
    
    /*
     Return the Registered Status of the Academic Course.
     */
    
    public boolean getisRegistered()
    {
        return this.isRegistered;
    }
        
    // Parameter passed to method in order to change and set new Lecturer Name and new Number of Assessments. 
    
    /*
     Set a new Lecturer Name for the Academic Course.
     */
    
    public void setLecturerName(String newLecturerName)
    {
        this.LecturerName = newLecturerName;
    }
    
    /*
     Set a new Number of Assessments for the Academic Course.
     */
    
    public void setNumberOfAssessments(int newNumberOfAssessments)
    {
        this.NumberOfAssessments = newNumberOfAssessments;
    }
    
    
    /* Method used to register any particular academic course.
       Method has four parameters. */ 
     
    /*
     Register the Academic Course.
     */
    
    public void register(String CourseLeader, String LecturerName , String StartingDate, String CompletionDate)
    {
        if (this.isRegistered == true)
        {
            System.out.println("This course is already registered.The details of the course: ");
            System.out.println("Lecturer Name: " + this.LecturerName);
            System.out.println("Starting Date: " + this.StartingDate);
            System.out.println("Completion Date: " + this.CompletionDate);
        }
        else 
        {
            super.setCourseLeader(CourseLeader);
            /* CourseLeader is called from the parent class with course leader name
               as a parameter. */ 
            this.LecturerName = LecturerName;
            this.StartingDate = StartingDate;
            this.CompletionDate = CompletionDate;
            this.isRegistered = true;
        }
    }
    
    /*
     Display the Academic Course details.
     */
    
    public void display()
    {
        super.display();
        /* Calling method in Course class to display 
           CourseID, CourseName, Duration, and CourseLeader. */
        System.out.println("Level: " + getLevel());
        System.out.println("Credit: " + getCredit());
        System.out.println("Number of Assessments: " + getNumberOfAssessments());
        if (this.isRegistered == true)
        {
            System.out.println("Lecturer Name: " + getLecturerName());            
            System.out.println("Starting Date: " + getStartingDate());
            System.out.println("Completion Date: " + getCompletionDate());
        }
    }
}