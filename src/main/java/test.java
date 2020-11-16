import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

public class test {
  public static void main(String[] args) {
    RedissonClient redisson = Redisson.create();


    redisson.shutdown();
  }
}
