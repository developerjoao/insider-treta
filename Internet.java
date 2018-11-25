/**
 * 
 */

/**
 * @author jvfca
 *
 */
public class Internet extends Device {
	private String url;

	public Internet(int id, String date, User user, String pc, String url){
		super(id,date,user,pc);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
