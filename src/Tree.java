public class Tree {
    private Node<User> root;

    public Tree(User user) {
        Node<User> usuario = new Node<User>(user);
        this.root = usuario;
        //adicionar no histograma.

    }
    
    /***
     * Adiciona uma data ao nó de data ao usuário que está
     * sendo análisado.
     * @param date A data que está sendo lida no CSV.
     * */
    public void addDate(String date) {
    	for(Node<String> filhos: root.getChildren()) {
    		if(filhos.getValue() == date) {
    			//adiciona no histograma na hora x.
    			return;
    		}else {
    			Node<String> data = new Node<String>(date);
    	    	this.root.addChildren(data);
    	    	//adicionar no histograma.
    	    	return;
    		}
    	}
    }

    public Node<String> findPC(String currentDate, String pc) {
    	
    	for(Node<String> date:root.getChildren()) {
    		if(date.getValue() == currentDate) {
    			for(Node<String> filhos: date.getChildren()) {
    				if(filhos.getValue() == pc) {
    					//adicionar no histograma
    					return filhos;
    				}else {
    					Node<String> computer = new Node<String>(pc);
    					date.addChildren(computer);
    					//adicionar no histograma
    					return computer;
    				}
    			}
    		}
    	}
    	
    	//Por necessitar um retorno.
    	Node<String> falha = new Node<String>(" ");
		return falha;
    }
    
    
    /***
     * Adiciona à data que está sendo analisada um Http e a url
     * da mesma linha do CSV.
     * @param pc	O computador analisado.
     * @param url O url que será adicionado ao nó Http.  
     * */
    public void addHTTP(Node<String> pc, String url){
    	if(pc.getValue() == " ") {
    		return;
    	}
    	for(Node<String> filhos:pc.getChildren()) {
    		if(filhos.getValue() == "Http") {
				if(filhos.InChildren(url)) {
					//adiciona no histograma do Http e do filho.
				}else {
					filhos.addChildren(new Node<String>(url));
					//adicionar no histograma
				}
			}else {
				 Node<String> http = new Node<String>("Http");
			     http.addChildren(new Node<String>(url));
			     pc.addChildren(http);
			     //adicionar no histograma
			}
    	}
    }

    /***
     * Adiciona à data que está sendo analisada um Pendrive e a inserção
     * da mesma linha do CSV.
     * @param currentDate	A data analisáda.
     * @param insert A inserção que será adicionado ao nó Http. 
     * */
    public void addPendrive(Node<String> pc, String insert){
    	if(pc.getValue() == " ") {
    		return;
    	}
    	for(Node<String> filhos:pc.getChildren()) {
    		if(filhos.getValue() == "Pendrive") {
    			if(filhos.InChildren(insert)) {
    				//adiciona no histograma do pendrive e do filho
    			}else {
        			filhos.addChildren(new Node<String>(insert));
        			//adicionar no histograma
        		}
    		}else {
    			Node<String> http = new Node<String>("Pendrive");
			    http.addChildren(new Node<String>(insert));
			    pc.addChildren(http);
			    //adicionar no histograma
    		}
    	}
    }

    
    /***
     * */
    public void addLogon(Node<String> pc, String logon){
    	if(pc.getValue() == " ") {
    		return;
    	}
    	for(Node<String> filhos:pc.getChildren()) {
    		if(filhos.getValue() == "Logon") {
    			if(filhos.InChildren(logon)) {
    				//adiciona no histograma do pendrive e do filho
    			}else {
        			filhos.addChildren(new Node<String>(logon));
        			//adicionar no histograma
        		}
    		}else {
    			Node<String> computer = new Node<String>("Logon");
			    computer.addChildren(new Node<String>(logon));
			    pc.addChildren(computer);
			    //adicionar no histograma
    		}
    	}
    }

    public void showTree() {

    }
}