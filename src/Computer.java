/**
 * 
 */

/**
 * @author jvfca
 *
 */
public class Computer extends Device{
	private boolean logon;

	public Computer(int id, String date, User user, String pc, boolean logon){
		super(id,date,user,pc);
		this.logon = logon;
	}

	public boolean isLogon() {
		return logon;
	}

	public void setLogon(boolean logon) {
		this.logon = logon;
	}
}
