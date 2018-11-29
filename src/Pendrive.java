public class Pendrive extends Device{
	private boolean insert;

	public Pendrive(int id, String date, User user, String pc, boolean insert){
		super(id,date,user,pc);
		this.insert = insert;
	}

	public boolean isInsert() {
		return insert;
	}

	public void setInsert(boolean insert) {
		this.insert = insert;
	}
}
