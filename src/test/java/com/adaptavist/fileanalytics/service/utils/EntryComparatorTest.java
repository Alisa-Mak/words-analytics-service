package com.adaptavist.fileanalytics.service.utils;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryComparatorTest {

    EntityComparator comparator = new EntityComparator();

    @Test
    public void compareNoneEqualsByIntDSC() {
        Map.Entry<String,Integer> entry1 =
                new AbstractMap.SimpleEntry<>("java", 4);
        Map.Entry<String,Integer> entry2 =
                new AbstractMap.SimpleEntry<>("python", 8);

        int result = comparator.compare(entry1,entry2);
        assertEquals(Integer.compare(8,4),result);
    }

    @Test
    public void compareEqualsByValueASC() {
        Map.Entry<String,Integer> entry1 =
                new AbstractMap.SimpleEntry<>("xyz", 4);
        Map.Entry<String,Integer> entry2 =
                new AbstractMap.SimpleEntry<>("abc", 4);

        int result = comparator.compare(entry1,entry2);
        assertEquals("xyz".compareTo("abc"),result);
    }
}
