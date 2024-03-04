package javaproject1;


public interface educational_background {
	
	String cname = "NIE, Mysuru";
	int tier = 1;
	
	
	void edu(String graduation_in, int sem);
	
	//default method in the interface
	default void collage_details()
	{
		System.out.println("COLLAGE NAME : " + cname);
		System.out.println("TIER : " + true + " college");
	}
	
}