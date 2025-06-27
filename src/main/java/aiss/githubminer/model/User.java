package aiss.githubminer.model;

import aiss.githubminer.model.userParser.UserParser;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    public String id;
    public String username;
    public String name;
    public String avatar_url;
    public String web_url;
    public String htmlUrl;
    public Integer followers;

    public User(String id, String username, String name, String avatar_url, String web_url, String htmlUrl, Integer followers) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar_url = avatar_url;
        this.web_url = web_url;
        this.htmlUrl = htmlUrl;
        this.followers = followers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("followers")
    public Integer getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public static User of(UserParser userData){
        return new User(
                userData.getId().toString(),
                userData.getLogin(),
                userData.getName(),
                userData.getAvatarUrl(),
                userData.getUrl(),
                userData.getHtmlUrl(),
                userData.getFollowers()
        );
    }
}
