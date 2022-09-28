package com.mazhar.dashboard.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class CricInfoDataModel {
    @XmlElement
    private String title;
    @XmlElement
    private Integer ttl;
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
    @XmlElement(name = "item")
    private List<InfoItem> items;

}
