import java.io.*;
import java.net.URL;

interface Task {
    void start();
    void stop();
}

public class task5 implements Task {

    private String url;
    private String path;
    private volatile boolean stopped = false;
    private Thread thread;

    public task5(String url, String path) {
        this.url = url;
        this.path = path;
    }

    public void start() {
        thread = new Thread(() -> {
            BufferedInputStream in = null;
            FileOutputStream out = null;
            try {
                in = new BufferedInputStream(new URL(url).openStream());
                out = new FileOutputStream(path);

                byte[] buf = new byte[4096];
                int n;
                while ((n = in.read(buf)) != -1 && !stopped) {
                    out.write(buf, 0, n);
                }

                if (stopped) {
                    out.close();
                    out = null;
                    in.close();
                    in = null;
                    new File(path).delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try { out.close(); } catch (IOException ignored) {}
                }
                if (in != null) {
                    try { in.close(); } catch (IOException ignored) {}
                }
                if (stopped) {
                    new File(path).delete();
                }
            }
        });
        thread.start();
    }

    public void stop() {
        stopped = true;
        if (thread != null) {
            try { thread.join(); } catch (InterruptedException ignored) {}
        }
    }

    public static void main(String[] args) throws Exception {
        Task task = new task5(
            "https://github.com/Flowseal/zapret-discord-youtube/releases/download/1.10.3/zapret-discord-youtube-1.10.3.zip",
            "downloaded.zip"
        );
        task.start();
        Thread.sleep(2000);
        task.stop();
    }
}