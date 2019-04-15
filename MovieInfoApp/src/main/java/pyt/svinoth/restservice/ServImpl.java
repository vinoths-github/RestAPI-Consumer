package pyt.svinoth.restservice;

/*import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;*/
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpMethod;
//import org.codehaus.jackson.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.svinoth.model.Movies;

public class ServImpl {
	private RestTemplate restTemplate;
	
	public List<String> getTitle(String Url, String substr){
		List<String> titles = new ArrayList<>();
		int i=1;
		Movies movies;
		do {
			
			movies = restTemplate.getForObject(Url + i, Movies.class, substr);
			
			i = movies.getPage()+1;
			titles.addAll(movies.getData().stream().map(e -> e.getTitle()).collect(Collectors.toList()));
			
			/*ResponseEntity<String> response = restTemplate.getForEntity(Url, String.class);
		    assertThat(response.getBody()).containsIgnoringCase("hello, pwebb");
		    System.out.println("received: " + response.getBody());

			ResponseEntity<String> responseEntity = restTemplate.getForEntity(Url + i, String.class);
			responseEntity.getBody();*/
			
		}while (i <= movies.getTotal_pages());
		return titles.stream().sorted().collect(Collectors.toList());
	}
}
