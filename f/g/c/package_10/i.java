package f.g.c.package_10;

public final class i
  extends h
{
  public i(String paramString, Predicate paramPredicate)
  {
    super(paramString);
  }
  
  public boolean a(char paramChar)
  {
    return p.apply(Character.valueOf(paramChar));
  }
  
  public boolean add(Character paramCharacter)
  {
    Predicate localPredicate = p;
    if (paramCharacter != null) {
      return localPredicate.apply(paramCharacter);
    }
    throw new NullPointerException();
  }
}
