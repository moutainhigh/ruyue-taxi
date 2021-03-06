import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * 监管平台例子1
 * 获取数据
 */
public class Test_http_binFile_01 {
	
	private static char[] commonDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	public static void main(String[] args) throws ClientProtocolException, IOException
	{
		HttpPost post = new HttpPost("http://wycapi.gzjt.gov.cn/api/app/common/binapi");

		String companyId="RY";
		String key="SLj16Qq7FK9nbyi4";
		String result = "{\"items\":[{\"companyId\":\""+companyId+"\",\"vehicleNum\":1,\"driverNum\":0.00,\"symbol\":\"123123123\","
				+ "\"flag\":1,\"updateTime\":\"2018-12-23 17:30:00\"},"
				+ "{\"companyId\":\""+companyId+"\",\"vehicleNum\":1.12,\"driverNum\":1.00,"
				+ "\"flag\":1,\"updateTime\":\"2018-12-23 17:30:00\"},"
				+ "{\"companyId\":\""+companyId+"\",\"vehicleNum\":100,\"driverNum\":100,"
				+ "\"flag\":1,\"updateTime\":\"2018-12-23 17:30:00\"},"
				+ "{\"companyId\":\""+companyId+"\",\"vehicleNum\":12.12,\"driverNum\":12.23,"
				+ "\"flag\":\"1\",\"updateTime\":\"2018-12-23 17:30:00\"},"
				+ "{\"companyId\":\""+companyId+"\",\"vehicleNum\":9.1,\"driverNum\":1.0,"
				+ "\"flag\":\"1\",\"updateTime\":\"2018-12-23 17:30:00\"}"
				+ "]}";

		InputStream in = new ByteArrayInputStream(result.getBytes("UTF-8"));
		String md5 = hash(in);
		in.reset();
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		post.addHeader("binfile-md5", md5);
		post.addHeader("binfile-auth", companyId);//token
		post.addHeader("binfile-auth", companyId);//平台标识
		post.addHeader("binfile-gzip", "false");
		post.addHeader("binfile-reqlen", String.valueOf(in.available()));//请求长度
		String filename = companyId+"_BASIC_PTYYGM_REQ_20170116163722348.json";
		builder.addBinaryBody("binFile", in, ContentType.DEFAULT_BINARY, filename);// 文件
		builder.addTextBody("filename", filename, ContentType.create(ContentType.DEFAULT_TEXT.getMimeType(), "UTF-8"));
		post.setEntity(builder.build());
		
		int connTimeout = 10000;
		int soTimeout = -1;
		
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		RequestConfig.Builder configBuilder = RequestConfig.custom();
		if (connTimeout > 0) configBuilder.build();
		if (soTimeout > 0) configBuilder.setSocketTimeout(soTimeout);
		clientBuilder.setDefaultRequestConfig(configBuilder.build());
		// 4.3以后会自动在interceptor中实现启用压缩和自动解压，所以不需要gzip的时候需要指定一下---binfile-gzip true/false
		if (!false) clientBuilder.disableContentCompression();
//		clientBuilder.setProxy(proxy);----放开抓包
		CloseableHttpClient client = clientBuilder.build();
		HttpResponse response = client.execute(post);
		System.out.println(response.toString());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println("内容："+EntityUtils.toString(response.getEntity()));
	}
	
	public static String hash(InputStream in)
	{
		try
		{
			byte[] buffer = new byte[1024];
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			int numRead = 0;
			while ((numRead = in.read(buffer)) > 0)
			{
				md5.update(buffer, 0, numRead);
			}
			in.close();
			return toHexString(md5.digest());
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	private static String toHexString(byte[] b)
	{
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++)
		{
			sb.append(commonDigit[(b[i] & 0xf0) >>> 4]);
			sb.append(commonDigit[b[i] & 0x0f]);
		}
		return sb.toString();
	}
}
