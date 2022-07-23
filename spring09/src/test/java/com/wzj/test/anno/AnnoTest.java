package com.wzj.test.anno;

import com.wzj.anno.Targetinterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextanno.xml")
public class AnnoTest {
    @Autowired
    private Targetinterface target;
    @Test
    public void text1(){
        target.save();
    }
}
