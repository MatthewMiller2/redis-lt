import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

public class RedisJavaEx {

  public static void main(String[] args) {
    RedissonClient redisson = Redisson.create();

    // Strings
    System.out.println("----- Strings -----");
    RBucket<String> s = redisson.getBucket("matt");
    s.set("miller");
    System.out.println("Key matt has been set to " + s.get());
    s.delete();

    // Lists
    System.out.println("----- Lists -----");
    RList<String> l = redisson.getList("das");
    l.add("zubair");
    l.add("mousumi");
    for (String member : l) {
      System.out.println("Member: " + member);
    }
    l.delete();

    redisson.shutdown();
  }

}
