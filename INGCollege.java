
/**
 * INGCollege class represents the GUI of Course.
 *
 * @author (Rabina Shrestha)
 * @version (5.0.0)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class INGCollege implements ActionListener 
{
    /* Declaring Instance Variables.
       ArrayList */  
    private ArrayList<Course> list_Course = new ArrayList<Course>();
    private AcademicCourse AcademicObject;
    private NonAcademicCourse NonAcademicObject;
       
    // JFrame and JPanel
    private JFrame frame;
    private JPanel panel, panel_Academic, panel_addAC, panel_registerAC, panel_NonAcademic, panel_addNAC, panel_registerNAC;
    
    //Course JLabel and JButton
    private JLabel label_CourseForm;
    private JButton button_clickAC, button_clickNAC;
    
    /* Academic Course.
       1. JLabel */
    private JLabel label_AcademicCourse, label_CourseID, label_CourseName, label_Duration, label_Level, label_Credit, label_NoOfAssessment,
            label_ACregisterID, label_CourseLeader, label_LecturerName, label_ACStartDate, label_ACEndDate;
            
    //2. JTextField
    private JTextField field_ID, field_CName, field_Duration, field_Level, field_Credit, field_NoOfAssessment, field_ACregisterID,
            field_ACLeader, field_LName;
            
    //3. JComboBox
    private JComboBox box_ACYear1, box_ACMonth1, box_ACDay1, box_ACYear2, box_ACMonth2, box_ACDay2; 
    
    //4. JButton
    private JButton button_addAC, button_registerAC, button_Display;  
    
    //5. String Dates
    private String ACStartingDate, ACCompletionDate;
    
    /* Non-Academic Course.
       1. JLabel */
    private JLabel label_NonAcademicCourse, label_NACourseID, label_NACourseName, label_NADuration, label_Prerequisite, label_NACregisterID,
            label_NACourseLeader, label_InstructorName, label_NACStartDate, label_NACEndDate, label_ExamDate;
            
    //2. JTextField
    private JTextField fieldNA_ID, fieldNA_CName, field_NADuration, field_Prerequisite, field_NACregisterID, field_NACLeader, field_IName;
    
    //3. JComboBox    
    private JComboBox box_NACYear1, box_NACMonth1, box_NACDay1, box_NACYear2, box_NACMonth2, box_NACDay2, box_NACYear3, box_NACMonth3, box_NACDay3;
    
    //4. JButton
    private JButton button_addNAC, button_RemoveNAC, button_registerNAC, button_NADisplay;
    
    //5. String Dates
    private String NACStartingDate, NACCompletionDate, ExamDate;
    
    //Clear JButton.
    private JButton button_Clear;
    
    //For main method
    static INGCollege main = new INGCollege();    
    
    //Method for GUI 
    public void gUI()
    {
        frame = new JFrame();
        panel = new JPanel();
        
        /* Panels used for Academic Course(AC).
           Academic, addAC, registerAC */
        panel_Academic = new JPanel();
        panel_addAC = new JPanel();
        panel_registerAC = new JPanel();
        
        /* Panels used for Non-Academic Course(NAC).
           NonAcademic, addNAC, registerNAC */
        panel_NonAcademic = new JPanel();
        panel_addNAC = new JPanel();
        panel_registerNAC = new JPanel();
        
        //Layout and Bounds of panels.            
        panel.setLayout(null);        
        //Academic
        panel_Academic.setBounds(32,115,772,372);
        panel_Academic.setLayout(null);
        panel_addAC.setBounds(42,155,370,320);
        panel_addAC.setLayout(null);        
        panel_registerAC.setBounds(425,155,370,320);
        panel_registerAC.setLayout(null);
        //Non-Academic
        panel_NonAcademic.setBounds(32,115,772,372);
        panel_NonAcademic.setLayout(null);
        panel_addNAC.setBounds(42,155,370,320);
        panel_addNAC.setLayout(null);        
        panel_registerNAC.setBounds(425,155,370,320);
        panel_registerNAC.setLayout(null);
        
        /* Colors used for Background and Border.
           1.Background */
        Color color_bg =  new Color(188, 235, 253);
        panel.setBackground(color_bg);
        //Academic
        panel_Academic.setBackground(color_bg);
        panel_addAC.setBackground(Color.WHITE);
        panel_registerAC.setBackground(Color.WHITE);
        //Non Academic
        panel_NonAcademic.setBackground(color_bg);
        panel_addNAC.setBackground(Color.WHITE);
        panel_registerNAC.setBackground(Color.WHITE);
        
        // 2. Border
        Color color_line = new Color(119, 202, 236);
        panel_Academic.setBorder(BorderFactory.createLineBorder(color_line));
        panel_NonAcademic.setBorder(BorderFactory.createLineBorder(color_line));
        
        //Main Heading
        label_CourseForm = new JLabel("Course Registration Form");
        label_CourseForm.setBounds(300,20,250,30);
        Font font_titles = new Font("Maiandra GD", Font.BOLD, 20);
        label_CourseForm.setFont(font_titles);
        
        /* Color used for:
           Text and Button */
        Color color_Courseform = new Color(8, 170, 236);
        Color color_Button = new Color(27, 187, 252);
        label_CourseForm.setForeground(color_Courseform);
        panel.add(label_CourseForm);
        
        //Font for buttons
        Font font_button = new Font("Sitka Heading", Font.BOLD, 15);
        Font font_buttonInside = new Font("Sitka Heading", Font.BOLD, 16);
        
        //JButton for Academic Course                
        button_clickAC = new JButton("Click here for Academic Course.");
        button_clickAC.setBounds(32,70,300,27); 
        button_clickAC.setFont(font_button);
        button_clickAC.setBackground(Color.WHITE);        
        button_clickAC.setForeground(color_Button);
        button_clickAC.addActionListener(this);
        panel.add(button_clickAC);
        
        //JButton for Non-Academic Course 
        button_clickNAC = new JButton("Click here for Non-Academic Course.");
        button_clickNAC.setBounds(504,70,300,27); 
        button_clickNAC.setFont(font_button);
        button_clickNAC.setBackground(Color.WHITE);
        button_clickNAC.setForeground(color_Button);
        button_clickNAC.addActionListener(this);
        panel.add(button_clickNAC);
        
        /* Start of Academic Course.
           JLabel Academic Course*/
        label_AcademicCourse = new JLabel("Academic Course");
        label_AcademicCourse.setBounds(307,5,250,30);
        label_AcademicCourse.setFont(font_titles);
        panel_Academic.add(label_AcademicCourse);  
                
        //Border for Add Academic Course and Register Academic Course.
        panel_addAC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_registerAC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        //Font for JLabel Form 
        Font font_form = new Font("Maiandra GD", Font.BOLD, 15);
        Font font_formextra = new Font("Maiandra GD", Font.BOLD, 13);
        
        /* Add Academic Course:
           JLabel and JTextField for Add Academic Course ID */        
        label_CourseID = new JLabel("Course ID: ");
        label_CourseID.setBounds(15,10,135,20);        
        label_CourseID.setFont(font_form);
        panel_addAC.add(label_CourseID);
        
        field_ID = new JTextField();
        field_ID.setBounds(160, 10, 195, 27);        
        field_ID.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addAC.add(field_ID);
            
        //JLabel and JTextField for Academic Course Name
        label_CourseName = new JLabel("Course Name: ");
        label_CourseName.setBounds(15,52,135,20);        
        label_CourseName.setFont(font_form);
        panel_addAC.add(label_CourseName);
        
        field_CName = new JTextField();
        field_CName.setBounds(160, 50, 195, 27);
        field_CName.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addAC.add(field_CName);
        
        //JLabel and JTextField for Academic Course Duration
        label_Duration = new JLabel("Duration: ");
        label_Duration.setBounds(15,92,135,20);        
        label_Duration.setFont(font_form);
        panel_addAC.add(label_Duration);
        
        field_Duration = new JTextField();
        field_Duration.setBounds(160, 90, 195, 27);
        field_Duration.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addAC.add(field_Duration);
        
        //JLabel and JTextField for Level
        label_Level = new JLabel("Level: ");
        label_Level.setBounds(15,132,135,20);        
        label_Level.setFont(font_form);
        panel_addAC.add(label_Level);
        
        field_Level = new JTextField();
        field_Level.setBounds(160, 130, 195, 27);
        field_Level.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addAC.add(field_Level);
        
        //JLabel and JTextField for Credit
        label_Credit = new JLabel("Credit: ");
        label_Credit.setBounds(15,172,135,20);        
        label_Credit.setFont(font_form);
        panel_addAC.add(label_Credit);
        
        field_Credit = new JTextField();
        field_Credit.setBounds(160, 170, 195, 27);
        field_Credit.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addAC.add(field_Credit);
        
        //JLabel and JTextField for Number Of Assessment
        label_NoOfAssessment = new JLabel("No. Of Assessment: ");
        label_NoOfAssessment.setBounds(15,212,135,20);        
        label_NoOfAssessment.setFont(font_formextra);
        panel_addAC.add(label_NoOfAssessment);
        
        field_NoOfAssessment = new JTextField();
        field_NoOfAssessment.setBounds(160, 210, 195, 27);
        field_NoOfAssessment.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addAC.add(field_NoOfAssessment);
        
        //JButton to Add Academic Course
        button_addAC = new JButton("Add Academic Course");
        button_addAC.setBounds(57,260,260,35);
        button_addAC.setFont(font_buttonInside);
        button_addAC.setBackground(Color.WHITE);
        button_addAC.setForeground(color_line);
        button_addAC.addActionListener(this);
        panel_addAC.add(button_addAC);
        
        /* Register Academic Course:
           JLabel and JTextField to Register Academic Course ID */
        label_ACregisterID = new JLabel("Course ID: ");
        label_ACregisterID.setBounds(15,10,135,20);        
        label_ACregisterID.setFont(font_form);
        label_ACregisterID.setForeground(color_line);
        panel_registerAC.add(label_ACregisterID);
        
        field_ACregisterID = new JTextField();
        field_ACregisterID.setBounds(160, 10, 195, 27);        
        panel_registerAC.add(field_ACregisterID);
        
        //JLabel and JTextField for Academic Course Leader
        label_CourseLeader = new JLabel("Course Leader: ");
        label_CourseLeader.setBounds(15,52,135,20);        
        label_CourseLeader.setFont(font_form);
        label_CourseLeader.setForeground(color_line);
        panel_registerAC.add(label_CourseLeader);
        
        field_ACLeader = new JTextField();
        field_ACLeader.setBounds(160, 50, 195, 27);        
        panel_registerAC.add(field_ACLeader);
        
        //JLabel and JTextField for Academic Course Lecturer Name
        label_LecturerName = new JLabel("Lecturer Name: ");
        label_LecturerName.setBounds(15,92,135,20);        
        label_LecturerName.setFont(font_form);
        label_LecturerName.setForeground(color_line);
        panel_registerAC.add(label_LecturerName);
        
        field_LName = new JTextField();
        field_LName.setBounds(160, 90, 195, 27);
        panel_registerAC.add(field_LName);
        
        /*JLabel and JComboBox for Academic Course 
          1. Starting Date*/
        label_ACStartDate = new JLabel("Starting Date: ");
        label_ACStartDate.setBounds(15,132,135,20);        
        label_ACStartDate.setFont(font_form);
        label_ACStartDate.setForeground(color_line);
        panel_registerAC.add(label_ACStartDate);
                
        //Font for JComboBox 
        Font font_box = new Font("Maiandra GD", Font.BOLD, 12);
        
        //For Year to start from 2020 - 2030.
        Integer yeardate[] = new Integer[11];
        int year = 2020;
        for(int i = 0; i <=10; i++)
        {
            yeardate[i]=year;
            year++;
        }
        
        //JComboBox Year
        box_ACYear1 = new JComboBox(yeardate);
        box_ACYear1.setBounds(160, 130, 60, 27);
        box_ACYear1.setFont(font_box);
        box_ACYear1.setBackground(Color.WHITE);
        panel_registerAC.add(box_ACYear1);
        
        //Months in a Year.
        String months[] = {"January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"};
            
        //JComboBox Month
        box_ACMonth1 = new JComboBox(months);
        box_ACMonth1.setBounds(221, 130, 88, 27);
        box_ACMonth1.setFont(font_box);
        box_ACMonth1.setBackground(Color.WHITE);
        panel_registerAC.add(box_ACMonth1);
        
        //Days in a month.
        Integer day[] = new Integer[31];
        for(int i = 0; i < 31; i++)
        {
            day[i] = i+1;
        }    
        
        //JComboBox Date
        box_ACDay1= new JComboBox(day);
        box_ACDay1.setBounds(310, 130, 44, 27);
        box_ACDay1.setFont(font_box);
        box_ACDay1.setBackground(Color.WHITE);
        panel_registerAC.add(box_ACDay1);
        
        //2. Completion Date
        label_ACEndDate = new JLabel("Completion Date: ");
        label_ACEndDate.setBounds(15,172,135,20);        
        label_ACEndDate.setFont(font_form);
        label_ACEndDate.setForeground(color_line);
        panel_registerAC.add(label_ACEndDate);
        
        //JComboBox Year Month & Date.
        box_ACYear2 = new JComboBox(yeardate);
        box_ACYear2.setBounds(160, 170, 60, 27);
        box_ACYear2.setFont(font_box);
        box_ACYear2.setBackground(Color.WHITE);
        panel_registerAC.add(box_ACYear2);
        
        box_ACMonth2 = new JComboBox(months);
        box_ACMonth2.setBounds(221, 170, 88, 27);
        box_ACMonth2.setFont(font_box);
        box_ACMonth2.setBackground(Color.WHITE);
        panel_registerAC.add(box_ACMonth2);
        
        box_ACDay2 = new JComboBox(day);
        box_ACDay2.setBounds(310, 170, 44, 27);
        box_ACDay2.setFont(font_box);
        box_ACDay2.setBackground(Color.WHITE);
        panel_registerAC.add(box_ACDay2);
        
        //JButton to Register Academic Course
        button_registerAC = new JButton("Register Academic Course");
        button_registerAC.setBounds(57,260,260,35);
        button_registerAC.setFont(font_buttonInside);
        button_registerAC.setBackground(Color.WHITE);
        button_registerAC.setBorder(BorderFactory.createLineBorder(color_line));
        button_registerAC.addActionListener(this);
        panel_registerAC.add(button_registerAC); 
        
        //JButton to Display Academic Course
        button_Display = new JButton("Display");
        button_Display.setBounds(595,505,100,30);
        button_Display.setFont(font_button);
        button_Display.setBackground(Color.WHITE);
        button_Display.setBorder(BorderFactory.createLineBorder(color_line));
        button_Display.addActionListener(this);
        panel.add(button_Display);
        
        /* Start of Non-Academic Course.
           JLabel Non-Academic Course*/
        label_NonAcademicCourse = new JLabel("Non-Academic Course");
        label_NonAcademicCourse.setBounds(280,5,250,30);
        label_NonAcademicCourse.setFont(font_titles);
        panel_NonAcademic.add(label_NonAcademicCourse);
        
        //Border for Add Academic Course and Register Academic Course.
        panel_addNAC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_registerNAC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        /* Add Non-Academic Course:
           JLabel and JTextField for Add Non-Academic Course ID */
        label_NACourseID = new JLabel("Course ID: ");
        label_NACourseID.setBounds(15,10,135,20);        
        label_NACourseID.setFont(font_form);
        panel_addNAC.add(label_NACourseID);
                
        fieldNA_ID = new JTextField();
        fieldNA_ID.setBounds(160, 10, 195, 27);
        fieldNA_ID.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addNAC.add(fieldNA_ID);
              
        //JLabel and JTextField for Non Academic Course Name
        label_NACourseName = new JLabel("Course Name: ");
        label_NACourseName.setBounds(15,52,135,20);        
        label_NACourseName.setFont(font_form);
        panel_addNAC.add(label_NACourseName);
        
        fieldNA_CName = new JTextField();
        fieldNA_CName.setBounds(160, 50, 195, 27);
        fieldNA_CName.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addNAC.add(fieldNA_CName);
        
        //JLabel and JTextField for Non Academic Course Duration
        label_NADuration = new JLabel("Duration: ");
        label_NADuration.setBounds(15,92,135,20);        
        label_NADuration.setFont(font_form);
        panel_addNAC.add(label_NADuration);
        
        field_NADuration = new JTextField();
        field_NADuration.setBounds(160, 90, 195, 27);
        field_NADuration.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addNAC.add(field_NADuration);
        
        //JLabel and JTextField for Prerequisite
        label_Prerequisite = new JLabel("Prerequisite: ");
        label_Prerequisite.setBounds(15,132,135,20);        
        label_Prerequisite.setFont(font_form);
        panel_addNAC.add(label_Prerequisite);
        
        field_Prerequisite = new JTextField();
        field_Prerequisite.setBounds(160, 130, 195, 27);
        field_Prerequisite.setBorder(BorderFactory.createLineBorder(color_line));
        panel_addNAC.add(field_Prerequisite);
        
        //JButton to Add Non-Academic Course
        button_addNAC = new JButton("Add Non-Academic Course");
        button_addNAC.setBounds(57,195,260,35); 
        button_addNAC.setFont(font_buttonInside);
        button_addNAC.setBackground(Color.WHITE);
        button_addNAC.setForeground(color_line);
        button_addNAC.addActionListener(this);
        panel_addNAC.add(button_addNAC);
        
        //JButton to Remove Non-Academic Course
        button_RemoveNAC = new JButton("Remove Course");
        button_RemoveNAC.setBounds(57,260,260,35);
        button_RemoveNAC.setFont(font_buttonInside);
        button_RemoveNAC.setBackground(Color.WHITE);
        button_RemoveNAC.setForeground(color_line); 
        button_RemoveNAC.addActionListener(this);
        panel_addNAC.add(button_RemoveNAC);
        
        /* Register Non Academic Course:
           JLabel and JTextField to Register Non-Academic Course ID */
        label_NACregisterID = new JLabel("Course ID: ");
        label_NACregisterID.setBounds(15,10,135,20);        
        label_NACregisterID.setFont(font_form);
        label_NACregisterID.setForeground(color_line);
        panel_registerNAC.add(label_NACregisterID);
        
        field_NACregisterID = new JTextField();
        field_NACregisterID.setBounds(160, 10, 195, 27);        
        panel_registerNAC.add(field_NACregisterID);
        
        //JLabel and JTextField for Non Academic Course Leader
        label_NACourseLeader = new JLabel("Course Leader: ");
        label_NACourseLeader.setBounds(15,52,135,20);        
        label_NACourseLeader.setFont(font_form);
        label_NACourseLeader.setForeground(color_line);
        panel_registerNAC.add(label_NACourseLeader);
        
        field_NACLeader = new JTextField();
        field_NACLeader.setBounds(160, 50, 195, 27);        
        panel_registerNAC.add(field_NACLeader);
        
        //JLabel and JTextField for Non Academic Course Instructor Name
        label_InstructorName = new JLabel("Instructor Name: ");
        label_InstructorName.setBounds(15,92,135,20);        
        label_InstructorName.setFont(font_form);
        label_InstructorName.setForeground(color_line);
        panel_registerNAC.add(label_InstructorName);
        
        field_IName = new JTextField();
        field_IName.setBounds(160, 90, 195, 27);
        panel_registerNAC.add(field_IName);
        
        /*JLabel and JComboBox for Non Academic Course 
          1. Starting Date*/
        label_NACStartDate = new JLabel("Starting Date: ");
        label_NACStartDate.setBounds(15,132,135,20);        
        label_NACStartDate.setFont(font_form);
        label_NACStartDate.setForeground(color_line);
        panel_registerNAC.add(label_NACStartDate);
        
        //JComboBox Year
        box_NACYear1 = new JComboBox(yeardate);
        box_NACYear1.setBounds(160, 130, 60, 27);
        box_NACYear1.setFont(font_box);
        box_NACYear1.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACYear1);
        
        //JComboBox Month
        box_NACMonth1 = new JComboBox(months);
        box_NACMonth1.setBounds(221, 130, 88, 27);
        box_NACMonth1.setFont(font_box);
        box_NACMonth1.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACMonth1);
        
        //JComboBox Date
        box_NACDay1 = new JComboBox(day);
        box_NACDay1.setBounds(310, 130, 44, 27);
        box_NACDay1.setFont(font_box);
        box_NACDay1.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACDay1);
        
        //2. Completion Date
        label_NACEndDate = new JLabel("Completion Date: ");
        label_NACEndDate.setBounds(15,172,135,20);        
        label_NACEndDate.setFont(font_form);
        label_NACEndDate.setForeground(color_line);
        panel_registerNAC.add(label_NACEndDate);
        
        //JComboBox Year Month & Date
        box_NACYear2 = new JComboBox(yeardate);
        box_NACYear2.setBounds(160, 170, 60, 27);
        box_NACYear2.setFont(font_box);
        box_NACYear2.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACYear2);
        
        box_NACMonth2 = new JComboBox(months);
        box_NACMonth2.setBounds(221, 170, 88, 27);
        box_NACMonth2.setFont(font_box);
        box_NACMonth2.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACMonth2);
        
        box_NACDay2 = new JComboBox(day);
        box_NACDay2.setBounds(310, 170, 44, 27);
        box_NACDay2.setFont(font_box);
        box_NACDay2.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACDay2);
        
        //3. Exam Date
        label_ExamDate = new JLabel("Exam Date: ");
        label_ExamDate.setBounds(15,208,135,20);        
        label_ExamDate.setFont(font_form);
        label_ExamDate.setForeground(color_line);
        panel_registerNAC.add(label_ExamDate);
        
        //JComboBox Year Month & Date
        box_NACYear3 = new JComboBox(yeardate);
        box_NACYear3.setBounds(160, 210, 60, 27);
        box_NACYear3.setFont(font_box);
        box_NACYear3.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACYear3);
        
        box_NACMonth3 = new JComboBox(months);
        box_NACMonth3.setBounds(221, 210, 88, 27);
        box_NACMonth3.setFont(font_box);
        box_NACMonth3.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACMonth3);
        
        box_NACDay3 = new JComboBox(day);
        box_NACDay3.setBounds(310, 210, 44, 27);
        box_NACDay3.setFont(font_box);
        box_NACDay3.setBackground(Color.WHITE);
        panel_registerNAC.add(box_NACDay3);
        
        //JButton to Register Non Academic Course
        button_registerNAC = new JButton("Register Non-Academic Course");
        button_registerNAC.setBounds(57,260,260,35);
        button_registerNAC.setFont(font_buttonInside);
        button_registerNAC.setBackground(Color.WHITE);
        button_registerNAC.setBorder(BorderFactory.createLineBorder(color_line));
        button_registerNAC.addActionListener(this);
        panel_registerNAC.add(button_registerNAC);        
         
        //JButton to Display Non-Academic Course
        button_NADisplay = new JButton("Display");
        button_NADisplay.setBounds(595,505,100,30);
        button_NADisplay.setFont(font_button);
        button_NADisplay.setBackground(Color.WHITE);
        button_NADisplay.setBorder(BorderFactory.createLineBorder(color_line));
        button_NADisplay.addActionListener(this);
        panel.add(button_NADisplay);
        
        //JButton to Clear
        button_Clear = new JButton("Clear");
        button_Clear.setBounds(704,505,100,30); 
        button_Clear.setFont(font_button);
        button_Clear.setBackground(Color.WHITE);
        button_Clear.setBorder(BorderFactory.createLineBorder(color_line));
        button_Clear.addActionListener(this);
        panel.add(button_Clear);   
        
        //Setting Non-Academic Course's Course Visibility to false
        button_NADisplay.setVisible(false);
        panel_addNAC.setVisible(false);
        panel_registerNAC.setVisible(false);
        panel_NonAcademic.setVisible(false);
        
        //Adding panel to frame
        frame.add(panel_addAC);
        frame.add(panel_registerAC);
        frame.add(panel_Academic);
        frame.add(panel_addNAC);
        frame.add(panel_registerNAC);
        frame.add(panel_NonAcademic);          
        frame.add(panel);        
        
        //Bounds, Title, Resizability and Visibility of the Frame.
        frame.setBounds(345,132,850,595);
        frame.setTitle("Course Registration Form");
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    //Main Method to call GUI.
    public static void main(String[] args)
    {
        main.gUI();
    }
    
    /* Using Accessor Method / Getters Method for Academic Course.
       1. Add Academic Course*/
    
    public String getACourseID()
    {
        return this.field_ID.getText();
    }
    
    public String getACourseName()
    {
        return this.field_CName.getText();
    }
    
    public int getACDuration()
    {
        return Integer.parseInt(this.field_Duration.getText());        
    }
    
    public String getLevel()
    {
        return this.field_Level.getText();
    }
    
    public String getCredit()
    {
        return this.field_Credit.getText();
    }
    
    public int getNoOfAssessment()
    {
        return Integer.parseInt(this.field_NoOfAssessment.getText());        
    }
    
    //2. Register Academic Course
    
    public String getACourseRegisterID()
    {
        return this.field_ACregisterID.getText();
    }
    
    public String getACourseLeader()
    {
        return this.field_ACLeader.getText();
    }
    
    public String getACLecturerName()
    {
        return this.field_LName.getText();
    }
    
    public String getACStartDate()
    {
        ACStartingDate = box_ACYear1.getSelectedItem()+ " " + box_ACMonth1.getSelectedItem()+ " " + box_ACDay1.getSelectedItem();
        return ACStartingDate;
    }
        
    public String getACCompleteDate()
    {
        ACCompletionDate = box_ACYear2.getSelectedItem()+ " " + box_ACMonth2.getSelectedItem()+ " " + box_ACDay2.getSelectedItem();
        return ACCompletionDate;
    }
    
    /* Using Accessor Method / Getters Method for Non Academic Course.
       1. Add Non Academic Course*/
    
    public String getNACourseID()
    {
        return this.fieldNA_ID.getText();
    }
        
    public String getNACourseName()
    {
        return this.fieldNA_CName.getText();
    }
    
    public int getNACDuration()
    {
        return Integer.parseInt(this.field_NADuration.getText());        
    }
    
    public String getPrerequisite()
    {
        return this.field_Prerequisite.getText();
    }
    
    //2. Register Non Academic Course
    
    public String getNACourseRegisterID()
    {
        return this.field_NACregisterID.getText();
    }
    
    public String getNACourseLeader()
    {
        return this.field_NACLeader.getText();
    }
      
    public String getInstructorName()
    {
        return this.field_IName.getText();
    }
        
    public String getNACStartDate()
    {
        NACStartingDate = box_NACYear1.getSelectedItem()+ " " + box_NACMonth1.getSelectedItem()+ " " + box_NACDay1.getSelectedItem();
        return NACStartingDate;
    }
        
    public String getNACCompleteDate()
    {
        NACCompletionDate = box_NACYear2.getSelectedItem().toString()+ " " + box_NACMonth2.getSelectedItem()+ " " + box_NACDay2.getSelectedItem();
        return NACCompletionDate;
    }
    
    public String getExamDate()
    {
        ExamDate = box_NACYear3.getSelectedItem()+ " " + box_NACMonth3.getSelectedItem()+ " " + box_NACDay3.getSelectedItem();
        return ExamDate;
    }
    
    //Implementing actionPerformed method.
    public void actionPerformed(ActionEvent e)
    {
        /* Changes to Academic Course panel when the button is clicked.
           1. Set Visible as true for Academic Components.
           2. Set Visible as false for Non Academic Components. */
        if(e.getSource() == button_clickAC)
        {
            button_Display.setVisible(true);
            panel_addAC.setVisible(true);
            panel_registerAC.setVisible(true);
            panel_Academic.setVisible(true);
            
            button_NADisplay.setVisible(false);
            panel_addNAC.setVisible(false);
            panel_registerNAC.setVisible(false);
            panel_NonAcademic.setVisible(false);            
        }
        
        /* Changes to Non-Academic Course panel when the button is clicked.
           1. Set Visibile as true for Non Academic Components. 
           2. Set Visible as false for Academic Components. */
        else if(e.getSource() == button_clickNAC)
        {           
            button_NADisplay.setVisible(true);
            panel_addNAC.setVisible(true);
            panel_registerNAC.setVisible(true);
            panel_NonAcademic.setVisible(true);
            
            button_Display.setVisible(false);
            panel_addAC.setVisible(false);
            panel_registerAC.setVisible(false);
            panel_Academic.setVisible(false);          
        }
        
        /* ACADEMIC COURSE BUTTONS.
           Adds Academic Course when the button is clicked. 
           1. Makes sure that none of the fields are left empty.
           2. If the Course ID has already been added an error message pops up.
           3. Checks if the user has entered correct integer value in Duration and Assessment field.
           4. Adds the Academic Course after checking. */        
        else if(e.getSource() == button_addAC)
        {
            int count = 0;
            int count2 = 0;
            if (getACourseID().equals("") || getACourseName().equals("") || getLevel().equals("") || getCredit().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please ensure that all fields are filled.","ATTENTION!", JOptionPane.ERROR_MESSAGE);
                count = 1;
            }
            if (count == 0)
            {
                for (Course alist: list_Course)
                {
                    if (getACourseID().equals(alist.getCourseID()))
                    {
                        JOptionPane.showMessageDialog(frame, "The Course ID: " + getACourseID() +"\n"+ " with Course Name: " + getACourseName() + 
                                                      "\n"+" has already been added.","ATTENTION!", JOptionPane.ERROR_MESSAGE);
                        count2 = 1;
                        break;
                    }
                }
                try               
                {
                    Integer.parseInt(this.field_Duration.getText());
                    try               
                    {
                        Integer.parseInt(this.field_NoOfAssessment.getText());
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(frame, "The Assessment must be an integer number.","ATTENTION!", JOptionPane.ERROR_MESSAGE);   
                        count2 = 1;
                    }
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(frame, "The Duration must be an integer number.","ATTENTION!", JOptionPane.ERROR_MESSAGE);    
                    count2 = 1;                    
                }           
                if (count2 == 0)            
                {
                    JOptionPane.showMessageDialog(frame, "The following values has been added \n"+ "Course ID: " + getACourseID() + "\n" +
                                                  "Course Name: " + getACourseName() + "\n"+ "Duration: " + getACDuration() + "\n" + 
                                                  "Level: " + getLevel() + "\n"+ "Credit: " + getCredit() + "\n"+"No. Of Assessment: " +
                                                   getNoOfAssessment()+"\n" + "to Academic Course.");                    
                    AcademicObject = new AcademicCourse(getACourseID(), getACourseName(), getACDuration(), getLevel(), getCredit(), getNoOfAssessment());
                    list_Course.add(AcademicObject);
                }
            }
        }
        
        /* Register Academic Course when the Button is clicked.
           1. Makes sure that none of the fields are left empty.
           2. Checks if the Course is already registered.
           3. Registers the Academic Course after checking.
           4. If the Course ID doesn't match an error message pops up. */
        else if(e.getSource() == button_registerAC)
        {
            int count = 0;
            if (getACourseRegisterID().equals("") || getACourseLeader().equals("") || getACLecturerName().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please ensure that all fields are filled.","ATTENTION!", JOptionPane.ERROR_MESSAGE);
                count = 1;
            }
            if (count == 0) 
            {
                for (Course alist: list_Course)
                {
                    if (getACourseRegisterID().equals(alist.getCourseID()) && alist instanceof AcademicCourse)
                    {
                        AcademicCourse AcademicObject = (AcademicCourse) alist;
                        count = 1;
                        if (AcademicObject.getisRegistered() == true)
                        {
                            JOptionPane.showMessageDialog(frame, "This course is already registered.");
                            count = 1;
                        }
                        else if (AcademicObject.getisRegistered() == false)
                        {
                            AcademicObject.register(getACourseLeader(), getACLecturerName(), getACStartDate() ,getACCompleteDate());
                            JOptionPane.showMessageDialog(frame, "The Academic Course has been registered. \n"
                                                          + "Course ID: " + getACourseRegisterID() + "\n"
                                                          + "Course Leader: " + getACourseLeader() + "\n"                                              
                                                          + "Lecturer Name: " + getACLecturerName() + "\n"
                                                          + "Starting Date: " + getACStartDate() + "\n"
                                                          + "Completion Date: " + getACCompleteDate());                            
                            count = 1;
                        }
                    }
                }
            }
            if (count == 0)
            {
                JOptionPane.showMessageDialog(frame, "Course ID does not match. Please enter the correct value.", "ATTENTION!", JOptionPane.WARNING_MESSAGE);
            }
        }        
             
        //Display Academic Course details when the Button is clicked.
        else if(e.getSource() == button_Display)
        {
            for (Course alist: list_Course)
            {
                if (alist instanceof AcademicCourse)
                {
                    AcademicCourse AcademicObject = (AcademicCourse) alist;
                    System.out.println("");
                    AcademicObject.display();                    
                }
            }
        }
        
        /* NON-ACADEMIC COURSE BUTTONS.
           Add Non Academic Course when the button is clicked.
           1. Makes sure that none of the fields are left empty.
           2. If the Course ID has already been added an error message pops up.
           3. Checks if the user has entered correct integer value in Duration field.
           4. Adds the Non Academic Course after checking.*/
        else if(e.getSource() == button_addNAC)
        {
            int count = 0;
            int count2 = 0;
            if (getNACourseID().equals("") || getNACourseName().equals("") || getPrerequisite().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please ensure that all fields are filled.","ATTENTION!", JOptionPane.ERROR_MESSAGE);
                count = 1;
            }
            if (count == 0)
            {
                for (Course alist: list_Course)
                {
                    if (getNACourseID().equals(alist.getCourseID()))
                    {
                        JOptionPane.showMessageDialog(frame, "The Course ID: " + getNACourseID() + "\n"+ " with Course Name: " + getNACourseName() + 
                                                      "\n"+" has already been added.","ATTENTION!", JOptionPane.ERROR_MESSAGE);
                        count2 = 1;
                        break;
                    }
                }
                try               
                {
                    Integer.parseInt(this.field_NADuration.getText());
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(frame, "The Duration must be an integer number.","ATTENTION!", JOptionPane.ERROR_MESSAGE);   
                    count2 = 1;
                }
                if (count2 == 0)            
                {
                    JOptionPane.showMessageDialog(frame, "The following values has been added \n"+ "Course ID: " + getNACourseID() + "\n"+ 
                                                  "Course Name: " + getNACourseName() + "\n"+ "Duration: " + getNACDuration() + "\n" + 
                                                  "Prerequisite: " + getPrerequisite() + "\n" + "to Non-Academic Course.");                                      
                    NonAcademicObject = new NonAcademicCourse(getNACourseID(), getNACourseName(), getNACDuration(), getPrerequisite());
                    list_Course.add(NonAcademicObject);
                }
            }        
        }
        
        /* Register Non-Academic Course when the Button is clicked.
           1. Makes sure that none of the fields are left empty.
           2. Checks if the Course is already registered.
           3. Registers the Non Academic Course after checking.
           4. If the Course ID doesn't match an error message pops up. */
        else if(e.getSource() == button_registerNAC)
        {
            int count = 0;
            if (getNACourseRegisterID().equals("") || getNACourseLeader().equals("") || getInstructorName().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please ensure that all fields are filled.","ATTENTION!", JOptionPane.ERROR_MESSAGE);
                count = 1;
            }
            if (count == 0)
            {
                for (Course alist: list_Course)
                {
                    if (getNACourseRegisterID().equals(alist.getCourseID()) && alist instanceof NonAcademicCourse)
                    {
                        NonAcademicCourse NonAcademicObject = (NonAcademicCourse) alist;
                        count = 1;
                        if (NonAcademicObject.getisRegistered() == true)
                        {
                            JOptionPane.showMessageDialog(frame, "This course is already registered.");
                            count = 1;
                        }
                        else if (NonAcademicObject.getisRegistered() == false)
                        {
                            NonAcademicObject.register(getNACourseLeader(), getInstructorName(), getNACStartDate() ,getNACCompleteDate(),
                                                       getExamDate());
                            JOptionPane.showMessageDialog(frame, "The Non-Academic Course has been registered. \n"
                                                          + "Course ID: " + getNACourseRegisterID() + "\n"
                                                          + "Course Leader: " + getNACourseLeader() + "\n"
                                                          + "InstructorName: " + getInstructorName() + "\n"                                              
                                                          + "Starting Date: " + getNACStartDate() + "\n"
                                                          + "Completion Date: " + getNACCompleteDate() + "\n"
                                                          + "Exam Date: " + getExamDate());
                            count = 1;
                        }
                    }
                }
            }
            if (count == 0)
            {
                JOptionPane.showMessageDialog(frame, "Course ID does not match. Please enter the correct value.", "ATTENTION!", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        /* Remove Non-Academic Course when the Button is clicked.
           1. Checks the Course ID.
           2. If isRemoved is false, it removes the course.
           3. If it has already been removed an error message pops up.*/
        else if(e.getSource() == button_RemoveNAC)
        {
            int count = 0;
            if (getNACourseID().equals("") || getNACourseRegisterID().equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Please ensure that all fields are filled.","ATTENTION!", JOptionPane.ERROR_MESSAGE);
                count = 1;
            }
            if (count == 0)
            {
                for (Course alist: list_Course)
                {
                    if (getNACourseID().equals(alist.getCourseID()) && alist instanceof NonAcademicCourse) 
                    {
                        NonAcademicCourse NACourse = (NonAcademicCourse) alist;
                        if(NACourse.getisRemoved()==false)
                        {
                            JOptionPane.showMessageDialog(frame, "The Non-Academic Course with "+ "\n"
                                                          + "Course ID: "+ getNACourseID() + " has been removed.");
                            NACourse.remove();
                            count = 1;
                        }
                        else if(NACourse.getisRemoved()==true)
                        {
                            JOptionPane.showMessageDialog(frame, "The Non-Academic Course with "+ "\n"
                                                          + "Course ID: "+ getNACourseID() + " has already been removed.","Attention"
                                                          ,JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }
            }
        }
        
        //Display Non-Academic Course details when the Button is clicked.
        else if(e.getSource() == button_NADisplay)
        {
            for (Course alist: list_Course)
            {
                if (alist instanceof NonAcademicCourse)
                {
                    NonAcademicCourse NonAcademicObject = (NonAcademicCourse) alist;
                    System.out.println("");
                    NonAcademicObject.display();
                }
            }
        }
        
        //Clear all fields when the Button is clicked.
        else if(e.getSource() == button_Clear)
        {
            //Clear all the data present
            field_ID.setText("");
            field_CName.setText("");
            field_Duration.setText("");
            field_Level.setText("");
            field_Credit.setText("");
            field_NoOfAssessment.setText("");
            field_ACregisterID.setText("");
            field_ACLeader.setText("");
            field_LName.setText("");
            fieldNA_ID.setText("");
            fieldNA_CName.setText("");
            field_NADuration.setText("");
            field_Prerequisite.setText("");
            field_NACregisterID.setText("");
            field_NACLeader.setText("");
            field_IName.setText("");
            box_ACYear1.setSelectedIndex(0);
            box_ACMonth1.setSelectedIndex(0);
            box_ACDay1.setSelectedIndex(0);
            box_ACYear2.setSelectedIndex(0);
            box_ACMonth2.setSelectedIndex(0);
            box_ACDay2.setSelectedIndex(0);       
            box_NACYear1.setSelectedIndex(0);
            box_NACMonth1.setSelectedIndex(0);
            box_NACDay1.setSelectedIndex(0);
            box_NACYear2.setSelectedIndex(0);
            box_NACMonth2.setSelectedIndex(0);
            box_NACDay2.setSelectedIndex(0); 
            box_NACYear3.setSelectedIndex(0);
            box_NACMonth3.setSelectedIndex(0);
            box_NACDay3.setSelectedIndex(0);
        }
    }
}
