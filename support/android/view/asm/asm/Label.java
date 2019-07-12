package support.android.view.asm.asm;

import java.util.ArrayList;
import java.util.HashSet;
import support.android.view.asm.Item;

public class Label
{
  public static final boolean DEBUG = false;
  public static final boolean DEFAULT_SHOW_WEEK_NUM = false;
  public static final int DEFAULT_STACK_LIMIT = -1;
  public static final int MAX_ACTIVITY_COUNT_UNLIMITED = java.lang.Integer.MAX_VALUE;
  public static final int REACHABLE = -2;
  public static final int RESOLVED = 2;
  public static final int j = 0;
  public static final int k = 1;
  public final i a;
  public Label b;
  public support.android.view.asm.Label c;
  public XLayoutStyle d = XLayoutStyle.d;
  public int e = -1;
  public final c f;
  public TextOrientationType g = TextOrientationType.a;
  public int h = 0;
  public int i = 0;
  public int x = java.lang.Integer.MAX_VALUE;
  
  public Label(i paramI, c paramC)
  {
    a = paramI;
    f = paramC;
  }
  
  private String a(HashSet paramHashSet)
  {
    if (paramHashSet.add(this))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(a.getActionView());
      localStringBuilder1.append(":");
      localStringBuilder1.append(f.toString());
      if (b != null)
      {
        StringBuilder localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(" connected to ");
        localStringBuilder2.append(b.a(paramHashSet));
        paramHashSet = localStringBuilder2.toString();
      }
      else
      {
        paramHashSet = "";
      }
      localStringBuilder1.append(paramHashSet);
      return localStringBuilder1.toString();
    }
    return "<-";
  }
  
  private boolean a(i paramI, HashSet paramHashSet)
  {
    if (paramHashSet.contains(paramI)) {
      return false;
    }
    paramHashSet.add(paramI);
    if (paramI == getValue()) {
      return true;
    }
    paramI = paramI.j();
    int n = paramI.size();
    int m = 0;
    while (m < n)
    {
      Label localLabel = (Label)paramI.get(m);
      if ((localLabel.c(this)) && (localLabel.equals()) && (a(localLabel.length().getValue(), paramHashSet))) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  public int a()
  {
    if (a.get() == 8) {
      return 0;
    }
    if (e > -1)
    {
      Label localLabel = b;
      if ((localLabel != null) && (a.get() == 8)) {
        return e;
      }
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    if (equals()) {
      i = paramInt;
    }
  }
  
  public void a(Item paramItem)
  {
    paramItem = c;
    if (paramItem == null)
    {
      c = new support.android.view.asm.Label(support.android.view.asm.c.b);
      return;
    }
    paramItem.a();
  }
  
  public void a(XLayoutStyle paramXLayoutStyle)
  {
    if (equals()) {
      d = paramXLayoutStyle;
    }
  }
  
  public boolean a(Label paramLabel)
  {
    c localC = f;
    if (localC == c.i) {
      return false;
    }
    if (localC == paramLabel.d()) {
      return true;
    }
    int m = f.ordinal();
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4)
          {
            if (m != 7)
            {
              if (m != 8) {
                return false;
              }
              m = paramLabel.d().ordinal();
              if (m != 2)
              {
                if (m != 4) {
                  return false;
                }
              }
              else {
                return true;
              }
            }
            else
            {
              m = paramLabel.d().ordinal();
              if (m != 1)
              {
                if (m != 3) {
                  return false;
                }
              }
              else {
                return true;
              }
            }
          }
          else
          {
            m = paramLabel.d().ordinal();
            if (m != 2)
            {
              if (m != 8) {
                return false;
              }
            }
            else {
              return true;
            }
          }
        }
        else
        {
          m = paramLabel.d().ordinal();
          if (m != 1)
          {
            if (m != 7) {
              return false;
            }
          }
          else {
            return true;
          }
        }
      }
      else
      {
        m = paramLabel.d().ordinal();
        if (m != 4)
        {
          if (m != 8) {
            return false;
          }
        }
        else {
          return true;
        }
      }
    }
    else
    {
      m = paramLabel.d().ordinal();
      if ((m != 3) && (m != 7)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(Label paramLabel, int paramInt)
  {
    return a(paramLabel, paramInt, -1, XLayoutStyle.b, 0, false);
  }
  
  public boolean a(Label paramLabel, int paramInt1, int paramInt2, XLayoutStyle paramXLayoutStyle, int paramInt3, boolean paramBoolean)
  {
    if (paramLabel == null)
    {
      b = null;
      i = 0;
      e = -1;
      d = XLayoutStyle.d;
      h = 2;
      return true;
    }
    if ((!paramBoolean) && (!b(paramLabel))) {
      return false;
    }
    b = paramLabel;
    if (paramInt1 > 0) {
      i = paramInt1;
    } else {
      i = 0;
    }
    e = paramInt2;
    d = paramXLayoutStyle;
    h = paramInt3;
    return true;
  }
  
  public boolean a(Label paramLabel, int paramInt1, XLayoutStyle paramXLayoutStyle, int paramInt2)
  {
    return a(paramLabel, paramInt1, -1, paramXLayoutStyle, paramInt2, false);
  }
  
  public boolean a(i paramI)
  {
    if (a(paramI, new HashSet())) {
      return false;
    }
    i localI = getValue().next();
    if (localI == paramI) {
      return true;
    }
    return paramI.next() == localI;
  }
  
  public boolean a(i paramI, Label paramLabel)
  {
    return a(paramI);
  }
  
  public void b()
  {
    b = null;
    i = 0;
    e = -1;
    d = XLayoutStyle.b;
    h = 0;
    g = TextOrientationType.a;
  }
  
  public void b(int paramInt)
  {
    if (equals()) {
      e = paramInt;
    }
  }
  
  public boolean b(Label paramLabel)
  {
    if (paramLabel == null) {
      return false;
    }
    c localC1 = paramLabel.d();
    c localC2 = f;
    boolean bool2;
    if (localC1 == localC2)
    {
      if (localC2 == c.i) {
        return false;
      }
      if (localC2 == c.e)
      {
        if (paramLabel.getValue().replace())
        {
          if (getValue().replace()) {
            break label245;
          }
          return false;
        }
      }
      else {
        return true;
      }
    }
    else
    {
      int m = localC2.ordinal();
      boolean bool1;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3) {
            break label185;
          }
          if (m != 4)
          {
            if (m != 6) {
              return false;
            }
            if ((localC1 == c.e) || (localC1 == c.g) || (localC1 == c.h)) {
              break label247;
            }
            return true;
          }
        }
        if ((localC1 != c.d) && (localC1 != c.b)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        bool2 = bool1;
        if (!(paramLabel.getValue() instanceof ByteVector)) {
          break label249;
        }
        return (bool1) || (localC1 == c.h);
      }
      label185:
      if ((localC1 != c.a) && (localC1 != c.c)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if (!(paramLabel.getValue() instanceof ByteVector)) {
        break label249;
      }
      return (bool1) || (localC1 == c.g);
    }
    return false;
    label245:
    return true;
    label247:
    return false;
    label249:
    return bool2;
  }
  
  public boolean b(Label paramLabel, int paramInt1, int paramInt2)
  {
    return a(paramLabel, paramInt1, -1, XLayoutStyle.b, paramInt2, false);
  }
  
  public final Label c()
  {
    int m = f.ordinal();
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4) {
            return null;
          }
          return a.a;
        }
        return a.f;
      }
      return a.c;
    }
    return a.b;
  }
  
  public boolean c(Label paramLabel)
  {
    paramLabel = paramLabel.d();
    c localC = f;
    if (paramLabel == localC) {
      return true;
    }
    switch (localC.ordinal())
    {
    default: 
      return false;
    case 2: 
    case 4: 
    case 5: 
    case 8: 
      if ((paramLabel != c.d) && (paramLabel != c.b) && (paramLabel != c.h)) {
        return paramLabel == c.e;
      }
      break;
    case 1: 
    case 3: 
    case 7: 
      if ((paramLabel != c.a) && (paramLabel != c.c)) {
        return paramLabel == c.g;
      }
      break;
    case 6: 
      return paramLabel != c.e;
    }
    return true;
  }
  
  public int compareTo()
  {
    switch (f.ordinal())
    {
    default: 
      return 0;
    case 5: 
      return 1;
    case 7: 
    case 8: 
      return 0;
    }
    return 2;
  }
  
  public c d()
  {
    return f;
  }
  
  public XLayoutStyle e()
  {
    return d;
  }
  
  public boolean encode()
  {
    int m = f.ordinal();
    return (m != 1) && (m != 3) && (m != 6) && (m != 7);
  }
  
  public boolean equals()
  {
    return b != null;
  }
  
  public int f()
  {
    return h;
  }
  
  public int getColor()
  {
    switch (f.ordinal())
    {
    default: 
      return 0;
    case 5: 
      return 2;
    case 8: 
      return 1;
    case 2: 
    case 4: 
    case 7: 
      return 0;
    case 1: 
    case 3: 
      return 1;
    }
    return 3;
  }
  
  public int getFirst()
  {
    return x;
  }
  
  public support.android.view.asm.Label getName()
  {
    return c;
  }
  
  public i getValue()
  {
    return a;
  }
  
  public boolean isNull()
  {
    int m = f.ordinal();
    return (m == 1) || (m == 2) || (m == 3) || (m == 4);
  }
  
  public void layout(int paramInt)
  {
    x = paramInt;
  }
  
  public Label length()
  {
    return b;
  }
  
  public TextOrientationType setColor()
  {
    return g;
  }
  
  public void setColor(TextOrientationType paramTextOrientationType)
  {
    g = paramTextOrientationType;
  }
  
  public void setIcon(int paramInt)
  {
    h = paramInt;
  }
  
  public String toString()
  {
    Object localObject = new HashSet();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(a.getActionView());
    localStringBuilder1.append(":");
    localStringBuilder1.append(f.toString());
    if (b != null)
    {
      StringBuilder localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(" connected to ");
      localStringBuilder2.append(b.a((HashSet)localObject));
      localObject = localStringBuilder2.toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder1.append((String)localObject);
    return localStringBuilder1.toString();
  }
}
