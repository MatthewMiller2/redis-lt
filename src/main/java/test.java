import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

public class test {
  public static void main(String[] args) {
    RedissonClient redisson = Redisson.create();

    RBucket<String> s = redisson.getBucket("matt");
    System.out.println(s.get());
    s.set("miller");
    System.out.println(s.get());
    s.delete();

    RList<String> l = redisson.getList("das");
    l.add("zubair");
    l.add("ben");
    for (String member : l) {
      System.out.println(member);
    }
    l.delete();

    redisson.shutdown();
  }
}
