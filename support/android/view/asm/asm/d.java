package support.android.view.asm.asm;

import java.util.ArrayList;
import support.android.view.asm.Item;

public class d
  extends i
{
  public ArrayList<b.b.d.a.a.f> a = new ArrayList();
  
  public d() {}
  
  public d(int paramInt1, int paramInt2)
  {
    super(0, 0, paramInt1, paramInt2);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static ClassWriter a(ArrayList paramArrayList)
  {
    ClassWriter localClassWriter = new ClassWriter();
    if (paramArrayList.size() == 0) {
      return localClassWriter;
    }
    int i5 = paramArrayList.size();
    int i3 = java.lang.Integer.MAX_VALUE;
    int j = 0;
    int n = java.lang.Integer.MAX_VALUE;
    int k = 0;
    int i4;
    for (int i = 0; j < i5; i = i4)
    {
      i localI = (i)paramArrayList.get(j);
      int m = i3;
      if (localI.getString() < i3) {
        m = localI.getString();
      }
      int i1 = n;
      if (localI.f() < n) {
        i1 = localI.f();
      }
      int i2 = k;
      if (localI.getItemId() > k) {
        i2 = localI.getItemId();
      }
      i4 = i;
      if (localI.d() > i) {
        i4 = localI.d();
      }
      j += 1;
      i3 = m;
      n = i1;
      k = i2;
    }
    localClassWriter.a(i3, n, k - i3, i - n);
    return localClassWriter;
  }
  
  public ArrayList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    int i = a.size();
    paramInt3 = 0;
    while (paramInt3 < i)
    {
      i localI = (i)a.get(paramInt3);
      paramInt4 = localI.e();
      int j = localI.iterator();
      int k = localI.getValue();
      int m = localI.size();
      if ((paramInt1 >= paramInt4) && (paramInt1 < paramInt4 + k) && (paramInt2 >= j) && (paramInt2 < j + m)) {
        paramInt4 = 1;
      } else {
        paramInt4 = 0;
      }
      if (paramInt4 != 0) {
        localArrayList.add(localI);
      }
      paramInt3 += 1;
    }
    return localArrayList;
  }
  
  public i a(float paramFloat1, float paramFloat2)
  {
    int i = e();
    int j = iterator();
    int k = getValue();
    int m = size();
    Object localObject1;
    if ((paramFloat1 >= i) && (paramFloat1 <= k + i) && (paramFloat2 >= j) && (paramFloat2 <= m + j)) {
      localObject1 = this;
    } else {
      localObject1 = null;
    }
    i = 0;
    j = a.size();
    while (i < j)
    {
      Object localObject3 = (i)a.get(i);
      if ((localObject3 instanceof d))
      {
        i localI = ((d)localObject3).a(paramFloat1, paramFloat2);
        localObject3 = localI;
        localObject2 = localObject1;
        if (localI == null) {
          break label228;
        }
        localObject1 = localObject3;
      }
      else
      {
        k = ((i)localObject3).e();
        m = ((i)localObject3).iterator();
        int n = ((i)localObject3).getValue();
        int i1 = ((i)localObject3).size();
        localObject2 = localObject1;
        if (paramFloat1 < k) {
          break label228;
        }
        localObject2 = localObject1;
        if (paramFloat1 > n + k) {
          break label228;
        }
        localObject2 = localObject1;
        if (paramFloat2 < m) {
          break label228;
        }
        localObject2 = localObject1;
        if (paramFloat2 > i1 + m) {
          break label228;
        }
        localObject1 = localObject3;
      }
      Object localObject2 = localObject1;
      label228:
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    G = paramInt1;
    B = paramInt2;
    paramInt2 = a.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((i)a.get(paramInt1)).a(h(), n());
      paramInt1 += 1;
    }
  }
  
  public void a(Item paramItem)
  {
    super.a(paramItem);
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      ((i)a.get(i)).a(paramItem);
      i += 1;
    }
  }
  
  public void add()
  {
    reset();
    Object localObject = a;
    if (localObject == null) {
      return;
    }
    int j = ((ArrayList)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = (i)a.get(i);
      if ((localObject instanceof d)) {
        ((d)localObject).add();
      }
      i += 1;
    }
  }
  
  public void c(i paramI)
  {
    a.remove(paramI);
    paramI.e(null);
  }
  
  public void close(i paramI)
  {
    a.add(paramI);
    if (paramI.next() != null) {
      ((d)paramI.next()).c(paramI);
    }
    paramI.e(this);
  }
  
  public f getId()
  {
    Object localObject = next();
    f localF;
    if ((this instanceof f)) {
      localF = (f)this;
    } else {
      localF = null;
    }
    while (localObject != null)
    {
      i localI = ((i)localObject).next();
      if ((localObject instanceof f)) {
        localF = (f)localObject;
      }
      localObject = localI;
    }
    return localF;
  }
  
  public ArrayList getRegions()
  {
    return a;
  }
  
  public void init()
  {
    a.clear();
    super.init();
  }
  
  public void removeGroup()
  {
    super.removeGroup();
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      ((i)a.get(i)).removeGroup();
      i += 1;
    }
  }
  
  public void reset()
  {
    super.reset();
    Object localObject = a;
    if (localObject == null) {
      return;
    }
    int j = ((ArrayList)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = (i)a.get(i);
      ((i)localObject).a(e(), iterator());
      if (!(localObject instanceof f)) {
        ((i)localObject).reset();
      }
      i += 1;
    }
  }
  
  public void setEnabled()
  {
    a.clear();
  }
}
