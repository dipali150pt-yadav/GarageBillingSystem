
import service.BillingService;
import entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BillingService service= new BillingService();
        while(true){
            System.out.println("1. Add Customer \n2. Generate Invoice\n3. show Invoice\n4. Exit");
            int ch= sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println(" Customer name:");
                    String name= sc.next();
                    System.out.println("phone:");
                    String phone = sc.next();
                    service.CustomerService.addCustomer(new Customer(0,name,phone));
                    break;
                    case 2:
                        System.out.println("Enter Customer ID: ");
                        int cid=sc.nextInt();
                        System.out.println("Enter Vehicle ID: ");
                        int vid=sc.nextInt();
                        System.out.println("Enter number of services: ");
                        int n=sc.nextInt();
                        List<Integer> sids=new ArrayList<Integer>();
                        for(int i=0;i<n;i++){
                            System.out.println("Enter Service ID: ");
                            sids.add(sc.nextInt());
                        }
                        service.createInvoice(cid,vid,sids);
                        break;
                        case 3:
                            service.showAllInvoices();
                            break;
                            case 4:
                                System.exit(0);
                                break;
                default:
                        System.out.println("Invalid choice");
            }
        }
    }
}
