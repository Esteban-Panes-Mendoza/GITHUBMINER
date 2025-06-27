package aiss.githubminer.model;

import aiss.githubminer.model.commitParser.CommitParser;

public class Commit {
    public String id;
    public String title;
    public String message;
    public String author_name;
    public String author_email;
    public String authored_date;
    public String web_url;
    public String htmlUrl;
    public String commentsUrl;

    public Commit(String id, String title, String message, String author_name, String author_email, String authored_date, String web_url, String htmlUrl, String commentsUrl) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author_name = author_name;
        this.author_email = author_email;
        this.authored_date = authored_date;
        this.web_url = web_url;
        this.htmlUrl = htmlUrl;
        this.commentsUrl = commentsUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public String getAuthored_date() {
        return authored_date;
    }

    public void setAuthored_date(String authored_date) {
        this.authored_date = authored_date;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getHtml_url() { return htmlUrl;}

    public void setHtml_url(String html_url) {
        this.htmlUrl = html_url;
    }

    public   String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public static Commit of(CommitParser commitData){
    return new Commit(
            commitData.getModelId(),
            null, //No he visto ninguna propiedad que se pueda interpretar como el title, tambien se podria interpretar como titulo y dejar message como null
            commitData.getModelMessage(),
            commitData.getModelAuthorName(),
            commitData.getModelAuthorEmail(),
            commitData.getModelAuthoredDate(),
            commitData.getModelUrl(),
            commitData.getModelHtmlUrl(),
            commitData.getModelCommentsUrl()
    );
    }

}
