package com.facebook;

import android.os.Handler;

public class RequestProgress
{
  public final Handler callbackHandler;
  public long lastReportedProgress;
  public long maxProgress;
  public long progress;
  public final GraphRequest request;
  public final long threshold;
  
  public RequestProgress(Handler paramHandler, GraphRequest paramGraphRequest)
  {
    request = paramGraphRequest;
    callbackHandler = paramHandler;
    threshold = FacebookSdk.getOnProgressThreshold();
  }
  
  public void addProgress(long paramLong)
  {
    progress += paramLong;
    paramLong = progress;
    if ((paramLong >= lastReportedProgress + threshold) || (paramLong >= maxProgress)) {
      reportProgress();
    }
  }
  
  public void addToMax(long paramLong)
  {
    maxProgress += paramLong;
  }
  
  public long getMaxProgress()
  {
    return maxProgress;
  }
  
  public long getProgress()
  {
    return progress;
  }
  
  public void reportProgress()
  {
    if (progress > lastReportedProgress)
    {
      Object localObject = request.getCallback();
      long l1 = maxProgress;
      if ((l1 > 0L) && ((localObject instanceof GraphRequest.OnProgressCallback)))
      {
        final long l2 = progress;
        localObject = (GraphRequest.OnProgressCallback)localObject;
        Handler localHandler = callbackHandler;
        if (localHandler == null) {
          ((GraphRequest.OnProgressCallback)localObject).onProgress(l2, l1);
        } else {
          localHandler.post(new Runnable()
          {
            public void run()
            {
              val$callbackCopy.onProgress(l2, val$maxProgressCopy);
            }
          });
        }
        lastReportedProgress = progress;
      }
    }
  }
}
