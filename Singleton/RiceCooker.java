public class RiceCooker {
    private RiceCooker() {}

    private static final RiceCooker instance = new RiceCooker();

    public static RiceCooker getInstance() {
        return instance;
    }

    public void showMessage(){
        System.out.println("I am the singleton object");
    }

    public static void main(String[] args){
        RiceCooker riceCooker = RiceCooker.getInstance();
        riceCooker.showMessage();  
    }
}
