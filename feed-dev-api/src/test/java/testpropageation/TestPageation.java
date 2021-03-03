package testpropageation;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/2 11:07
 * @Modified By：
 * 测试事务
 */

import com.foodieshop.FoodieShopRunner;
import com.foodieshop.service.StuService;
import com.foodieshop.service.impl.ITestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FoodieShopRunner.class)
public class TestPageation {

    @Autowired
    private StuService stuService;

    @Autowired
    private ITestTransService testTransService;

    @Test
    public void Test() {
//        testTransService.saveParent();
    }


}
