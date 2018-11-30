/**
 * 
 */

/**
 * @author jvfca
 *
 */
public class Computer extends Device{
	private String logon;

	/***
	 * Construtor de uma classe logon.
	 * */
	public Computer(int id, String date, User user, String pc, String logon){
		super(id,date,user,pc);
		this.logon = logon;
	}

	/***
	 * Metodo que retorna o atributo logon.
	 * */
	public String isLogon() {
		return logon;
	}

	/***
	 * Metodo que assimila o atributo logon.
	 * */
	public void setLogon(String logon) {
		this.logon = logon;
	}
}
