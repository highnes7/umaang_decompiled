package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox.Entry;
import f.h.a.b;
import f.h.a.e;
import f.h.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieFragmentBox
  extends b
{
  public static final String TYPE = "moof";
  
  public MovieFragmentBox()
  {
    super("moof");
  }
  
  public f getFileChannel()
  {
    return dataSource;
  }
  
  public List getSyncSamples(SampleDependencyTypeBox paramSampleDependencyTypeBox)
  {
    ArrayList localArrayList = new ArrayList();
    paramSampleDependencyTypeBox = paramSampleDependencyTypeBox.getEntries().iterator();
    for (long l = 1L;; l += 1L)
    {
      if (!paramSampleDependencyTypeBox.hasNext()) {
        return localArrayList;
      }
      if (((SampleDependencyTypeBox.Entry)paramSampleDependencyTypeBox.next()).getSampleDependsOn() == 2) {
        localArrayList.add(Long.valueOf(l));
      }
    }
  }
  
  public int getTrackCount()
  {
    return ((e)this).getBoxes(TrackFragmentBox.class, false).size();
  }
  
  public List getTrackFragmentHeaderBoxes()
  {
    return ((e)this).getBoxes(TrackFragmentHeaderBox.class, true);
  }
  
  public long[] getTrackNumbers()
  {
    int i = 0;
    List localList = ((e)this).getBoxes(TrackFragmentBox.class, false);
    long[] arrayOfLong = new long[localList.size()];
    for (;;)
    {
      if (i >= localList.size()) {
        return arrayOfLong;
      }
      arrayOfLong[i] = ((TrackFragmentBox)localList.get(i)).getTrackFragmentHeaderBox().getTrackId();
      i += 1;
    }
  }
  
  public List getTrackRunBoxes()
  {
    return ((e)this).getBoxes(TrackRunBox.class, true);
  }
}
