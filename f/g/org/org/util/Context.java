package f.g.org.org.util;

public abstract interface Context
{
  public static final Context c = new Transaction.1();
  
  public abstract void report(long paramLong)
    throws InterruptedException;
}
