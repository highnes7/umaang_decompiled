package support.android.view.asm.asm;

import b.b.d.a.a.m.a;
import java.util.ArrayList;

public class AnnotationWriter
{
  public ArrayList<m.a> a = new ArrayList();
  public int b;
  public int c;
  public int d;
  public int n;
  
  public AnnotationWriter(i paramI)
  {
    b = paramI.getString();
    c = paramI.f();
    d = paramI.getValue();
    n = paramI.size();
    paramI = paramI.j();
    int j = paramI.size();
    int i = 0;
    while (i < j)
    {
      Label localLabel = (Label)paramI.get(i);
      a.add(new e(localLabel));
      i += 1;
    }
  }
  
  public void a(i paramI)
  {
    b = paramI.getString();
    c = paramI.f();
    d = paramI.getValue();
    n = paramI.size();
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      ((e)a.get(i)).b(paramI);
      i += 1;
    }
  }
  
  public void visit(i paramI)
  {
    paramI.next(b);
    paramI.put(c);
    paramI.get(d);
    paramI.append(n);
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      ((e)a.get(i)).a(paramI);
      i += 1;
    }
  }
}
