import java.util.Scanner;

import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;

public class Messaging {

  public static void main(String[] args) {
    String channel = "group";
    RedisMessaging messaging = new RedisMessaging(channel);
    messaging.run();
  }

}

class RedisMessaging {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_CYAN = "\u001B[36m";

  private String mySentMessage = null;
  private final RedissonClient redisson;
  private final String channel;

  public RedisMessaging(String channel) {
    this.channel = channel;
    redisson = Redisson.create();
  }

  public synchronized void run() {
    RTopic topic = redisson.getTopic(channel);
    topic.addListener(String.class, (channel, msg) -> {
      if (mySentMessage == null || !mySentMessage.equals(msg)) {
        System.out.println(ANSI_CYAN + msg + ANSI_RESET);
      }
    });

    Scanner scanner = new Scanner(System.in);
    String msg;
    while ((msg = scanner.nextLine()) != null) {
      mySentMessage = msg;
      topic.publish(msg);
    }
    redisson.shutdown();
  }

}
