package sample;

import com.google.gson.Gson;
import domain.product.Product;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

public class SimpleRestClient {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SimpleRestClient.class);
    private final String url = "http://localhost:8091/product/";
    private final Gson gson = new Gson();

    SimpleRestClient(){
    }

    Product getProduct(String key){
        final String query = url + key;
        log.info("Get: " + query);

        HttpGet httpGetQuery = new HttpGet(query);

        return executeProductQuery(httpGetQuery);
    }

    Product postProduct(Product product){
        final String query = url + "add";
        log.info("POST: " + query);

        HttpPost httpPostQuery = new HttpPost(query);
        httpPostQuery.addHeader("content-type", "application/json");

        StringEntity params;

        try{
            params = new StringEntity(gson.toJson(product));
            httpPostQuery.setEntity(params);
        } catch(Exception e){
            log.error(e.toString());
        }

        return executeProductQuery(httpPostQuery);
    }


    private Product executeProductQuery(HttpRequestBase requestBaseQuery) {
        Product product = null;

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(requestBaseQuery)) {
            log.info("Status: " + response.getStatusLine());

            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            log.info("JSON entity: " + entityString);

            product = gson.fromJson(entityString, Product.class);

        } catch (Exception e) {
            log.error(e.toString());
        }

        return product;
    }


}
