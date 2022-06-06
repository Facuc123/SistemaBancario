package main;
import java.util.Scanner;
import service.ClienteService;
import banco.Cliente;
import banco.Cuenta;
import java.util.InputMismatchException;
import service.CuentaService;
import service.SucursalService;

public class Main {

    public static void main(String[] args) {
        int x=0;
        System.out.println(Math.random()*13);
        Boolean bandera = true;
        ClienteService cservice = new ClienteService();
        CuentaService cuservice = new CuentaService();
        SucursalService suservice = new SucursalService();
        do{ 
        Scanner sc = new Scanner(System.in);
        System.out.println("******MENU PRINCIPAL******");
        System.out.println("1) Agregar cliente");
        System.out.println("2) Agregar cuenta a cliente");
        System.out.println("3) Listar clientes por sucursal");
        System.out.println("4) Listar clientes de una sucursal");
        System.out.println("5) Extraer dinero");
        System.out.println("6) Consultar saldo");
        System.out.println("7) Realizar deposito");
        System.out.println("8) Realizar transferencia");
        System.out.println("9) Eliminar una sucursal");
        System.out.println("0) Salir");
        System.out.println("Ingrese su opcion: ");
        do{
        try{
           x = sc.nextInt();
            sc.nextLine(); 
            if(x<0 && x>10){
                System.out.println("Ingrese una opcion valida");
                bandera = false;
            }
            else{
                bandera = true;
            }
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        }while(bandera == false);
        switch(x){
            
            case 1:
                addCliente(cservice,sc);
                break;
            case 2:
                addCuenta(cuservice, sc);
                break;
            case 3:
                listarTodo(cservice);
                break;
            case 4:
                listarCliente(cservice,sc);
                break;
            case 5:
                extraerDinero(cuservice,sc);
                break;
            case 6:
                consultaSaldo(cuservice, sc);
                break;
            case 7:
                realizarDeposito(cuservice, sc);
                break;
            case 8:
                realizarTransferencia(cuservice, sc);
                break;
            case 9:
                suservice.deleteSucursal();
                break;
          
        }
    }while(x!=0);
    }
    
    private static void addCliente(ClienteService cservice, Scanner sc){
        Cliente cl = new Cliente();

        System.out.print("Ingrese nombre y apellido: ");
        cl.setNombre(sc.nextLine());
        System.out.print("Ingrese el domicilio: ");
        cl.setDomicilioLegal(sc.nextLine());
        System.out.println(cl.getDomicilioLegal());
        System.out.print("Ingrese el mail: ");
        cl.setEmail(sc.nextLine());
        System.out.println("Ingrese nro de telefono: ");
        cl.setNroTelefono(sc.nextLine());
        System.out.println("Ingrese el numero de sucursal: ");
        cl.setidSucursal(sc.nextInt());
        sc.nextLine();
        cservice.addCliente(cl);
    }
    
    public static void addCuenta(CuentaService cuservice, Scanner sc){
        Cuenta cu = new Cuenta();
        Cliente cl = new Cliente();
        cu.setCliente(cl);
        System.out.println("Ingrese el numero de cuenta: ");
        cu.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese numero de cliente: ");    
        cl.setIdCliente(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese saldo: ");
        cu.setSaldo(sc.nextDouble());
        sc.nextLine();
        System.out.println("Diga si es cuenta corriente(CC) o caja de ahorro(CA): ");
        cu.setTipoCuenta(sc.nextLine());
        System.out.println("Ingrese tipo de moneda(EUR, ARS, USD): ");
        cu.setTipoMoneda(sc.nextLine());
        System.out.println("Ingrese el identificador de la sucursal: ");
        cl.setidSucursal(sc.nextInt());
        sc.nextLine();
        cuservice.addCuenta(cl, cu);
    }
        
    private static void listarCliente(ClienteService cservice, Scanner sc){
        int a;
        System.out.println("Ingrese el nro de sucursal a listar: ");
        a = sc.nextInt();
        sc.nextLine();
        cservice.listar(a);
    }
    
    private static void listarTodo(ClienteService cservice){
        cservice.listarTodo();
    }
    
    private static void consultaSaldo(CuentaService cuservice, Scanner sc){
        int a;
        System.out.println("Ingrese su numero de cliente");
        a = sc.nextInt();
        sc.nextLine();
        cuservice.consultaSaldo(a);
    }
    
    private static void extraerDinero(CuentaService cuservice, Scanner sc){
        System.out.println("Ingrese su numero de cliente: ");
        int idCliente = sc.nextInt();
        System.out.println("Ingrese el monto a extraer: ");
        double monto = sc.nextDouble();
        cuservice.extraerDinero(idCliente,monto);
    }
    
    private static void realizarDeposito(CuentaService cuservice, Scanner sc){
        int a;
        double monto;
        System.out.println("Ingrese su numero de cliente: ");
        a = sc.nextInt();
        System.out.println("Ingrese el monto a depositar: ");
        monto = sc.nextDouble();
        cuservice.realizarDeposito(a, monto);
    }
    
    private static void realizarTransferencia(CuentaService cuservice, Scanner sc){
        int a,c;
        double b;
        System.out.println("Ingrese su numero de cliente: ");
        a = sc.nextInt();
        System.out.println("Ingrese el monto a transferir: ");
        b = sc.nextDouble();
        System.out.println("Ingrese su numero de cliente: ");
        c = sc.nextInt();
        cuservice.realizarTransferencia(a,b,c);
    }
}
