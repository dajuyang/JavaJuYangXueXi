package ZuoYe.Two.ZuoYe6;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author JuYang
 * @date 2021年07月03日18:14
 */
public class HttpClient {
    public static void main(String[] args) throws IOException {
        //打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //get请求
        HttpGet httpGet = new HttpGet("http://localhost:8801");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try{
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                System.out.println("Response长度"+entity.getContentLength());
                System.out.println("ResponseContext内容：  "+EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            httpClient.close();
            response.close();
        }
    }

}
