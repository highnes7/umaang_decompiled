package com.coremedia.iso.boxes;

import f.h.a.b;
import f.h.a.e;
import java.util.Iterator;
import java.util.List;

public class SampleTableBox
  extends b
{
  public static final String TYPE = "stbl";
  public SampleToChunkBox sampleToChunkBox;
  
  public SampleTableBox()
  {
    super("stbl");
  }
  
  public ChunkOffsetBox getChunkOffsetBox()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof ChunkOffsetBox));
    return (ChunkOffsetBox)localBox;
  }
  
  public CompositionTimeToSample getCompositionTimeToSample()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof CompositionTimeToSample));
    return (CompositionTimeToSample)localBox;
  }
  
  public SampleDependencyTypeBox getSampleDependencyTypeBox()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof SampleDependencyTypeBox));
    return (SampleDependencyTypeBox)localBox;
  }
  
  public SampleDescriptionBox getSampleDescriptionBox()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof SampleDescriptionBox));
    return (SampleDescriptionBox)localBox;
  }
  
  public SampleSizeBox getSampleSizeBox()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof SampleSizeBox));
    return (SampleSizeBox)localBox;
  }
  
  public SampleToChunkBox getSampleToChunkBox()
  {
    Object localObject = sampleToChunkBox;
    if (localObject != null) {
      return localObject;
    }
    localObject = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        return null;
      }
      localBox = (Box)((Iterator)localObject).next();
    } while (!(localBox instanceof SampleToChunkBox));
    sampleToChunkBox = ((SampleToChunkBox)localBox);
    return sampleToChunkBox;
  }
  
  public SyncSampleBox getSyncSampleBox()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof SyncSampleBox));
    return (SyncSampleBox)localBox;
  }
  
  public TimeToSampleBox getTimeToSampleBox()
  {
    Iterator localIterator = getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof TimeToSampleBox));
    return (TimeToSampleBox)localBox;
  }
}
