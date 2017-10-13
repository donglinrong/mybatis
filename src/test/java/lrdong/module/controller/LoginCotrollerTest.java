package lrdong.module.controller;

import lrdong.Application;
import lrdong.common.util.HttpClientUtil;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class LoginCotrollerTest {



    @Autowired
   private RestTemplate restTemplate;

    String url ="http://localhost:8080/mybatis/admininfo/login";



    @Test
    public void testLogin()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName","lrdong");
        map.put("userPassword","william");
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        restTemplate.postForEntity(url,map,Map.class);
    }

}
