import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by HeShulin on 2017/8/19.
 */
public class RogueThread extends Thread {
    private Socket socket = null;

    @Override
    public void run() {
        while (true) {
            if (socket == null) {

                try {
                    socket = new Socket("127.0.0.1", 54171);
                    System.out.println("服务端启动la");
                } catch (IOException e) {
                    try {
                        Runtime.getRuntime().exec("test2.exe");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("服务端没启动");
                    //e.printStackTrace();
                }
            } else {
                try {
                    socket.getOutputStream().write(ByteAndInt.int2byte(1));
                    System.out.println("我给服务端发东西啦！！");
                } catch (IOException e) {
                    socket = null;
                    try {
                        Runtime.getRuntime().exec("test2.exe");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("服务端没启动2");
                    //e.printStackTrace();
                }
                try {
                    sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }
}
