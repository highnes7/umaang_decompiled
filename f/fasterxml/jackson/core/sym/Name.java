package f.fasterxml.jackson.core.sym;

public abstract class Name
{
  public final int _hashCode;
  public final String _name;
  
  public Name(String paramString, int paramInt)
  {
    _name = paramString;
    _hashCode = paramInt;
  }
  
  public abstract boolean equals(int paramInt);
  
  public abstract boolean equals(int paramInt1, int paramInt2);
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
  
  public abstract boolean equals(int[] paramArrayOfInt, int paramInt);
  
  public String getName()
  {
    return _name;
  }
  
  public final int hashCode()
  {
    return _hashCode;
  }
  
  public String toString()
  {
    return _name;
  }
}
