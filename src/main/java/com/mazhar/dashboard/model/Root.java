package com.mazhar.dashboard.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
    @XmlElement(name = "channel")
    private CricInfoDataModel channel;
    @XmlElement
    private Integer version;
}
