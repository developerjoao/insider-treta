/**
 * 
 */

/**
 * @author jvfca
 *
 */
public class Internet extends Device {
	private String url;

	/***
	 * Construtor da classe Internet(Http).
	 * */
	public Internet(int id, String date, User user, String pc, String url){
		super(id,date,user,pc);
		this.url = url;
	}
	
	/***
	 * Método que retorna o valor da url.
	 * */
	public String getUrl() {
		return url;
	}

	/***
	 * Método que assimila o valor da url.
	 * */
	public void setUrl(String url) {
		this.url = url;
	}
}
