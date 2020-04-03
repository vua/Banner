# Banner
## 一. @Banner注解
1.添加jar依赖 [下载banner.jar](https://github.com/vua/Banner/releases/tag/v1)

2.在方法上添加@Banner注解,设置打印内容(name),打印字体(type),打印颜色(color)
```
public class Obj{
	@Banner(name="Crawford",type= BannerType.Crawford2,color = BannerColor.Red)
	public void Crawford2(){}
}
```
3.使用BannerMan类代理Obj后执行添加@Banner注解的方法
```
public class BannerTest {
    @Test
    public void test() {
        Obj proxy = (Obj) new BannerMan(new Obj()).create();  
        proxy.Crawford2();
    
    }
}
```
![效果图](https://github.com/vua/Banner/blob/master/img.png)
## 二.@Cache注解
因为banner是根据@Banner注解的name属性值从本地库中遍历拼接出的所以会有一定时耗,而Banner name固定后一般不会改变,所以启用@Cache将上次运行时生成的banner保存在本地,下次运行就无需再次生成了

使用方式:直接添加在方法上即可
```
public class Obj{
	@Cache
	@Banner(name="Ansi",type= BannerType.Ansi,color = BannerColor.Bule)
	public void Ansi(){}
}
```
```
public class BannerTest {
    @Test
    public void test() {
        Obj proxy = (Obj) new BannerMan(new Obj()).create();  
        proxy.Ansi();
    }
}
```

![效果图](https://github.com/vua/Banner/blob/master/img1.png)
