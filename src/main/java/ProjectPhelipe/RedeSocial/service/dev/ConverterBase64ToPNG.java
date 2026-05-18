package ProjectPhelipe.RedeSocial.service.dev;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class ConverterBase64ToPNG {

    @Value("${API_KEY}")
    private String API_KEY;
    @Value("${PRESET_KEY}")
    private String PRESET_KEY;

    private ObjectMapper objectMapper;

    public ConverterBase64ToPNG(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String converterToPNG(String base64) throws IOException, InterruptedException {
        String body = "file=data:image/png;base64," + URLEncoder.encode(base64, StandardCharsets.UTF_8) + "&upload_preset=" + PRESET_KEY;

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(API_KEY)).
                header("Content-Type","application/x-www-form-urlencoded").
                POST(HttpRequest.BodyPublishers.ofString(body)).
                build();


        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        RecordPegarUrlAPI record = objectMapper.readValue(response.body(), RecordPegarUrlAPI.class);

        System.out.println(record.secure_url());
        return record.secure_url();
    }
}
