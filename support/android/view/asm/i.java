package support.android.view.asm;

import java.io.PrintStream;
import java.util.Arrays;

public class i
{
  public static final boolean d = false;
  public static final int v = -1;
  public float[] a;
  public int[] b;
  public int c = 0;
  public final Item e;
  public Label f = null;
  public int g = 8;
  public int[] j;
  public int k;
  public int l;
  public boolean m;
  public final h x;
  
  public i(h paramH, Item paramItem)
  {
    int i = g;
    j = new int[i];
    b = new int[i];
    a = new float[i];
    k = -1;
    l = -1;
    m = false;
    x = paramH;
    e = paramItem;
  }
  
  public final float a(Label paramLabel)
  {
    if (f == paramLabel) {
      f = null;
    }
    int i = k;
    if (i == -1) {
      return 0.0F;
    }
    int n = 0;
    int i1 = -1;
    while ((i != -1) && (n < c))
    {
      int i2 = j[i];
      if (i2 == j)
      {
        if (i == k)
        {
          k = b[i];
        }
        else
        {
          paramLabel = b;
          paramLabel[i1] = paramLabel[i];
        }
        e.i[i2].a(x);
        c -= 1;
        j[i] = -1;
        if (m) {
          l = i;
        }
        return a[i];
      }
      int[] arrayOfInt = b;
      n += 1;
      i1 = i;
      i = arrayOfInt[i];
    }
    return 0.0F;
  }
  
