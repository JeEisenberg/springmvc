package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gavin.pojo.User;

public class TestJson {

    public static void main(String[] args) throws JsonProcessingException {
User user= new User(888,"扎根三","123455","url");
        ObjectMapper objectMapper= new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(user));
    }

}
