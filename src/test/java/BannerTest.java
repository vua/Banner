import com.cooooode.BannerMan;
import org.junit.Test;

/**
 * @program: banner
 * @description:
 * @author: vua
 * @create: 2020-01-19 17:55
 */
public class BannerTest {
    @Test
    public void test() {
        Obj proxy = (Obj) new BannerMan(new Obj()).create();
        proxy.Ansi();
        proxy.Crawford2();
//        proxy.Doom();
//        proxy.Graffiti();
//        proxy.Modular();
    }
}
