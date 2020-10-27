package io.github.kimmking.netty.server;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/10/27 15:20
 */
public class HttpClient {

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Request request = new Request.Builder().url("http://localhost:8808/test").build();
            Response response = okHttpClient.newCall(request).execute();
            String responseStr = response.body().string();
            if (!response.isSuccessful()) {
                System.out.println("get请求失败");
            }
            System.out.println("服务器返回：" + responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
