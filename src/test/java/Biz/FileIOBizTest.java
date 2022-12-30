package Biz;

import com.orikey.tutor.client.FileIOClient;
import com.orikey.tutor.req.FileRequest;
import com.orikey.tutor.res.FileResponse;
import com.orikey.tutor.biz.FileIOBiz;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @Author:TieJiang
 * @Date: 2021/1/19 8:44 下午
 * 人一能之，己十之，人十能之，己百之，果能此道矣，虽愚必明，虽柔必强。
 */
@RunWith(MockitoJUnitRunner.class)
public class FileIOBizTest {

    @InjectMocks
    FileIOBiz fileIOBiz;

    @Mock
    FileIOClient fileIOClient;

    @Test
    public void getFile() {
//        Mock阶段
//        构造参数
        FileRequest request = new FileRequest();
        request.setName("Title");
//        Mock Client
        when(fileIOClient.fileRead(any())).thenReturn(5);
        when(fileIOClient.fileWrite(any())).thenReturn(5);

//        Mock结果，进行校验
        FileResponse response = fileIOBiz.getFile(request);

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getValue(),"5 5");

    }
}