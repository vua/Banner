import com.cooooode.BannerColor;
import com.cooooode.BannerType;
import com.cooooode.annotation.Banner;
import com.cooooode.annotation.Cache;

/**
 * @program: banner
 * @description:
 * @author: vua
 * @create: 2020-01-19 17:56
 */
public class Obj {

    @Cache
    @Banner(name="Crawford",type= BannerType.Crawford2,color = BannerColor.Red)
    public void Crawford2(){}
    @Cache
    @Banner(name="Ansi",type= BannerType.Ansi,color = BannerColor.Blue)
    public void Ansi(){}
    @Cache
    @Banner(name="Doom",type= BannerType.Doom,color = BannerColor.Yellow)
    public void Doom(){}
    @Cache
    @Banner(name="Graffiti",type= BannerType.Graffiti,color = BannerColor.Green)
    public void Graffiti(){}
    @Cache
    @Banner(name="Modular",type= BannerType.Modular,color = BannerColor.Purple)
    public void Modular(){}
}
