import java.io.*;
import java.net.Socket;

public class ThreadService extends Thread{
    Socket s;
    ThreadService(Socket s){
        this.s=s;
    }
    public void run(){
      //recuperer le log et le password
        try {
            InputStream is=s.getInputStream();
            InputStreamReader reader=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(reader);
            String log=br.readLine();
            String password=br.readLine();
            boolean test;
            if(map.containsKey(log) && map.get(log).equals(pwd)){
                System.out.println(log+"vient d connecter");
                test=true;
            }
            else{
                System.out.println("Connexion failed");
                test=false;

            }
            //envoyer le resultat au client
            OutputStream os=s.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            pw.println(test);
            pw.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
