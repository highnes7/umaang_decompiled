package f.fasterxml.jackson.core.sym;

public final class Name3
  extends Name
{
  public final int c;
  public final int[] f;
  
  public Name3(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramString, paramInt1);
    if (paramInt2 >= 3)
    {
      f = paramArrayOfInt;
      c = paramInt2;
      return;
    }
    throw new IllegalArgumentException("Qlen must >= 3");
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt != c) {
      return false;
    }
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt[i] != f[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}
