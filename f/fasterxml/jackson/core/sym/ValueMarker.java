package f.fasterxml.jackson.core.sym;

public final class ValueMarker
  extends Name
{
  public final int c;
  public final int e;
  public final int f;
  
  public ValueMarker(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramInt1);
    e = paramInt2;
    f = paramInt3;
    c = paramInt4;
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
    return (paramInt == 3) && (paramArrayOfInt[0] == e) && (paramArrayOfInt[1] == f) && (paramArrayOfInt[2] == c);
  }
}