  public Label a()
  {
    Object localObject1 = f;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      int n = k;
      int i = 0;
      for (localObject1 = null;; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (n == -1) {
          break;
        }
        localObject2 = localObject1;
        if (i >= c) {
          break;
        }
        localObject2 = localObject1;
        if (a[n] < 0.0F)
        {
          Label localLabel = e.i[j[n]];
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (i >= i) {}
          }
          else
          {
            localObject2 = localLabel;
          }
        }
        n = b[n];
        i += 1;
      }
    }
    return localObject2;
  }
  
  public final Label a(int paramInt)
  {
    int n = k;
    int i = 0;
    while ((n != -1) && (i < c))
    {
      if (i == paramInt) {
        return e.i[j[n]];
      }
      n = b[n];
      i += 1;
    }
    return null;
  }
  
  public final void a(Label paramLabel, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      a(paramLabel);
      return;
    }
    int i = k;
    Object localObject;
    if (i == -1)
    {
      k = 0;
      localObject = a;
      i = k;
      localObject[i] = paramFloat;
      j[i] = j;
      b[i] = -1;
      c += 1;
      if (!m) {
        l += 1;
      }
    }
    else
    {
      int n = 0;
      int i2 = -1;
      int i1;
      while ((i != -1) && (n < c))
      {
        localObject = j;
        int i3 = localObject[i];
        i1 = j;
        if (i3 == i1)
        {
          a[i] = paramFloat;
          return;
        }
        if (localObject[i] < i1) {
          i2 = i;
        }
        i = b[i];
        n += 1;
      }
      i = l;
      if (m)
      {
        localObject = j;
        if (localObject[i] != -1) {
          i = localObject.length;
        }
      }
      else
      {
        i += 1;
      }
      localObject = j;
      n = i;
      if (i >= localObject.length)
      {
        n = i;
        if (c < localObject.length)
        {
          i1 = 0;
          for (;;)
          {
            localObject = j;
            n = i;
            if (i1 >= localObject.length) {
              break;
            }
            if (localObject[i1] == -1)
            {
              n = i1;
              break;
            }
            i1 += 1;
          }
        }
      }
      localObject = j;
      i = n;
      if (n >= localObject.length)
      {
        i = localObject.length;
        g *= 2;
        m = false;
        l = (i - 1);
        a = Arrays.copyOf(a, g);
        j = Arrays.copyOf(j, g);
        b = Arrays.copyOf(b, g);
      }
      j[i] = j;
      a[i] = paramFloat;
      if (i2 != -1)
      {
        paramLabel = b;
        paramLabel[i] = paramLabel[i2];
        paramLabel[i2] = i;
      }
      else
      {
        b[i] = k;
        k = i;
      }
      c += 1;
      if (!m) {
        l += 1;
      }
      if (c >= j.length) {
        m = true;
      }
    }
  }
  
  public void a(h paramH1, h paramH2)
  {
    int i = k;
    int n = 0;
    for (;;)
    {
      if ((i == -1) || (n >= c)) {
        return;
      }
      int i1 = j[i];
      Object localObject = a;
      if (i1 == j)
      {
        float f1 = a[i];
        a((Label)localObject);
        localObject = b;
        n = k;
        i = 0;
        while ((n != -1) && (i < c))
        {
          b(e.i[j[n]], a[n] * f1);
          n = b[n];
          i += 1;
        }
        float f2 = k;
        k = (k * f1 + f2);
        a.a(paramH1);
        i = k;
        break;
      }
      i = b[i];
      n += 1;
    }
  }
  
  public void a(h paramH, h[] paramArrayOfH)
  {
    int i = k;
    i localI1 = this;
    int n = 0;
    for (;;)
    {
      if ((i == -1) || (n >= c)) {
        return;
      }
      Object localObject = e.i[j[i]];
      if (c != -1)
      {
        float f1 = a[i];
        localI1.a((Label)localObject);
        localObject = paramArrayOfH[c];
        if (!s)
        {
          i localI2 = b;
          n = k;
          i = 0;
          while ((n != -1) && (i < c))
          {
            localI1.b(e.i[j[n]], a[n] * f1);
            n = b[n];
            i += 1;
          }
        }
        float f2 = k;
        k = (k * f1 + f2);
        a.a(paramH);
        i = k;
        break;
      }
      i = b[i];
      n += 1;
    }
  }
  
  public final float b(int paramInt)
  {
    int n = k;
    int i = 0;
    while ((n != -1) && (i < c))
    {
      if (i == paramInt) {
        return a[n];
      }
      n = b[n];
      i += 1;
    }
    return 0.0F;
  }
  
  public final float b(Label paramLabel)
  {
    int n = k;
    int i = 0;
    while ((n != -1) && (i < c))
    {
      if (j[n] == j) {
        return a[n];
      }
      n = b[n];
      i += 1;
    }
    return 0.0F;
  }
  
  public Label b()
  {
    int n = k;
    Object localObject2 = null;
    int i = 0;
    label81:
    Object localObject4;
    for (Object localObject1 = null; (n != -1) && (i < c); localObject1 = localObject4)
    {
      Object localObject3 = a;
      float f2 = localObject3[n];
      if (f2 < 0.0F)
      {
        f1 = f2;
        if (f2 <= -0.001F) {
          break label81;
        }
        localObject3[n] = 0.0F;
      }
      else
      {
        f1 = f2;
        if (f2 >= 0.001F) {
          break label81;
        }
        localObject3[n] = 0.0F;
      }
      float f1 = 0.0F;
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (f1 != 0.0F)
      {
        Label localLabel = e.i[j[n]];
        if (a == c.b)
        {
          if (f1 < 0.0F) {
            return localLabel;
          }
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localLabel;
            localObject3 = localObject2;
          }
        }
        else
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (f1 < 0.0F) {
            if (localObject2 != null)
            {
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (i >= i) {}
            }
            else
            {
              localObject3 = localLabel;
              localObject4 = localObject1;
            }
          }
        }
      }
      n = b[n];
      i += 1;
      localObject2 = localObject3;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return localObject2;
  }
  
  public void b(float paramFloat)
  {
    int n = k;
    int i = 0;
    while ((n != -1) && (i < c))
    {
      float[] arrayOfFloat = a;
      arrayOfFloat[n] /= paramFloat;
      n = b[n];
      i += 1;
    }
  }
  
  public final void b(Label paramLabel, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    int i = k;
    Object localObject;
    if (i == -1)
    {
      k = 0;
      localObject = a;
      i = k;
      localObject[i] = paramFloat;
      j[i] = j;
      b[i] = -1;
      c += 1;
      if (!m) {
        l += 1;
      }
    }
    else
    {
      int n = 0;
      int i2 = -1;
      int i1;
      while ((i != -1) && (n < c))
      {
        localObject = j;
        int i3 = localObject[i];
        i1 = j;
        if (i3 == i1)
        {
          paramLabel = a;
          paramLabel[i] += paramFloat;
          if (paramLabel[i] != 0.0F) {
            return;
          }
          if (i == k)
          {
            k = b[i];
          }
          else
          {
            paramLabel = b;
            paramLabel[i2] = paramLabel[i];
          }
          e.i[i3].a(x);
          if (m) {
            l = i;
          }
          c -= 1;
          return;
        }
        if (localObject[i] < i1) {
          i2 = i;
        }
        i = b[i];
        n += 1;
      }
      i = l;
      if (m)
      {
        localObject = j;
        if (localObject[i] != -1) {
          i = localObject.length;
        }
      }
      else
      {
        i += 1;
      }
      localObject = j;
      n = i;
      if (i >= localObject.length)
      {
        n = i;
        if (c < localObject.length)
        {
          i1 = 0;
          for (;;)
          {
            localObject = j;
            n = i;
            if (i1 >= localObject.length) {
              break;
            }
            if (localObject[i1] == -1)
            {
              n = i1;
              break;
            }
            i1 += 1;
          }
        }
      }
      localObject = j;
      i = n;
      if (n >= localObject.length)
      {
        i = localObject.length;
        g *= 2;
        m = false;
        l = (i - 1);
        a = Arrays.copyOf(a, g);
        j = Arrays.copyOf(j, g);
        b = Arrays.copyOf(b, g);
      }
      j[i] = j;
      a[i] = paramFloat;
      if (i2 != -1)
      {
        paramLabel = b;
        paramLabel[i] = paramLabel[i2];
        paramLabel[i2] = i;
      }
      else
      {
        b[i] = k;
        k = i;
      }
      c += 1;
      if (!m) {
        l += 1;
      }
      i = l;
      paramLabel = j;
      if (i >= paramLabel.length)
      {
        m = true;
        l = (paramLabel.length - 1);
      }
    }
  }
  
  public void b(h paramH)
  {
    int n = k;
    int i = 0;
    while ((n != -1) && (i < c))
    {
      e.i[j[n]].b(paramH);
      n = b[n];
      i += 1;
    }
  }
  
  public boolean c()
  {
    int n = k;
    int i = 0;
    while ((n != -1) && (i < c))
    {
      if (a[n] > 0.0F) {
        return true;
      }
      n = b[n];
      i += 1;
    }
    return false;
  }
  
  public final boolean c(Label paramLabel)
  {
    int n = k;
    if (n == -1) {
      return false;
    }
    int i = 0;
    while ((n != -1) && (i < c))
    {
      if (j[n] == j) {
        return true;
      }
      n = b[n];
      i += 1;
    }
    return false;
  }
  
  public void draw()
  {
    int n = k;
    int i = 0;
    while ((n != -1) && (i < c))
    {
      float[] arrayOfFloat = a;
      arrayOfFloat[n] *= -1.0F;
      n = b[n];
      i += 1;
    }
  }
  
  public final void f()
  {
    k = -1;
    l = -1;
    m = false;
    c = 0;
  }
  
  public int size()
  {
    return j.length * 4 * 3 + 0 + 36;
  }
  
  public String toString()
  {
    int n = k;
    Object localObject = "";
    int i = 0;
    while ((n != -1) && (i < c))
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, " -> "));
      ((StringBuilder)localObject).append(a[n]);
      ((StringBuilder)localObject).append(" : ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(((StringBuilder)localObject).toString());
      ((StringBuilder)localObject).append(e.i[j[n]]);
      localObject = ((StringBuilder)localObject).toString();
      n = b[n];
      i += 1;
    }
    return localObject;
  }
  
  public void write()
  {
    int n = c;
    System.out.print("{ ");
    int i = 0;
    while (i < n)
    {
      Label localLabel = a(i);
      if (localLabel != null)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localLabel);
        localStringBuilder.append(" = ");
        localStringBuilder.append(b(i));
        localStringBuilder.append(" ");
        localPrintStream.print(localStringBuilder.toString());
      }
      i += 1;
    }
    System.out.println(" }");
  }
}
