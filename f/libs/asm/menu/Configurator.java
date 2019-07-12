package f.libs.asm.menu;

import android.os.AsyncTask;
import l.a.a.a.Log;
import l.a.a.a.f;

public class Configurator
{
  public Configurator() {}
  
  private void configure(String paramString)
  {
    throw new RuntimeException(paramString);
  }
  
  public int b()
  {
    return b() + (int)Math.random();
  }
  
  public void clear()
  {
    int i = new int[2][10];
    Log localLog = f.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Out of bounds value: ");
    localStringBuilder.append(i);
    localLog.d("CrashlyticsCore", localStringBuilder.toString());
  }
  
  public void configure()
  {
    try
    {
      RuntimeException localRuntimeException1 = new RuntimeException("1");
      throw localRuntimeException1;
    }
    catch (Exception localException1)
    {
      try
      {
        RuntimeException localRuntimeException2 = new RuntimeException("2", localException1);
        throw localRuntimeException2;
      }
      catch (Exception localException2)
      {
        try
        {
          RuntimeException localRuntimeException3 = new RuntimeException("3", localException2);
          throw localRuntimeException3;
        }
        catch (Exception localException3)
        {
          try
          {
            RuntimeException localRuntimeException4 = new RuntimeException("4", localException3);
            throw localRuntimeException4;
          }
          catch (Exception localException4)
          {
            throw new RuntimeException("5", localException4);
          }
        }
      }
    }
  }
  
  public void getProperty(String paramString)
  {
    throw new RuntimeException(paramString);
  }
  
  public void onPostExecute(long paramLong)
  {
    new TileProviderMNM.IndexTask(this, paramLong).execute(new Void[] { null });
  }
}
