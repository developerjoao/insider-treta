/**
 * 
 */

/**
 * @author jvfca
 *
 */
public class Disk extends Device{
	private String file;

	public Disk(int id, String date, User user, String pc, String file){
		super(id,date,user,pc);
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
