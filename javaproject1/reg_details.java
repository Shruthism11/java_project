package javaproject1;

public class reg_details extends credits implements educational_background
{

	reg_details(String name, String stu_id, String courseid, String coursename, int credits) {
		super(name, stu_id, courseid, coursename, credits);
	}

	
	@Override
	public void edu(String graduation_in, int sem) {
		System.out.println("GRADUATION IN : " + graduation_in);
		System.out.println("SEM : " + sem);
		
	}
	
	void display()
	{
		super.display();
	}

}
