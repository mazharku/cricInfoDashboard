package com.mazhar.dashboard.services;

import com.mazhar.dashboard.model.CricInfoDataModel;
import com.mazhar.dashboard.model.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
@RequiredArgsConstructor
public class DataFetchService {
    private final String url = "http://static.cricinfo.com/rss/livescores.xml";
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void fetchData() {
        try {
            ResponseEntity<String> models = restTemplate.getForEntity(url, String.class);
            String xmlString = models.getBody();
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xmlString);
            Root dataModel = (Root) unmarshaller.unmarshal(reader);
            dataModel.getChannel();
        } catch (RestClientException | JAXBException e) {
            e.printStackTrace();
        }
    }


}
