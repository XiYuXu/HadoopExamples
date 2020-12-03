package org.myorg;

import org.junit.Test;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class TestJava {
    @Test
    public void TestThis(){
        String line = "12345\t23456\t21345\t12333";
        String[] words = line.split("\t");
        ArrayList<String> list = new ArrayList();
        for(int i=0;i<words.length;i++){
            list.add(words[i]);
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
