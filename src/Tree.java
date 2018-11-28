public class Tree {
    private Node<String> root;

    public Tree(String user) {
        Node<String> usuario = new Node<String>(user);
        this.root = usuario;

    }
    /***
    public void addUser(Node<User> user) {
        this.root = user;
    }*/

    public void addDate(Node<TimeWindow> timeWindow) {

    }

    public void addHTTP(String url){
        Node<String> http = new Node<String>("Http");
        http.addChildren(new Node<String>(url));
        this.root.addChildren(http);
    }

    public void addPendrive(String insert){
        Node<String> pendrive = new Node<String>("Pendrive");
        pendrive.addChildren(new Node<String>(insert));
        this.root.addChildren(pendrive);
    }

    public void addLogon(String logon){
        Node<String> computer = new Node<String>("Computer");
        computer.addChildren(new Node<String>(logon));
        this.root.addChildren(computer);
    }

    public void showTree() {

    }
}