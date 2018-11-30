public class Pendrive extends Device{
	private boolean insert;

	/***
	 * Construtor da classe Pendrive.
	 * */
	public Pendrive(int id, String date, User user, String pc, boolean insert){
		super(id,date,user,pc);
		this.insert = insert;
	}

	/***
	 * Método que retorna o valor do pendrive.
	 * */
	public boolean isInsert() {
		return insert;
	}

	/***
	 * Método que assimila o valor do pendrive.
	 * */
	public void setInsert(boolean insert) {
		this.insert = insert;
	}
}
