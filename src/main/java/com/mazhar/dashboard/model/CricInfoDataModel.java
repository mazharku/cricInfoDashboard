package com.mazhar.dashboard.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "channel")
public class CricInfoDataModel {
    @XmlElement
    private String title;
    @XmlElement
    private String ttl;
    @XmlElement
    private String link;
    @XmlElement
    private String description;
    @XmlElement
    private String copyright;
    @XmlElement
    private String language;
    @XmlElement
    private String pubDate;
    @XmlElement
    private List<InfoItem> items;

}
