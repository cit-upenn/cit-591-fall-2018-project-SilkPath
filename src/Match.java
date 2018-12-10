
public class Match {

	private String name;
	private int age;
	private String blurb;
	private String pic; //LUCY: when user uploads a picture, save the file path
	
	Match(String name, int age, String blurb, String pic){
		this.name = name;
		this.age = age;
		this.blurb = blurb;
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBlurb() {
		return blurb;
	}

	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
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
