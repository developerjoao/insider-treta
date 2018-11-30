public class User {
    private String name;
    private String id;
    private String domain;
    private String email;
    private String role;

    /***
     * Construtor de Usu�rio.
     * */
    public User(String name, String id, String domain, String email, String role) {
        this.name = name;
        this.id = id;
        this.domain = domain;
        this.email = email;
        this.role = role;
    }
    
    /***
     * M�todo para retornar o Id do usu�rio.
     * @return id Id do usu�rio.
     * */
    public String getId() {
    	return this.id;
    }

    /***
     * M�todo que imprime os atributos do usu�rio.
     * */
    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Domain: " + domain);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }

}