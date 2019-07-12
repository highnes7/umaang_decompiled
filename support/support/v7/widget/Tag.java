package support.support.v7.widget;

import b.b.a.F;
import b.b.a.N;
import java.util.concurrent.Executor;

@N({b.b.a.N.a.b})
public class Tag
  extends AsyncHttpClient
{
  public static volatile Tag NULL;
  @F
  public static final Executor data = new ActivityChooserModel.SerialExecutor();
  @F
  public static final Executor tag = new Threading.2();
  @F
  public AsyncHttpClient mClient = this$0;
  @F
  public AsyncHttpClient this$0 = new HttpConnection();
  
  public Tag() {}
  
  public static Executor access$getTag()
  {
    return tag;
  }
  
  public static Executor isData()
  {
    return data;
  }
  
  public static Tag valueOf()
  {
    if (NULL != null) {
      return NULL;
    }
    try
    {
      if (NULL == null) {
        NULL = new Tag();
      }
      return NULL;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    mClient.execute(paramRunnable);
  }
  
  public boolean execute()
  {
    return mClient.execute();
  }
  
  public void post(Runnable paramRunnable)
  {
    mClient.post(paramRunnable);
  }
  
  public void readObject(AsyncHttpClient paramAsyncHttpClient)
  {
    AsyncHttpClient localAsyncHttpClient = paramAsyncHttpClient;
    if (paramAsyncHttpClient == null) {
      localAsyncHttpClient = this$0;
    }
    mClient = localAsyncHttpClient;
  }
}
