package support.android.view.asm.asm;

import java.util.ArrayList;
import java.util.Arrays;
import support.android.view.asm.h;

public class f
  extends d
{
  public static final boolean A = false;
  public static final int ACCESS_LEVEL_NONE = 0;
  public static final int ACCOUNT_COLUMN = 1;
  public static final boolean B = true;
  public static final int BUTTON_WEEK_INDEX = 1;
  public static final int C = 2;
  public static final int CALENDARS_INDEX_CALENDAR_COLOR = 2;
  public static final boolean D = false;
  public static final int KEYBOARD_WARNING_DIALOG_SHOWN = 0;
  public static final int TOKEN_QUERY_CALENDARS = 2;
  public static final int WEEKS_BUFFER = 1;
  public static final boolean d = false;
  public static final int e = 3;
  public static final int h = 8;
  public static final int l = 4;
  public static final boolean mIsClosing = false;
  public static boolean mItemsChangedWhileDispatchPrevented = false;
  public static final int w = 8;
  public boolean[] a = new boolean[3];
  public i[] b = new i[4];
  public support.android.view.asm.f c = new support.android.view.asm.f();
  public i[] f = new i[4];
  public int g;
  public int i = 0;
  public i[] k = new i[4];
  public AnnotationWriter m;
  public int n;
  public support.android.view.asm.f o = null;
  public boolean p = false;
  public int q;
  public boolean r = false;
  public int s = 0;
  public int t;
  public int u = 2;
  public int v;
  public i[] x = new i[4];
  public int y;
  
  public f() {}
  
  public f(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static int a(Label paramLabel, int paramInt)
  {
    int j = x;
    if (a.next() == null) {
      return paramInt;
    }
    if (j <= paramInt) {
      return j;
    }
    x = paramInt;
    Label localLabel1 = paramLabel.c();
    Label localLabel2 = b;
    j = paramInt;
    if (localLabel1 != null) {
      j = a(localLabel1, paramInt);
    }
    paramInt = j;
    if (localLabel2 != null) {
      paramInt = a(localLabel2, j);
    }
    j = paramInt;
    if (localLabel1 != null) {
      j = a(localLabel1, paramInt);
    }
    x = j;
    return j;
  }
  
  private int a(support.android.view.asm.f paramF, i[] paramArrayOfI, i paramI, int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = true;
    paramArrayOfBoolean[1] = false;
    paramArrayOfI[0] = null;
    paramArrayOfI[2] = null;
    paramArrayOfI[1] = null;
    paramArrayOfI[3] = null;
    boolean bool1;
    Object localObject3;
    Object localObject4;
    Object localObject6;
    int j;
    if (paramInt == 0)
    {
      localObject1 = f.b;
      if ((localObject1 != null) && (a != this)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      E = null;
      if (paramI.get() != 8) {
        localObject3 = paramI;
      } else {
        localObject3 = null;
      }
      localObject5 = null;
      localObject2 = localObject3;
      paramInt = 0;
      localObject1 = paramI;
      for (;;)
      {
        localObject4 = localObject3;
        localObject6 = localObject2;
        j = paramInt;
        if (b.b == null) {
          break;
        }
        E = null;
        if (((i)localObject1).get() != 8)
        {
          localObject4 = localObject2;
          if (localObject2 == null) {
            localObject4 = localObject1;
          }
          if ((localObject3 != null) && (localObject3 != localObject1)) {
            E = ((i)localObject1);
          }
          localObject3 = localObject1;
          localObject2 = localObject4;
        }
        else
        {
          localObject4 = f;
          paramF.add(c, b.c, 0, 5);
          paramF.add(b.c, f.c, 0, 5);
        }
        j = paramInt;
        if (((i)localObject1).get() != 8)
        {
          localObject4 = type;
          localObject6 = Integer.left;
          j = paramInt;
          if (localObject4 == localObject6)
          {
            if (size == localObject6) {
              paramArrayOfBoolean[0] = false;
            }
            j = paramInt;
            if (z <= 0.0F)
            {
              paramArrayOfBoolean[0] = false;
              j = paramInt + 1;
              localObject4 = b;
              if (j >= localObject4.length) {
                b = ((i[])Arrays.copyOf((Object[])localObject4, localObject4.length * 2));
              }
              b[paramInt] = localObject1;
            }
          }
        }
        localObject4 = b.b.a;
        localObject6 = f.b;
        if (localObject6 == null)
        {
          localObject4 = localObject3;
          localObject6 = localObject2;
          break;
        }
        if (a != localObject1)
        {
          localObject4 = localObject3;
          localObject6 = localObject2;
          break;
        }
        if (localObject4 == localObject1)
        {
          localObject4 = localObject3;
          localObject6 = localObject2;
          break;
        }
        localObject5 = localObject4;
        localObject1 = localObject4;
        paramInt = j;
      }
      paramF = b.b;
      bool2 = bool1;
      if (paramF != null)
      {
        bool2 = bool1;
        if (a != this) {
          bool2 = false;
        }
      }
      if ((f.b != null) && (b.b != null)) {
        break label505;
      }
      paramArrayOfBoolean[1] = true;
      label505:
      N = bool2;
      E = null;
      paramArrayOfI[0] = paramI;
      paramArrayOfI[2] = localObject6;
      paramArrayOfI[1] = localObject5;
      paramArrayOfI[3] = localObject4;
      return j;
    }
    Object localObject1 = a.b;
    if ((localObject1 != null) && (a != this)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    o = null;
    if (paramI.get() != 8) {
      localObject3 = paramI;
    } else {
      localObject3 = null;
    }
    Object localObject5 = null;
    Object localObject2 = localObject3;
    paramInt = 0;
    localObject1 = paramI;
    for (;;)
    {
      localObject4 = localObject3;
      localObject6 = localObject2;
      j = paramInt;
      if (c.b == null) {
        break;
      }
      o = null;
      if (((i)localObject1).get() != 8)
      {
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = localObject1;
        }
        if ((localObject3 != null) && (localObject3 != localObject1)) {
          o = ((i)localObject1);
        }
        localObject3 = localObject1;
        localObject2 = localObject4;
      }
      else
      {
        localObject4 = a;
        paramF.add(c, b.c, 0, 5);
        paramF.add(c.c, a.c, 0, 5);
      }
      j = paramInt;
      if (((i)localObject1).get() != 8)
      {
        localObject4 = size;
        localObject6 = Integer.left;
        j = paramInt;
        if (localObject4 == localObject6)
        {
          if (type == localObject6) {
            paramArrayOfBoolean[0] = false;
          }
          j = paramInt;
          if (z <= 0.0F)
          {
            paramArrayOfBoolean[0] = false;
            j = paramInt + 1;
            localObject4 = b;
            if (j >= localObject4.length) {
              b = ((i[])Arrays.copyOf((Object[])localObject4, localObject4.length * 2));
            }
            b[paramInt] = localObject1;
          }
        }
      }
      localObject4 = c.b.a;
      localObject6 = a.b;
      if ((localObject6 == null) || (a != localObject1) || (localObject4 == localObject1))
      {
        localObject4 = localObject3;
        localObject6 = localObject2;
        break;
      }
      localObject1 = localObject4;
      localObject5 = localObject4;
      paramInt = j;
    }
    paramF = c.b;
    boolean bool2 = bool1;
    if (paramF != null)
    {
      bool2 = bool1;
      if (a != this) {
        bool2 = false;
      }
    }
    if ((a.b != null) && (c.b != null)) {
      break label1000;
    }
    paramArrayOfBoolean[1] = true;
    label1000:
    shift = bool2;
    o = null;
    paramArrayOfI[0] = paramI;
    paramArrayOfI[2] = localObject6;
    paramArrayOfI[1] = localObject5;
    paramArrayOfI[3] = localObject4;
    return j;
  }
  
  public static f a(f paramF, String paramString, ArrayList paramArrayList, int paramInt)
  {
    ClassWriter localClassWriter = d.a(paramArrayList);
    if ((c != 0) && (b != 0))
    {
      if (paramInt > 0)
      {
        int i1 = Math.min(h, m);
        j = paramInt;
        if (paramInt > i1) {
          j = i1;
        }
        localClassWriter.b(j, j);
      }
      paramF.set(h, m);
      paramF.add(c, b);
      paramF.d(paramString);
      paramInt = 0;
      paramString = ((i)paramArrayList.get(0)).next();
      int j = paramArrayList.size();
      while (paramInt < j)
      {
        i localI = (i)paramArrayList.get(paramInt);
        if (localI.next() == paramString)
        {
          paramF.close(localI);
          localI.next(localI.getString() - h);
          localI.put(localI.f() - m);
        }
        paramInt += 1;
      }
      return paramF;
    }
    return null;
  }
  
  private void a()
  {
    s = 0;
    i = 0;
  }
  
  private void a(support.android.view.asm.f paramF)
  {
    int i1 = 0;
    for (;;)
    {
      Object localObject3 = this;
      if (i1 >= s) {
        break;
      }
      Object localObject1 = x;
      i localI = localObject1[i1];
      int i5 = a(paramF, f, localObject1[i1], 0, a);
      Object localObject2 = f[2];
      if (localObject2 != null)
      {
        int i2;
        int i4;
        float f1;
        Object localObject4;
        for (;;)
        {
          if (a[1] != 0)
          {
            j = localI.e();
            while (localObject2 != null)
            {
              paramF.a(f.c, j);
              localObject1 = E;
              i2 = f.a();
              i3 = ((i)localObject2).getValue();
              j += b.a() + (i3 + i2);
              localObject2 = localObject1;
            }
          }
          else
          {
            if (next == 0) {
              j = 1;
            } else {
              j = 0;
            }
            if (next == 2) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (type == Integer.p) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            i4 = u;
            if (((i4 == 2) || (i4 == 8)) && (a[0] != 0) && (N) && (i2 == 0) && (i3 == 0) && (next == 0))
            {
              Attribute.a((f)localObject3, paramF, i5, localI);
            }
            else
            {
              if ((i5 == 0) || (i2 != 0)) {
                break label1557;
              }
              f1 = 0.0F;
              localObject1 = null;
              while (localObject2 != null)
              {
                if (type != Integer.left)
                {
                  i2 = f.a();
                  j = i2;
                  if (localObject1 != null) {
                    j = i2 + b.a();
                  }
                  if (f.b.a.type == Integer.left) {
                    i2 = 2;
                  } else {
                    i2 = 3;
                  }
                  localObject1 = f;
                  paramF.b(c, b.c, j, i2);
                  i3 = b.a();
                  i2 = i3;
                  localObject1 = b.b.a.f;
                  localObject4 = b;
                  j = i2;
                  if (localObject4 != null)
                  {
                    j = i2;
                    if (a == localObject2) {
                      j = i3 + ((Label)localObject1).a();
                    }
                  }
                  if (b.b.a.type == Integer.left) {
                    i2 = 2;
                  } else {
                    i2 = 3;
                  }
                  localObject1 = b;
                  paramF.a(c, b.c, -j, i2);
                }
                else
                {
                  f1 += k;
                  localObject1 = b;
                  if (b != null)
                  {
                    i2 = ((Label)localObject1).a();
                    j = i2;
                    if (localObject2 != f[3]) {
                      j = i2 + b.b.a.f.a();
                    }
                  }
                  else
                  {
                    j = 0;
                  }
                  paramF.b(b.c, f.c, 0, 1);
                  localObject1 = b;
                  paramF.a(c, b.c, -j, 1);
                }
                localObject1 = localObject2;
                localObject2 = E;
              }
              if (i5 != 1) {
                break;
              }
              localObject2 = b[0];
              i2 = f.a();
              j = i2;
              localObject1 = f.b;
              if (localObject1 != null) {
                j = i2 + ((Label)localObject1).a();
              }
              i3 = b.a();
              i2 = i3;
              localObject1 = b.b;
              if (localObject1 != null) {
                i2 = i3 + ((Label)localObject1).a();
              }
              localObject1 = b.b.c;
              localObject3 = f;
              if (localObject2 == localObject3[3]) {
                localObject1 = 1b.b.c;
              }
              if (w == 1)
              {
                localObject2 = f;
                paramF.b(c, b.c, j, 1);
                paramF.a(b.c, (support.android.view.asm.Label)localObject1, -i2, 1);
                paramF.add(b.c, f.c, localI.getValue(), 2);
              }
              else
              {
                localObject3 = f;
                paramF.add(c, b.c, j, 1);
                paramF.add(b.c, (support.android.view.asm.Label)localObject1, -i2, 1);
              }
            }
          }
        }
        Object localObject7;
        Object localObject8;
        for (int j = 0;; j = i3)
        {
          int i6 = i5 - 1;
          if (j >= i6) {
            break;
          }
          localObject1 = b;
          localObject4 = localObject1[j];
          i3 = j + 1;
          localObject5 = localObject1[i3];
          localObject6 = f.c;
          localObject7 = b.c;
          localObject8 = f.c;
          localObject1 = b;
          localObject2 = f;
          if (localObject5 == localObject2[3]) {
            localObject1 = 1b.c;
          } else {
            localObject1 = c;
          }
          i4 = f.a();
          j = i4;
          localObject2 = f.b;
          i2 = j;
          Object localObject9;
          if (localObject2 != null)
          {
            localObject2 = a.b;
            localObject9 = b;
            i2 = j;
            if (localObject9 != null)
            {
              i2 = j;
              if (a == localObject4) {
                i2 = i4 + ((Label)localObject2).a();
              }
            }
          }
          paramF.b((support.android.view.asm.Label)localObject6, f.b.c, i2, 2);
          i4 = b.a();
          j = i4;
          i2 = j;
          if (b.b != null)
          {
            localObject2 = E;
            i2 = j;
            if (localObject2 != null)
            {
              localObject2 = f;
              if (b != null) {
                j = ((Label)localObject2).a();
              } else {
                j = 0;
              }
              i2 = i4 + j;
            }
          }
          paramF.a((support.android.view.asm.Label)localObject7, b.b.c, -i2, 2);
          if (i3 == i6)
          {
            i4 = f.a();
            j = i4;
            localObject2 = f.b;
            i2 = j;
            if (localObject2 != null)
            {
              localObject2 = a.b;
              localObject9 = b;
              i2 = j;
              if (localObject9 != null)
              {
                i2 = j;
                if (a == localObject5) {
                  i2 = i4 + ((Label)localObject2).a();
                }
              }
            }
            paramF.b((support.android.view.asm.Label)localObject8, f.b.c, i2, 2);
            localObject2 = b;
            localObject9 = f;
            if (localObject5 == localObject9[3]) {
              localObject2 = 1b;
            }
            i4 = ((Label)localObject2).a();
            j = i4;
            localObject9 = b;
            i2 = j;
            if (localObject9 != null)
            {
              localObject9 = a.f;
              Label localLabel = b;
              i2 = j;
              if (localLabel != null)
              {
                i2 = j;
                if (a == localObject5) {
                  i2 = i4 + ((Label)localObject9).a();
                }
              }
            }
            paramF.a((support.android.view.asm.Label)localObject1, b.c, -i2, 2);
          }
          j = h;
          if (j > 0) {
            paramF.a((support.android.view.asm.Label)localObject7, (support.android.view.asm.Label)localObject6, j, 2);
          }
          localObject2 = paramF.a();
          ((h)localObject2).a(k, f1, k, (support.android.view.asm.Label)localObject6, f.a(), (support.android.view.asm.Label)localObject7, b.a(), (support.android.view.asm.Label)localObject8, f.a(), (support.android.view.asm.Label)localObject1, b.a());
          paramF.a((h)localObject2);
        }
        label1557:
        localObject3 = localObject2;
        Object localObject6 = null;
        Object localObject5 = null;
        int i3 = 0;
        while (localObject3 != null)
        {
          localObject1 = E;
          if (localObject1 == null)
          {
            localObject6 = f[1];
            i3 = 1;
          }
          if (i2 != 0)
          {
            localObject4 = f;
            i5 = ((Label)localObject4).a();
            i4 = i5;
            if (localObject5 != null) {
              i4 = i5 + b.a();
            }
            if (localObject2 != localObject3) {
              i5 = 3;
            } else {
              i5 = 1;
            }
            paramF.b(c, b.c, i4, i5);
            if (type == Integer.left)
            {
              localObject5 = b;
              if (w == 1)
              {
                i4 = Math.max(left, ((i)localObject3).getValue());
                paramF.add(c, c, i4, 3);
              }
              else
              {
                paramF.b(c, b.c, i, 3);
                paramF.a(c, c, left, 3);
              }
            }
          }
          else if ((j == 0) && (i3 != 0) && (localObject5 != null))
          {
            localObject4 = b;
            if (b == null)
            {
              paramF.a(c, ((i)localObject3).p());
            }
            else
            {
              i4 = ((Label)localObject4).a();
              paramF.add(b.c, b.b.c, -i4, 5);
            }
          }
          else
          {
            if ((j != 0) || (i3 != 0) || (localObject5 != null)) {
              break label1958;
            }
            localObject4 = f;
            if (b == null)
            {
              paramF.a(c, ((i)localObject3).e());
            }
            else
            {
              i4 = ((Label)localObject4).a();
              paramF.add(f.c, f.b.c, i4, 5);
            }
          }
          break label2216;
          label1958:
          localObject8 = f;
          localObject7 = b;
          i4 = ((Label)localObject8).a();
          i5 = ((Label)localObject7).a();
          paramF.b(c, b.c, i4, 1);
          paramF.a(c, b.c, -i5, 1);
          localObject4 = b;
          if (localObject4 != null) {
            localObject4 = c;
          } else {
            localObject4 = null;
          }
          if (localObject5 == null)
          {
            localObject4 = f.b;
            if (localObject4 != null) {
              localObject4 = c;
            } else {
              localObject4 = null;
            }
          }
          if (localObject1 == null)
          {
            localObject1 = b.b;
            if (localObject1 != null) {
              localObject1 = a;
            } else {
              localObject1 = null;
            }
          }
          if (localObject1 != null)
          {
            localObject5 = f.c;
            if (i3 != 0)
            {
              localObject5 = b.b;
              if (localObject5 != null) {
                localObject5 = c;
              } else {
                localObject5 = null;
              }
            }
            if ((localObject4 != null) && (localObject5 != null))
            {
              localObject8 = c;
              localObject7 = c;
              paramF.a((support.android.view.asm.Label)localObject8, (support.android.view.asm.Label)localObject4, i4, 0.5F, (support.android.view.asm.Label)localObject5, (support.android.view.asm.Label)localObject7, i5, 4);
            }
          }
          label2216:
          if (i3 != 0) {
            localObject1 = null;
          }
          localObject5 = localObject3;
          localObject3 = localObject1;
        }
        if (i2 != 0)
        {
          localObject3 = f;
          localObject4 = b;
          j = ((Label)localObject3).a();
          i2 = ((Label)localObject4).a();
          localObject1 = f.b;
          if (localObject1 != null) {
            localObject1 = c;
          } else {
            localObject1 = null;
          }
          localObject2 = b.b;
          if (localObject2 != null) {
            localObject2 = c;
          } else {
            localObject2 = null;
          }
          if ((localObject1 != null) && (localObject2 != null))
          {
            paramF.a(c, (support.android.view.asm.Label)localObject2, -i2, 1);
            paramF.a(c, (support.android.view.asm.Label)localObject1, j, t, (support.android.view.asm.Label)localObject2, c, i2, 4);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private boolean add(support.android.view.asm.f paramF)
  {
    int i8 = a.size();
    int j = 0;
    i localI;
    while (j < i8)
    {
      localI = (i)a.get(j);
      m = -1;
      x = -1;
      Integer localInteger1 = type;
      Integer localInteger2 = Integer.left;
      if ((localInteger1 == localInteger2) || (size == localInteger2))
      {
        m = 1;
        x = 1;
      }
      j += 1;
    }
    int i2 = 0;
    int i4 = 0;
    for (int i3 = 0; i2 == 0; i3 = j)
    {
      int i5 = 0;
      i1 = 0;
      int i7;
      for (j = 0; i5 < i8; j = i7)
      {
        localI = (i)a.get(i5);
        if (m == -1) {
          if (type == Integer.p) {
            m = 1;
          } else {
            Attribute.a(this, paramF, localI);
          }
        }
        if (x == -1) {
          if (size == Integer.p) {
            x = 1;
          } else {
            Attribute.add(this, paramF, localI);
          }
        }
        int i6 = i1;
        if (x == -1) {
          i6 = i1 + 1;
        }
        i7 = j;
        if (m == -1) {
          i7 = j + 1;
        }
        i5 += 1;
        i1 = i6;
      }
      if ((i1 == 0) && (j == 0)) {}
      do
      {
        i5 = 1;
        break;
        i5 = i2;
        if (i4 != i1) {
          break;
        }
        i5 = i2;
      } while (i3 == j);
      i4 = i1;
      i2 = i5;
    }
    int i1 = 0;
    i3 = 0;
    for (j = 0; i1 < i8; j = i4)
    {
      paramF = (i)a.get(i1);
      i4 = m;
      if (i4 != 1)
      {
        i2 = i3;
        if (i4 != -1) {}
      }
      else
      {
        i2 = i3 + 1;
      }
      i3 = x;
      if (i3 != 1)
      {
        i4 = j;
        if (i3 != -1) {}
      }
      else
      {
        i4 = j + 1;
      }
      i1 += 1;
      i3 = i2;
    }
    return (i3 == 0) && (j == 0);
  }
  
  private void d(i paramI)
  {
    int j = 0;
    int i1;
    for (;;)
    {
      i1 = i;
      if (j >= i1) {
        break;
      }
      if (k[j] == paramI) {
        return;
      }
      j += 1;
    }
    i[] arrayOfI = k;
    if (i1 + 1 >= arrayOfI.length) {
      k = ((i[])Arrays.copyOf(arrayOfI, arrayOfI.length * 2));
    }
    arrayOfI = k;
    j = i;
    arrayOfI[j] = paramI;
    i = (j + 1);
  }
  
  private void draw(support.android.view.asm.f paramF)
  {
    int i1 = 0;
    for (;;)
    {
      Object localObject3 = this;
      if (i1 >= i) {
        break;
      }
      Object localObject1 = k;
      i localI = localObject1[i1];
      int i5 = a(paramF, f, localObject1[i1], 1, a);
      Object localObject2 = f[2];
      if (localObject2 != null)
      {
        int i2;
        int i3;
        float f1;
        Object localObject4;
        for (;;)
        {
          if (a[1] != 0)
          {
            j = localI.iterator();
            while (localObject2 != null)
            {
              paramF.a(a.c, j);
              localObject1 = o;
              i2 = a.a();
              i3 = ((i)localObject2).size();
              j += c.a() + (i3 + i2);
              localObject2 = localObject1;
            }
          }
          else
          {
            if (length == 0) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (length == 2) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            if (size == Integer.p) {
              j = 1;
            } else {
              j = 0;
            }
            i4 = u;
            if (((i4 == 2) || (i4 == 8)) && (a[0] != 0) && (shift) && (i3 == 0) && (j == 0) && (length == 0))
            {
              Attribute.draw((f)localObject3, paramF, i5, localI);
            }
            else
            {
              if ((i5 == 0) || (i3 != 0)) {
                break label1556;
              }
              f1 = 0.0F;
              localObject1 = null;
              while (localObject2 != null)
              {
                if (size != Integer.left)
                {
                  i2 = a.a();
                  j = i2;
                  if (localObject1 != null) {
                    j = i2 + c.a();
                  }
                  if (a.b.a.size == Integer.left) {
                    i2 = 2;
                  } else {
                    i2 = 3;
                  }
                  localObject1 = a;
                  paramF.b(c, b.c, j, i2);
                  i3 = c.a();
                  i2 = i3;
                  localObject1 = c.b.a.a;
                  localObject4 = b;
                  j = i2;
                  if (localObject4 != null)
                  {
                    j = i2;
                    if (a == localObject2) {
                      j = i3 + ((Label)localObject1).a();
                    }
                  }
                  if (c.b.a.size == Integer.left) {
                    i2 = 2;
                  } else {
                    i2 = 3;
                  }
                  localObject1 = c;
                  paramF.a(c, b.c, -j, i2);
                }
                else
                {
                  f1 += g;
                  localObject1 = c;
                  if (b != null)
                  {
                    i2 = ((Label)localObject1).a();
                    j = i2;
                    if (localObject2 != f[3]) {
                      j = i2 + c.b.a.a.a();
                    }
                  }
                  else
                  {
                    j = 0;
                  }
                  paramF.b(c.c, a.c, 0, 1);
                  localObject1 = c;
                  paramF.a(c, b.c, -j, 1);
                }
                localObject1 = localObject2;
                localObject2 = o;
              }
              if (i5 != 1) {
                break;
              }
              localObject2 = b[0];
              i2 = a.a();
              j = i2;
              localObject1 = a.b;
              if (localObject1 != null) {
                j = i2 + ((Label)localObject1).a();
              }
              i3 = c.a();
              i2 = i3;
              localObject1 = c.b;
              if (localObject1 != null) {
                i2 = i3 + ((Label)localObject1).a();
              }
              localObject1 = c.b.c;
              localObject3 = f;
              if (localObject2 == localObject3[3]) {
                localObject1 = 1c.b.c;
              }
              if (bottom == 1)
              {
                localObject2 = a;
                paramF.b(c, b.c, j, 1);
                paramF.a(c.c, (support.android.view.asm.Label)localObject1, -i2, 1);
                paramF.add(c.c, a.c, localI.size(), 2);
              }
              else
              {
                localObject3 = a;
                paramF.add(c, b.c, j, 1);
                paramF.add(c.c, (support.android.view.asm.Label)localObject1, -i2, 1);
              }
            }
          }
        }
        Object localObject5;
        Object localObject7;
        Object localObject8;
        for (int j = 0;; j = i3)
        {
          int i6 = i5 - 1;
          if (j >= i6) {
            break;
          }
          localObject1 = b;
          localObject4 = localObject1[j];
          i3 = j + 1;
          localObject5 = localObject1[i3];
          localObject6 = a.c;
          localObject7 = c.c;
          localObject8 = a.c;
          localObject1 = c;
          localObject2 = f;
          if (localObject5 == localObject2[3]) {
            localObject1 = 1c.c;
          } else {
            localObject1 = c;
          }
          i4 = a.a();
          j = i4;
          localObject2 = a.b;
          i2 = j;
          Object localObject9;
          if (localObject2 != null)
          {
            localObject2 = a.c;
            localObject9 = b;
            i2 = j;
            if (localObject9 != null)
            {
              i2 = j;
              if (a == localObject4) {
                i2 = i4 + ((Label)localObject2).a();
              }
            }
          }
          paramF.b((support.android.view.asm.Label)localObject6, a.b.c, i2, 2);
          i4 = c.a();
          j = i4;
          i2 = j;
          if (c.b != null)
          {
            localObject2 = o;
            i2 = j;
            if (localObject2 != null)
            {
              localObject2 = a;
              if (b != null) {
                j = ((Label)localObject2).a();
              } else {
                j = 0;
              }
              i2 = i4 + j;
            }
          }
          paramF.a((support.android.view.asm.Label)localObject7, c.b.c, -i2, 2);
          if (i3 == i6)
          {
            i4 = a.a();
            j = i4;
            localObject2 = a.b;
            i2 = j;
            if (localObject2 != null)
            {
              localObject2 = a.c;
              localObject9 = b;
              i2 = j;
              if (localObject9 != null)
              {
                i2 = j;
                if (a == localObject5) {
                  i2 = i4 + ((Label)localObject2).a();
                }
              }
            }
            paramF.b((support.android.view.asm.Label)localObject8, a.b.c, i2, 2);
            localObject2 = c;
            localObject9 = f;
            if (localObject5 == localObject9[3]) {
              localObject2 = 1c;
            }
            i4 = ((Label)localObject2).a();
            j = i4;
            localObject9 = b;
            i2 = j;
            if (localObject9 != null)
            {
              localObject9 = a.a;
              Label localLabel = b;
              i2 = j;
              if (localLabel != null)
              {
                i2 = j;
                if (a == localObject5) {
                  i2 = i4 + ((Label)localObject9).a();
                }
              }
            }
            paramF.a((support.android.view.asm.Label)localObject1, b.c, -i2, 2);
          }
          j = q;
          if (j > 0) {
            paramF.a((support.android.view.asm.Label)localObject7, (support.android.view.asm.Label)localObject6, j, 2);
          }
          localObject2 = paramF.a();
          ((h)localObject2).a(g, f1, g, (support.android.view.asm.Label)localObject6, a.a(), (support.android.view.asm.Label)localObject7, c.a(), (support.android.view.asm.Label)localObject8, a.a(), (support.android.view.asm.Label)localObject1, c.a());
          paramF.a((h)localObject2);
        }
        label1556:
        localObject3 = localObject2;
        Object localObject6 = null;
        localObject1 = null;
        int i4 = 0;
        while (localObject3 != null)
        {
          localObject5 = o;
          if (localObject5 == null)
          {
            localObject6 = f[1];
            i4 = 1;
          }
          if (i3 != 0)
          {
            localObject7 = a;
            i5 = ((Label)localObject7).a();
            j = i5;
            if (localObject1 != null) {
              j = i5 + c.a();
            }
            if (localObject2 != localObject3) {
              i5 = 3;
            } else {
              i5 = 1;
            }
            localObject1 = b;
            if (localObject1 != null)
            {
              localObject4 = c;
              localObject1 = c;
            }
            else
            {
              localObject1 = y;
              localObject4 = b;
              if (localObject4 != null)
              {
                localObject1 = c;
                localObject4 = c;
                j -= ((Label)localObject7).a();
              }
              else
              {
                localObject1 = null;
                localObject4 = null;
              }
            }
            if ((localObject1 != null) && (localObject4 != null)) {
              paramF.b((support.android.view.asm.Label)localObject1, (support.android.view.asm.Label)localObject4, j, i5);
            }
            if (size == Integer.left)
            {
              localObject1 = c;
              if (bottom == 1)
              {
                j = Math.max(i, ((i)localObject3).size());
                paramF.add(c, c, j, 3);
              }
              else
              {
                paramF.b(c, b.c, i, 3);
                paramF.a(c, c, i, 3);
              }
            }
          }
          else if ((i2 == 0) && (i4 != 0) && (localObject1 != null))
          {
            localObject1 = c;
            if (b == null)
            {
              paramF.a(c, ((i)localObject3).k());
            }
            else
            {
              j = ((Label)localObject1).a();
              paramF.add(c.c, c.b.c, -j, 5);
            }
          }
          else
          {
            if ((i2 != 0) || (i4 != 0) || (localObject1 != null)) {
              break label2034;
            }
            localObject1 = a;
            if (b == null)
            {
              paramF.a(c, ((i)localObject3).iterator());
            }
            else
            {
              j = ((Label)localObject1).a();
              paramF.add(a.c, a.b.c, j, 5);
            }
          }
          localObject1 = localObject5;
          break label2293;
          label2034:
          localObject8 = a;
          localObject7 = c;
          j = ((Label)localObject8).a();
          i5 = ((Label)localObject7).a();
          paramF.b(c, b.c, j, 1);
          paramF.a(c, b.c, -i5, 1);
          localObject4 = b;
          if (localObject4 != null) {
            localObject4 = c;
          } else {
            localObject4 = null;
          }
          if (localObject1 == null)
          {
            localObject1 = a.b;
            if (localObject1 != null) {
              localObject4 = c;
            } else {
              localObject4 = null;
            }
          }
          if (localObject5 == null)
          {
            localObject1 = c.b;
            if (localObject1 != null) {
              localObject1 = a;
            } else {
              localObject1 = null;
            }
          }
          else
          {
            localObject1 = localObject5;
          }
          if (localObject1 != null)
          {
            localObject5 = a.c;
            if (i4 != 0)
            {
              localObject5 = c.b;
              if (localObject5 != null) {
                localObject5 = c;
              } else {
                localObject5 = null;
              }
            }
            if ((localObject4 != null) && (localObject5 != null))
            {
              localObject8 = c;
              localObject7 = c;
              paramF.a((support.android.view.asm.Label)localObject8, (support.android.view.asm.Label)localObject4, j, 0.5F, (support.android.view.asm.Label)localObject5, (support.android.view.asm.Label)localObject7, i5, 4);
            }
          }
          label2293:
          if (i4 != 0) {
            localObject1 = null;
          }
          localObject4 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject4;
        }
        if (i3 != 0)
        {
          localObject3 = a;
          localObject4 = c;
          j = ((Label)localObject3).a();
          i2 = ((Label)localObject4).a();
          localObject1 = a.b;
          if (localObject1 != null) {
            localObject1 = c;
          } else {
            localObject1 = null;
          }
          localObject2 = c.b;
          if (localObject2 != null) {
            localObject2 = c;
          } else {
            localObject2 = null;
          }
          if ((localObject1 != null) && (localObject2 != null))
          {
            paramF.a(c, (support.android.view.asm.Label)localObject2, -i2, 1);
            paramF.a(c, (support.android.view.asm.Label)localObject1, j, r, (support.android.view.asm.Label)localObject2, c, i2, 4);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void encode(i paramI)
  {
    int j = 0;
    int i1;
    for (;;)
    {
      i1 = s;
      if (j >= i1) {
        break;
      }
      if (x[j] == paramI) {
        return;
      }
      j += 1;
    }
    i[] arrayOfI = x;
    if (i1 + 1 >= arrayOfI.length) {
      x = ((i[])Arrays.copyOf(arrayOfI, arrayOfI.length * 2));
    }
    arrayOfI = x;
    j = s;
    arrayOfI[j] = paramI;
    s = (j + 1);
  }
  
  public void a(int paramInt)
  {
    int i2 = s;
    int i3 = v;
    Object localObject = l;
    int i1 = 0;
    if (localObject != null)
    {
      if (m == null) {
        m = new AnnotationWriter(this);
      }
      m.a(this);
      s = 0;
      v = 0;
      clear();
      a(c.e());
    }
    else
    {
      s = 0;
      v = 0;
    }
    int i4 = a.size();
    int j = 0;
    while (j < i4)
    {
      localObject = (i)a.get(j);
      if ((localObject instanceof d)) {
        ((d)localObject).add();
      }
      j += 1;
    }
    f.x = 0;
    b.x = 0;
    a.x = 1;
    c.x = 1;
    c.run();
    j = i1;
    while (j < paramInt)
    {
      localObject = c;
      try
      {
        a((support.android.view.asm.f)localObject, j);
        localObject = c;
        ((support.android.view.asm.f)localObject).add();
        localObject = c;
        toString((support.android.view.asm.f)localObject, j);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      toString(c, -2);
      j += 1;
    }
    if (l != null)
    {
      paramInt = getValue();
      j = size();
      m.visit(this);
      get(paramInt);
      append(j);
    }
    else
    {
      s = i2;
      v = i3;
    }
    if (this == getId()) {
      reset();
    }
  }
  
  public void a(ArrayList paramArrayList, boolean[] paramArrayOfBoolean)
  {
    int i9 = paramArrayList.size();
    paramArrayOfBoolean[0] = true;
    int i6 = 0;
    int i8 = 0;
    int i7 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i2 = 0;
    while (i6 < i9)
    {
      i localI = (i)paramArrayList.get(i6);
      if (!localI.equals())
      {
        if (!value) {
          add(localI, paramArrayOfBoolean);
        }
        if (!first) {
          a(localI, paramArrayOfBoolean);
        }
        if (paramArrayOfBoolean[0] == 0) {
          return;
        }
        j = count + right - localI.getValue();
        int i1 = C + D - localI.size();
        if (type == Integer.a) {
          j = localI.getValue() + f.i + b.i;
        }
        if (size == Integer.a) {
          i1 = localI.size() + a.i + c.i;
        }
        if (localI.get() == 8)
        {
          j = 0;
          i1 = 0;
        }
        i8 = Math.max(i8, count);
        i7 = Math.max(i7, right);
        i5 = Math.max(i5, D);
        i4 = Math.max(i4, C);
        i3 = Math.max(i3, j);
        i2 = Math.max(i2, i1);
      }
      i6 += 1;
    }
    int j = Math.max(i8, i7);
    y = Math.max(p, Math.max(j, i3));
    j = Math.max(i4, i5);
    n = Math.max(height, Math.max(j, i2));
    j = 0;
    while (j < i9)
    {
      paramArrayOfBoolean = (i)paramArrayList.get(j);
      value = false;
      first = false;
      start = false;
      end = false;
      I = false;
      J = false;
      j += 1;
    }
  }
  
  public void a(i paramI, int paramInt)
  {
    Label localLabel1;
    Object localObject;
    Label localLabel2;
    if (paramInt == 0)
    {
      for (;;)
      {
        localLabel1 = f;
        localObject = b;
        if (localObject == null) {
          break;
        }
        localObject = a;
        localLabel2 = b.b;
        if ((localLabel2 == null) || (localLabel2 != localLabel1) || (localObject == paramI)) {
          break;
        }
        paramI = (i)localObject;
      }
      encode(paramI);
      return;
    }
    if (paramInt == 1)
    {
      for (;;)
      {
        localLabel1 = a;
        localObject = b;
        if (localObject == null) {
          break;
        }
        localObject = a;
        localLabel2 = c.b;
        if ((localLabel2 == null) || (localLabel2 != localLabel1) || (localObject == paramI)) {
          break;
        }
        paramI = (i)localObject;
      }
      d(paramI);
    }
  }
  
  public void a(i paramI, boolean[] paramArrayOfBoolean)
  {
    Object localObject1 = size;
    Object localObject2 = Integer.left;
    int i3 = 0;
    int j = 0;
    if ((localObject1 == localObject2) && (type != localObject2) && (z > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int i2 = paramI.evaluate();
    int i1 = i2;
    boolean bool2 = true;
    first = true;
    if ((paramI instanceof ByteVector))
    {
      paramArrayOfBoolean = (ByteVector)paramI;
      if (paramArrayOfBoolean.add() == 0)
      {
        if (paramArrayOfBoolean.length() != -1)
        {
          j = paramArrayOfBoolean.length();
        }
        else if (paramArrayOfBoolean.put() != -1)
        {
          i1 = paramArrayOfBoolean.put();
          j = i3;
          break label128;
        }
        i1 = 0;
      }
    }
    for (j = i2;; j = paramI.f() + i2)
    {
      label128:
      i4 = j;
      j = i1;
      break label1013;
      if ((y.b != null) || (a.b != null) || (c.b != null)) {
        break;
      }
    }
    localObject2 = c.b;
    if (localObject2 != null)
    {
      localObject1 = a.b;
      if (localObject1 != null) {
        if (localObject2 != localObject1)
        {
          localObject2 = a;
          if ((localObject2 != a) || (localObject2 == l)) {}
        }
        else
        {
          paramArrayOfBoolean[0] = false;
          return;
        }
      }
    }
    if (y.equals())
    {
      localObject1 = y.b.getValue();
      if (!first) {
        a((i)localObject1, paramArrayOfBoolean);
      }
      i3 = Math.max(C - width + i2, i2);
      j = i3;
      i2 = Math.max(D - width + i2, i2);
      i1 = i2;
      if (paramI.get() == 8)
      {
        i1 = width;
        j = i3 - i1;
        i1 = i2 - i1;
      }
      C = j;
      D = i1;
      return;
    }
    boolean bool1 = a.equals();
    Object localObject3 = null;
    i localI;
    if (bool1)
    {
      localI = a.b.getValue();
      localObject2 = localI;
      i3 = a.a() + i2;
      j = i3;
      localObject1 = localObject2;
      if (!localI.equals())
      {
        j = i3;
        localObject1 = localObject2;
        if (!first)
        {
          a(localI, paramArrayOfBoolean);
          j = i3;
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      j = i2;
      localObject1 = null;
    }
    localObject2 = localObject3;
    if (c.equals())
    {
      localI = c.b.getValue();
      localObject3 = localI;
      i2 += c.a();
      i1 = i2;
      localObject2 = localObject3;
      if (!localI.equals())
      {
        i1 = i2;
        localObject2 = localObject3;
        if (!first)
        {
          a(localI, paramArrayOfBoolean);
          localObject2 = localObject3;
          i1 = i2;
        }
      }
    }
    i2 = j;
    if (a.b != null)
    {
      i2 = j;
      if (!((i)localObject1).equals())
      {
        if (a.b.d() == c.d)
        {
          i3 = j + (C - ((i)localObject1).evaluate());
        }
        else
        {
          i3 = j;
          if (a.b.d() == c.b) {
            i3 = j + C;
          }
        }
        if (!I)
        {
          paramArrayOfBoolean = a.b;
          if ((paramArrayOfBoolean != null) && (a != paramI))
          {
            paramArrayOfBoolean = c.b;
            if ((paramArrayOfBoolean != null) && (a != paramI) && (size != Integer.left)) {}
          }
          else
          {
            bool1 = false;
            break label716;
          }
        }
        bool1 = true;
        label716:
        I = bool1;
        i2 = i3;
        if (I)
        {
          paramArrayOfBoolean = c.b;
          if (paramArrayOfBoolean != null)
          {
            i2 = i3;
            if (a == paramI) {}
          }
          else
          {
            i2 = i3 - C + i3;
          }
        }
      }
    }
    int i4 = i2;
    j = i1;
    if (c.b != null)
    {
      i4 = i2;
      j = i1;
      if (!((i)localObject2).equals())
      {
        if (c.b.d() == c.b)
        {
          i3 = D - ((i)localObject2).evaluate() + i1;
        }
        else
        {
          i3 = i1;
          if (c.b.d() == c.d) {
            i3 = i1 + D;
          }
        }
        bool1 = bool2;
        if (!J)
        {
          paramArrayOfBoolean = a.b;
          if ((paramArrayOfBoolean != null) && (a != paramI))
          {
            paramArrayOfBoolean = c.b;
            if ((paramArrayOfBoolean != null) && (a != paramI) && (size != Integer.left))
            {
              bool1 = bool2;
              break label946;
            }
          }
          bool1 = false;
        }
        label946:
        J = bool1;
        i4 = i2;
        j = i3;
        if (J)
        {
          paramArrayOfBoolean = a.b;
          if (paramArrayOfBoolean != null)
          {
            i4 = i2;
            j = i3;
            if (a == paramI) {}
          }
          else
          {
            j = i3 + (i3 - D);
            i4 = i2;
          }
        }
      }
    }
    label1013:
    i2 = i4;
    i1 = j;
    if (paramI.get() == 8)
    {
      i1 = width;
      i2 = i4 - i1;
      i1 = j - i1;
    }
    C = i2;
    D = i1;
  }
  
  public void add()
  {
    int i4 = s;
    int i5 = v;
    int i6 = Math.max(0, getValue());
    int i7 = Math.max(0, size());
    p = false;
    r = false;
    if (l != null)
    {
      if (m == null) {
        m = new AnnotationWriter(this);
      }
      m.a(this);
      next(q);
      put(g);
      clear();
      a(c.e());
    }
    else
    {
      s = 0;
      v = 0;
    }
    Integer localInteger1 = size;
    Integer localInteger2 = type;
    Object localObject;
    int i11;
    if (u == 2)
    {
      localObject = Integer.p;
      if ((localInteger1 == localObject) || (localInteger2 == localObject))
      {
        a(a, a);
        i10 = a[0];
        i11 = i10;
        if (i6 > 0)
        {
          i11 = i10;
          if (i7 > 0) {
            if (y <= i6)
            {
              i11 = i10;
              if (n <= i7) {}
            }
            else
            {
              i11 = 0;
            }
          }
        }
        i10 = i11;
        if (i11 == 0) {
          break label369;
        }
        if (type == Integer.p)
        {
          type = Integer.data;
          if ((i6 > 0) && (i6 < y))
          {
            p = true;
            get(i6);
          }
          else
          {
            get(Math.max(p, y));
          }
        }
        i10 = i11;
        if (size != Integer.p) {
          break label369;
        }
        size = Integer.data;
        if ((i7 > 0) && (i7 < n))
        {
          r = true;
          append(i7);
          i10 = i11;
          break label369;
        }
        append(Math.max(height, n));
        i10 = i11;
        break label369;
      }
    }
    int i10 = 0;
    label369:
    a();
    int i8 = a.size();
    int j = 0;
    while (j < i8)
    {
      localObject = (i)a.get(j);
      if ((localObject instanceof d)) {
        ((d)localObject).add();
      }
      j += 1;
    }
    j = 0;
    int i13 = 1;
    int i1;
    while (i13 != 0)
    {
      int i3 = j + 1;
      localObject = c;
      int i12 = i13;
      try
      {
        ((support.android.view.asm.f)localObject).run();
        localObject = c;
        i12 = i13;
        i13 = add((support.android.view.asm.f)localObject, java.lang.Integer.MAX_VALUE);
        i11 = i13;
        i12 = i11;
        if (i13 != 0)
        {
          localObject = c;
          i12 = i11;
          ((support.android.view.asm.f)localObject).add();
          i12 = i11;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i localI;
      if (i12 != 0)
      {
        add(c, java.lang.Integer.MAX_VALUE, a);
      }
      else
      {
        toString(c, java.lang.Integer.MAX_VALUE);
        j = 0;
        while (j < i8)
        {
          localI = (i)a.get(j);
          if ((type == Integer.left) && (localI.getValue() < localI.complement()))
          {
            a[2] = true;
            break;
          }
          if ((size == Integer.left) && (localI.size() < localI.getTime()))
          {
            a[2] = true;
            break;
          }
          j += 1;
        }
      }
      if ((i3 < 8) && (a[2] != 0))
      {
        i1 = 0;
        int i2 = 0;
        j = 0;
        while (i1 < i8)
        {
          localI = (i)a.get(i1);
          int i9 = s;
          i2 = Math.max(i2, localI.getValue() + i9);
          i9 = v;
          j = Math.max(j, localI.size() + i9);
          i1 += 1;
        }
        i1 = Math.max(p, i2);
        j = Math.max(height, j);
        if ((localInteger2 == Integer.p) && (getValue() < i1))
        {
          get(i1);
          type = Integer.p;
          i13 = 1;
          i12 = 1;
        }
        else
        {
          i13 = 0;
          i12 = i10;
        }
        i10 = i12;
        i11 = i13;
        if (localInteger1 == Integer.p)
        {
          i10 = i12;
          i11 = i13;
          if (size() < j)
          {
            append(j);
            size = Integer.p;
            i11 = 1;
            i10 = 1;
          }
        }
      }
      else
      {
        i11 = 0;
      }
      j = Math.max(p, getValue());
      if (j > getValue())
      {
        get(j);
        type = Integer.data;
        i11 = 1;
        i10 = 1;
      }
      j = Math.max(height, size());
      if (j > size())
      {
        append(j);
        size = Integer.data;
        i11 = 1;
        i10 = 1;
      }
      i12 = i10;
      i13 = i11;
      if (i10 == 0)
      {
        int i15 = i10;
        int i14 = i11;
        if (type == Integer.p)
        {
          i15 = i10;
          i14 = i11;
          if (i6 > 0)
          {
            i15 = i10;
            i14 = i11;
            if (getValue() > i6)
            {
              p = true;
              type = Integer.data;
              get(i6);
              i14 = 1;
              i15 = 1;
            }
          }
        }
        i12 = i15;
        i13 = i14;
        if (size == Integer.p)
        {
          i12 = i15;
          i13 = i14;
          if (i7 > 0)
          {
            i12 = i15;
            i13 = i14;
            if (size() > i7)
            {
              r = true;
              size = Integer.data;
              append(i7);
              i13 = 1;
              i12 = 1;
            }
          }
        }
      }
      i10 = i12;
      j = i3;
    }
    if (l != null)
    {
      j = Math.max(p, getValue());
      i1 = Math.max(height, size());
      m.visit(this);
      get(j + q + t);
      append(i1 + g + v);
    }
    else
    {
      s = i4;
      v = i5;
    }
    if (i10 != 0)
    {
      type = localInteger2;
      size = localInteger1;
    }
    a(c.e());
    if (this == getId()) {
      reset();
    }
  }
  
  public void add(i paramI, boolean[] paramArrayOfBoolean)
  {
    Object localObject1 = type;
    Object localObject2 = Integer.left;
    int i2 = 0;
    int j = 0;
    if ((localObject1 == localObject2) && (size == localObject2) && (z > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int i3 = paramI.getColor();
    int i1 = i3;
    localObject1 = type;
    localObject2 = Integer.left;
    if ((localObject1 == localObject2) && (size != localObject2) && (z > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    boolean bool2 = true;
    value = true;
    if ((paramI instanceof ByteVector))
    {
      paramArrayOfBoolean = (ByteVector)paramI;
      if (paramArrayOfBoolean.add() == 1)
      {
        if (paramArrayOfBoolean.length() != -1)
        {
          j = paramArrayOfBoolean.length();
        }
        else if (paramArrayOfBoolean.put() != -1)
        {
          i1 = paramArrayOfBoolean.put();
          j = i2;
          break label170;
        }
        i1 = 0;
      }
      else
      {
        j = i3;
      }
    }
    for (;;)
    {
      label170:
      break;
      if ((!b.equals()) && (!f.equals()))
      {
        j = paramI.getString() + i3;
      }
      else
      {
        localObject2 = b.b;
        if (localObject2 != null)
        {
          localObject1 = f.b;
          if (localObject1 != null) {
            if (localObject2 != localObject1)
            {
              localObject2 = a;
              if ((localObject2 != a) || (localObject2 == l)) {}
            }
            else
            {
              paramArrayOfBoolean[0] = false;
              return;
            }
          }
        }
        localObject1 = b;
        Object localObject3 = b;
        localObject2 = null;
        if (localObject3 != null)
        {
          localObject3 = a;
          j = ((Label)localObject1).a() + i3;
          i2 = j;
          localObject1 = localObject3;
          if (!((i)localObject3).equals())
          {
            i2 = j;
            localObject1 = localObject3;
            if (!value)
            {
              add((i)localObject3, paramArrayOfBoolean);
              i2 = j;
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          i2 = i3;
          localObject1 = null;
        }
        Label localLabel = f;
        localObject3 = b;
        j = i1;
        if (localObject3 != null)
        {
          localObject3 = a;
          i1 = i3 + localLabel.a();
          j = i1;
          localObject2 = localObject3;
          if (!((i)localObject3).equals())
          {
            j = i1;
            localObject2 = localObject3;
            if (!value)
            {
              add((i)localObject3, paramArrayOfBoolean);
              localObject2 = localObject3;
              j = i1;
            }
          }
        }
        i1 = i2;
        boolean bool1;
        if (b.b != null)
        {
          i1 = i2;
          if (!((i)localObject1).equals())
          {
            paramArrayOfBoolean = b.b;
            if (f == c.c)
            {
              i3 = i2 + (right - ((i)localObject1).getColor());
            }
            else
            {
              i3 = i2;
              if (paramArrayOfBoolean.d() == c.a) {
                i3 = i2 + right;
              }
            }
            if ((!end) && ((f.b == null) || (b.b == null) || (type == Integer.left))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            end = bool1;
            i1 = i3;
            if (end)
            {
              paramArrayOfBoolean = f.b;
              if (paramArrayOfBoolean != null)
              {
                i1 = i3;
                if (a == paramI) {}
              }
              else
              {
                i1 = i3 - right + i3;
              }
            }
          }
        }
        i3 = j;
        if (f.b != null)
        {
          i3 = j;
          if (!((i)localObject2).equals())
          {
            if (f.b.d() == c.a)
            {
              i2 = count - ((i)localObject2).getColor() + j;
            }
            else
            {
              i2 = j;
              if (f.b.d() == c.c) {
                i2 = j + count;
              }
            }
            bool1 = bool2;
            if (!start) {
              if ((f.b != null) && (b.b != null) && (type != Integer.left)) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
            start = bool1;
            i3 = i2;
            if (start)
            {
              paramArrayOfBoolean = b.b;
              if (paramArrayOfBoolean != null)
              {
                i3 = i2;
                if (a == paramI) {}
              }
              else
              {
                j = i2 - count + i2;
                break;
              }
            }
          }
        }
        j = i3;
      }
    }
    i3 = j;
    i2 = i1;
    if (paramI.get() == 8)
    {
      i2 = data;
      i3 = j - i2;
      i2 = i1 - i2;
    }
    count = i3;
    right = i2;
  }
  
  public void add(support.android.view.asm.f paramF, int paramInt, boolean[] paramArrayOfBoolean)
  {
    int j = 0;
    paramArrayOfBoolean[2] = false;
    toString(paramF, paramInt);
    int i1 = a.size();
    while (j < i1)
    {
      i localI = (i)a.get(j);
      localI.toString(paramF, paramInt);
      if ((type == Integer.left) && (localI.getValue() < localI.complement())) {
        paramArrayOfBoolean[2] = true;
      }
      if ((size == Integer.left) && (localI.size() < localI.getTime())) {
        paramArrayOfBoolean[2] = true;
      }
      j += 1;
    }
  }
  
  public boolean add(support.android.view.asm.f paramF, int paramInt)
  {
    a(paramF, paramInt);
    int i2 = a.size();
    int j = u;
    int i1 = 0;
    if ((j != 2) && (j != 4))
    {
      j = 1;
    }
    else
    {
      if (add(paramF)) {
        return false;
      }
      j = 0;
    }
    while (i1 < i2)
    {
      i localI = (i)a.get(i1);
      if ((localI instanceof f))
      {
        Integer localInteger1 = type;
        Integer localInteger2 = size;
        if (localInteger1 == Integer.p) {
          localI.a(Integer.data);
        }
        if (localInteger2 == Integer.p) {
          localI.add(Integer.data);
        }
        localI.a(paramF, paramInt);
        if (localInteger1 == Integer.p) {
          localI.a(localInteger1);
        }
        if (localInteger2 == Integer.p) {
          localI.add(localInteger2);
        }
      }
      else
      {
        if (j != 0) {
          Attribute.d(this, paramF, localI);
        }
        localI.a(paramF, paramInt);
      }
      i1 += 1;
    }
    if (s > 0) {
      a(paramF);
    }
    if (i > 0) {
      draw(paramF);
    }
    return true;
  }
  
  public boolean close()
  {
    return p;
  }
  
  public void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    q = paramInt1;
    g = paramInt2;
    t = paramInt3;
    v = paramInt4;
  }
  
  public int draw()
  {
    Object localObject2 = new c[5];
    localObject2[0] = c.a;
    localObject2[1] = c.c;
    localObject2[2] = c.d;
    localObject2[3] = c.e;
    localObject2[4] = c.b;
    int i6 = a.size();
    int i2 = 0;
    Object localObject3;
    for (int j = 1; i2 < i6; j = i1)
    {
      localObject1 = (i)a.get(i2);
      localObject3 = f;
      if (b != null)
      {
        i1 = j;
        if (a((Label)localObject3, j) == j) {
          i1 = j + 1;
        }
      }
      else
      {
        x = java.lang.Integer.MAX_VALUE;
        i1 = j;
      }
      localObject3 = a;
      if (b != null)
      {
        j = i1;
        if (a((Label)localObject3, i1) == i1) {
          j = i1 + 1;
        }
      }
      else
      {
        x = java.lang.Integer.MAX_VALUE;
        j = i1;
      }
      localObject3 = b;
      if (b != null)
      {
        i1 = j;
        if (a((Label)localObject3, j) == j) {
          i1 = j + 1;
        }
      }
      else
      {
        x = java.lang.Integer.MAX_VALUE;
        i1 = j;
      }
      localObject3 = c;
      if (b != null)
      {
        j = i1;
        if (a((Label)localObject3, i1) == i1) {
          j = i1 + 1;
        }
      }
      else
      {
        x = java.lang.Integer.MAX_VALUE;
        j = i1;
      }
      localObject1 = y;
      if (b != null)
      {
        i1 = j;
        if (a((Label)localObject1, j) == j) {
          i1 = j + 1;
        }
      }
      else
      {
        x = java.lang.Integer.MAX_VALUE;
        i1 = j;
      }
      i2 += 1;
    }
    j = 1;
    int i3;
    while (j != 0)
    {
      i2 = 0;
      j = 0;
      while (i2 < i6)
      {
        localObject3 = (i)a.get(i2);
        i3 = 0;
        while (i3 < localObject2.length)
        {
          Label localLabel = localObject2[i3];
          localObject1 = null;
          i1 = localLabel.ordinal();
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              if (i1 != 3)
              {
                if (i1 != 4)
                {
                  if (i1 == 5) {
                    localObject1 = y;
                  }
                }
                else {
                  localObject1 = c;
                }
              }
              else {
                localObject1 = b;
              }
            }
            else {
              localObject1 = a;
            }
          }
          else {
            localObject1 = f;
          }
          localLabel = b;
          if (localLabel != null)
          {
            i1 = j;
            int i4;
            int i5;
            if (a.next() != null)
            {
              i4 = x;
              i5 = x;
              i1 = j;
              if (i4 != i5)
              {
                if (i5 > i4) {
                  j = i4;
                } else {
                  j = i5;
                }
                x = j;
                x = j;
                i1 = 1;
              }
            }
            localLabel = localLabel.c();
            j = i1;
            if (localLabel != null)
            {
              i4 = x;
              i5 = x;
              j = i1;
              if (i4 != i5)
              {
                if (i5 > i4) {
                  j = i4;
                } else {
                  j = i5;
                }
                x = j;
                x = j;
                j = 1;
              }
            }
          }
          i3 += 1;
        }
        i2 += 1;
      }
    }
    Object localObject1 = new int[a.size() * localObject2.length + 1];
    Arrays.fill((int[])localObject1, -1);
    i2 = 0;
    for (int i1 = 0; i2 < i6; i1 = j)
    {
      localObject2 = (i)a.get(i2);
      localObject3 = f;
      i3 = x;
      j = i1;
      if (i3 != java.lang.Integer.MAX_VALUE)
      {
        j = i1;
        if (localObject1[i3] == -1)
        {
          localObject1[i3] = i1;
          j = i1 + 1;
        }
        x = localObject1[i3];
      }
      localObject3 = a;
      i3 = x;
      i1 = j;
      if (i3 != java.lang.Integer.MAX_VALUE)
      {
        i1 = j;
        if (localObject1[i3] == -1)
        {
          localObject1[i3] = j;
          i1 = j + 1;
        }
        x = localObject1[i3];
      }
      localObject3 = b;
      i3 = x;
      j = i1;
      if (i3 != java.lang.Integer.MAX_VALUE)
      {
        j = i1;
        if (localObject1[i3] == -1)
        {
          localObject1[i3] = i1;
          j = i1 + 1;
        }
        x = localObject1[i3];
      }
      localObject3 = c;
      i3 = x;
      i1 = j;
      if (i3 != java.lang.Integer.MAX_VALUE)
      {
        i1 = j;
        if (localObject1[i3] == -1)
        {
          localObject1[i3] = j;
          i1 = j + 1;
        }
        x = localObject1[i3];
      }
      localObject2 = y;
      i3 = x;
      j = i1;
      if (i3 != java.lang.Integer.MAX_VALUE)
      {
        j = i1;
        if (localObject1[i3] == -1)
        {
          localObject1[i3] = i1;
          j = i1 + 1;
        }
        x = localObject1[i3];
      }
      i2 += 1;
    }
    return i1;
  }
  
  public void f(int paramInt)
  {
    u = paramInt;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public String i()
  {
    return "ConstraintLayout";
  }
  
  public void init()
  {
    c.run();
    q = 0;
    t = 0;
    g = 0;
    v = 0;
    super.init();
  }
  
  public ArrayList l()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = a.size();
    int j = 0;
    while (j < i1)
    {
      Object localObject = (i)a.get(j);
      if ((localObject instanceof ByteVector))
      {
        localObject = (ByteVector)localObject;
        if (((ByteVector)localObject).add() == 0) {
          localArrayList.add(localObject);
        }
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public boolean m()
  {
    return r;
  }
  
  public support.android.view.asm.f o()
  {
    return c;
  }
  
  public int onRender()
  {
    int i1 = a.size();
    int j = 0;
    while (j < i1)
    {
      i localI = (i)a.get(j);
      f.x = 0;
      b.x = 0;
      a.x = 1;
      c.x = 1;
      y.x = 1;
      j += 1;
    }
    return 2;
  }
  
  public ArrayList visit()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = a.size();
    int j = 0;
    while (j < i1)
    {
      Object localObject = (i)a.get(j);
      if ((localObject instanceof ByteVector))
      {
        localObject = (ByteVector)localObject;
        if (((ByteVector)localObject).add() == 1) {
          localArrayList.add(localObject);
        }
      }
      j += 1;
    }
    return localArrayList;
  }
}
