package support.android.v4.app;

public class OperationCanceledException
  extends RuntimeException
{
  public OperationCanceledException()
  {
    this(null);
  }
  
  public OperationCanceledException(String paramString)
  {
    super(paramString);
  }
}
