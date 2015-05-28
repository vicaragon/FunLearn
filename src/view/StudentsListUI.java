package view;

import javax.swing.*;
import controller.*;

public class StudentsListUI extends JPanel {
	private JLabel name;
	private JLabel age;
	private JButton addNewStudent;
	private JButton deleteStudent;
	private JButton updateStudent;
	private JButton allStudents;
	private JButton addToPlayList;
	private JTable displayStudentsList;
	private JTable PlayList;
	private JButton deleteFromPlayList;
	private JButton startPlaying;
	private StudentController studentController;
}
