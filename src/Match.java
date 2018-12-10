/**
 * This class simulates a match in real life
 * @author silkpath
 *
 */
public class Match {

	private String name;
	private int age;
	private String blurb;
	private String pic; //LUCY: when user uploads a picture, save the file path
	
	/**
	 * Constructor
	 * @param name
	 * @param age
	 * @param blurb
	 * @param pic
	 */
	Match(String name, int age, String blurb, String pic){
		this.name = name;
		this.age = age;
		this.blurb = blurb;
		this.pic = pic;
	}

	/**
	 * Get match name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set match name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get match age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set match age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Get blurb
	 * @return blurb
	 */
	public String getBlurb() {
		return blurb;
	}

	/**
	 * Set blurb
	 * @param blurb
	 */
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	/**
	 * Get picture path (file path)
	 * @return pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * Set picture path
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Overriding Object's equals method
	 */
	@Override
	public boolean equals(Object object) {
		Match match = (Match) object;
		if (match == null) return false;
		if (name.equals(match.getName()) && age == match.getAge() 
				&& blurb.equals(match.getBlurb()) && pic.equals(match.getPic()))
				return true;
				
		else return false;
	}
}
