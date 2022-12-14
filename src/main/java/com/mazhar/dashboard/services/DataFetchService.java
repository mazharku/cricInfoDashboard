package com.mazhar.dashboard.services;

import com.mazhar.dashboard.model.CricInfoDataModel;
import com.mazhar.dashboard.model.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class DataFetchService {
    private static final String url = "http://static.cricinfo.com/rss/livescores.xml";
    private final RestTemplate restTemplate;

    public CricInfoDataModel fetchData() {
        try {
            ResponseEntity<String> models = restTemplate.getForEntity(url, String.class);
            String xmlString = models.getBody();
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            assert xmlString != null;
            StringReader reader = new StringReader(xmlString);
            Root dataModel = (Root) unmarshaller.unmarshal(reader);
            return dataModel.getChannel();
        } catch (RestClientException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Scheduled(cron = "0 */5 * * * *" ,zone="GMT+6")
    public void startTaskSchedule() {

    }

}
