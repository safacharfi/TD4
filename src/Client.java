import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //connexion au serveur
        InetAddress addr=InetAddress.getByName("192.186.0.9");
        Socket s=new Socket(addr,8080);
        //envoi du mdp et du login
        OutputStream os=s.getOutputStream();
        PrintWriter pw=new PrintWriter(os);
        Scanner sc=new Scanner(System.in);
        System.out.println("entrez votre login");
        String log=sc.nextLine();
        System.out.println("entrez votre password");
        String password=sc.nextLine();
        pw.println(log);
        pw.println(password);
        pw.flush();
        //recevoir le resultat de la connection :cava ou pas
        InputStream is=s.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader istream = new BufferedReader(reader);
        boolean test=Boolean.parseBoolean(istream.readLine());
        if(test){
            System.out.println("ok");
        }
        else{
            System.out.println("failed");
        }








    }}
