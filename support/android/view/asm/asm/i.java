package support.android.view.asm.asm;

import b.b.d.a.a.b;
import java.util.ArrayList;
import support.android.view.asm.Item;
import support.android.view.asm.h;

public class i
{
  public static final int ACCOUNT_COLUMN = 1;
  public static final int BUTTON_WEEK_INDEX = 1;
  public static final int CALENDARS_INDEX_CALENDAR_COLOR = 2;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final boolean DEFAULT_SHOW_WEEK_NUM = false;
  public static final int FORMAT_ISO_8859_7 = 8;
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int HINT_CONTEXT_UNKNOWN = 0;
  public static final int Icode_DUP = -1;
  public static final int KEYBOARD_WARNING_DIALOG_SHOWN = 0;
  public static final int QUERY_TYPE_NEWER = 1;
  public static final int QUIET_HOURS_DEFAULT_END_MINUTE = 0;
  public static final int QUIET_HOURS_DEFAULT_START_MINUTE = 0;
  public static final int WEEKS_BUFFER = 1;
  public static float buf;
  public String A;
  public int B = 0;
  public int C;
  public int D;
  public i E;
  public int G = 0;
  public String H;
  public boolean I;
  public boolean J;
  public boolean N;
  public Label a = new Label(this, c.d);
  public Label b = new Label(this, c.c);
  public int bottom = 0;
  public Label c = new Label(this, c.b);
  public Object context;
  public int count;
  public int current = 0;
  public Label d = new Label(this, c.g);
  public int data = 0;
  public int e = 0;
  public boolean end;
  public Label f = new Label(this, c.a);
  public boolean first;
  public int flags = -1;
  public float g;
  public int h = 0;
  public int height;
  public int i = 0;
  public int id = 0;
  public Label j = new Label(this, c.h);
  public float k;
  public i l = null;
  public int left = 0;
  public int length;
  public int m = -1;
  public int mState = 0;
  public int mTime = 0;
  public ArrayList<b> n = new ArrayList();
  public int next;
  public i o;
  public int p;
  public int page = 0;
  public int path = 0;
  public int q = 0;
  public float r;
  public int right;
  public int s = 0;
  public boolean shift;
  public Integer size;
  public boolean start;
  public int state;
  public float t;
  public Label this$0 = new Label(this, c.i);
  public int time;
  public int timestamp;
  public int top = 0;
  public Integer type;
  public int u = 0;
  public int v = 0;
  public boolean value;
  public int version;
  public int w = 0;
  public int width = 0;
  public int x = -1;
  public Label y = new Label(this, c.e);
  public float z = 0.0F;
  
  public i()
  {
    float f1 = buf;
    t = f1;
    r = f1;
    Integer localInteger = Integer.data;
    type = localInteger;
    size = localInteger;
    timestamp = 0;
    state = 0;
    A = null;
    H = null;
    next = 0;
    length = 0;
    k = 0.0F;
    g = 0.0F;
    E = null;
    o = null;
    a();
  }
  
  public i(int paramInt1, int paramInt2)
  {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = buf;
    t = f1;
    r = f1;
    Integer localInteger = Integer.data;
    type = localInteger;
    size = localInteger;
    timestamp = 0;
    state = 0;
    A = null;
    H = null;
    next = 0;
    length = 0;
    k = 0.0F;
    g = 0.0F;
    E = null;
    o = null;
    s = paramInt1;
    v = paramInt2;
    data = paramInt3;
    width = paramInt4;
    a();
    onCreate();
  }
  
  private void a()
  {
    n.add(f);
    n.add(a);
    n.add(b);
    n.add(c);
    n.add(d);
    n.add(j);
    n.add(y);
  }
  
