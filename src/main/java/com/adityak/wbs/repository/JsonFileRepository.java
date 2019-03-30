package com.adityak.wbs.repository;

import com.adityak.wbs.model.Holder;
import com.adityak.wbs.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class JsonFileRepository {




    public void save(List<Task> tasks){

        ObjectMapper mapper = new ObjectMapper();

        try{
            Holder holder = new Holder();
            holder.setTasks(tasks);
            final String json = mapper.writeValueAsString(holder);
            IOUtils.write(json,new FileOutputStream("tasks.json"), Charset.forName("UTF-8"));
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



    public List<Task> retrieve(){

        try {
            String taskGson = IOUtils.toString(new FileInputStream("tasks.json"), Charset.forName("UTF-8"));
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(taskGson, Holder.class).getTasks();

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return new ArrayList<Task>();
    }



}
