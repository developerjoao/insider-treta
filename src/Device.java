public abstract class Device {
	private int id;
	private String date;
	private User user;
	private String pc;

	public Device(int id, String date, User user, String pc){
		this.id = id;
		this.date = date;
		this.user = user;
		this.pc = pc;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPc() {
		return pc;
	}
	public void setPc(String pc) {
		this.pc = pc;
	}
}
