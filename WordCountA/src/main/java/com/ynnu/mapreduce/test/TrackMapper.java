package com.ynnu.mapreduce.test;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class TrackMapper extends Mapper<LongWritable, Text, Text,Text>{
    Text k = new Text();
    Text v = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws
            IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割
        String[] words = line.split("\t");
        // 3 输出
        k.set(words[0]);
        String tempString = new String();
        for(int i=1;i<words.length;i++){
            tempString+=words[i];
            tempString+=" ";
        }

        v.set(tempString);
        context.write(k, v);
    }
}