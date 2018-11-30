import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Node<T> {
    private T value;
    private int[] histogram;
    private ArrayList<Node<String>> children;

    
    /***
     * @param value O valor que inicia o nï¿½.
     * */
    public Node(T value) {
        this.value = value;
        this.histogram = new int[24];
        this.children = new ArrayList<Node<String>>();
    }
    /***
     * Retorna os filhos de um nï¿½ para poder manipulï¿½-los
     * no processo de leitura dos CSV.
     *@return Os filhos do nï¿½ em questï¿½o.
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
     * Método para obter o valor especifico de um campo do histograma
     * para gerar o valor médio.
     * @param hour Hora do valor que será retornado.
     * @return Valor do histograma na hora dada.
     * */
    public int getHistogram(int hour) {
    	return this.histogram[hour];
    }
    
    /***
     * Método que imprime o histograma de um nó.
     * */
    public void showHistogram() {
    	System.out.println(Arrays.toString(this.histogram));
    }
    
    /***
     * Método que calcula a distância do usuária análisado do
     * usuário médio. Se a distancia entre o usuário médio 
     * e o usuário analisado for maior que 1, ele é considerado
     * suspeito.
     * @param int[] Histograma do usuário médio
     * @return True se o usuário for suspeito, false se for considerado normal.
     * */
    public boolean enclideanDistance(int[] avgHistogram) {
    	
    	double inner = 0;
    	
    	for(int i = 0;i<24;i++) {
    		inner+= Math.pow(this.histogram[i] - avgHistogram[i],2);
    	}
    	
    	
    	double distance = Math.sqrt(inner);
    	
    	//Se a distancia for maior que um número médio, Este usuário é suspeito.
    	if(Math.ceil(distance)>1) {
    		return true;
    	}
    	return false;
    }
    
    /***
     * Adiciona um filho no array de filhos do nï¿½.
     * @param newChildren o novo filho a ser adicionado ao nï¿½ em questï¿½o.
     * */
    public void addChildren(Node<String> newChildren){
        this.children.add(newChildren);
    }
    
    /***
     * Método que diz se um dado valor se encontra nos filhos de um
     * nó de String.
     * @param value Valor a ser procurado
     * @param hour Hora em que deve ser incrementado o histograma
     * @return True se houver um filho com o valor, false caso contrário.
     * */
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
     * Retorna o valor de um nï¿½ especï¿½fico.
     * @return O valor do nï¿½ em questï¿½o.
     * */
    public T getValue() {
        return this.value;
    }
    
    /***
     * Método que imprime os filhos da árvore de usuário.
     * */
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