  private void a(support.android.view.asm.f paramF, boolean paramBoolean1, boolean paramBoolean2, Label paramLabel1, Label paramLabel2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i1 = paramInt6;
    support.android.view.asm.Label localLabel3 = paramF.a(paramLabel1);
    support.android.view.asm.Label localLabel1 = paramF.a(paramLabel2);
    support.android.view.asm.Label localLabel4 = paramF.a(paramLabel1.length());
    support.android.view.asm.Label localLabel2 = paramF.a(paramLabel2.length());
    int i2 = paramLabel1.a();
    int i3 = paramLabel2.a();
    if (state == 8)
    {
      paramBoolean2 = true;
      paramInt3 = 0;
    }
    if ((localLabel4 == null) && (localLabel2 == null))
    {
      paramF.a(paramF.a().a(localLabel3, paramInt1));
      if (!paramBoolean3)
      {
        if (paramBoolean1)
        {
          paramF.a(support.android.view.asm.f.c(paramF, localLabel1, localLabel3, paramInt4, true));
          return;
        }
        if (paramBoolean2)
        {
          paramF.a(support.android.view.asm.f.c(paramF, localLabel1, localLabel3, paramInt3, false));
          return;
        }
        paramF.a(paramF.a().a(localLabel1, paramInt2));
      }
    }
    else if ((localLabel4 != null) && (localLabel2 == null))
    {
      paramF.a(paramF.a().a(localLabel3, localLabel4, i2));
      if (paramBoolean1)
      {
        paramF.a(support.android.view.asm.f.c(paramF, localLabel1, localLabel3, paramInt4, true));
        return;
      }
      if (!paramBoolean3)
      {
        if (paramBoolean2)
        {
          paramF.a(paramF.a().a(localLabel1, localLabel3, paramInt3));
          return;
        }
        paramF.a(paramF.a().a(localLabel1, paramInt2));
      }
    }
    else if ((localLabel4 == null) && (localLabel2 != null))
    {
      paramF.a(paramF.a().a(localLabel1, localLabel2, i3 * -1));
      if (paramBoolean1)
      {
        paramF.a(support.android.view.asm.f.c(paramF, localLabel1, localLabel3, paramInt4, true));
        return;
      }
      if (!paramBoolean3)
      {
        if (paramBoolean2)
        {
          paramF.a(paramF.a().a(localLabel1, localLabel3, paramInt3));
          return;
        }
        paramF.a(paramF.a().a(localLabel3, paramInt1));
      }
    }
    else if (paramBoolean2)
    {
      if (paramBoolean1) {
        paramF.a(support.android.view.asm.f.c(paramF, localLabel1, localLabel3, paramInt4, true));
      } else {
        paramF.a(paramF.a().a(localLabel1, localLabel3, paramInt3));
      }
      if (paramLabel1.e() != paramLabel2.e())
      {
        if (paramLabel1.e() == XLayoutStyle.b)
        {
          paramF.a(paramF.a().a(localLabel3, localLabel4, i2));
          paramLabel1 = paramF.c();
          paramLabel2 = paramF.a();
          paramLabel2.a(localLabel1, localLabel2, paramLabel1, i3 * -1);
          paramF.a(paramLabel2);
          return;
        }
        paramLabel1 = paramF.c();
        paramLabel2 = paramF.a();
        paramLabel2.b(localLabel3, localLabel4, paramLabel1, i2);
        paramF.a(paramLabel2);
        paramF.a(paramF.a().a(localLabel1, localLabel2, i3 * -1));
        return;
      }
      if (localLabel4 == localLabel2)
      {
        paramF.a(support.android.view.asm.f.a(paramF, localLabel3, localLabel4, 0, 0.5F, localLabel2, localLabel1, 0, true));
        return;
      }
      if (!paramBoolean4)
      {
        if (paramLabel1.setColor() != TextOrientationType.b) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        paramF.a(support.android.view.asm.f.a(paramF, localLabel3, localLabel4, i2, paramBoolean1));
        if (paramLabel2.setColor() != TextOrientationType.b) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        paramF.a(support.android.view.asm.f.b(paramF, localLabel1, localLabel2, i3 * -1, paramBoolean1));
        paramF.a(support.android.view.asm.f.a(paramF, localLabel3, localLabel4, i2, paramFloat, localLabel2, localLabel1, i3, false));
      }
    }
    else
    {
      if (paramBoolean3)
      {
        paramF.b(localLabel3, localLabel4, i2, 3);
        paramF.a(localLabel1, localLabel2, i3 * -1, 3);
        paramF.a(support.android.view.asm.f.a(paramF, localLabel3, localLabel4, i2, paramFloat, localLabel2, localLabel1, i3, true));
        return;
      }
      if (!paramBoolean4)
      {
        if (paramInt5 == 1)
        {
          if (paramInt6 > paramInt3) {
            paramInt1 = i1;
          } else {
            paramInt1 = paramInt3;
          }
          paramInt2 = paramInt1;
          if (paramInt7 > 0) {
            if (paramInt7 < paramInt1)
            {
              paramInt2 = paramInt7;
            }
            else
            {
              paramF.a(localLabel1, localLabel3, paramInt7, 3);
              paramInt2 = paramInt1;
            }
          }
          paramF.add(localLabel1, localLabel3, paramInt2, 3);
          paramF.b(localLabel3, localLabel4, i2, 2);
          paramF.a(localLabel1, localLabel2, -i3, 2);
          paramF.a(localLabel3, localLabel4, i2, paramFloat, localLabel2, localLabel1, i3, 4);
          return;
        }
        if ((paramInt6 == 0) && (paramInt7 == 0))
        {
          paramF.a(paramF.a().a(localLabel3, localLabel4, i2));
          paramF.a(paramF.a().a(localLabel1, localLabel2, i3 * -1));
          return;
        }
        if (paramInt7 > 0) {
          paramF.a(localLabel1, localLabel3, paramInt7, 3);
        }
        paramF.b(localLabel3, localLabel4, i2, 2);
        paramF.a(localLabel1, localLabel2, -i3, 2);
        paramF.a(localLabel3, localLabel4, i2, paramFloat, localLabel2, localLabel1, i3, 4);
      }
    }
  }
  
  public Label a(c paramC)
  {
    switch (paramC.ordinal())
    {
    default: 
      return null;
    case 6: 
      return this$0;
    case 8: 
      return j;
    case 7: 
      return d;
    case 5: 
      return y;
    case 4: 
      return c;
    case 3: 
      return b;
    case 2: 
      return a;
    }
    return f;
  }
  
  public void a(float paramFloat)
  {
    r = paramFloat;
  }
  
  public void a(float paramFloat, int paramInt)
  {
    z = paramFloat;
    flags = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    G = paramInt1;
    B = paramInt2;
  }
  
  public void a(Object paramObject)
  {
    context = paramObject;
  }
  
  public void a(Item paramItem)
  {
    f.a(paramItem);
    a.a(paramItem);
    b.a(paramItem);
    c.a(paramItem);
    y.a(paramItem);
    this$0.a(paramItem);
    d.a(paramItem);
    j.a(paramItem);
  }
  
  public void a(Integer paramInteger)
  {
    type = paramInteger;
    if (type == Integer.p) {
      get(version);
    }
  }
  
  public void a(Label paramLabel)
  {
    if ((next() != null) && ((next() instanceof f)) && (((f)next()).g())) {
      return;
    }
    Label localLabel1 = a(c.a);
    Label localLabel2 = a(c.c);
    Label localLabel3 = a(c.d);
    Label localLabel4 = a(c.b);
    Label localLabel5 = a(c.i);
    Label localLabel6 = a(c.g);
    Label localLabel7 = a(c.h);
    if (paramLabel == localLabel5)
    {
      if ((localLabel1.equals()) && (localLabel2.equals()) && (localLabel1.length() == localLabel2.length()))
      {
        localLabel1.b();
        localLabel2.b();
      }
      if ((localLabel3.equals()) && (localLabel4.equals()) && (localLabel3.length() == localLabel4.length()))
      {
        localLabel3.b();
        localLabel4.b();
      }
      t = 0.5F;
      r = 0.5F;
    }
    else if (paramLabel == localLabel6)
    {
      if ((localLabel1.equals()) && (localLabel2.equals()) && (localLabel1.length().getValue() == localLabel2.length().getValue()))
      {
        localLabel1.b();
        localLabel2.b();
      }
      t = 0.5F;
    }
    else if (paramLabel == localLabel7)
    {
      if ((localLabel3.equals()) && (localLabel4.equals()) && (localLabel3.length().getValue() == localLabel4.length().getValue()))
      {
        localLabel3.b();
        localLabel4.b();
      }
      r = 0.5F;
    }
    else if ((paramLabel != localLabel1) && (paramLabel != localLabel2))
    {
      if (((paramLabel == localLabel3) || (paramLabel == localLabel4)) && (localLabel3.equals()) && (localLabel3.length() == localLabel4.length())) {
        localLabel5.b();
      }
    }
    else if ((localLabel1.equals()) && (localLabel1.length() == localLabel2.length()))
    {
      localLabel5.b();
    }
    paramLabel.b();
  }
  
  public void a(Label paramLabel1, Label paramLabel2, int paramInt)
  {
    a(paramLabel1, paramLabel2, paramInt, XLayoutStyle.b, 0);
  }
  
  public void a(Label paramLabel1, Label paramLabel2, int paramInt1, int paramInt2)
  {
    a(paramLabel1, paramLabel2, paramInt1, XLayoutStyle.b, paramInt2);
  }
  
