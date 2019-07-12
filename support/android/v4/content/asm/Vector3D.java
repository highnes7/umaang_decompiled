package support.android.v4.content.asm;

import java.util.List;

public final class Vector3D
{
  public final float[] v;
  public final int[] z;
  
  public Vector3D(int paramInt1, int paramInt2)
  {
    z = new int[] { paramInt1, paramInt2 };
    v = new float[] { 0.0F, 1.0F };
  }
  
  public Vector3D(int paramInt1, int paramInt2, int paramInt3)
  {
    z = new int[] { paramInt1, paramInt2, paramInt3 };
    v = new float[] { 0.0F, 0.5F, 1.0F };
  }
  
  public Vector3D(List paramList1, List paramList2)
  {
    int j = paramList1.size();
    z = new int[j];
    v = new float[j];
    int i = 0;
    while (i < j)
    {
      z[i] = ((Integer)paramList1.get(i)).intValue();
      v[i] = ((Float)paramList2.get(i)).floatValue();
      i += 1;
    }
  }
}
