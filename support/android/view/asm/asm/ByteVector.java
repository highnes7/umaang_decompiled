package support.android.view.asm.asm;

import java.util.ArrayList;

public class ByteVector
  extends i
{
  public static final int BUTTON_WEEK_INDEX = 1;
  public static final int DEFAULT_BLOCK_SIZE = 1;
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int Icode_DUP = -1;
  public static final int QUIET_HOURS_DEFAULT_END_MINUTE = 0;
  public static final int QUIET_HOURS_DEFAULT_START_MINUTE = 0;
  public Label a = a;
  public int b = -1;
  public int blockSize = 8;
  public int c = 0;
  public int f = -1;
  public boolean l = false;
  public ClassWriter n = new ClassWriter();
  public int size = 0;
  public float x = -1.0F;
  
  public ByteVector()
  {
    n.clear();
    n.add(a);
  }
  
  public Label a(c paramC)
  {
    int i = paramC.ordinal();
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          if (i != 4) {
            break label53;
          }
        }
      }
      else
      {
        if (c != 0) {
          break label53;
        }
        return a;
      }
    }
    if (c == 1) {
      return a;
    }
    label53:
    return null;
  }
  
  public void a()
  {
    if (f != -1)
    {
      read();
      return;
    }
    if (x != -1.0F)
    {
      b();
      return;
    }
    if (b != -1) {
      visitFrame();
    }
  }
  
  public void a(int paramInt)
  {
    if (c == paramInt) {
      return;
    }
    c = paramInt;
    n.clear();
    if (c == 1) {
      a = f;
    } else {
      a = a;
    }
    n.add(a);
  }
  
  public void a(support.android.view.asm.f paramF, int paramInt)
  {
    f localF = (f)next();
    if (localF == null) {
      return;
    }
    Label localLabel1 = localF.a(c.a);
    Label localLabel2 = localF.a(c.c);
    if (c == 0)
    {
      localLabel1 = localF.a(c.d);
      localLabel2 = localF.a(c.b);
    }
    if (f != -1)
    {
      paramF.a(support.android.view.asm.f.c(paramF, paramF.a(a), paramF.a(localLabel1), f, false));
      return;
    }
    if (b != -1)
    {
      paramF.a(support.android.view.asm.f.c(paramF, paramF.a(a), paramF.a(localLabel2), -b, false));
      return;
    }
    if (x != -1.0F) {
      paramF.a(support.android.view.asm.f.a(paramF, paramF.a(a), paramF.a(localLabel1), paramF.a(localLabel2), x, l));
    }
  }
  
  public int add()
  {
    return c;
  }
  
  public void b()
  {
    int i = next().getValue() - getString();
    if (c == 0) {
      i = next().size() - f();
    }
    write(i);
  }
  
  public void b(int paramInt)
  {
    if (paramInt > -1)
    {
      x = -1.0F;
      f = paramInt;
      b = -1;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (c == 1)
    {
      paramInt1 -= G;
      if (f != -1)
      {
        b(paramInt1);
        return;
      }
      if (b != -1)
      {
        write(next().getValue() - paramInt1);
        return;
      }
      if (x != -1.0F) {
        write(paramInt1 / next().getValue());
      }
    }
    else
    {
      paramInt1 = paramInt2 - B;
      if (f != -1)
      {
        b(paramInt1);
        return;
      }
      if (b != -1)
      {
        write(next().size() - paramInt1);
        return;
      }
      if (x != -1.0F) {
        write(paramInt1 / next().size());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (l == paramBoolean) {
      return;
    }
    l = paramBoolean;
  }
  
  public ClassWriter c()
  {
    ClassWriter localClassWriter = n;
    int i = e();
    int j = blockSize;
    int k = iterator();
    int m = blockSize;
    localClassWriter.a(i - j, k - m * 2, m * 2, m * 2);
    if (add() == 0)
    {
      localClassWriter = n;
      i = e();
      j = blockSize;
      k = iterator();
      m = blockSize;
      localClassWriter.a(i - j * 2, k - m, m * 2, m * 2);
    }
    return n;
  }
  
  public int getSize()
  {
    if (x != -1.0F) {
      return 0;
    }
    if (f != -1) {
      return 1;
    }
    if (b != -1) {
      return 2;
    }
    return -1;
  }
  
  public float getX()
  {
    return x;
  }
  
  public String i()
  {
    return "Guideline";
  }
  
  public ArrayList j()
  {
    return n;
  }
  
  public int length()
  {
    return f;
  }
  
  public int put()
  {
    return b;
  }
  
  public Label putUTF8()
  {
    return a;
  }
  
  public void read()
  {
    float f1 = getString() / next().getValue();
    if (c == 0) {
      f1 = f() / next().size();
    }
    write(f1);
  }
  
  public void read(int paramInt)
  {
    write(paramInt / 100.0F);
  }
  
  public void toString(support.android.view.asm.f paramF, int paramInt)
  {
    if (next() == null) {
      return;
    }
    paramInt = paramF.read(a);
    if (c == 1)
    {
      next(paramInt);
      put(0);
      append(next().size());
      get(0);
      return;
    }
    next(0);
    put(paramInt);
    get(next().getValue());
    append(0);
  }
  
  public void trimToSize(int paramInt)
  {
    size = paramInt;
  }
  
  public void visitFrame()
  {
    int i = getString();
    if (c == 0) {
      i = f();
    }
    b(i);
  }
  
  public void write(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      x = paramFloat;
      f = -1;
      b = -1;
    }
  }
  
  public void write(int paramInt)
  {
    if (paramInt > -1)
    {
      x = -1.0F;
      f = -1;
      b = paramInt;
    }
  }
}
