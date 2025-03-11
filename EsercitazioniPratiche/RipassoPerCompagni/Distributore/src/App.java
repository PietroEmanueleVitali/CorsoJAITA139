
import services.ServiceCan;

public class App {
    public static void main(String[] args) throws Exception {
        ServiceCan serviceCan = ServiceCan.getInstance();
        serviceCan.printAll();
    }
}
