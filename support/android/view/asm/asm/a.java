package support.android.view.asm.asm;

import java.util.ArrayList;

public class a
  extends f
{
  public AllowedSolution d = AllowedSolution.d;
  
  public a() {}
  
  public a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(support.android.view.asm.f paramF, int paramInt)
  {
    if (a.size() != 0)
    {
      int i = 0;
      int j = a.size();
      Object localObject2;
      XLayoutStyle localXLayoutStyle;
      for (Object localObject1 = this; i < j; localObject1 = localObject2)
      {
        localObject2 = (i)a.get(i);
        if (localObject1 != this)
        {
          ((i)localObject2).a(c.a, (i)localObject1, c.c);
          ((i)localObject1).a(c.c, (i)localObject2, c.a);
        }
        else
        {
          localXLayoutStyle = XLayoutStyle.b;
          if (d == AllowedSolution.c) {
            localXLayoutStyle = XLayoutStyle.e;
          }
          c localC = c.a;
          ((i)localObject2).a(localC, (i)localObject1, localC, 0, localXLayoutStyle);
        }
        localObject1 = c.d;
        ((i)localObject2).a((c)localObject1, this, (c)localObject1);
        localObject1 = c.b;
        ((i)localObject2).a((c)localObject1, this, (c)localObject1);
        i += 1;
      }
      if (localObject1 != this)
      {
        localXLayoutStyle = XLayoutStyle.b;
        if (d == AllowedSolution.V) {
          localXLayoutStyle = XLayoutStyle.e;
        }
        localObject2 = c.c;
        ((i)localObject1).a((c)localObject2, this, (c)localObject2, 0, localXLayoutStyle);
      }
    }
    super.a(paramF, paramInt);
  }
}
