package aiss.githubminer.service;

                                                import aiss.githubminer.Utils;
                                                import aiss.githubminer.model.Comment;
                                                import aiss.githubminer.model.Issue;
                                                import aiss.githubminer.model.issueParser.IssueParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {
    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentService commentService;

    @Autowired
    Utils utils;

    public Issue getIssueFromUrl(String uri){
        ResponseEntity<IssueParser> response = utils.requestWithToken(uri, IssueParser.class);
        IssueParser issue = response.getBody();
        List<Comment> comments = commentService.getCommentsFromUrl(issue.getCommentsUrl()); // CommentsUrl nunca será null aunque el numero de comentaqrios sea 0
        return Issue.of(issue,comments);
    }

    public List<Issue> getIssueListFromUrl(String uri) {
        ResponseEntity<IssueParser[]> response = utils.requestWithToken(uri, IssueParser[].class);
        IssueParser[] issues = response.getBody();
        List<Issue> issuesModel = new ArrayList<>();
        for (IssueParser issue: issues){
            List<Comment> comments = commentService.getCommentsFromUrl(issue.getCommentsUrl()); // CommentsUrl nunca será null aunque el numero de comentaqrios sea 0
            Issue issueToAdd = Issue.of(issue, comments);
            issuesModel.add(issueToAdd);
        }
        return issuesModel;
    }

}