  public void a(Label paramLabel1, Label paramLabel2, int paramInt1, XLayoutStyle paramXLayoutStyle, int paramInt2)
  {
    if (paramLabel1.getValue() == this) {
      a(paramLabel1.d(), paramLabel2.getValue(), paramLabel2.d(), paramInt1, paramXLayoutStyle, paramInt2);
    }
  }
  
  public void a(c paramC, int paramInt)
  {
    int i1 = paramC.ordinal();
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return;
          }
          c.e = paramInt;
          return;
        }
        b.e = paramInt;
        return;
      }
      a.e = paramInt;
      return;
    }
    f.e = paramInt;
  }
  
  public void a(c paramC1, i paramI, c paramC2)
  {
    a(paramC1, paramI, paramC2, 0, XLayoutStyle.b);
  }
  
  public void a(c paramC1, i paramI, c paramC2, int paramInt)
  {
    a(paramC1, paramI, paramC2, paramInt, XLayoutStyle.b);
  }
  
  public void a(c paramC1, i paramI, c paramC2, int paramInt1, int paramInt2)
  {
    a(paramC1).a(paramI.a(paramC2), paramInt1, paramInt2, XLayoutStyle.b, 0, true);
  }
  
  public void a(c paramC1, i paramI, c paramC2, int paramInt, XLayoutStyle paramXLayoutStyle)
  {
    a(paramC1, paramI, paramC2, paramInt, paramXLayoutStyle, 0);
  }
  
  public void a(c paramC1, i paramI, c paramC2, int paramInt1, XLayoutStyle paramXLayoutStyle, int paramInt2)
  {
    Object localObject = c.i;
    int i1 = 0;
    if (paramC1 == localObject)
    {
      if (paramC2 == localObject)
      {
        localObject = a(c.a);
        Label localLabel = a(c.c);
        paramC1 = a(c.d);
        paramC2 = a(c.b);
        i1 = 1;
        if (((localObject != null) && (((Label)localObject).equals())) || ((localLabel != null) && (localLabel.equals())))
        {
          paramInt1 = 0;
        }
        else
        {
          localObject = c.a;
          a((c)localObject, paramI, (c)localObject, 0, paramXLayoutStyle, paramInt2);
          localObject = c.c;
          a((c)localObject, paramI, (c)localObject, 0, paramXLayoutStyle, paramInt2);
          paramInt1 = 1;
        }
        if (((paramC1 != null) && (paramC1.equals())) || ((paramC2 != null) && (paramC2.equals())))
        {
          i1 = 0;
        }
        else
        {
          paramC1 = c.d;
          a(paramC1, paramI, paramC1, 0, paramXLayoutStyle, paramInt2);
          paramC1 = c.b;
          a(paramC1, paramI, paramC1, 0, paramXLayoutStyle, paramInt2);
        }
        if ((paramInt1 != 0) && (i1 != 0))
        {
          a(c.i).b(paramI.a(c.i), 0, paramInt2);
          return;
        }
        if (paramInt1 != 0)
        {
          a(c.g).b(paramI.a(c.g), 0, paramInt2);
          return;
        }
        if (i1 != 0) {
          a(c.h).b(paramI.a(c.h), 0, paramInt2);
        }
      }
      else if ((paramC2 != c.a) && (paramC2 != c.c))
      {
        if ((paramC2 == c.d) || (paramC2 == c.b))
        {
          a(c.d, paramI, paramC2, 0, paramXLayoutStyle, paramInt2);
          a(c.b, paramI, paramC2, 0, paramXLayoutStyle, paramInt2);
          a(c.i).b(paramI.a(paramC2), 0, paramInt2);
        }
      }
      else
      {
        a(c.a, paramI, paramC2, 0, paramXLayoutStyle, paramInt2);
        paramC1 = c.c;
      }
    }
    else
    {
      try
      {
        a(paramC1, paramI, paramC2, 0, paramXLayoutStyle, paramInt2);
        a(c.i).b(paramI.a(paramC2), 0, paramInt2);
        return;
      }
      catch (Throwable paramC1)
      {
        throw paramC1;
      }
      if ((paramC1 == c.g) && ((paramC2 == c.a) || (paramC2 == c.c)))
      {
        paramC1 = a(c.a);
        paramI = paramI.a(paramC2);
        paramC2 = a(c.c);
        paramC1.b(paramI, 0, paramInt2);
        paramC2.b(paramI, 0, paramInt2);
        a(c.g).b(paramI, 0, paramInt2);
        return;
      }
      if ((paramC1 == c.h) && ((paramC2 == c.d) || (paramC2 == c.b)))
      {
        paramC1 = paramI.a(paramC2);
        a(c.d).b(paramC1, 0, paramInt2);
        a(c.b).b(paramC1, 0, paramInt2);
        a(c.h).b(paramC1, 0, paramInt2);
        return;
      }
      localObject = c.g;
      if ((paramC1 == localObject) && (paramC2 == localObject))
      {
        a(c.a).b(paramI.a(c.a), 0, paramInt2);
        a(c.c).b(paramI.a(c.c), 0, paramInt2);
        a(c.g).b(paramI.a(paramC2), 0, paramInt2);
        return;
      }
      localObject = c.h;
      if ((paramC1 == localObject) && (paramC2 == localObject))
      {
        a(c.d).b(paramI.a(c.d), 0, paramInt2);
        a(c.b).b(paramI.a(c.b), 0, paramInt2);
        a(c.h).b(paramI.a(paramC2), 0, paramInt2);
        return;
      }
      localObject = a(paramC1);
      paramI = paramI.a(paramC2);
      if (((Label)localObject).b(paramI))
      {
        if (paramC1 == c.e)
        {
          paramC1 = a(c.d);
          paramC2 = a(c.b);
          if (paramC1 != null) {
            paramC1.b();
          }
          paramInt1 = i1;
          if (paramC2 != null)
          {
            paramC2.b();
            paramInt1 = i1;
          }
        }
        for (;;)
        {
          break;
          if ((paramC1 != c.d) && (paramC1 != c.b))
          {
            if ((paramC1 == c.a) || (paramC1 == c.c))
            {
              paramC2 = a(c.i);
              if (paramC2.length() != paramI) {
                paramC2.b();
              }
              paramC1 = a(paramC1).c();
              paramC2 = a(c.g);
              if (paramC2.equals())
              {
                paramC1.b();
                paramC2.b();
              }
            }
          }
          else
          {
            paramC2 = a(c.e);
            if (paramC2 != null) {
              paramC2.b();
            }
            paramC2 = a(c.i);
            if (paramC2.length() != paramI) {
              paramC2.b();
            }
            paramC1 = a(paramC1).c();
            paramC2 = a(c.h);
            if (paramC2.equals())
            {
              paramC1.b();
              paramC2.b();
            }
          }
        }
        ((Label)localObject).a(paramI, paramInt1, paramXLayoutStyle, paramInt2);
        paramI.getValue().add(((Label)localObject).getValue());
        return;
      }
    }
  }
  
  public void a(i paramI)
  {
    ArrayList localArrayList = j();
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Label localLabel = (Label)localArrayList.get(i1);
      if ((localLabel.equals()) && (localLabel.length().getValue() == paramI)) {
        localLabel.b();
      }
      i1 += 1;
    }
  }
  
  public void a(support.android.view.asm.f paramF, int paramInt)
  {
    Object localObject2 = null;
    support.android.view.asm.Label localLabel2;
    if ((paramInt != java.lang.Integer.MAX_VALUE) && (f.x != paramInt)) {
      localLabel2 = null;
    } else {
      localLabel2 = paramF.a(f);
    }
    support.android.view.asm.Label localLabel3;
    if ((paramInt != java.lang.Integer.MAX_VALUE) && (b.x != paramInt)) {
      localLabel3 = null;
    } else {
      localLabel3 = paramF.a(b);
    }
    if ((paramInt != java.lang.Integer.MAX_VALUE) && (a.x != paramInt)) {
      localObject1 = null;
    } else {
      localObject1 = paramF.a(a);
    }
    support.android.view.asm.Label localLabel1;
    if ((paramInt != java.lang.Integer.MAX_VALUE) && (c.x != paramInt)) {
      localLabel1 = null;
    } else {
      localLabel1 = paramF.a(c);
    }
    if ((paramInt == java.lang.Integer.MAX_VALUE) || (y.x == paramInt)) {
      localObject2 = paramF.a(y);
    }
    label263:
    label340:
    Object localObject5;
    Object localObject6;
    label462:
    label566:
    label688:
    label792:
    boolean bool4;
    boolean bool5;
    if (l != null)
    {
      localObject3 = f;
      localObject4 = b;
      if ((localObject4 == null) || (b != localObject3))
      {
        localObject3 = b;
        localObject4 = b;
        if ((localObject4 == null) || (b != localObject3)) {}
      }
      else
      {
        ((f)l).a(this, 0);
        bool1 = true;
        break label263;
      }
      bool1 = false;
      localObject3 = a;
      localObject4 = b;
      if ((localObject4 == null) || (b != localObject3))
      {
        localObject3 = c;
        localObject4 = b;
        if ((localObject4 == null) || (b != localObject3)) {}
      }
      else
      {
        ((f)l).a(this, 1);
        bool2 = true;
        break label340;
      }
      bool2 = false;
      if ((l.invoke() == Integer.p) && (!bool1))
      {
        localObject3 = f;
        localObject4 = b;
        if (localObject4 != null)
        {
          localObject5 = a;
          localObject6 = l;
          if (localObject5 == localObject6)
          {
            if ((localObject4 == null) || (localObject5 != localObject6)) {
              break label462;
            }
            ((Label)localObject3).setColor(TextOrientationType.b);
            break label462;
          }
        }
        localObject3 = paramF.a(l.f);
        localObject4 = paramF.a();
        ((h)localObject4).b(localLabel2, (support.android.view.asm.Label)localObject3, paramF.c(), 0);
        paramF.a((h)localObject4);
        localObject3 = b;
        localObject4 = b;
        if (localObject4 != null)
        {
          localObject5 = a;
          localObject6 = l;
          if (localObject5 == localObject6)
          {
            if ((localObject4 == null) || (localObject5 != localObject6)) {
              break label566;
            }
            ((Label)localObject3).setColor(TextOrientationType.b);
            break label566;
          }
        }
        localObject3 = paramF.a(l.b);
        localObject4 = paramF.a();
        ((h)localObject4).b((support.android.view.asm.Label)localObject3, localLabel3, paramF.c(), 0);
        paramF.a((h)localObject4);
      }
      if ((l.isEmpty() == Integer.p) && (!bool2))
      {
        localObject3 = a;
        localObject4 = b;
        if (localObject4 != null)
        {
          localObject5 = a;
          localObject6 = l;
          if (localObject5 == localObject6)
          {
            if ((localObject4 == null) || (localObject5 != localObject6)) {
              break label688;
            }
            ((Label)localObject3).setColor(TextOrientationType.b);
            break label688;
          }
        }
        localObject3 = paramF.a(l.a);
        localObject4 = paramF.a();
        ((h)localObject4).b((support.android.view.asm.Label)localObject1, (support.android.view.asm.Label)localObject3, paramF.c(), 0);
        paramF.a((h)localObject4);
        localObject3 = c;
        localObject4 = b;
        if (localObject4 != null)
        {
          localObject5 = a;
          localObject6 = l;
          if (localObject5 == localObject6)
          {
            if ((localObject4 == null) || (localObject5 != localObject6)) {
              break label792;
            }
            ((Label)localObject3).setColor(TextOrientationType.b);
            break label792;
          }
        }
        localObject3 = paramF.a(l.c);
        localObject4 = paramF.a();
        ((h)localObject4).b((support.android.view.asm.Label)localObject3, localLabel1, paramF.c(), 0);
        paramF.a((h)localObject4);
      }
      bool4 = bool2;
      bool5 = bool1;
    }
    else
    {
      bool5 = false;
      bool4 = false;
    }
    int i2 = data;
    int i3 = p;
    int i1 = i2;
    if (i2 < i3) {
      i1 = i3;
    }
    i3 = width;
    int i4 = height;
    i2 = i3;
    if (i3 < i4) {
      i2 = i4;
    }
    if (type != Integer.left) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (size != Integer.left) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      localObject3 = f;
      bool1 = bool2;
      if (localObject3 != null)
      {
        localObject4 = b;
        bool1 = bool2;
        if (localObject4 != null) {
          if (b != null)
          {
            bool1 = bool2;
            if (b != null) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    boolean bool2 = bool3;
    if (!bool3)
    {
      localObject3 = a;
      bool2 = bool3;
      if (localObject3 != null)
      {
        localObject4 = c;
        bool2 = bool3;
        if (localObject4 != null) {
          if (b != null)
          {
            bool2 = bool3;
            if (b != null) {}
          }
          else
          {
            if (u != 0)
            {
              localObject3 = y;
              bool2 = bool3;
              if (localObject3 == null) {
                break label1069;
              }
              if (a.b != null)
              {
                bool2 = bool3;
                if (b != null) {
                  break label1069;
                }
              }
            }
            bool2 = true;
          }
        }
      }
    }
    label1069:
    i3 = flags;
    float f1 = z;
    if ((f1 > 0.0F) && (state != 8))
    {
      localObject3 = type;
      localObject4 = Integer.left;
      if ((localObject3 == localObject4) && (size == localObject4))
      {
        if ((bool1) && (!bool2))
        {
          i3 = 0;
        }
        else if ((!bool1) && (bool2))
        {
          if (flags == -1) {
            f1 = 1.0F / f1;
          }
          i3 = 1;
        }
        i4 = i1;
        i1 = i2;
        i5 = 1;
        i2 = i3;
        i3 = i5;
        break label1308;
      }
      localObject3 = type;
      localObject4 = Integer.left;
      if (localObject3 == localObject4)
      {
        i4 = (int)(width * f1);
        bool1 = true;
        i1 = 0;
        break label1293;
      }
      if (size == localObject4)
      {
        f2 = f1;
        if (flags == -1) {
          f2 = 1.0F / f1;
        }
        f1 = data;
        i4 = i1;
        i1 = (int)(f1 * f2);
        i2 = 1;
        i3 = 0;
        bool2 = true;
        f1 = f2;
        break label1308;
      }
    }
    i4 = i1;
    i1 = i3;
    label1293:
    int i5 = i2;
    i3 = 0;
    i2 = i1;
    i1 = i5;
    label1308:
    if ((i3 != 0) && ((i2 == 0) || (i2 == -1))) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool6;
    if ((type == Integer.p) && ((this instanceof f))) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    if (m != 2)
    {
      if ((paramInt != java.lang.Integer.MAX_VALUE) && ((f.x != paramInt) || (b.x != paramInt))) {
        break label1618;
      }
      if (bool3)
      {
        localObject3 = f;
        if ((b != null) && (b.b != null))
        {
          localObject3 = paramF.a(localObject3);
          localObject4 = paramF.a(b);
          localObject5 = paramF.a(f.length());
          localObject6 = paramF.a(b.length());
          paramF.b((support.android.view.asm.Label)localObject3, (support.android.view.asm.Label)localObject5, f.a(), 3);
          paramF.a((support.android.view.asm.Label)localObject4, (support.android.view.asm.Label)localObject6, b.a() * -1, 3);
          if (!bool5) {
            paramF.a((support.android.view.asm.Label)localObject3, (support.android.view.asm.Label)localObject5, f.a(), t, (support.android.view.asm.Label)localObject6, (support.android.view.asm.Label)localObject4, b.a(), 4);
          }
          break label1618;
        }
      }
      localObject3 = f;
      localObject4 = b;
      i5 = s;
      a(paramF, bool6, bool1, (Label)localObject3, (Label)localObject4, i5, i5 + i4, i4, p, t, bool3, bool5, w, left, h);
    }
    label1618:
    Object localObject3 = this;
    if (x == 2) {
      return;
    }
    if ((size == Integer.p) && ((localObject3 instanceof f))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (i3 != 0)
    {
      if (i2 != 1) {
        if (i2 != -1) {
          break label1685;
        }
      }
      bool3 = true;
      break label1688;
    }
    label1685:
    boolean bool3 = false;
    label1688:
    i4 = i2;
    label1755:
    support.android.view.asm.Label localLabel4;
    if (u > 0)
    {
      localObject5 = c;
      if ((paramInt != java.lang.Integer.MAX_VALUE) && ((x != paramInt) || (y.x != paramInt))) {
        break label1755;
      }
      paramF.add((support.android.view.asm.Label)localObject2, (support.android.view.asm.Label)localObject1, getVerticalMargins(), 5);
      localObject4 = paramF;
      localObject2 = y;
      if (b != null)
      {
        i2 = u;
      }
      else
      {
        i2 = i1;
        localObject2 = localObject5;
      }
      if ((paramInt != java.lang.Integer.MAX_VALUE) && ((a.x != paramInt) || (x != paramInt))) {
        break label2122;
      }
      if (bool3)
      {
        localObject5 = a;
        if ((b != null) && (c.b != null))
        {
          localObject2 = ((support.android.view.asm.f)localObject4).a(localObject5);
          localObject5 = ((support.android.view.asm.f)localObject4).a(c);
          localObject6 = ((support.android.view.asm.f)localObject4).a(a.length());
          localLabel4 = ((support.android.view.asm.f)localObject4).a(c.length());
          ((support.android.view.asm.f)localObject4).b((support.android.view.asm.Label)localObject2, (support.android.view.asm.Label)localObject6, a.a(), 3);
          ((support.android.view.asm.f)localObject4).a((support.android.view.asm.Label)localObject5, localLabel4, c.a() * -1, 3);
          if (!bool4) {
            paramF.a((support.android.view.asm.Label)localObject2, (support.android.view.asm.Label)localObject6, a.a(), r, localLabel4, (support.android.view.asm.Label)localObject5, c.a(), 4);
          }
          break label2122;
        }
      }
      localObject4 = a;
      i5 = v;
      a(paramF, bool1, bool2, (Label)localObject4, (Label)localObject2, i5, i5 + i2, i2, height, r, bool3, bool4, bottom, i, q);
      localObject2 = localObject1;
      paramF.add(localLabel1, (support.android.view.asm.Label)localObject1, i1, 5);
      localObject1 = localObject2;
    }
    else
    {
      localObject2 = localObject1;
      if (paramInt == java.lang.Integer.MAX_VALUE) {
        break label2129;
      }
      localObject1 = localObject2;
      if (a.x == paramInt)
      {
        localObject1 = localObject2;
        if (c.x == paramInt) {
          break label2129;
        }
      }
    }
    for (;;)
    {
      label2122:
      localObject2 = localObject1;
      break label2388;
      label2129:
      localObject3 = this;
      if (!bool3) {
        break;
      }
      localObject1 = a;
      if ((b == null) || (c.b == null)) {
        break;
      }
      localObject4 = paramF.a(localObject1);
      localObject5 = paramF.a(c);
      localObject6 = paramF.a(a.length());
      localLabel4 = paramF.a(c.length());
      paramF.b((support.android.view.asm.Label)localObject4, (support.android.view.asm.Label)localObject6, a.a(), 3);
      paramF.a((support.android.view.asm.Label)localObject5, localLabel4, c.a() * -1, 3);
      localObject1 = localObject2;
      if (!bool4)
      {
        paramF.a((support.android.view.asm.Label)localObject4, (support.android.view.asm.Label)localObject6, a.a(), r, localLabel4, (support.android.view.asm.Label)localObject5, c.a(), 4);
        localObject1 = localObject2;
      }
    }
    Object localObject1 = a;
    Object localObject4 = c;
    i2 = v;
    i5 = height;
    float f2 = r;
    int i6 = bottom;
    int i7 = i;
    int i8 = q;
    a(paramF, bool1, bool2, (Label)localObject1, (Label)localObject4, i2, i2 + i1, i1, i5, f2, bool3, bool4, i6, i7, i8);
    label2388:
    if (i3 != 0)
    {
      localObject3 = paramF.a();
      if (paramInt != java.lang.Integer.MAX_VALUE) {
        if ((f.x != paramInt) || (b.x != paramInt)) {
          return;
        }
      }
      localObject1 = this;
      if (i4 == 0)
      {
        paramF.a(((h)localObject3).a(localLabel3, localLabel2, localLabel1, (support.android.view.asm.Label)localObject2, f1));
        return;
      }
      if (i4 == 1)
      {
        paramF.a(((h)localObject3).a(localLabel1, (support.android.view.asm.Label)localObject2, localLabel3, localLabel2, f1));
        return;
      }
      paramInt = left;
      if (paramInt > 0) {
        paramF.b(localLabel3, localLabel2, paramInt, 3);
      }
      paramInt = i;
      if (paramInt > 0) {
        paramF.b(localLabel1, (support.android.view.asm.Label)localObject2, paramInt, 3);
      }
      ((h)localObject3).a(localLabel3, localLabel2, localLabel1, (support.android.view.asm.Label)localObject2, f1);
      localObject1 = paramF.d();
      localLabel1 = paramF.d();
      i = 4;
      i = 4;
      ((h)localObject3).a((support.android.view.asm.Label)localObject1, localLabel1);
      paramF.a((h)localObject3);
    }
  }
  
  public void a(support.android.view.asm.f paramF, String paramString)
  {
    A = paramString;
    Object localObject4 = paramF.a(f);
    Object localObject3 = paramF.a(a);
    Object localObject2 = paramF.a(b);
    Object localObject1 = paramF.a(c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".left");
    ((support.android.view.asm.Label)localObject4).a(localStringBuilder.toString());
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append(".top");
    ((support.android.view.asm.Label)localObject3).a(((StringBuilder)localObject4).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(".right");
    ((support.android.view.asm.Label)localObject2).a(((StringBuilder)localObject3).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".bottom");
    ((support.android.view.asm.Label)localObject1).a(((StringBuilder)localObject2).toString());
    if (u > 0)
    {
      paramF = paramF.a(y);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(".baseline");
      paramF.a(((StringBuilder)localObject1).toString());
    }
  }
  
  public void add(float paramFloat)
  {
    t = paramFloat;
  }
  
  public void add(int paramInt)
  {
    top = (paramInt - G);
    s = top;
  }
  
  public void add(int paramInt1, int paramInt2)
  {
    data = paramInt1;
    paramInt1 = data;
    int i1 = p;
    if (paramInt1 < i1) {
      data = i1;
    }
    width = paramInt2;
    paramInt1 = width;
    paramInt2 = height;
    if (paramInt1 < paramInt2) {
      width = paramInt2;
    }
  }
  
  public void add(int paramInt1, int paramInt2, int paramInt3)
  {
    bottom = paramInt1;
    i = paramInt2;
    q = paramInt3;
  }
  
  public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2;
    s = paramInt1;
    v = paramInt2;
    if (state == 8)
    {
      data = 0;
      width = 0;
      return;
    }
    if (type == Integer.data)
    {
      paramInt1 = data;
      if (i1 < paramInt1) {}
    }
    else
    {
      paramInt1 = i1;
    }
    if (size == Integer.data)
    {
      paramInt2 = width;
      if (paramInt3 < paramInt2) {}
    }
    else
    {
      paramInt2 = paramInt3;
    }
    data = paramInt1;
    width = paramInt2;
    paramInt1 = width;
    paramInt2 = height;
    if (paramInt1 < paramInt2) {
      width = paramInt2;
    }
    paramInt1 = data;
    paramInt2 = p;
    if (paramInt1 < paramInt2) {
      data = paramInt2;
    }
  }
  
  public void add(Integer paramInteger)
  {
    size = paramInteger;
    if (size == Integer.p) {
      append(time);
    }
  }
  
  public void add(i paramI) {}
  
  public int addIntentOptions()
  {
    return e + mTime;
  }
  
  public void append(int paramInt)
  {
    width = paramInt;
    paramInt = width;
    int i1 = height;
    if (paramInt < i1) {
      width = i1;
    }
  }
  
  public void append(int paramInt1, int paramInt2)
  {
    v = paramInt1;
    width = (paramInt2 - paramInt1);
    paramInt1 = width;
    paramInt2 = height;
    if (paramInt1 < paramInt2) {
      width = paramInt2;
    }
  }
  
  public void b(float paramFloat)
  {
    g = paramFloat;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    top = (paramInt1 - G);
    e = (paramInt2 - B);
    s = top;
    v = e;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    w = paramInt1;
    left = paramInt2;
    h = paramInt3;
  }
  
  public void b(i paramI)
  {
    ArrayList localArrayList = j();
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Label localLabel = (Label)localArrayList.get(i1);
      if ((localLabel.equals()) && (localLabel.length().getValue() == paramI) && (localLabel.f() == 2)) {
        localLabel.b();
      }
      i1 += 1;
    }
  }
  
  public void c(String paramString)
  {
    H = paramString;
  }
  
  public void clear()
  {
    i localI = next();
    if ((localI != null) && ((localI instanceof f)) && (((f)next()).g())) {
      return;
    }
    int i1 = 0;
    int i2 = n.size();
    while (i1 < i2)
    {
      ((Label)n.get(i1)).b();
      i1 += 1;
    }
  }
  
  public void clear(int paramInt)
  {
    time = paramInt;
  }
  
  public void clear(support.android.view.asm.f paramF)
  {
    a(paramF, java.lang.Integer.MAX_VALUE);
  }
  
  public boolean collapseActionView()
  {
    if ((this instanceof f))
    {
      i localI = l;
      if ((localI == null) || (!(localI instanceof f))) {
        return true;
      }
    }
    return false;
  }
  
  public int complement()
  {
    return version;
  }
  
  public int d()
  {
    return f() + width;
  }
  
  public void d(int paramInt)
  {
    e = (paramInt - B);
    v = e;
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    s = paramInt1;
    data = (paramInt2 - paramInt1);
    paramInt1 = data;
    paramInt2 = p;
    if (paramInt1 < paramInt2) {
      data = paramInt2;
    }
  }
  
  public void d(String paramString)
  {
    A = paramString;
  }
  
  public int e()
  {
    return top + G;
  }
  
  public void e(float paramFloat)
  {
    k = paramFloat;
  }
  
  public void e(int paramInt)
  {
    u = paramInt;
  }
  
  public void e(i paramI)
  {
    l = paramI;
  }
  
  public boolean equals()
  {
    return l == null;
  }
  
  public int evaluate()
  {
    int i1 = width;
    int i2 = i1;
    if (size == Integer.left)
    {
      if (bottom == 1)
      {
        i1 = Math.max(i, i1);
      }
      else
      {
        i1 = i;
        if (i1 > 0) {
          width = i1;
        } else {
          i1 = 0;
        }
      }
      int i3 = q;
      i2 = i1;
      if (i3 > 0)
      {
        i2 = i1;
        if (i3 < i1) {
          return i3;
        }
      }
    }
    return i2;
  }
  
  public int f()
  {
    return v;
  }
  
  public d findItem()
  {
    for (i localI = this; localI.next() != null; localI = localI.next()) {}
    if ((localI instanceof d)) {
      return (d)localI;
    }
    return null;
  }
  
  public int findNext()
  {
    return next;
  }
  
  public void g(int paramInt)
  {
    if (paramInt < 0)
    {
      p = 0;
      return;
    }
    p = paramInt;
  }
  
  public int get()
  {
    return state;
  }
  
  public void get(int paramInt)
  {
    data = paramInt;
    paramInt = data;
    int i1 = p;
    if (paramInt < i1) {
      data = i1;
    }
  }
  
  public String getActionView()
  {
    return A;
  }
  
  public int getColor()
  {
    int i1 = data;
    int i2 = i1;
    if (type == Integer.left)
    {
      if (w == 1)
      {
        i1 = Math.max(left, i1);
      }
      else
      {
        i1 = left;
        if (i1 > 0) {
          data = i1;
        } else {
          i1 = 0;
        }
      }
      int i3 = h;
      i2 = i1;
      if (i3 > 0)
      {
        i2 = i1;
        if (i3 < i1) {
          return i3;
        }
      }
    }
    return i2;
  }
  
  public int getDigestSize()
  {
    return length;
  }
  
  public int getFlags()
  {
    return flags;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public int getIcon()
  {
    return f();
  }
  
  public int getItem()
  {
    return e;
  }
  
  public void getItem(int paramInt)
  {
    state = paramInt;
  }
  
  public int getItemId()
  {
    return getString() + data;
  }
  
  public int getMTime()
  {
    return mTime;
  }
  
  public int getOrder()
  {
    return getString();
  }
  
  public int getState()
  {
    return mState;
  }
  
  public int getString()
  {
    return s;
  }
  
  public int getTime()
  {
    return time;
  }
  
  public int getTopDecorationHeight()
  {
    return top;
  }
  
  public int getValue()
  {
    if (state == 8) {
      return 0;
    }
    return data;
  }
  
  public int getVerticalMargins()
  {
    return u;
  }
  
  public float getZ()
  {
    return z;
  }
  
  public int h()
  {
    return s + G;
  }
  
  public String i()
  {
    return H;
  }
  
  public void i(int paramInt)
  {
    next = paramInt;
  }
  
  public int index()
  {
    return p;
  }
  
  public void init()
  {
    f.b();
    a.b();
    b.b();
    c.b();
    y.b();
    d.b();
    j.b();
    this$0.b();
    l = null;
    data = 0;
    width = 0;
    z = 0.0F;
    flags = -1;
    s = 0;
    v = 0;
    top = 0;
    e = 0;
    mState = 0;
    mTime = 0;
    G = 0;
    B = 0;
    u = 0;
    p = 0;
    height = 0;
    version = 0;
    time = 0;
    float f1 = buf;
    t = f1;
    r = f1;
    Integer localInteger = Integer.data;
    type = localInteger;
    size = localInteger;
    context = null;
    timestamp = 0;
    state = 0;
    A = null;
    H = null;
    value = false;
    first = false;
    next = 0;
    length = 0;
    N = false;
    shift = false;
    k = 0.0F;
    g = 0.0F;
    m = -1;
    x = -1;
  }
  
  public Integer invoke()
  {
    return type;
  }
  
  public Integer isEmpty()
  {
    return size;
  }
  
  public Object isVisible()
  {
    return context;
  }
  
  public int iterator()
  {
    return e + B;
  }
  
  public ArrayList j()
  {
    return n;
  }
  
  public int k()
  {
    return iterator() + mTime;
  }
  
  public void l(int paramInt)
  {
    if (paramInt < 0)
    {
      height = 0;
      return;
    }
    height = paramInt;
  }
  
  public int n()
  {
    return v + B;
  }
  
  public i next()
  {
    return l;
  }
  
  public void next(int paramInt)
  {
    s = paramInt;
  }
  
  public void onCreate()
  {
    int i1 = s;
    int i2 = v;
    int i3 = data;
    int i4 = width;
    top = i1;
    e = i2;
    mState = (i3 + i1 - i1);
    mTime = (i4 + i2 - i2);
  }
  
  public boolean onMenuItemSelected()
  {
    i localI2 = next();
    i localI1 = localI2;
    if (localI2 == null) {
      return false;
    }
    while (localI1 != null)
    {
      if ((localI1 instanceof f)) {
        return true;
      }
      localI1 = localI1.next();
    }
    return false;
  }
  
  public boolean onMenuItemSelected(i paramI)
  {
    i localI2 = next();
    i localI1 = localI2;
    if (localI2 == paramI) {
      return true;
    }
    if (localI2 == paramI.next()) {
      return false;
    }
    while (localI1 != null)
    {
      if (localI1 == paramI) {
        return true;
      }
      if (localI1 == paramI.next()) {
        return true;
      }
      localI1 = localI1.next();
    }
    return false;
  }
  
  public boolean onRefresh()
  {
    Label localLabel1 = a;
    Label localLabel2 = b;
    if ((localLabel2 == null) || (b != localLabel1))
    {
      localLabel1 = c;
      localLabel2 = b;
    }
    return (localLabel2 != null) && (b == localLabel1);
  }
  
  public int p()
  {
    return e() + mState;
  }
  
  public void parse(String paramString)
  {
    int i2;
    int i1;
    String str;
    if ((paramString != null) && (paramString.length() != 0))
    {
      int i3 = -1;
      int i5 = paramString.length();
      int i6 = paramString.indexOf(',');
      int i4 = 0;
      i2 = i4;
      i1 = i3;
      if (i6 > 0)
      {
        i2 = i4;
        i1 = i3;
        if (i6 < i5 - 1)
        {
          str = paramString.substring(0, i6);
          if (str.equalsIgnoreCase("W"))
          {
            i1 = 0;
          }
          else
          {
            i1 = i3;
            if (str.equalsIgnoreCase("H")) {
              i1 = 1;
            }
          }
          i2 = i6 + 1;
        }
      }
      i3 = paramString.indexOf(':');
      if ((i3 >= 0) && (i3 < i5 - 1))
      {
        str = paramString.substring(i2, i3);
        paramString = paramString.substring(i3 + 1);
        if ((str.length() <= 0) || (paramString.length() <= 0)) {
          break label245;
        }
      }
    }
    try
    {
      f1 = Float.parseFloat(str);
      float f2 = Float.parseFloat(paramString);
      if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
        break label245;
      }
      if (i1 == 1)
      {
        f1 = f2 / f1;
        f1 = Math.abs(f1);
      }
      else
      {
        f1 /= f2;
        f1 = Math.abs(f1);
      }
    }
    catch (NumberFormatException paramString)
    {
      float f1;
      for (;;) {}
    }
    paramString = paramString.substring(i2);
    if (paramString.length() > 0) {}
    try
    {
      f1 = Float.parseFloat(paramString);
    }
    catch (NumberFormatException paramString)
    {
      label245:
      for (;;) {}
    }
    f1 = 0.0F;
    if (f1 > 0.0F)
    {
      z = f1;
      flags = i1;
      return;
      z = 0.0F;
      return;
    }
  }
  
  public void push(int paramInt)
  {
    length = paramInt;
  }
  
  public void put(int paramInt)
  {
    v = paramInt;
  }
  
  public int q()
  {
    return timestamp;
  }
  
  public float r()
  {
    return r;
  }
  
  public void removeGroup()
  {
    int i2 = n.size();
    int i1 = 0;
    while (i1 < i2)
    {
      n.get(i1)).x = java.lang.Integer.MAX_VALUE;
      i1 += 1;
    }
  }
  
  public boolean removeItem()
  {
    Label localLabel1 = f;
    Label localLabel2 = b;
    if ((localLabel2 == null) || (b != localLabel1))
    {
      localLabel1 = b;
      localLabel2 = b;
    }
    return (localLabel2 != null) && (b == localLabel1);
  }
  
  public boolean replace()
  {
    return u > 0;
  }
  
  public void reset()
  {
    int i1 = s;
    int i2 = v;
    int i3 = data;
    int i4 = width;
    top = i1;
    e = i2;
    mState = (i3 + i1 - i1);
    mTime = (i4 + i2 - i2);
  }
  
  public i run()
  {
    Object localObject3;
    if (onRefresh())
    {
      Object localObject1 = this;
      localObject3 = null;
      while ((localObject3 == null) && (localObject1 != null))
      {
        Object localObject2 = ((i)localObject1).a(c.d);
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((Label)localObject2).length();
        }
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((Label)localObject2).getValue();
        }
        if (localObject2 == next()) {
          return localObject1;
        }
        Label localLabel;
        if (localObject2 == null) {
          localLabel = null;
        } else {
          localLabel = ((i)localObject2).a(c.b).length();
        }
        if ((localLabel != null) && (localLabel.getValue() != localObject1)) {
          localObject3 = localObject1;
        } else {
          localObject1 = localObject2;
        }
      }
    }
    return null;
    return localObject3;
  }
  
  public void run(int paramInt)
  {
    Object localObject = next();
    if ((localObject != null) && ((localObject instanceof f)) && (((f)next()).g())) {
      return;
    }
    int i1 = 0;
    int i2 = n.size();
    while (i1 < i2)
    {
      localObject = (Label)n.get(i1);
      if (paramInt == ((Label)localObject).f())
      {
        if (((Label)localObject).encode()) {
          a(buf);
        } else {
          add(buf);
        }
        ((Label)localObject).b();
      }
      i1 += 1;
    }
  }
  
  public float s()
  {
    return t;
  }
  
  public void set(int paramInt)
  {
    version = paramInt;
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    s = paramInt1;
    v = paramInt2;
  }
  
  public void setChecked(int paramInt)
  {
    mState = paramInt;
  }
  
  public void setMenu(support.android.view.asm.f paramF)
  {
    toString(paramF, java.lang.Integer.MAX_VALUE);
  }
  
  public void setValue(int paramInt)
  {
    if (paramInt >= 0)
    {
      timestamp = paramInt;
      return;
    }
    timestamp = 0;
  }
  
  public void setVariable(int paramInt)
  {
    mTime = paramInt;
  }
  
  public int size()
  {
    if (state == 8) {
      return 0;
    }
    return width;
  }
  
  public int t()
  {
    return top + mState;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = H;
    String str = "";
    if (localObject != null) {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("type: "), H, " ");
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (A != null) {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("id: "), A, " ");
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("(");
    localStringBuilder.append(s);
    localStringBuilder.append(", ");
    localStringBuilder.append(v);
    localStringBuilder.append(") - (");
    localStringBuilder.append(data);
    localStringBuilder.append(" x ");
    localStringBuilder.append(width);
    localStringBuilder.append(")");
    localStringBuilder.append(" wrap: (");
    localStringBuilder.append(version);
    localStringBuilder.append(" x ");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, time, ")");
  }
  
  public void toString(support.android.view.asm.f paramF, int paramInt)
  {
    if (paramInt == java.lang.Integer.MAX_VALUE)
    {
      add(paramF.read(f), paramF.read(a), paramF.read(b), paramF.read(c));
      return;
    }
    if (paramInt == -2)
    {
      add(id, current, path, page);
      return;
    }
    Label localLabel = f;
    if (x == paramInt) {
      id = paramF.read(localLabel);
    }
    localLabel = a;
    if (x == paramInt) {
      current = paramF.read(localLabel);
    }
    localLabel = b;
    if (x == paramInt) {
      path = paramF.read(localLabel);
    }
    localLabel = c;
    if (x == paramInt) {
      page = paramF.read(localLabel);
    }
  }
  
  public i value()
  {
    Object localObject3;
    if (removeItem())
    {
      Object localObject1 = this;
      localObject3 = null;
      while ((localObject3 == null) && (localObject1 != null))
      {
        Object localObject2 = ((i)localObject1).a(c.a);
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((Label)localObject2).length();
        }
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((Label)localObject2).getValue();
        }
        if (localObject2 == next()) {
          return localObject1;
        }
        Label localLabel;
        if (localObject2 == null) {
          localLabel = null;
        } else {
          localLabel = ((i)localObject2).a(c.c).length();
        }
        if ((localLabel != null) && (localLabel.getValue() != localObject1)) {
          localObject3 = localObject1;
        } else {
          localObject1 = localObject2;
        }
      }
    }
    return null;
    return localObject3;
  }
  
  public void write()
  {
    clear();
    a(buf);
    add(buf);
    if ((this instanceof f)) {
      return;
    }
    if (invoke() == Integer.left) {
      if (getValue() == complement()) {
        a(Integer.p);
      } else if (getValue() > index()) {
        a(Integer.data);
      }
    }
    if (isEmpty() == Integer.left)
    {
      if (size() == getTime())
      {
        add(Integer.p);
        return;
      }
      if (size() > getHeight()) {
        add(Integer.data);
      }
    }
  }
}
