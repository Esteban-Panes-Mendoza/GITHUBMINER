package aiss.githubminer.model;

import aiss.githubminer.model.commentParser.CommentParser;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {
    public String id;
    public String body;
    public String created_at;
    public String updated_at;
    public String htmlUrl;
    public String issueUrl;
    public User author;

    public Comment(String id, String body, String created_at, String updated_at, String htmlUrl, String issueUrl ,User author) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.htmlUrl = htmlUrl;
        this.issueUrl = issueUrl;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }


    public String getIssueUrl() {
        return issueUrl;
    }


    public void setIssueUrl(String issueUrl) {
        this.issueUrl = issueUrl;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public static Comment of(CommentParser commentData) {
        String id = commentData.getId().toString();
        String body = commentData.getBody();
        String created_at = commentData.getCreatedAt();
        String updated_at = commentData.getUpdatedAt();
        String html_url = commentData.getHtmlUrl();
        String issue_url = commentData.getIssueUrl();
        User author = commentData.getUserModel();
        return new Comment(
                id,
                body,
                created_at,
                updated_at,
                html_url,
                issue_url,
                author
        );
    }
}
