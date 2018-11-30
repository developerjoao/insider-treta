public class User {
    private String name;
    private String id;
    private String domain;
    private String email;
    private String role;

    /***
     * Construtor de Usuário.
     * */
    public User(String name, String id, String domain, String email, String role) {
        this.name = name;
        this.id = id;
        this.domain = domain;
        this.email = email;
        this.role = role;
    }
    
    /***
     * Método para retornar o Id do usuário.
     * @return id Id do usuário.
     * */
    public String getId() {
    	return this.id;
    }

    /***
     * Método que imprime os atributos do usuário.
     * */
    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Domain: " + domain);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }

}