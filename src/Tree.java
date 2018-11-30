public class Tree {
    private Node<User> root;

    public Tree(User user) {
        Node<User> usuario = new Node<User>(user);
        this.root = usuario;
    }
    
    /***
     * M�todo para poder acessar os m�todos de Usu�rio da �rvore.
     * @return O objeto Usu�rio.
     * */
    public Node<User> getRoot(){
    	return this.root;
    } 
    
    /***
     * Adiciona uma data ao nó de data ao usuário que está
     * sendo análisado.
     * @param date A data que está sendo lida no CSV.
     * */
    public void addDate(String date) {
    	Node<String> data = new Node<String>(date);
    	this.root.addChildren(data);
    	return;
    }

    /***
     * Acha um computador que o usuário que está sendo lido utilizou.
     * @param currentDate a data em questão que está sendo analisada
     * @param pc O computador utilizado pelo usuário durante a análise.
     * @return Retorna um objeto que representa o computador que o usuário utilizou.
     * */
    public Node<String> findPC(String currentDate, String pc, int hour) {

    	for(Node<String> date:root.getChildren()) {
    		if(date.getValue().equals(currentDate)) {
    			if(date.getChildren().isEmpty()) {
    				Node<String> computer = new Node<String>(pc);
					date.addChildren(computer);
					computer.setHistogram(hour);
					this.root.setHistogram(hour);
					return computer;
    			}else {
	    			for(Node<String> filhos: date.getChildren()) {
	    				if(filhos.getValue().equals(pc)) {
	    					filhos.setHistogram(hour);
	    					this.root.setHistogram(hour);
	    					return filhos;
	    				}else {
	    					Node<String> computer = new Node<String>(pc);
	    					date.addChildren(computer);
	    					computer.setHistogram(hour);
	    					this.root.setHistogram(hour);
	    					return computer;
	    				}
	    			}
	    		}
    		}
    	}
    	
    	//Por necessitar um retorno.
    	Node<String> falha = new Node<String>("Falha");
		return falha;
    }
    
    
    /***
     * Adiciona à data que está sendo analisada um Http e a url
     * da mesma linha do CSV.
     * @param pc O computador utilizado pelo usuário durante a análise.
     * @param url O url que será adicionado ao nó Http.  
     * */
    public void addHTTP(Node<String> pc, String url, int hour){
    	if(pc.getValue().equals("Falha")) {
    		return;
    	}
    	if(pc.getChildren().isEmpty()) {
    		Node<String> http = new Node<String>("Http");
			http.setHistogram(hour);
			
			Node<String> novoFilho = new Node<String>(url);
			novoFilho.setHistogram(hour);
			
		    http.addChildren(novoFilho);
		    pc.addChildren(http);
		    this.root.setHistogram(hour);
		    return;
		    //adicionar no histograma
    	}
    	for(Node<String> filhos:pc.getChildren()) {
    		if(filhos.getValue().equals("Http")) {
				if(filhos.InChildren(url, hour)) {
					this.root.setHistogram(hour);
    				return;
					//atualiza no histograma do Http e do filho.
				}else {
					Node<String> novoFilho = new Node<String>(url);
    				novoFilho.setHistogram(hour);
    				
        			filhos.addChildren(novoFilho);
        			filhos.setHistogram(hour);
        			//this.root.setHistogram(hour);
        			return;
        			//adicionar no histograma
				}
			}
    	}
    }

    /***
     * Adiciona à data que está sendo analisada um Pendrive e a inserção
     * da mesma linha do CSV.
     * @param pc O computador utilizado pelo usuário durante a análise.
     * @param insert A inserção que será adicionado ao nó Http. 
     * */
    public void addPendrive(Node<String> pc, String insert, int hour){
    	if(pc.getValue().equals("Falha")) {
    		return;
    	}
    	if(pc.getChildren().isEmpty()) {
    		Node<String> pendrive = new Node<String>("Pendrive");
			pendrive.setHistogram(hour);
			
			Node<String> novoFilho = new Node<String>(insert);
			novoFilho.setHistogram(hour);
			
		    pendrive.addChildren(novoFilho);
		    pc.addChildren(pendrive);
		    this.root.setHistogram(hour);
		    return;
		    //adicionar no histograma
    	}
    	for(Node<String> filhos:pc.getChildren()) {
    		if(filhos.getValue().equals("Pendrive")) {
    			if(filhos.InChildren(insert, hour)) {
    				this.root.setHistogram(hour);
    				return;
    				//atualiza no histograma do pendrive e do filho
    			}else {
    				Node<String> novoFilho = new Node<String>(insert);
    				novoFilho.setHistogram(hour);
    				
        			filhos.addChildren(novoFilho);
        			filhos.setHistogram(hour);
        			//this.root.setHistogram(hour);
        			return;
        			//adicionar no histograma
        		}
    		}
    	}
    }

    
    /***
     * Adiciona os dados de logon que foram feitos pelo usuário no computador
     * análisado.
     * @param pc O pc utilizado pelo usuário durante a análise.
     * @param logon a atividade de logon ou logoff.
     * */
    public void addLogon(Node<String> pc, String logon, int hour){
    	if(pc.getValue().equals("Falha")) {
    		return;
    	}
    	if(pc.getChildren().isEmpty()) {
    		Node<String> computer = new Node<String>("Logon");
			computer.setHistogram(hour);
			
			Node<String> novoFilho = new Node<String>(logon);
			novoFilho.setHistogram(hour);
			
		    computer.addChildren(novoFilho);
		    pc.addChildren(computer);
		    this.root.setHistogram(hour);
		    return;
		    //adicionar no histograma
    	}
    	for(Node<String> filhos:pc.getChildren()) {
    		if(filhos.getValue().equals("Logon")) {
    			if(filhos.InChildren(logon, hour)) {
    				this.root.setHistogram(hour);
    				return;
    				//atualiza no histograma do pendrive e do filho
    			}else {
    				Node<String> novoFilho = new Node<String>(logon);
    				novoFilho.setHistogram(hour);
    				
        			filhos.addChildren(novoFilho);
        			filhos.setHistogram(hour);
        			//this.root.setHistogram(hour);
        			return;
        			//adicionar no histograma
        		}
    		}
    	}
    }

    /***
     * Fun��o que tenta imprimir um usu�rio e seus filhos.
     * */
    public void showTree() {
    	this.root.getValue().show();
    	for(Node<String> data:this.root.getChildren()) {
    		data.show();
    	}
    }
}