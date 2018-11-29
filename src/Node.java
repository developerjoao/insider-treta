import java.util.ArrayList;

public class Node<T> {
    private T value;
    private int[] histogram;
    private ArrayList<Node<String>> children;

    
    /***
     * @param value O valor que inicia o n�.
     * */
    public Node(T value) {
        this.value = value;
        this.histogram = new int[24];
        this.children = new ArrayList<Node<String>>();
    }
    /***
     * Retorna os filhos de um n� para poder manipul�-los
     * no processo de leitura dos CSV.
     *@return Os filhos do n� em quest�o.
     * */
    public ArrayList<Node<String>> getChildren(){
    	return this.children;
    }
    
    public void setHistogram(){

    }

    /***
     * Adiciona um filho no array de filhos do n�.
     * @param newChildren o novo filho a ser adicionado ao n� em quest�o.
     * */
    public void addChildren(Node<String> newChildren){
        this.children.add(newChildren);
    }
    
    /***
     * Retorna o valor de um n� espec�fico.
     * @return O valor do n� em quest�o.
     * */
    public T getValue() {
        return this.value;
    }
}