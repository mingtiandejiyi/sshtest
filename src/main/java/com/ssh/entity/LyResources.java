package com.ssh.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ly_resources")
public class LyResources implements java.io.Serializable {

    // Fields

    private Integer id;
    private String name;
    private Integer parentId;
    private String resKey;
    private String type;
    private String resUrl;
    private Integer level;
    private String icon;
    private Integer ishide = 0;
    private String description;
    private Integer buttonId = 0;
    // Constructors

    /** default constructor */
    public LyResources() {
    }

    /** full constructor */
    public LyResources(String name, Integer parentId, String resKey,
                       String type, String resUrl, Integer level, String icon,
                       Integer ishide, String description,Integer buttonId) {
        this.name = name;
        this.parentId = parentId;
        this.resKey = resKey;
        this.type = type;
        this.resUrl = resUrl;
        this.level = level;
        this.icon = icon;
        this.ishide = ishide;
        this.description = description;
        this.buttonId = buttonId;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "parentId")
    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Column(name = "resKey", length = 50)
    public String getResKey() {
        return this.resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    @Column(name = "type", length = 40)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "resUrl", length = 200)
    public String getResUrl() {
        return this.resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    @Column(name = "level")
    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "icon", length = 100)
    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Column(name = "ishide", columnDefinition = "int(3) DEFAULT 0")
    public Integer getIshide() {
        return this.ishide;
    }

    public void setIshide(Integer ishide) {
        this.ishide = ishide;
    }

    @Column(name = "description", length = 200)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "buttonId", columnDefinition = "int(11) DEFAULT 0")
    public Integer getButtonId() {
        return this.buttonId;
    }

    public void setButtonId(Integer buttonId) {
        this.buttonId = buttonId;
    }


}
