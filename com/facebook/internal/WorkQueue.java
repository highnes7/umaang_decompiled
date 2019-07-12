package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

public class WorkQueue
{
  public static final int DEFAULT_MAX_CONCURRENT = 8;
  public final Executor executor;
  public final int maxConcurrent;
  public WorkNode pendingJobs;
  public int runningCount = 0;
  public WorkNode runningJobs = null;
  public final Object workLock = new Object();
  
  public WorkQueue()
  {
    this(8);
  }
  
  public WorkQueue(int paramInt)
  {
    this(paramInt, FacebookSdk.getExecutor());
  }
  
  public WorkQueue(int paramInt, Executor paramExecutor)
  {
    maxConcurrent = paramInt;
    executor = paramExecutor;
  }
  
  private void execute(final WorkNode paramWorkNode)
  {
    executor.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          paramWorkNode.getCallback().run();
          WorkQueue.access$000(WorkQueue.this, paramWorkNode);
          return;
        }
        catch (Throwable localThrowable)
        {
          WorkQueue.access$000(WorkQueue.this, paramWorkNode);
          throw localThrowable;
        }
      }
    });
  }
  
  private void finishItemAndStartNew(WorkNode paramWorkNode)
  {
    Object localObject = workLock;
    if (paramWorkNode != null) {}
    for (;;)
    {
      try
      {
        runningJobs = paramWorkNode.removeFromList(runningJobs);
        runningCount -= 1;
        if (runningCount >= maxConcurrent) {
          break label131;
        }
        WorkNode localWorkNode = pendingJobs;
        paramWorkNode = localWorkNode;
        if (localWorkNode != null)
        {
          pendingJobs = localWorkNode.removeFromList(pendingJobs);
          runningJobs = localWorkNode.addToList(runningJobs, false);
          runningCount += 1;
          localWorkNode.setIsRunning(true);
          paramWorkNode = localWorkNode;
        }
        if (paramWorkNode != null)
        {
          executor.execute(new Runnable()
          {
            public void run()
            {
              try
              {
                paramWorkNode.getCallback().run();
                WorkQueue.access$000(WorkQueue.this, paramWorkNode);
                return;
              }
              catch (Throwable localThrowable)
              {
                WorkQueue.access$000(WorkQueue.this, paramWorkNode);
                throw localThrowable;
              }
            }
          });
          return;
        }
      }
      catch (Throwable paramWorkNode)
      {
        throw paramWorkNode;
      }
      return;
      label131:
      paramWorkNode = null;
    }
  }
  
  private void startItem()
  {
    finishItemAndStartNew(null);
  }
  
  public WorkItem addActiveWorkItem(Runnable paramRunnable)
  {
    return addActiveWorkItem(paramRunnable, true);
  }
  
  public WorkItem addActiveWorkItem(Runnable paramRunnable, boolean paramBoolean)
  {
    WorkNode localWorkNode = new WorkNode(paramRunnable);
    paramRunnable = workLock;
    try
    {
      pendingJobs = localWorkNode.addToList(pendingJobs, paramBoolean);
      finishItemAndStartNew(null);
      return localWorkNode;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void validate()
  {
    Object localObject2 = workLock;
    try
    {
      if (runningJobs != null)
      {
        Object localObject1 = runningJobs;
        WorkNode localWorkNode;
        do
        {
          ((WorkNode)localObject1).verify(true);
          localWorkNode = ((WorkNode)localObject1).getNext();
          localObject1 = localWorkNode;
        } while (localWorkNode != runningJobs);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static abstract interface WorkItem
  {
    public abstract boolean cancel();
    
    public abstract boolean isRunning();
    
    public abstract void moveToFront();
  }
  
  private class WorkNode
    implements WorkQueue.WorkItem
  {
    public final Runnable callback;
    public boolean isRunning;
    public WorkNode next;
    public WorkNode prev;
    
    public WorkNode(Runnable paramRunnable)
    {
      callback = paramRunnable;
    }
    
    public WorkNode addToList(WorkNode paramWorkNode, boolean paramBoolean)
    {
      if (paramWorkNode == null)
      {
        prev = this;
        next = this;
        paramWorkNode = this;
      }
      else
      {
        next = paramWorkNode;
        prev = prev;
        WorkNode localWorkNode = next;
        prev.next = this;
        prev = this;
      }
      if (paramBoolean) {
        return this;
      }
      return paramWorkNode;
    }
    
    public boolean cancel()
    {
      Object localObject = workLock;
      try
      {
        if (!isRunning())
        {
          pendingJobs = removeFromList(pendingJobs);
          return true;
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public Runnable getCallback()
    {
      return callback;
    }
    
    public WorkNode getNext()
    {
      return next;
    }
    
    public boolean isRunning()
    {
      return isRunning;
    }
    
    public void moveToFront()
    {
      Object localObject = workLock;
      try
      {
        if (!isRunning())
        {
          pendingJobs = removeFromList(pendingJobs);
          pendingJobs = addToList(pendingJobs, true);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public WorkNode removeFromList(WorkNode paramWorkNode)
    {
      WorkNode localWorkNode = paramWorkNode;
      if (paramWorkNode == this)
      {
        paramWorkNode = next;
        localWorkNode = paramWorkNode;
        if (paramWorkNode == this) {
          localWorkNode = null;
        }
      }
      paramWorkNode = next;
      prev = prev;
      prev.next = paramWorkNode;
      prev = null;
      next = null;
      return localWorkNode;
    }
    
    public void setIsRunning(boolean paramBoolean)
    {
      isRunning = paramBoolean;
    }
    
    public void verify(boolean paramBoolean) {}
  }
}
