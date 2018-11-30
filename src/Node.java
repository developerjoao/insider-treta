import java.util.ArrayList;

public class Node<T> {
    private T value;
    private int[] histogram;
    private ArrayList<Node<String>> children;

    
    /***
     * @param value O valor que inicia o nó.
     * */
    public Node(T value) {
        this.value = value;
        this.histogram = new int[24];
        this.children = new ArrayList<Node<String>>();
    }
    /***
     * Retorna os filhos de um nó para poder manipulá-los
     * no processo de leitura dos CSV.
     *@return Os filhos do nó em questão.
     * */
    public ArrayList<Node<String>> getChildren(){
    	return this.children;
    }
    
    /***
     * Aumenta em 1 a frequencia no histograma.
     * @param hour Hora da atividade vinda do log.
     * */
    public void setHistogram(int hour){
    	this.histogram[hour]+=1;
    }

    /***
     * Adiciona um filho no array de filhos do nó.
     * @param newChildren o novo filho a ser adicionado ao nó em questão.
     * */
    public void addChildren(Node<String> newChildren){
        this.children.add(newChildren);
    }
    
    public boolean InChildren(String value, int hour) {
    	for(Node<String> filho:this.getChildren()) {
    		if(filho.getValue() == value) {
    			this.setHistogram(hour);
    			filho.setHistogram(hour);
    			return true;
    		}
    	}
    	return false;
    }
    
    /***
     * Retorna o valor de um nó específico.
     * @return O valor do nó em questão.
     * */
    public T getValue() {
        return this.value;
    }
    
    
    public void show() {
    	System.out.println("Value: "+ this.getValue());
    	for(Node<String> filhos:this.getChildren()) {
    		System.out.println("Imprimindo filhos:");
    		System.out.println(filhos.getValue());
    		for(Node<String> filhos2:filhos.getChildren()) {
    			if(filhos2.getValue().equals("Pendrive")) {
    				filhos2.show();
    			}
    			if(filhos2.getValue().equals("Http")) {
    				filhos2.show();
    			}
    			if(filhos2.getValue().equals("Logon")) {
    				filhos2.show();
    			}
    		}
    	}
    }
}