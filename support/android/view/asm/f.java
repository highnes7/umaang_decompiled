package support.android.view.asm;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class f
{
  public static final boolean D = false;
  public static int s;
  public int a;
  public h[] b;
  public HashMap<String, b.b.d.a.h> c = null;
  public h[] f;
  public boolean[] g;
  public int h;
  public int i;
  public final Item j;
  public int k = 0;
  public Label[] n;
  public int p;
  public d r = new d();
  public int t;
  public int x = 32;
  
  public f()
  {
    int m = x;
    h = m;
    b = null;
    g = new boolean[m];
    i = 1;
    a = 0;
    p = m;
    n = new Label[s];
    t = 0;
    f = new h[m];
    b = new h[m];
    accept();
    j = new Item();
  }
  
  private int a(d paramD)
  {
    int m = 0;
    while (m < i)
    {
      g[m] = false;
      m += 1;
    }
    m = 0;
    int i4 = 0;
    int i3 = 0;
    while (m == 0)
    {
      int i5 = i4 + 1;
      Label localLabel = paramD.a();
      Object localObject2 = localLabel;
      int i1 = i3;
      int i2 = m;
      Object localObject1 = localObject2;
      if (localLabel != null)
      {
        localObject1 = g;
        i1 = j;
        if (localObject1[i1] != 0)
        {
          localObject1 = null;
          i1 = i3;
          i2 = m;
        }
        else
        {
          localObject1[i1] = 1;
          i3 += 1;
          i1 = i3;
          i2 = m;
          localObject1 = localObject2;
          if (i3 >= i)
          {
            i2 = 1;
            localObject1 = localObject2;
            i1 = i3;
          }
        }
      }
      if (localObject1 != null)
      {
        m = 0;
        i3 = -1;
        float f2;
        for (float f1 = Float.MAX_VALUE; m < a; f1 = f2)
        {
          localObject2 = b[m];
          if (a.a == c.b)
          {
            i4 = i3;
            f2 = f1;
          }
          else
          {
            i4 = i3;
            f2 = f1;
            if (((h)localObject2).b((Label)localObject1))
            {
              float f3 = b.b((Label)localObject1);
              i4 = i3;
              f2 = f1;
              if (f3 < 0.0F)
              {
                f3 = -k / f3;
                i4 = i3;
                f2 = f1;
                if (f3 < f1)
                {
                  i4 = m;
                  f2 = f3;
                }
              }
            }
          }
          m += 1;
          i3 = i4;
        }
        if (i3 > -1)
        {
          localObject2 = b[i3];
          a.c = -1;
          ((h)localObject2).a((Label)localObject1);
          a.c = i3;
          m = 0;
          while (m < a)
          {
            b[m].b((h)localObject2);
            m += 1;
          }
          paramD.a(this);
          try
          {
            b(paramD);
            i4 = i5;
            i3 = i1;
            m = i2;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i4 = i5;
            i3 = i1;
            m = i2;
          }
          continue;
        }
      }
      m = 1;
      i4 = i5;
      i3 = i1;
    }
    return i4;
  }
  
  private Label a(String paramString, c paramC)
  {
    if (i + 1 >= h) {
      b();
    }
    paramC = a(paramC);
    paramC.a(paramString);
    k += 1;
    i += 1;
    j = k;
    if (c == null) {
      c = new HashMap();
    }
    c.put(paramString, paramC);
    j.i[k] = paramC;
    return paramC;
  }
  
  private Label a(c paramC)
  {
    Object localObject = (Label)j.b.a();
    if (localObject == null)
    {
      paramC = new Label(paramC);
    }
    else
    {
      ((Label)localObject).a();
      ((Label)localObject).b(paramC);
      paramC = (c)localObject;
    }
    int m = t;
    int i1 = s;
    if (m >= i1)
    {
      s = i1 * 2;
      n = ((Label[])Arrays.copyOf(n, s));
    }
    localObject = n;
    m = t;
    t = (m + 1);
    localObject[m] = paramC;
    return paramC;
  }
  
  public static h a(f paramF, Label paramLabel1, Label paramLabel2, int paramInt1, float paramFloat, Label paramLabel3, Label paramLabel4, int paramInt2, boolean paramBoolean)
  {
    h localH = paramF.a();
    localH.a(paramLabel1, paramLabel2, paramInt1, paramFloat, paramLabel3, paramLabel4, paramInt2);
    if (paramBoolean)
    {
      paramLabel1 = paramF.d();
      paramF = paramF.d();
      i = 4;
      i = 4;
      localH.a(paramLabel1, paramF);
    }
    return localH;
  }
  
  public static h a(f paramF, Label paramLabel1, Label paramLabel2, int paramInt, boolean paramBoolean)
  {
    Label localLabel = paramF.c();
    h localH = paramF.a();
    localH.b(paramLabel1, paramLabel2, localLabel, paramInt);
    if (paramBoolean)
    {
      paramInt = (int)(b.b(localLabel) * -1.0F);
      localH.c(paramF.d(), paramInt);
    }
    return localH;
  }
  
  public static h a(f paramF, Label paramLabel1, Label paramLabel2, Label paramLabel3, float paramFloat, boolean paramBoolean)
  {
    h localH = paramF.a();
    if (paramBoolean) {
      paramF.b(localH);
    }
    return localH.a(paramLabel1, paramLabel2, paramLabel3, paramFloat);
  }
  
  private void accept()
  {
    int m = 0;
    for (;;)
    {
      Object localObject = b;
      if (m >= localObject.length) {
        break;
      }
      localObject = localObject[m];
      if (localObject != null) {
        j.a.a(localObject);
      }
      b[m] = null;
      m += 1;
    }
  }
  
  private int b(d paramD)
    throws Exception
  {
    int m = 0;
    Object localObject;
    while (m < a)
    {
      localObject = b;
      if ((a.a != c.b) && (k < 0.0F))
      {
        m = 1;
        break label69;
      }
      m += 1;
    }
    m = 0;
    label69:
    if (m != 0)
    {
      int i6 = 0;
      m = 0;
      for (;;)
      {
        i1 = m;
        if (i6 != 0) {
          break;
        }
        int i10 = m + 1;
        int i3 = 0;
        int i2 = -1;
        m = -1;
        float f1 = Float.MAX_VALUE;
        int i4;
        for (i1 = 0; i3 < a; i1 = i4)
        {
          localObject = b[i3];
          float f2;
          int i7;
          int i5;
          if (a.a == c.b)
          {
            f2 = f1;
            i7 = i2;
            i5 = m;
            i4 = i1;
          }
          else
          {
            f2 = f1;
            i7 = i2;
            i5 = m;
            i4 = i1;
            if (k < 0.0F)
            {
              i4 = 1;
              while (i4 < i)
              {
                Label localLabel = j.i[i4];
                float f3 = b.b(localLabel);
                int i8;
                int i9;
                if (f3 <= 0.0F)
                {
                  i7 = m;
                  i8 = i1;
                  i9 = i2;
                  f2 = f1;
                }
                else
                {
                  i5 = 0;
                  for (;;)
                  {
                    i7 = m;
                    i8 = i1;
                    i9 = i2;
                    f2 = f1;
                    if (i5 >= 6) {
                      break;
                    }
                    f2 = d[i5] / f3;
                    if ((f2 >= f1) || (i5 != i1))
                    {
                      i7 = i1;
                      if (i5 <= i1) {}
                    }
                    else
                    {
                      f1 = f2;
                      i2 = i3;
                      m = i4;
                      i7 = i5;
                    }
                    i5 += 1;
                    i1 = i7;
                  }
                }
                i4 += 1;
                m = i7;
                i1 = i8;
                i2 = i9;
                f1 = f2;
              }
              i4 = i1;
              i5 = m;
              i7 = i2;
              f2 = f1;
            }
          }
          i3 += 1;
          f1 = f2;
          i2 = i7;
          m = i5;
        }
        if (i2 != -1)
        {
          localObject = b[i2];
          a.c = -1;
          ((h)localObject).a(j.i[m]);
          a.c = i2;
          m = 0;
          while (m < a)
          {
            b[m].b((h)localObject);
            m += 1;
          }
          paramD.a(this);
          m = i10;
        }
        else
        {
          i6 = 1;
          m = i10;
        }
      }
    }
    int i1 = 0;
    m = 0;
    while (m < a)
    {
      paramD = b;
      if ((a.a != c.b) && (k < 0.0F)) {
        return i1;
      }
      m += 1;
    }
    return i1;
  }
  
  public static h b(f paramF, Label paramLabel1, Label paramLabel2, int paramInt, boolean paramBoolean)
  {
    Label localLabel = paramF.c();
    h localH = paramF.a();
    localH.a(paramLabel1, paramLabel2, localLabel, paramInt);
    if (paramBoolean)
    {
      paramInt = (int)(b.b(localLabel) * -1.0F);
      localH.c(paramF.d(), paramInt);
    }
    return localH;
  }
  
  private void b()
  {
    x *= 2;
    b = ((h[])Arrays.copyOf(b, x));
    Item localItem = j;
    i = ((Label[])Arrays.copyOf(i, x));
    int m = x;
    g = new boolean[m];
    h = m;
    p = m;
    r.a.clear();
  }
  
  private void b(h paramH)
  {
    paramH.a(d(), d());
  }
  
  public static h c(f paramF, Label paramLabel1, Label paramLabel2, int paramInt, boolean paramBoolean)
  {
    h localH = paramF.a();
    localH.a(paramLabel1, paramLabel2, paramInt);
    if (paramBoolean) {
      localH.c(paramF.d(), 1);
    }
    return localH;
  }
  
  private void c(h paramH, int paramInt)
  {
    paramH.c(d(), paramInt);
  }
  
  private void close()
  {
    init();
    Object localObject1 = "";
    int m = 0;
    while (m < a)
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject1);
      ((StringBuilder)localObject1).append(b[m]);
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(((StringBuilder)localObject1).toString(), "\n");
      m += 1;
    }
    Object localObject2 = localObject1;
    if (r.a.size() != 0) {
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject1), r, "\n");
    }
    System.out.println((String)localObject2);
  }
  
  private void d(h paramH)
  {
    if (a > 0)
    {
      b.a(paramH, b);
      if (b.c == 0) {
        s = true;
      }
    }
  }
  
  private String format(int paramInt)
  {
    paramInt *= 4;
    int m = paramInt / 1024;
    int i1 = m / 1024;
    if (i1 > 0) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString("", i1, " Mb");
    }
    if (m > 0) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString("", m, " Kb");
    }
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString("", paramInt, " bytes");
  }
  
  private void init()
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Display Rows (");
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("x");
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, i, ") :\n\t | C | ");
    int m = 1;
    while (m <= i)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, j.i[m]), " | ");
      m += 1;
    }
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, "\n");
    System.out.println((String)localObject);
  }
  
  private void visitMaxs()
  {
    int m = 0;
    while (m < a)
    {
      h localH = b[m];
      a.g = k;
      m += 1;
    }
  }
  
  public Label a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if (i + 1 >= h) {
      b();
    }
    if ((paramObject instanceof support.android.view.asm.asm.Label))
    {
      support.android.view.asm.asm.Label localLabel1 = (support.android.view.asm.asm.Label)paramObject;
      Label localLabel = localLabel1.getName();
      paramObject = localLabel;
      if (localLabel == null)
      {
        localLabel1.a(j);
        paramObject = localLabel1.getName();
      }
      int m = j;
      if ((m == -1) || (m > k) || (j.i[m] == null))
      {
        if (j != -1) {
          paramObject.a();
        }
        k += 1;
        i += 1;
        m = k;
        j = m;
        a = c.b;
        j.i[m] = paramObject;
        return paramObject;
      }
    }
    else
    {
      return null;
    }
    return paramObject;
  }
  
  public h a()
  {
    h localH = (h)j.a.a();
    if (localH == null) {
      return new h(j);
    }
    localH.b();
    return localH;
  }
  
  public h a(int paramInt)
  {
    return b[paramInt];
  }
  
  public void a(Label paramLabel, int paramInt)
  {
    int m = c;
    if (m != -1)
    {
      localH = b[m];
      if (s)
      {
        k = paramInt;
        return;
      }
      localH = a();
      localH.a(paramLabel, paramInt);
      a(localH);
      return;
    }
    h localH = a();
    localH.b(paramLabel, paramInt);
    a(localH);
  }
  
  public void a(Label paramLabel1, Label paramLabel2, int paramInt1, float paramFloat, Label paramLabel3, Label paramLabel4, int paramInt2, int paramInt3)
  {
    h localH = a();
    localH.a(paramLabel1, paramLabel2, paramInt1, paramFloat, paramLabel3, paramLabel4, paramInt2);
    paramLabel1 = d();
    paramLabel2 = d();
    i = paramInt3;
    i = paramInt3;
    localH.a(paramLabel1, paramLabel2);
    a(localH);
  }
  
  public void a(Label paramLabel1, Label paramLabel2, int paramInt1, int paramInt2)
  {
    h localH = a();
    Label localLabel = c();
    i = paramInt2;
    localH.a(paramLabel1, paramLabel2, localLabel, paramInt1);
    a(localH);
  }
  
  public void a(h paramH)
  {
    if (paramH == null) {
      return;
    }
    if ((a + 1 >= p) || (i + 1 >= h)) {
      b();
    }
    if (!s)
    {
      d(paramH);
      paramH.d();
      paramH.e();
      if (!paramH.c()) {
        return;
      }
    }
    Object localObject = b;
    int m = a;
    if (localObject[m] != null) {
      j.a.a(localObject[m]);
    }
    if (!s) {
      paramH.setChecked();
    }
    localObject = b;
    m = a;
    localObject[m] = paramH;
    localObject = a;
    c = m;
    a = (m + 1);
    int i3 = k;
    if (i3 > 0)
    {
      for (;;)
      {
        localObject = f;
        if (localObject.length >= i3) {
          break;
        }
        f = new h[localObject.length * 2];
      }
      int i2 = 0;
      m = 0;
      int i1;
      for (;;)
      {
        i1 = i2;
        if (m >= i3) {
          break;
        }
        localObject[m] = a.b[m];
        m += 1;
      }
      while (i1 < i3)
      {
        h localH = localObject[i1];
        if (localH != paramH)
        {
          b.a(localH, paramH);
          localH.setChecked();
        }
        i1 += 1;
      }
    }
  }
  
  public h add(Label paramLabel1, Label paramLabel2, int paramInt1, int paramInt2)
  {
    h localH = a();
    localH.a(paramLabel1, paramLabel2, paramInt1);
    paramLabel1 = d();
    paramLabel2 = d();
    i = paramInt2;
    i = paramInt2;
    localH.a(paramLabel1, paramLabel2);
    a(localH);
    return localH;
  }
  
  public void add()
    throws Exception
  {
    d(r);
  }
  
  public float b(String paramString)
  {
    paramString = b(paramString, c.b);
    if (paramString == null) {
      return 0.0F;
    }
    return g;
  }
  
  public Label b(String paramString, c paramC)
  {
    if (c == null) {
      c = new HashMap();
    }
    Label localLabel2 = (Label)c.get(paramString);
    Label localLabel1 = localLabel2;
    if (localLabel2 == null) {
      localLabel1 = a(paramString, paramC);
    }
    return localLabel1;
  }
  
  public void b(Label paramLabel1, Label paramLabel2, int paramInt1, int paramInt2)
  {
    h localH = a();
    Label localLabel = c();
    i = paramInt2;
    localH.b(paramLabel1, paramLabel2, localLabel, paramInt1);
    a(localH);
  }
  
  public Label c()
  {
    if (i + 1 >= h) {
      b();
    }
    Label localLabel = a(c.c);
    k += 1;
    i += 1;
    int m = k;
    j = m;
    j.i[m] = localLabel;
    return localLabel;
  }
  
  public void clear()
  {
    r.a(this);
  }
  
  public Label d()
  {
    if (i + 1 >= h) {
      b();
    }
    Label localLabel = a(c.a);
    k += 1;
    i += 1;
    int m = k;
    j = m;
    j.i[m] = localLabel;
    return localLabel;
  }
  
  public void d(d paramD)
    throws Exception
  {
    paramD.a(this);
    b(paramD);
    a(paramD);
    visitMaxs();
  }
  
  public void doInBackground()
  {
    init();
    Object localObject1 = "";
    int m = 0;
    while (m < a)
    {
      localObject2 = localObject1;
      if (b[m].a.a == c.b)
      {
        localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject1);
        ((StringBuilder)localObject1).append(b[m].a());
        localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(((StringBuilder)localObject1).toString(), "\n");
      }
      m += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (r.a.size() != 0) {
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject1), r, "\n");
    }
    System.out.println((String)localObject2);
  }
  
  public Item e()
  {
    return j;
  }
  
  public int f()
  {
    int m = 0;
    int i2;
    for (int i1 = 0; m < a; i1 = i2)
    {
      h[] arrayOfH = b;
      i2 = i1;
      if (arrayOfH[m] != null) {
        i2 = arrayOfH[m].setEnabled() + i1;
      }
      m += 1;
    }
    return i1;
  }
  
  public int i()
  {
    return k;
  }
  
  public int k()
  {
    return a;
  }
  
  public d m()
  {
    return r;
  }
  
  public int read(Object paramObject)
  {
    paramObject = ((support.android.view.asm.asm.Label)paramObject).getName();
    if (paramObject != null) {
      return (int)(g + 0.5F);
    }
    return 0;
  }
  
  public void run()
  {
    int m = 0;
    for (;;)
    {
      localObject = j;
      Label[] arrayOfLabel = i;
      if (m >= arrayOfLabel.length) {
        break;
      }
      localObject = arrayOfLabel[m];
      if (localObject != null) {
        ((Label)localObject).a();
      }
      m += 1;
    }
    b.a(n, t);
    t = 0;
    Arrays.fill(j.i, null);
    Object localObject = c;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    k = 0;
    r.a.clear();
    i = 1;
    m = 0;
    while (m < a)
    {
      b[m].i = false;
      m += 1;
    }
    accept();
    a = 0;
  }
  
  public void update()
  {
    int i1 = 0;
    for (int m = 0; i1 < x; m = i2)
    {
      localObject = b;
      i2 = m;
      if (localObject[i1] != null) {
        i2 = localObject[i1].setEnabled() + m;
      }
      i1 += 1;
    }
    int i2 = 0;
    int i3;
    for (i1 = 0; i2 < a; i1 = i3)
    {
      localObject = b;
      i3 = i1;
      if (localObject[i2] != null) {
        i3 = localObject[i2].setEnabled() + i1;
      }
      i2 += 1;
    }
    Object localObject = System.out;
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Linear System -> Table size: ");
    localStringBuilder.append(x);
    localStringBuilder.append(" (");
    i2 = x;
    localStringBuilder.append(format(i2 * i2));
    localStringBuilder.append(") -- row sizes: ");
    localStringBuilder.append(format(m));
    localStringBuilder.append(", actual size: ");
    localStringBuilder.append(format(i1));
    localStringBuilder.append(" rows: ");
    localStringBuilder.append(a);
    localStringBuilder.append("/");
    localStringBuilder.append(p);
    localStringBuilder.append(" cols: ");
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(h);
    localStringBuilder.append(" ");
    localStringBuilder.append(0);
    localStringBuilder.append(" occupied cells, ");
    localStringBuilder.append(format(0));
    ((PrintStream)localObject).println(localStringBuilder.toString());
  }
  
  public void write()
  {
    init();
    Object localObject1 = "";
    int m = 0;
    while (m < a)
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject1);
      ((StringBuilder)localObject1).append(b[m].a());
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(((StringBuilder)localObject1).toString(), "\n");
      m += 1;
    }
    Object localObject2 = localObject1;
    if (r != null) {
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject1), r, "\n");
    }
    System.out.println((String)localObject2);
  }
}
