import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

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
    
    /***
     * Aumenta em 1 a frequencia no histograma.
     * @param hour Hora da atividade vinda do log.
     * */
    public void setHistogram(int hour){
    	this.histogram[hour]+=1;
    }
    
    /***
     * M�todo para obter o valor especifico de um campo do histograma
     * para gerar o valor m�dio.
     * @param hour Hora do valor que ser� retornado.
     * @return Valor do histograma na hora dada.
     * */
    public int getHistogram(int hour) {
    	return this.histogram[hour];
    }
    
    /***
     * M�todo que imprime o histograma de um n�.
     * */
    public void showHistogram() {
    	System.out.println(Arrays.toString(this.histogram));
    }
    
    /***
     * M�todo que calcula a dist�ncia do usu�ria an�lisado do
     * usu�rio m�dio. Se a distancia entre o usu�rio m�dio 
     * e o usu�rio analisado for maior que 1, ele � considerado
     * suspeito.
     * @param int[] Histograma do usu�rio m�dio
     * @return True se o usu�rio for suspeito, false se for considerado normal.
     * */
    public boolean enclideanDistance(int[] avgHistogram) {
    	
    	double inner = 0;
    	
    	for(int i = 0;i<24;i++) {
    		inner+= Math.pow(this.histogram[i] - avgHistogram[i],2);
    	}
    	
    	
    	double distance = Math.sqrt(inner);
    	
    	//Se a distancia for maior que um n�mero m�dio, Este usu�rio � suspeito.
    	if(Math.ceil(distance)>1) {
    		return true;
    	}
    	return false;
    }
    
    /***
     * Adiciona um filho no array de filhos do n�.
     * @param newChildren o novo filho a ser adicionado ao n� em quest�o.
     * */
    public void addChildren(Node<String> newChildren){
        this.children.add(newChildren);
    }
    
    /***
     * M�todo que diz se um dado valor se encontra nos filhos de um
     * n� de String.
     * @param value Valor a ser procurado
     * @param hour Hora em que deve ser incrementado o histograma
     * @return True se houver um filho com o valor, false caso contr�rio.
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
     * Retorna o valor de um n� espec�fico.
     * @return O valor do n� em quest�o.
     * */
    public T getValue() {
        return this.value;
    }
    
    /***
     * M�todo que imprime os filhos da �rvore de usu�rio.
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