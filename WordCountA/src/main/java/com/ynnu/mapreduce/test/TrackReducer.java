package com.ynnu.mapreduce.test;
import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TrackReducer extends Reducer<Text, Text, Text, Text>{
    Text v = new Text();
    @Override
    protected void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
        // 1 累积
        List<String> list = new ArrayList();
        for(Text value:values){
            list.add(value.toString());
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String result = new String();
        for(int i=0;i<list.size();i++){
            result+=list.get(i);
            result+="\n";
        }
        v.set(result);
        // 2 输出
        context.write(key,v);
    }
}