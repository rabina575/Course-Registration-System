
/**
 * A course class represents a real world course.
 * Course is used as an abstract superclass of:
 * Academic Course and Non Academic Course.
 * @author (Rabina Shrestha)
 * @version (5.0.0)
 */
public class Course
{
    //Four Attributes / Instance Variables of Course Class.
    
    private String CourseID;
    private String CourseName;
    private String CourseLeader;
    private int Duration;    
    
    /*
     Creating Constructor of Course with CourseID, Name, and Duration.
     */
    
    Course(String CourseID, String CourseName, int Duration)
    {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.CourseLeader = "";
        this.Duration = Duration;
    }
    
    // Using Accessor Method / Getters Method for each attributes.
    
    /*
     Return the Course ID of the Course.
     */
    
    public String getCourseID()
    {
        return this.CourseID;        
    }
    
    /*
     Return the Course Name of the Course.
     */
    
    public String getCourseName()
    {
        return this.CourseName;
    }
    
    /*
     Return the Course Leader of the Course.
     */
    
    public String getCourseLeader()
    {
        return this.CourseLeader;
    }
    
    /*
     Return the Duration of the Course.
     */
    
    public int getDuration()
    {
        return this.Duration;
    }
    
    // Parameter passed to method in order to set a new name as the Course Leader.
    
    /*
     Set a new Course Leader for the Course.
     */
    
    public void setCourseLeader(String newCourseLeader)
    {
        this.CourseLeader = newCourseLeader;
    }
    
    /*
     Display the Course details and Course Leader if assigned.
     */
    
    public void display()
    {
        System.out.println("Course ID: " + getCourseID());
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Duration: " + getDuration());         
        if (CourseLeader != "")
        {
            System.out.println("Course Leader: " + getCourseLeader());
        }
    }
}


