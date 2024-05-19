import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Serveur {
    public static void main(String[] args) throws IOException {
        //on va faire une petite base de donnee pour faire la verification des champs entree
        Map<String,String> map=new HashMap<>();
        map.put("Safa","123");
        map.put("ali","123");
        int clientCount=0;

        //etape1:specifier le port
        ServerSocket ss=new ServerSocket(8080);
        System.out.println("le serveur est lancee");

        while(true){
            //2eme etape le socket=>accepter des clients
            Socket s=ss.accept();
            clientCount++;
            System.out.println("Client N"+clientCount);
            //declenchement du threadService pour chaque client ainsi connectee
            ThreadService th=new ThreadService(s);
            //lancement du threadService
            th.start();




        }


    }
}