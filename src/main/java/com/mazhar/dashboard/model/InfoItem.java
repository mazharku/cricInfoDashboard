package com.mazhar.dashboard.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "item")
public class InfoItem {
    @XmlElement
    private String title;
    @XmlElement
    private String link;
    @XmlElement
    private String description;
    @XmlElement
    private String guid;
}
