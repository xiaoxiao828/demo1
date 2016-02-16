package com.developer.utils.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiao.lai on 16/1/20.
 */
public class SocketMain {

    public static int port = 8080;
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while(true) {
                try{
                    Socket socket = server.accept();
                    //Thread task = new DayThread(socket);
                    //task.start();
                    Callable task = new DayCallable(socket);
                    pool.submit(task);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (server!=null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }








        /* Socket socket = null;

        try {
            socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            InputStream stream = socket.getInputStream();
            BufferedInputStream in = new BufferedInputStream(stream);
            InputStreamReader reader = new InputStreamReader(in);
            int c;
            StringBuffer result = new StringBuffer();
            while ((c=reader.read())!=-1) {
                result.append((char)c);
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }*/

       /* String host = args.length > 0? args[0]:"localhost";
        for(int i=0;i<10240;i++) {
            try{
                Socket socket = new Socket(host, i);
                System.out.println("当前服务器："+host+",端口："+i);
                socket.close();
            }catch (UnknownHostException e) {
                //e.printStackTrace();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }*/



    }
}
