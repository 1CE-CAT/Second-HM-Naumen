//task 4
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class task4 {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/user-agent"))
            .GET()
            .header("Accept", "application/json")
            .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        String value = json
            .replaceAll(".*\"user-agent\"\\s*:\\s*\"([^\"]+)\".*", "$1");
            
        System.out.println(value);

    }
}
