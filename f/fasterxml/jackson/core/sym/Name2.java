package f.fasterxml.jackson.core.sym;

public final class Name2
  extends Name
{
  public final int d;
  public final int d1;
  
  public Name2(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString, paramInt1);
    d = paramInt2;
    d1 = paramInt3;
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 == d) && (paramInt2 == d1);
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 2) && (paramArrayOfInt[0] == d) && (paramArrayOfInt[1] == d1);
  }
}
