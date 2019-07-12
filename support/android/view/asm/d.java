package support.android.view.asm;

import java.util.ArrayList;

public class d
{
  public ArrayList<b.b.d.a.h> a = new ArrayList();
  
  public d() {}
  
  private void b(f paramF)
  {
    a.clear();
    int i = 1;
    while (i < i)
    {
      Label localLabel = j.i[i];
      int j = 0;
      while (j < 6)
      {
        d[j] = 0.0F;
        j += 1;
      }
      d[i] = 1.0F;
      if (a == c.a) {
        a.add(localLabel);
      }
      i += 1;
    }
  }
  
  public Label a()
  {
    int n = a.size();
    int m = 0;
    Object localObject2 = null;
    int j = 0;
    while (m < n)
    {
      Label localLabel = (Label)a.get(m);
      int i = 5;
      while (i >= 0)
      {
        float f = d[i];
        Object localObject1 = localObject2;
        int k = j;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          k = j;
          if (f < 0.0F)
          {
            localObject1 = localObject2;
            k = j;
            if (i >= j)
            {
              localObject1 = localLabel;
              k = i;
            }
          }
        }
        localObject2 = localObject1;
        j = k;
        if (f > 0.0F)
        {
          localObject2 = localObject1;
          j = k;
          if (i > k)
          {
            localObject2 = null;
            j = i;
          }
        }
        i -= 1;
      }
      m += 1;
    }
    return localObject2;
  }
  
  public void a(f paramF)
  {
    b(paramF);
    int m = a.size();
    int i = 0;
    while (i < m)
    {
      Label localLabel1 = (Label)a.get(i);
      int j = c;
      if (j != -1)
      {
        i localI = ab;
        int n = c;
        j = 0;
        while (j < n)
        {
          Label localLabel2 = localI.a(j);
          if (localLabel2 != null)
          {
            float f1 = localI.b(j);
            int k = 0;
            while (k < 6)
            {
              float[] arrayOfFloat = d;
              float f2 = arrayOfFloat[k];
              arrayOfFloat[k] = (d[k] * f1 + f2);
              k += 1;
            }
            if (!a.contains(localLabel2)) {
              a.add(localLabel2);
            }
          }
          j += 1;
        }
        localLabel1.b();
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    int j = a.size();
    Object localObject = "Goal: ";
    int i = 0;
    while (i < j)
    {
      Label localLabel = (Label)a.get(i);
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject);
      ((StringBuilder)localObject).append(localLabel.format());
      localObject = ((StringBuilder)localObject).toString();
      i += 1;
    }
    return localObject;
  }
}
