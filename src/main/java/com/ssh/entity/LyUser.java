package com.ssh.entity; 
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ly_user")
public class LyUser implements java.io.Serializable {

    // Fields

    private Long id;
    private String userName;
    private String accountName;
    private String password;
    private String credentialsSalt;
    private String description;
    private String locked;
    private Date createTime = new Date();
    private Integer deletestatus;

    // Constructors

    /** default constructor */
    public LyUser() {
    }

    /** full constructor */
    public LyUser(String userName, String accountName, String password,
                  String credentialsSalt, String description, String locked,
                  Date createTime, Integer deletestatus,Integer orgId,boolean isMaster) {
        this.userName = userName;
        this.accountName = accountName;
        this.password = password;
        this.credentialsSalt = credentialsSalt;
        this.description = description;
        this.locked = locked;
        this.createTime = createTime;
        this.deletestatus = deletestatus;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "userName", length = 20)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "accountName", length = 20)
    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "password", length = 100)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "credentialsSalt", length = 100)
    public String getCredentialsSalt() {
        return this.credentialsSalt;
    }

    public void setCredentialsSalt(String credentialsSalt) {
        this.credentialsSalt = credentialsSalt;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "locked", length = 3, columnDefinition = "varchar(3) DEFAULT '0'")
    public String getLocked() {
        return this.locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    @Column(name = "createTime", length = 0)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "deletestatus", columnDefinition = "int(1) DEFAULT '0' COMMENT '逻辑删除状态0:存在1:删除'")
    public Integer getDeletestatus() {
        return this.deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

}