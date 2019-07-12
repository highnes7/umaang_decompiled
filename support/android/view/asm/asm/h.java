package support.android.view.asm.asm;

import b.b.d.a.a.d.a;
import b.b.d.a.a.d.b;
import b.b.d.a.a.j;
import java.util.ArrayList;

public class h
  extends f
{
  public static final int d = 0;
  public static final int i = 3;
  public static final int q = 2;
  public static final int t = 1;
  public ArrayList<d.b> a = new ArrayList();
  public support.android.view.asm.f b = null;
  public int c = 8;
  public ArrayList<d.a> j = new ArrayList();
  public ArrayList<j> m = new ArrayList();
  public ArrayList<j> n = new ArrayList();
  public boolean p = true;
  public int s = 0;
  public int x = 0;
  
  public h() {}
  
  public h(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void b()
  {
    int i2 = a.size();
    int k = 0;
    int i1 = 0;
    while (k < i2)
    {
      i localI1 = (i)a.get(k);
      i1 = localI1.q() + i1;
      int i3 = x;
      int i4 = i1 / i3;
      Object localObject = (Item)j.get(i4);
      m localM = (m)a.get(i1 % i3);
      i localI2 = b;
      i localI3 = a;
      i localI4 = b;
      localObject = c;
      localI1.a(c.a).a(localI2.a(c.a), c);
      if ((localI3 instanceof ByteVector)) {
        localI1.a(c.c).a(localI3.a(c.a), c);
      } else {
        localI1.a(c.c).a(localI3.a(c.c), c);
      }
      i3 = i;
      if (i3 != 1)
      {
        if (i3 != 2)
        {
          if (i3 == 3) {
            localI1.a(Integer.left);
          }
        }
        else
        {
          localI1.a(c.a).a(XLayoutStyle.e);
          localI1.a(c.c).a(XLayoutStyle.b);
        }
      }
      else
      {
        localI1.a(c.a).a(XLayoutStyle.b);
        localI1.a(c.c).a(XLayoutStyle.e);
      }
      localI1.a(c.d).a(localI4.a(c.d), c);
      if ((localObject instanceof ByteVector)) {
        localI1.a(c.b).a(((i)localObject).a(c.d), c);
      } else {
        localI1.a(c.b).a(((i)localObject).a(c.b), c);
      }
      i1 += 1;
      k += 1;
    }
  }
  
  private void c()
  {
    if (b == null) {
      return;
    }
    int i2 = n.size();
    int i1 = 0;
    int k = 0;
    ByteVector localByteVector;
    support.android.view.asm.f localF;
    StringBuilder localStringBuilder;
    while (k < i2)
    {
      localByteVector = (ByteVector)n.get(k);
      localF = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getActionView());
      localStringBuilder.append(".VG");
      localStringBuilder.append(k);
      localByteVector.a(localF, localStringBuilder.toString());
      k += 1;
    }
    i2 = m.size();
    k = i1;
    while (k < i2)
    {
      localByteVector = (ByteVector)m.get(k);
      localF = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getActionView());
      localStringBuilder.append(".HG");
      localStringBuilder.append(k);
      localByteVector.a(localF, localStringBuilder.toString());
      k += 1;
    }
  }
  
  private void initialize()
  {
    a.clear();
    float f2 = 100.0F / x;
    int k = 0;
    Object localObject = this;
    float f1 = f2;
    while (k < x)
    {
      m localM = new m(this);
      b = ((i)localObject);
      if (k < x - 1)
      {
        localObject = new ByteVector();
        ((ByteVector)localObject).a(1);
        ((i)localObject).e(this);
        ((ByteVector)localObject).read((int)f1);
        f1 += f2;
        a = ((i)localObject);
        n.add(localObject);
      }
      else
      {
        a = this;
      }
      localObject = a;
      a.add(localM);
      k += 1;
    }
    c();
  }
  
  private void update()
  {
    j.clear();
    float f2 = 100.0F / s;
    Object localObject = this;
    float f1 = f2;
    int k = 0;
    while (k < s)
    {
      Item localItem = new Item(this);
      b = ((i)localObject);
      if (k < s - 1)
      {
        localObject = new ByteVector();
        ((ByteVector)localObject).a(0);
        ((i)localObject).e(this);
        ((ByteVector)localObject).read((int)f1);
        f1 += f2;
        c = ((i)localObject);
        m.add(localObject);
      }
      else
      {
        c = this;
      }
      localObject = c;
      j.add(localItem);
      k += 1;
    }
    c();
  }
  
  public void a()
  {
    int i2 = a.size();
    int k = 0;
    int i1 = 0;
    while (k < i2)
    {
      i1 += ((i)a.get(k)).q();
      k += 1;
    }
    i2 += i1;
    int i3;
    if (p)
    {
      if (x == 0) {
        c(1);
      }
      i3 = x;
      i1 = i2 / i3;
      k = i1;
      if (i3 * i1 < i2) {
        k = i1 + 1;
      }
      if ((s == k) && (n.size() == x - 1)) {
        return;
      }
      s = k;
      update();
    }
    else
    {
      if (s == 0) {
        setEnabled(1);
      }
      i3 = s;
      i1 = i2 / i3;
      k = i1;
      if (i3 * i1 < i2) {
        k = i1 + 1;
      }
      if ((x == k) && (m.size() == s - 1)) {
        return;
      }
      x = k;
      initialize();
    }
    b();
  }
  
  public void a(String paramString)
  {
    int i1 = paramString.length();
    int k = 0;
    while (k < i1)
    {
      int i2 = paramString.charAt(k);
      if (i2 == 76) {
        c(k, 1);
      } else if (i2 == 67) {
        c(k, 0);
      } else if (i2 == 70) {
        c(k, 3);
      } else if (i2 == 82) {
        c(k, 2);
      } else {
        c(k, 0);
      }
      k += 1;
    }
  }
  
  public void a(support.android.view.asm.f paramF, int paramInt)
  {
    super.a(paramF, paramInt);
    int i3 = a.size();
    if (i3 == 0) {
      return;
    }
    a();
    if (paramF == c)
    {
      int i1 = n.size();
      int i2 = 0;
      int k = 0;
      boolean bool;
      ByteVector localByteVector;
      for (;;)
      {
        bool = true;
        if (k >= i1) {
          break;
        }
        localByteVector = (ByteVector)n.get(k);
        if (invoke() != Integer.p) {
          bool = false;
        }
        localByteVector.b(bool);
        localByteVector.a(paramF, paramInt);
        k += 1;
      }
      int i4 = m.size();
      k = 0;
      for (;;)
      {
        i1 = i2;
        if (k >= i4) {
          break;
        }
        localByteVector = (ByteVector)m.get(k);
        if (isEmpty() == Integer.p) {
          bool = true;
        } else {
          bool = false;
        }
        localByteVector.b(bool);
        localByteVector.a(paramF, paramInt);
        k += 1;
      }
      while (i1 < i3)
      {
        ((i)a.get(i1)).a(paramF, paramInt);
        i1 += 1;
      }
    }
  }
  
  public void a(support.android.view.asm.f paramF, String paramString)
  {
    b = paramF;
    super.a(paramF, paramString);
    c();
  }
  
  public void b(int paramInt)
  {
    m localM = (m)a.get(paramInt);
    paramInt = i;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
    else {
      i = 2;
    }
    b();
  }
  
  public void c(int paramInt)
  {
    if ((p) && (x != paramInt))
    {
      x = paramInt;
      initialize();
      a();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 < a.size())
    {
      a.get(paramInt1)).i = paramInt2;
      b();
    }
  }
  
  public void copy()
  {
    int i2 = n.size();
    int i1 = 0;
    int k = 0;
    while (k < i2)
    {
      ((ByteVector)n.get(k)).read();
      k += 1;
    }
    i2 = m.size();
    k = i1;
    while (k < i2)
    {
      ((ByteVector)m.get(k)).read();
      k += 1;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    p = paramBoolean;
  }
  
  public String doInBackground()
  {
    int i1 = a.size();
    Object localObject2 = "";
    int k = 0;
    while (k < i1)
    {
      int i2 = a.get(k)).i;
      Object localObject1;
      if (i2 == 1)
      {
        localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject2, "L");
      }
      else if (i2 == 0)
      {
        localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject2, "C");
      }
      else if (i2 == 3)
      {
        localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject2, "F");
      }
      else
      {
        localObject1 = localObject2;
        if (i2 == 2) {
          localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject2, "R");
        }
      }
      k += 1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public String getKeyName(int paramInt)
  {
    paramInt = a.get(paramInt)).i;
    if (paramInt == 1) {
      return "L";
    }
    if (paramInt == 0) {
      return "C";
    }
    if (paramInt == 3) {
      return "F";
    }
    if (paramInt == 2) {
      return "R";
    }
    return "!";
  }
  
  public int getMaxX()
  {
    return x;
  }
  
  public int getSupportActionProvider()
  {
    return s;
  }
  
  public int getTitle()
  {
    return c;
  }
  
  public String i()
  {
    return "ConstraintTableLayout";
  }
  
  public boolean isCheckable()
  {
    return p;
  }
  
  public ArrayList l()
  {
    return m;
  }
  
  public void setEnabled(int paramInt)
  {
    if ((!p) && (x != paramInt))
    {
      s = paramInt;
      update();
      a();
    }
  }
  
  public void setIcon(int paramInt)
  {
    if (paramInt > 1) {
      c = paramInt;
    }
  }
  
  public void toString(support.android.view.asm.f paramF, int paramInt)
  {
    super.toString(paramF, paramInt);
    if (paramF == c)
    {
      int i2 = n.size();
      int i1 = 0;
      int k = 0;
      while (k < i2)
      {
        ((ByteVector)n.get(k)).toString(paramF, paramInt);
        k += 1;
      }
      i2 = m.size();
      k = i1;
      while (k < i2)
      {
        ((ByteVector)m.get(k)).toString(paramF, paramInt);
        k += 1;
      }
    }
  }
  
  public ArrayList visit()
  {
    return n;
  }
}
