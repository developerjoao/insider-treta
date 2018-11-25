/**
 * 
 */

/**
 * @author jvfca
 *
 */
public class Email extends Device{
	private String receiver;


	public Email(int id, String date, User user, String pc, String receiver){
		super(id,date,user,pc);
		this.receiver = receiver;
	}

	public String getreceiver() {
		return receiver;
	}

	public void setreceiver(String receiver) {
		this.receiver = receiver;
	}
}
