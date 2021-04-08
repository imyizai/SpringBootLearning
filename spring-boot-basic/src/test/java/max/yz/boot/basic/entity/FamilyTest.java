package max.yz.boot.basic.entity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author imyizai
 * @ClassName FamilyTest
 * @Description
 * @Date 2021/3/16 2:19 下午
 **/

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class FamilyTest {
    @Resource
    private  Family family;
    @Test
    void getFamilyName(){
        log.info("family:"+ family );
    }

}