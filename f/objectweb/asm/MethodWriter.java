package f.objectweb.asm;

public class MethodWriter
  extends d
{
  public MethodWriter(h paramH) {}
  
  public void a(PagerSlidingTabStrip paramPagerSlidingTabStrip)
  {
    paramPagerSlidingTabStrip.show(true);
    l localL = b.g;
    if (localL != null) {
      localL.a(b, true);
    }
    b.a();
  }
  
  public void b(PagerSlidingTabStrip paramPagerSlidingTabStrip)
  {
    paramPagerSlidingTabStrip.show(false);
    Object localObject = b;
    if (G)
    {
      localObject = g;
      if (localObject != null) {
        ((l)localObject).a(b, false);
      }
      b.a();
      return;
    }
    localObject = g;
    if (localObject != null) {
      ((l)localObject).a(b);
    }
  }
  
  public void c(PagerSlidingTabStrip paramPagerSlidingTabStrip)
  {
    if (b.f) {
      b(paramPagerSlidingTabStrip);
    }
  }
}
