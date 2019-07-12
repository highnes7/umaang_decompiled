package support.android.view.asm.asm;

public class Attribute
{
  public Attribute() {}
  
  public static void a(f paramF, support.android.view.asm.f paramF1, int paramInt, i paramI)
  {
    Object localObject1 = paramI;
    Object localObject2 = null;
    int m = 0;
    float f2 = 0.0F;
    int i;
    float f1;
    int j;
    Object localObject3;
    for (int k = 0;; k = j)
    {
      int n = 1;
      if (localObject1 == null) {
        break;
      }
      if (((i)localObject1).get() != 8) {
        n = 0;
      }
      i = m;
      f1 = f2;
      j = k;
      if (n == 0)
      {
        m += 1;
        if (type != Integer.left)
        {
          n = ((i)localObject1).getValue();
          localObject2 = f;
          if (b != null) {
            i = ((Label)localObject2).a();
          } else {
            i = 0;
          }
          localObject2 = b;
          if (b != null) {
            j = ((Label)localObject2).a();
          } else {
            j = 0;
          }
          j = n + k + i + j;
          i = m;
          f1 = f2;
        }
        else
        {
          f1 = f2 + k;
          j = k;
          i = m;
        }
      }
      localObject2 = b.b;
      if (localObject2 != null) {
        localObject3 = a;
      } else {
        localObject3 = null;
      }
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        Label localLabel = f.b;
        if (localLabel != null)
        {
          localObject2 = localObject3;
          if (localLabel != null)
          {
            localObject2 = localObject3;
            if (a == localObject1) {}
          }
        }
        else
        {
          localObject2 = null;
        }
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      m = i;
      f2 = f1;
    }
    if (localObject2 != null)
    {
      localObject1 = b.b;
      if (localObject1 != null) {
        i = a.getString();
      } else {
        i = 0;
      }
      localObject1 = b.b;
      j = i;
      if (localObject1 != null)
      {
        j = i;
        if (a == paramF) {
          j = paramF.getItemId();
        }
      }
    }
    else
    {
      j = 0;
    }
    float f5 = j - 0 - k;
    float f3 = f5 / (m + 1);
    if (paramInt == 0)
    {
      f1 = f3;
    }
    else
    {
      f3 = f5 / paramInt;
      f1 = 0.0F;
    }
    while (paramI != null)
    {
      localObject1 = f;
      if (b != null) {
        i = ((Label)localObject1).a();
      } else {
        i = 0;
      }
      localObject1 = b;
      if (b != null) {
        j = ((Label)localObject1).a();
      } else {
        j = 0;
      }
      float f4;
      if (paramI.get() != 8)
      {
        float f6 = i;
        f4 = f1 + f6;
        paramF1.a(f.c, (int)(f4 + 0.5F));
        if (type == Integer.left)
        {
          if (f2 == 0.0F) {
            f1 = f3 - f6;
          } else {
            f1 = k * f5 / f2 - f6;
          }
          f1 = f1 - j + f4;
        }
        else
        {
          f1 = paramI.getValue() + f4;
        }
        paramF1.a(b.c, (int)(0.5F + f1));
        f4 = f1;
        if (paramInt == 0) {
          f4 = f1 + f3;
        }
        f1 = f4 + j;
      }
      else
      {
        f4 = f3 / 2.0F;
        localObject1 = f.c;
        i = (int)(f1 - f4 + 0.5F);
        paramF1.a((support.android.view.asm.Label)localObject1, i);
        paramF1.a(b.c, i);
      }
      localObject1 = b.b;
      if (localObject1 != null) {
        localObject1 = a;
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject3 = f.b;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (a != paramI) {
            localObject2 = null;
          }
        }
      }
      if (localObject2 == paramF) {
        paramI = null;
      } else {
        paramI = (i)localObject2;
      }
    }
  }
  
  public static void a(f paramF, support.android.view.asm.f paramF1, i paramI)
  {
    Object localObject = type;
    if (localObject == Integer.left)
    {
      m = 1;
      return;
    }
    int i;
    int j;
    if ((type != Integer.p) && (localObject == Integer.a))
    {
      localObject = f;
      c = paramF1.a(localObject);
      localObject = b;
      c = paramF1.a(localObject);
      i = f.i;
      j = paramF.getValue() - b.i;
      paramF1.a(f.c, i);
      paramF1.a(b.c, j);
      paramI.d(i, j);
      m = 2;
      return;
    }
    localObject = f;
    Label localLabel1 = b;
    if (localLabel1 != null)
    {
      Label localLabel2 = b.b;
      if (localLabel2 != null)
      {
        if ((a == paramF) && (a == paramF))
        {
          j = ((Label)localObject).a();
          i = j;
          int k = b.a();
          if (type == Integer.left)
          {
            j = paramF.getValue() - k;
          }
          else
          {
            i = paramI.getValue();
            i = j + (int)((paramF.getValue() - j - k - i) * t + 0.5F);
            j = paramI.getValue() + i;
          }
          paramF = f;
          c = paramF1.a(paramF);
          paramF = b;
          c = paramF1.a(paramF);
          paramF1.a(f.c, i);
          paramF1.a(b.c, j);
          m = 2;
          paramI.d(i, j);
          return;
        }
        m = 1;
        return;
      }
    }
    localObject = f;
    localLabel1 = b;
    if ((localLabel1 != null) && (a == paramF))
    {
      i = ((Label)localObject).a();
      j = paramI.getValue() + i;
      paramF = f;
      c = paramF1.a(paramF);
      paramF = b;
      c = paramF1.a(paramF);
      paramF1.a(f.c, i);
      paramF1.a(b.c, j);
      m = 2;
      paramI.d(i, j);
      return;
    }
    localObject = b.b;
    if ((localObject != null) && (a == paramF))
    {
      localObject = f;
      c = paramF1.a(localObject);
      localObject = b;
      c = paramF1.a(localObject);
      i = paramF.getValue() - b.a();
      j = i - paramI.getValue();
      paramF1.a(f.c, j);
      paramF1.a(b.c, i);
      m = 2;
      paramI.d(j, i);
      return;
    }
    localObject = f;
    localLabel1 = b;
    if ((localLabel1 != null) && (a.m == 2))
    {
      paramF = c;
      c = paramF1.a(localObject);
      localObject = b;
      c = paramF1.a(localObject);
      i = (int)(g + f.a() + 0.5F);
      j = paramI.getValue() + i;
      paramF1.a(f.c, i);
      paramF1.a(b.c, j);
      m = 2;
      paramI.d(i, j);
      return;
    }
    localObject = b.b;
    if ((localObject != null) && (a.m == 2))
    {
      paramF = c;
      localObject = f;
      c = paramF1.a(localObject);
      localObject = b;
      c = paramF1.a(localObject);
      i = (int)(g - b.a() + 0.5F);
      j = i - paramI.getValue();
      paramF1.a(f.c, j);
      paramF1.a(b.c, i);
      m = 2;
      paramI.d(j, i);
      return;
    }
    if (f.b != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (b.b != null) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i == 0) && (j == 0)) {
      if ((paramI instanceof ByteVector))
      {
        localObject = (ByteVector)paramI;
        if (((ByteVector)localObject).add() == 1)
        {
          localLabel1 = f;
          c = paramF1.a(localLabel1);
          localLabel1 = b;
          c = paramF1.a(localLabel1);
          float f;
          if (((ByteVector)localObject).length() != -1)
          {
            f = ((ByteVector)localObject).length();
          }
          else if (((ByteVector)localObject).put() != -1)
          {
            f = paramF.getValue() - ((ByteVector)localObject).put();
          }
          else
          {
            f = paramF.getValue();
            f = ((ByteVector)localObject).getX() * f;
          }
          i = (int)(f + 0.5F);
          paramF1.a(f.c, i);
          paramF1.a(b.c, i);
          m = 2;
          x = 2;
          paramI.d(i, i);
          paramI.append(0, paramF.size());
        }
      }
      else
      {
        paramF = f;
        c = paramF1.a(paramF);
        paramF = b;
        c = paramF1.a(paramF);
        i = paramI.getString();
        j = paramI.getValue();
        paramF1.a(f.c, i);
        paramF1.a(b.c, j + i);
        m = 2;
      }
    }
  }
  
  public static void add(f paramF, support.android.view.asm.f paramF1, i paramI)
  {
    Object localObject1 = size;
    Object localObject2 = Integer.left;
    int k = 1;
    if (localObject1 == localObject2)
    {
      x = 1;
      return;
    }
    int i;
    int j;
    if ((size != Integer.p) && (localObject1 == Integer.a))
    {
      localObject1 = a;
      c = paramF1.a(localObject1);
      localObject1 = c;
      c = paramF1.a(localObject1);
      i = a.i;
      j = paramF.size() - c.i;
      paramF1.a(a.c, i);
      paramF1.a(c.c, j);
      if ((u > 0) || (paramI.get() == 8))
      {
        paramF = y;
        c = paramF1.a(paramF);
        paramF1.a(y.c, u + i);
      }
      paramI.append(i, j);
      x = 2;
      return;
    }
    localObject1 = a;
    localObject2 = b;
    float f;
    if (localObject2 != null)
    {
      Label localLabel = c.b;
      if (localLabel != null)
      {
        if ((a == paramF) && (a == paramF))
        {
          j = ((Label)localObject1).a();
          i = j;
          k = c.a();
          if (size == Integer.left)
          {
            j = paramI.size();
          }
          else
          {
            i = paramI.size();
            int m = paramF.size();
            f = j;
            i = (int)((m - j - k - i) * r + f + 0.5F);
            j = paramI.size();
          }
          j += i;
          paramF = a;
          c = paramF1.a(paramF);
          paramF = c;
          c = paramF1.a(paramF);
          paramF1.a(a.c, i);
          paramF1.a(c.c, j);
          if ((u > 0) || (paramI.get() == 8))
          {
            paramF = y;
            c = paramF1.a(paramF);
            paramF1.a(y.c, u + i);
          }
          x = 2;
          paramI.append(i, j);
          return;
        }
        x = 1;
        return;
      }
    }
    localObject1 = a;
    localObject2 = b;
    if ((localObject2 != null) && (a == paramF))
    {
      i = ((Label)localObject1).a();
      j = paramI.size() + i;
      paramF = a;
      c = paramF1.a(paramF);
      paramF = c;
      c = paramF1.a(paramF);
      paramF1.a(a.c, i);
      paramF1.a(c.c, j);
      if ((u > 0) || (paramI.get() == 8))
      {
        paramF = y;
        c = paramF1.a(paramF);
        paramF1.a(y.c, u + i);
      }
      x = 2;
      paramI.append(i, j);
      return;
    }
    localObject1 = c.b;
    if ((localObject1 != null) && (a == paramF))
    {
      localObject1 = a;
      c = paramF1.a(localObject1);
      localObject1 = c;
      c = paramF1.a(localObject1);
      i = paramF.size() - c.a();
      j = i - paramI.size();
      paramF1.a(a.c, j);
      paramF1.a(c.c, i);
      if ((u > 0) || (paramI.get() == 8))
      {
        paramF = y;
        c = paramF1.a(paramF);
        paramF1.a(y.c, u + j);
      }
      x = 2;
      paramI.append(j, i);
      return;
    }
    localObject1 = a;
    localObject2 = b;
    if ((localObject2 != null) && (a.x == 2))
    {
      paramF = c;
      c = paramF1.a(localObject1);
      localObject1 = c;
      c = paramF1.a(localObject1);
      i = (int)(g + a.a() + 0.5F);
      j = paramI.size() + i;
      paramF1.a(a.c, i);
      paramF1.a(c.c, j);
      if ((u > 0) || (paramI.get() == 8))
      {
        paramF = y;
        c = paramF1.a(paramF);
        paramF1.a(y.c, u + i);
      }
      x = 2;
      paramI.append(i, j);
      return;
    }
    localObject1 = c.b;
    if ((localObject1 != null) && (a.x == 2))
    {
      paramF = c;
      localObject1 = a;
      c = paramF1.a(localObject1);
      localObject1 = c;
      c = paramF1.a(localObject1);
      i = (int)(g - c.a() + 0.5F);
      j = i - paramI.size();
      paramF1.a(a.c, j);
      paramF1.a(c.c, i);
      if ((u > 0) || (paramI.get() == 8))
      {
        paramF = y;
        c = paramF1.a(paramF);
        paramF1.a(y.c, u + j);
      }
      x = 2;
      paramI.append(j, i);
      return;
    }
    localObject1 = y.b;
    if ((localObject1 != null) && (a.x == 2))
    {
      paramF = c;
      localObject1 = a;
      c = paramF1.a(localObject1);
      localObject1 = c;
      c = paramF1.a(localObject1);
      i = (int)(g - u + 0.5F);
      j = paramI.size() + i;
      paramF1.a(a.c, i);
      paramF1.a(c.c, j);
      paramF = y;
      c = paramF1.a(paramF);
      paramF1.a(y.c, u + i);
      x = 2;
      paramI.append(i, j);
      return;
    }
    if (y.b != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (a.b != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (c.b == null) {
      k = 0;
    }
    if ((i == 0) && (j == 0) && (k == 0)) {
      if ((paramI instanceof ByteVector))
      {
        localObject1 = (ByteVector)paramI;
        if (((ByteVector)localObject1).add() == 0)
        {
          localObject2 = a;
          c = paramF1.a(localObject2);
          localObject2 = c;
          c = paramF1.a(localObject2);
          if (((ByteVector)localObject1).length() != -1)
          {
            f = ((ByteVector)localObject1).length();
          }
          else if (((ByteVector)localObject1).put() != -1)
          {
            f = paramF.size() - ((ByteVector)localObject1).put();
          }
          else
          {
            f = paramF.size();
            f = ((ByteVector)localObject1).getX() * f;
          }
          i = (int)(f + 0.5F);
          paramF1.a(a.c, i);
          paramF1.a(c.c, i);
          x = 2;
          m = 2;
          paramI.append(i, i);
          paramI.d(0, paramF.getValue());
        }
      }
      else
      {
        paramF = a;
        c = paramF1.a(paramF);
        paramF = c;
        c = paramF1.a(paramF);
        i = paramI.f();
        j = paramI.size();
        paramF1.a(a.c, i);
        paramF1.a(c.c, j + i);
        if ((u > 0) || (paramI.get() == 8))
        {
          paramF = y;
          c = paramF1.a(paramF);
          paramF1.a(y.c, i + u);
        }
        x = 2;
      }
    }
  }
  
  public static void d(f paramF, support.android.view.asm.f paramF1, i paramI)
  {
    Label localLabel;
    int i;
    int j;
    if ((type != Integer.p) && (type == Integer.a))
    {
      localLabel = f;
      c = paramF1.a(localLabel);
      localLabel = b;
      c = paramF1.a(localLabel);
      i = f.i;
      j = paramF.getValue() - b.i;
      paramF1.a(f.c, i);
      paramF1.a(b.c, j);
      paramI.d(i, j);
      m = 2;
    }
    if ((size != Integer.p) && (size == Integer.a))
    {
      localLabel = a;
      c = paramF1.a(localLabel);
      localLabel = c;
      c = paramF1.a(localLabel);
      i = a.i;
      j = paramF.size() - c.i;
      paramF1.a(a.c, i);
      paramF1.a(c.c, j);
      if ((u > 0) || (paramI.get() == 8))
      {
        paramF = y;
        c = paramF1.a(paramF);
        paramF1.a(y.c, u + i);
      }
      paramI.append(i, j);
      x = 2;
    }
  }
  
  public static void draw(f paramF, support.android.view.asm.f paramF1, int paramInt, i paramI)
  {
    Object localObject1 = paramI;
    Object localObject2 = null;
    int m = 0;
    float f2 = 0.0F;
    int i;
    float f1;
    int j;
    Object localObject3;
    for (int k = 0;; k = j)
    {
      int n = 1;
      if (localObject1 == null) {
        break;
      }
      if (((i)localObject1).get() != 8) {
        n = 0;
      }
      i = m;
      f1 = f2;
      j = k;
      if (n == 0)
      {
        m += 1;
        if (size != Integer.left)
        {
          n = ((i)localObject1).size();
          localObject2 = a;
          if (b != null) {
            i = ((Label)localObject2).a();
          } else {
            i = 0;
          }
          localObject2 = c;
          if (b != null) {
            j = ((Label)localObject2).a();
          } else {
            j = 0;
          }
          j = n + k + i + j;
          i = m;
          f1 = f2;
        }
        else
        {
          f1 = f2 + g;
          j = k;
          i = m;
        }
      }
      localObject2 = c.b;
      if (localObject2 != null) {
        localObject3 = a;
      } else {
        localObject3 = null;
      }
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        Label localLabel = a.b;
        if (localLabel != null)
        {
          localObject2 = localObject3;
          if (localLabel != null)
          {
            localObject2 = localObject3;
            if (a == localObject1) {}
          }
        }
        else
        {
          localObject2 = null;
        }
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      m = i;
      f2 = f1;
    }
    if (localObject2 != null)
    {
      localObject1 = c.b;
      if (localObject1 != null) {
        i = a.getString();
      } else {
        i = 0;
      }
      localObject1 = c.b;
      j = i;
      if (localObject1 != null)
      {
        j = i;
        if (a == paramF) {
          j = paramF.d();
        }
      }
    }
    else
    {
      j = 0;
    }
    float f5 = j - 0 - k;
    float f3 = f5 / (m + 1);
    if (paramInt == 0)
    {
      f1 = f3;
    }
    else
    {
      f3 = f5 / paramInt;
      f1 = 0.0F;
    }
    while (paramI != null)
    {
      localObject1 = a;
      if (b != null) {
        i = ((Label)localObject1).a();
      } else {
        i = 0;
      }
      localObject1 = c;
      if (b != null) {
        j = ((Label)localObject1).a();
      } else {
        j = 0;
      }
      float f4;
      if (paramI.get() != 8)
      {
        float f6 = i;
        f4 = f1 + f6;
        paramF1.a(a.c, (int)(f4 + 0.5F));
        if (size == Integer.left)
        {
          if (f2 == 0.0F) {
            f1 = f3 - f6;
          } else {
            f1 = g * f5 / f2 - f6;
          }
          f1 = f1 - j + f4;
        }
        else
        {
          f1 = paramI.size() + f4;
        }
        paramF1.a(c.c, (int)(0.5F + f1));
        f4 = f1;
        if (paramInt == 0) {
          f4 = f1 + f3;
        }
        f1 = f4 + j;
      }
      else
      {
        f4 = f3 / 2.0F;
        localObject1 = a.c;
        i = (int)(f1 - f4 + 0.5F);
        paramF1.a((support.android.view.asm.Label)localObject1, i);
        paramF1.a(c.c, i);
      }
      localObject1 = c.b;
      if (localObject1 != null) {
        localObject1 = a;
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject3 = a.b;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (a != paramI) {
            localObject2 = null;
          }
        }
      }
      if (localObject2 == paramF) {
        paramI = null;
      } else {
        paramI = (i)localObject2;
      }
    }
  }
}
