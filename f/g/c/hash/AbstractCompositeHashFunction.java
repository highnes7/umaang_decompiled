package f.g.c.hash;

public abstract class AbstractCompositeHashFunction
  extends AbstractStreamingHashFunction
{
  public static final long serialVersionUID = 0L;
  public final HashFunction[] functions;
  
  public AbstractCompositeHashFunction(HashFunction... paramVarArgs)
  {
    functions = paramVarArgs;
  }
  
  public abstract HashCode makeHash(Hasher[] paramArrayOfHasher);
  
  public Hasher newHasher()
  {
    Hasher[] arrayOfHasher = new Hasher[functions.length];
    int i = 0;
    while (i < arrayOfHasher.length)
    {
      arrayOfHasher[i] = functions[i].newHasher();
      i += 1;
    }
    return new AbstractCompositeHashFunction.1(this, arrayOfHasher);
  }
}
