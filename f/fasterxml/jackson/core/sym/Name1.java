package f.fasterxml.jackson.core.sym;

public final class Name1
  extends Name
{
  public static final Name1 sEmptyName = new Name1("", 0, 0);
  public final int mQuad;
  
  public Name1(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
    mQuad = paramInt2;
  }
  
  public static Name1 getEmptyName()
  {
    return sEmptyName;
  }
  
  public boolean equals(int paramInt)
  {
    return paramInt == mQuad;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 == mQuad) && (paramInt2 == 0);
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 1) && (paramArrayOfInt[0] == mQuad);
  }
}
