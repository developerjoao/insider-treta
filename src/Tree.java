public class Tree {
    private Node<User> root;

    public Tree(User user) {
        Node<User> usuario = new Node<User>(user);
        this.root = usuario;

    }
    /***
    public void addUser(User user) {
    	Node<User> usuario = new Node<User>(user);
        this.users.add(usuario);
    }*/

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