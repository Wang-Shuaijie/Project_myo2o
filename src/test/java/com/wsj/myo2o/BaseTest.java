package com.wsj.myo2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 初始化spring
 * 配置spring和junit整合，junit启动时加载springioc
 * @author WangShuaiJie
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}
