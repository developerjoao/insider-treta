public class Tree {
    private Node<User> root;

    public Tree(User user) {
        Node<User> usuario = new Node<User>(user);
        this.root = usuario;

    }
    
    /***
     * Adiciona uma data ao n� de data ao usu�rio que est�
     * sendo an�lisado.
     * @param date A data que est� sendo lida no CSV.
     * */
    public void addDate(String date) {
    	for(Node<String> filhos: root.getChildren()) {
    		if(filhos.getValue() == date) {
    			//adiciona no histograma.
    		}else {
    			Node<String> data = new Node<String>(date);
    	    	this.root.addChildren(data);
    	    	break;
    		}
    	}
    }

    /***
     * Adiciona � data que est� sendo analisada um Http e a url
     * da mesma linha do CSV.
     * @param currentDate	A data analis�da.
     * @param url O url que ser� adicionado ao n� Http.  
     * */
    public void addHTTP(String currentDate, String url){
    	for(Node<String> date: root.getChildren()) {
    		if(date.getValue() == currentDate) {
    			for(Node<String> filhos: date.getChildren()) {
    				if(filhos.getValue() == "Http") {
    					filhos.addChildren(new Node<String>(url));
    				}else {
    					 Node<String> http = new Node<String>("Http");
    				     http.addChildren(new Node<String>(url));
    				     date.addChildren(http);
    				}
    			}
    		}
    	}
    	/***
        Node<String> http = new Node<String>("Http");
        http.addChildren(new Node<String>(url));
        this.root.addChildren(http);
        */
    }

    /***
     * Adiciona � data que est� sendo analisada um Pendrive e a inser��o
     * da mesma linha do CSV.
     * @param currentDate	A data analis�da.
     * @param insert A inser��o que ser� adicionado ao n� Http. 
     * */
    public void addPendrive(String currentDate, String insert){
    	for(Node<String> date: root.getChildren()) {
    		if(date.getValue() == currentDate) {
    			for(Node<String> filhos: date.getChildren()) {
    				if(filhos.getValue() == "Pendrive") {
    					filhos.addChildren(new Node<String>(insert));
    				}else {
    					 Node<String> http = new Node<String>("Pendrive");
    				     http.addChildren(new Node<String>(insert));
    				     date.addChildren(http);
    				}
    			}
    		}
    	}
    	/***
        Node<String> pendrive = new Node<String>("Pendrive");
        pendrive.addChildren(new Node<String>(insert));
        this.root.addChildren(pendrive);
        */
    }

    
    /***
     * Adiciona � data que est� sendo analisada um Http e a url
     * da mesma linha do CSV.
     * @param currentDate	A data analis�da.
     * @param url O url que ser� adicionado ao n� Http. 
     * */
    public void addLogon(String currentDate, String logon){
    	for(Node<String> date: root.getChildren()) {
    		if(date.getValue() == currentDate) {
    			for(Node<String> filhos: date.getChildren()) {
    				if(filhos.getValue() == "Computer") {
    					filhos.addChildren(new Node<String>(logon));
    				}else {
    					 Node<String> http = new Node<String>("Computer");
    				     http.addChildren(new Node<String>(logon));
    				     date.addChildren(http);
    				}
    			}
    		}
    	}
    	/***
        Node<String> computer = new Node<String>("Computer");
        computer.addChildren(new Node<String>(logon));
        this.root.addChildren(computer);
        */
    }

    public void showTree() {

    }
}