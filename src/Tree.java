public class Tree {
    private Node root;

    public Tree(String user) {
        Node<User> usuario = new Node<User>(user);
        this.root = user;

    }
    /***
    public void addUser(Node<User> user) {
        this.root = user;
    }*/

    public void addDate(Node<TimeWindow> timeWindow) {

    }

    public void addHTTP(String url){
        Node<String> http = new Node<String>("Http");
        http.addChildren(url)
        this.root.addChildren(http);
    }

    public void addPendrive(String insert){
        Node<String> pendrive = new Node<String>("Pendrive");
        pendrive.addChildren(insert)
        this.root.addChildren(pendrive);
    }

    public void addLogon(String logon){
        Node<String> computer = new Node<String>("Computer");
        computer.addChildren(logon)
        this.root.addChildren(computer);
    }

    public void showTree() {

    }
}