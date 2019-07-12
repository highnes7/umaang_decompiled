package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProgressOutputStream
  extends FilterOutputStream
  implements RequestOutputStream
{
  public long batchProgress;
  public RequestProgress currentRequestProgress;
  public long lastReportedProgress;
  public long maxProgress;
  public final Map<GraphRequest, RequestProgress> progressMap;
  public final GraphRequestBatch requests;
  public final long threshold;
  
  public ProgressOutputStream(OutputStream paramOutputStream, GraphRequestBatch paramGraphRequestBatch, Map paramMap, long paramLong)
  {
    super(paramOutputStream);
    requests = paramGraphRequestBatch;
    progressMap = paramMap;
    maxProgress = paramLong;
    threshold = FacebookSdk.getOnProgressThreshold();
  }
  
  private void addProgress(long paramLong)
  {
    RequestProgress localRequestProgress = currentRequestProgress;
    if (localRequestProgress != null) {
      localRequestProgress.addProgress(paramLong);
    }
    batchProgress += paramLong;
    paramLong = batchProgress;
    if ((paramLong >= lastReportedProgress + threshold) || (paramLong >= maxProgress)) {
      reportBatchProgress();
    }
  }
  
  private void reportBatchProgress()
  {
    if (batchProgress > lastReportedProgress)
    {
      Iterator localIterator = requests.getCallbacks().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (GraphRequestBatch.Callback)localIterator.next();
        if ((localObject instanceof GraphRequestBatch.OnProgressCallback))
        {
          Handler localHandler = requests.getCallbackHandler();
          localObject = (GraphRequestBatch.OnProgressCallback)localObject;
          if (localHandler == null) {
            ((GraphRequestBatch.OnProgressCallback)localObject).onBatchProgress(requests, batchProgress, maxProgress);
          } else {
            localHandler.post(new Runnable()
            {
              public void run()
              {
                val$progressCallback.onBatchProgress(ProgressOutputStream.access$000(ProgressOutputStream.this), ProgressOutputStream.access$100(ProgressOutputStream.this), ProgressOutputStream.access$200(ProgressOutputStream.this));
              }
            });
          }
        }
      }
      lastReportedProgress = batchProgress;
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    Iterator localIterator = progressMap.values().iterator();
    while (localIterator.hasNext()) {
      ((RequestProgress)localIterator.next()).reportProgress();
    }
    reportBatchProgress();
  }
  
  public long getBatchProgress()
  {
    return batchProgress;
  }
  
  public long getMaxProgress()
  {
    return maxProgress;
  }
  
  public void setCurrentRequest(GraphRequest paramGraphRequest)
  {
    if (paramGraphRequest != null) {
      paramGraphRequest = (RequestProgress)progressMap.get(paramGraphRequest);
    } else {
      paramGraphRequest = null;
    }
    currentRequestProgress = paramGraphRequest;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    out.write(paramInt);
    addProgress(1L);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    out.write(paramArrayOfByte);
    addProgress(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramArrayOfByte, paramInt1, paramInt2);
    addProgress(paramInt2);
  }
}
