package dev.julien.juge.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.List;

@Document(collection = "applications")
public class ApplicationDto {

    @Id
    private String id;

    @Field("application_id")
    private String applicationId;

    @Field("application_name")
    private String applicationName;

    @Field("url")
    private String applicationUrl;

    @Field("granted_users")
    private List<String> applicationGrantedUsers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public List<String> getApplicationGrantedUsers() {
        return applicationGrantedUsers;
    }

    public void setApplicationGrantedUsers(List<String> applicationGrantedUsers) {
        applicationGrantedUsers = applicationGrantedUsers;
    }

    @Override
    public String toString() {
        StringBuilder grantedUsers = new StringBuilder();
        grantedUsers.append("[");
        if (null != applicationGrantedUsers) {
            applicationGrantedUsers.forEach(grantedUsers::append);
        }
        grantedUsers.append("]");
        return "{\"_class\":\"application\", " +
                "\"id\":" + (id == null ? "null" : "\"" + id + "\"") + ", " +
                "\"application_id\":" + (applicationId == null ? "null" : "\"" + applicationId + "\"") + ", " +
                "\"application_name\":" + (applicationName == null ? "null" : "\"" + applicationName + "\"") + ", " +
                "\"url\":" + (applicationUrl == null ? "null" : "\"" + applicationUrl + "\"") + ", " +
                "\"granted_users\":" + grantedUsers +
                "}";
    }
}
