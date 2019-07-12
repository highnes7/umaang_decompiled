package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ProgressNoopOutputStream
  extends OutputStream
  implements RequestOutputStream
{
  public int batchMax;
  public final Handler callbackHandler;
  public GraphRequest currentRequest;
  public RequestProgress currentRequestProgress;
  public final Map<GraphRequest, RequestProgress> progressMap = new HashMap();
  
  public ProgressNoopOutputStream(Handler paramHandler)
  {
    callbackHandler = paramHandler;
  }
  
  public void addProgress(long paramLong)
  {
    if (currentRequestProgress == null)
    {
      currentRequestProgress = new RequestProgress(callbackHandler, currentRequest);
      progressMap.put(currentRequest, currentRequestProgress);
    }
    currentRequestProgress.addToMax(paramLong);
    batchMax = ((int)(batchMax + paramLong));
  }
  
  public int getMaxProgress()
  {
    return batchMax;
  }
  
  public Map getProgressMap()
  {
    return progressMap;
  }
  
  public void setCurrentRequest(GraphRequest paramGraphRequest)
  {
    currentRequest = paramGraphRequest;
    if (paramGraphRequest != null) {
      paramGraphRequest = (RequestProgress)progressMap.get(paramGraphRequest);
    } else {
      paramGraphRequest = null;
    }
    currentRequestProgress = paramGraphRequest;
  }
  
  public void write(int paramInt)
  {
    addProgress(1L);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    addProgress(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    addProgress(paramInt2);
  }
}
