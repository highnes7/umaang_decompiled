package support.android.view.asm;

public class h
{
  public static final boolean I = false;
  public Label a = null;
  public final i b;
  public boolean i = false;
  public float k = 0.0F;
  public boolean s = false;
  
  public h(Item paramItem)
  {
    b = new i(this, paramItem);
  }
  
  public String a()
  {
    if (a == null)
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString("", "0");
    }
    else
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
      ((StringBuilder)localObject1).append(a);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject1, " = ");
    Object localObject1 = localObject2;
    float f1 = k;
    int n = 0;
    if (f1 != 0.0F)
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject2);
      ((StringBuilder)localObject1).append(k);
      localObject1 = ((StringBuilder)localObject1).toString();
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i1 = b.c;
    int m = j;
    int j = n;
    while (j < i1)
    {
      localObject2 = b.a(j);
      if (localObject2 != null)
      {
        float f2 = b.b(j);
        f1 = f2;
        String str = ((Label)localObject2).toString();
        if (m == 0)
        {
          localObject2 = localObject1;
          if (f2 >= 0.0F) {
            break label217;
          }
          localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject1, "- ");
        }
        else
        {
          if (f2 > 0.0F)
          {
            localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject1, " + ");
            break label217;
          }
          localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject1, " - ");
        }
        f1 = f2 * -1.0F;
        label217:
        if (f1 == 1.0F)
        {
          localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject2, str);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(f1);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(str);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        m = 1;
      }
      j += 1;
    }
    if (m == 0) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject1, "0.0");
    }
    return localObject1;
  }
  
  public h a(float paramFloat1, float paramFloat2, float paramFloat3, Label paramLabel1, int paramInt1, Label paramLabel2, int paramInt2, Label paramLabel3, int paramInt3, Label paramLabel4, int paramInt4)
  {
    if ((paramFloat2 != 0.0F) && (paramFloat1 != paramFloat3))
    {
      paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
      paramFloat2 = -paramInt1 - paramInt2;
      paramFloat3 = paramInt3;
      k = (paramInt4 * paramFloat1 + (paramFloat3 * paramFloat1 + paramFloat2));
      b.a(paramLabel1, 1.0F);
      b.a(paramLabel2, -1.0F);
      b.a(paramLabel4, paramFloat1);
      b.a(paramLabel3, -paramFloat1);
      return this;
    }
    k = (-paramInt1 - paramInt2 + paramInt3 + paramInt4);
    b.a(paramLabel1, 1.0F);
    b.a(paramLabel2, -1.0F);
    b.a(paramLabel4, 1.0F);
    b.a(paramLabel3, -1.0F);
    return this;
  }
  
  public h a(Label paramLabel, int paramInt)
  {
    if (paramInt < 0)
    {
      k = (paramInt * -1);
      b.a(paramLabel, 1.0F);
      return this;
    }
    k = paramInt;
    b.a(paramLabel, -1.0F);
    return this;
  }
  
  public h a(Label paramLabel1, Label paramLabel2)
  {
    b.a(paramLabel1, 1.0F);
    b.a(paramLabel2, -1.0F);
    return this;
  }
  
  public h a(Label paramLabel1, Label paramLabel2, int paramInt)
  {
    int j = 0;
    int m = 0;
    if (paramInt != 0)
    {
      j = m;
      m = paramInt;
      if (paramInt < 0)
      {
        m = paramInt * -1;
        j = 1;
      }
      k = m;
    }
    if (j == 0)
    {
      b.a(paramLabel1, -1.0F);
      b.a(paramLabel2, 1.0F);
      return this;
    }
    b.a(paramLabel1, 1.0F);
    b.a(paramLabel2, -1.0F);
    return this;
  }
  
  public h a(Label paramLabel1, Label paramLabel2, int paramInt1, float paramFloat, Label paramLabel3, Label paramLabel4, int paramInt2)
  {
    if (paramLabel2 == paramLabel3)
    {
      b.a(paramLabel1, 1.0F);
      b.a(paramLabel4, 1.0F);
      b.a(paramLabel2, -2.0F);
      return this;
    }
    if (paramFloat == 0.5F)
    {
      b.a(paramLabel1, 1.0F);
      b.a(paramLabel2, -1.0F);
      b.a(paramLabel3, -1.0F);
      b.a(paramLabel4, 1.0F);
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        k = (-paramInt1 + paramInt2);
        return this;
      }
    }
    else
    {
      if (paramFloat <= 0.0F)
      {
        b.a(paramLabel1, -1.0F);
        b.a(paramLabel2, 1.0F);
        k = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        b.a(paramLabel3, -1.0F);
        b.a(paramLabel4, 1.0F);
        k = paramInt2;
        return this;
      }
      i localI = b;
      float f1 = 1.0F - paramFloat;
      localI.a(paramLabel1, f1 * 1.0F);
      b.a(paramLabel2, f1 * -1.0F);
      b.a(paramLabel3, -1.0F * paramFloat);
      b.a(paramLabel4, 1.0F * paramFloat);
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        float f2 = -paramInt1;
        k = (paramInt2 * paramFloat + f2 * f1);
      }
    }
    return this;
  }
  
  public h a(Label paramLabel1, Label paramLabel2, Label paramLabel3, float paramFloat)
  {
    b.a(paramLabel1, -1.0F);
    b.a(paramLabel2, 1.0F - paramFloat);
    b.a(paramLabel3, paramFloat);
    return this;
  }
  
  public h a(Label paramLabel1, Label paramLabel2, Label paramLabel3, int paramInt)
  {
    int j = 0;
    int m = 0;
    if (paramInt != 0)
    {
      j = m;
      m = paramInt;
      if (paramInt < 0)
      {
        m = paramInt * -1;
        j = 1;
      }
      k = m;
    }
    if (j == 0)
    {
      b.a(paramLabel1, -1.0F);
      b.a(paramLabel2, 1.0F);
      b.a(paramLabel3, -1.0F);
      return this;
    }
    b.a(paramLabel1, 1.0F);
    b.a(paramLabel2, -1.0F);
    b.a(paramLabel3, 1.0F);
    return this;
  }
  
  public h a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, float paramFloat)
  {
    b.a(paramLabel1, -1.0F);
    b.a(paramLabel2, 1.0F);
    b.a(paramLabel3, paramFloat);
    b.a(paramLabel4, -paramFloat);
    return this;
  }
  
  public void a(Label paramLabel)
  {
    Label localLabel = a;
    if (localLabel != null)
    {
      b.a(localLabel, -1.0F);
      a = null;
    }
    float f = b.a(paramLabel) * -1.0F;
    a = paramLabel;
    if (f == 1.0F) {
      return;
    }
    k /= f;
    b.b(f);
  }
  
  public h b(Label paramLabel, int paramInt)
  {
    a = paramLabel;
    float f = paramInt;
    g = f;
    k = f;
    s = true;
    return this;
  }
  
  public h b(Label paramLabel1, Label paramLabel2, Label paramLabel3, int paramInt)
  {
    int j = 0;
    int m = 0;
    if (paramInt != 0)
    {
      j = m;
      m = paramInt;
      if (paramInt < 0)
      {
        m = paramInt * -1;
        j = 1;
      }
      k = m;
    }
    if (j == 0)
    {
      b.a(paramLabel1, -1.0F);
      b.a(paramLabel2, 1.0F);
      b.a(paramLabel3, 1.0F);
      return this;
    }
    b.a(paramLabel1, 1.0F);
    b.a(paramLabel2, -1.0F);
    b.a(paramLabel3, -1.0F);
    return this;
  }
  
  public void b()
  {
    a = null;
    b.f();
    k = 0.0F;
    s = false;
  }
  
  public boolean b(Label paramLabel)
  {
    return b.c(paramLabel);
  }
  
  public boolean b(h paramH)
  {
    b.a(this, paramH);
    return true;
  }
  
  public h c(Label paramLabel, int paramInt)
  {
    b.a(paramLabel, paramInt);
    return this;
  }
  
  public boolean c()
  {
    Label localLabel = a;
    return (localLabel != null) && ((a == c.b) || (k >= 0.0F));
  }
  
  public void d()
  {
    float f = k;
    if (f < 0.0F)
    {
      k = (f * -1.0F);
      b.draw();
    }
  }
  
  public void e()
  {
    Label localLabel = b.b();
    if (localLabel != null) {
      a(localLabel);
    }
    if (b.c == 0) {
      s = true;
    }
  }
  
  public boolean expandActionView()
  {
    return b.c();
  }
  
  public void setChecked()
  {
    b.b(this);
  }
  
  public int setEnabled()
  {
    int j;
    if (a != null) {
      j = 4;
    } else {
      j = 0;
    }
    return b.size() + (j + 4 + 4);
  }
  
  public String toString()
  {
    return a();
  }
}
