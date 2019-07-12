package f.l.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import f.l.a.b.a.QueueProcessingType;
import f.l.a.b.a.e;
import f.l.a.b.b.b;
import java.util.concurrent.Executor;

public final class i
{
  public final f.l.a.a.b.c a;
  public final ClassWriter b;
  public final f.l.a.b.d.c c;
  public final boolean customExecutor;
  public final boolean customExecutorForCachedImages;
  public final f.l.a.b.d.c d;
  public final b e;
  public final f.l.a.b.d.c f;
  public final Resources j;
  public final int k;
  public final int maxImageHeightForDiskCache;
  public final int maxImageHeightForMemoryCache;
  public final int maxImageWidthForDiskCache;
  public final f.l.a.b.g.a processorForDiskCache;
  public final f.l.a.a.a.a q;
  public final Executor taskExecutor;
  public final Executor taskExecutorForCachedImages;
  public final QueueProcessingType tasksProcessingType;
  public final int threadPoolSize;
  public final int threadPriority;
  
  public i(ImageLoaderConfiguration.Builder paramBuilder)
  {
    j = ImageLoaderConfiguration.Builder.access$getContext(paramBuilder).getResources();
    k = ImageLoaderConfiguration.Builder.access$getMaxImageHeightForDiscCache(paramBuilder);
    maxImageHeightForMemoryCache = ImageLoaderConfiguration.Builder.access$getImageQualityForDiscCache(paramBuilder);
    maxImageWidthForDiskCache = ImageLoaderConfiguration.Builder.access$getMaxImageWidthForDiskCache(paramBuilder);
    maxImageHeightForDiskCache = ImageLoaderConfiguration.Builder.access$getMaxImageHeightForDiskCache(paramBuilder);
    processorForDiskCache = ImageLoaderConfiguration.Builder.access$getProcessorForDiskCache(paramBuilder);
    taskExecutor = ImageLoaderConfiguration.Builder.access$getTaskExecutorForCachedImages(paramBuilder);
    taskExecutorForCachedImages = ImageLoaderConfiguration.Builder.access$getTaskExecutor(paramBuilder);
    threadPoolSize = ImageLoaderConfiguration.Builder.access$getThreadPoolSize(paramBuilder);
    threadPriority = ImageLoaderConfiguration.Builder.access$getThreadPriority(paramBuilder);
    tasksProcessingType = ImageLoaderConfiguration.Builder.access$getTasksProcessingType(paramBuilder);
    q = ImageLoaderConfiguration.Builder.access$getDiskCache(paramBuilder);
    a = ImageLoaderConfiguration.Builder.access$getMemoryCache(paramBuilder);
    b = ImageLoaderConfiguration.Builder.access$getDiscCache(paramBuilder);
    d = ImageLoaderConfiguration.Builder.access$getDownloader(paramBuilder);
    e = ImageLoaderConfiguration.Builder.access$getDefaultDisplayImageOptions(paramBuilder);
    customExecutor = ImageLoaderConfiguration.Builder.access$getCustomExecutor(paramBuilder);
    customExecutorForCachedImages = ImageLoaderConfiguration.Builder.access$getCustomExecutorForCachedImages(paramBuilder);
    f = new h.b(d);
    c = new h.c(d);
    f.l.a.c.L.c = ImageLoaderConfiguration.Builder.access$getWriteLogs(paramBuilder);
  }
  
  public static i build(Context paramContext)
  {
    return new ImageLoaderConfiguration.Builder(paramContext).build();
  }
  
  public e a()
  {
    DisplayMetrics localDisplayMetrics = j.getDisplayMetrics();
    int m = k;
    int i = m;
    if (m <= 0) {
      i = widthPixels;
    }
    int n = maxImageHeightForMemoryCache;
    m = n;
    if (n <= 0) {
      m = heightPixels;
    }
    return new e(i, m);
  }
}
