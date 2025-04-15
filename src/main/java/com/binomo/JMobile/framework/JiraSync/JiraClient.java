package com.example.JMobile.framework.JiraSync;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Comment;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.input.FieldInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import java.net.URI;

public class JiraClient {
    private String username = Config.getProperty("jira.user");
    private String password =  System.getProperty("jiraPassword", "");;
    private String jiraUrl = Config.getProperty("jira.baseUrl");
    private JiraRestClient restClient = getJiraRestClient();


    private JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
    }
    private URI getJiraUri() {
        return URI.create(this.jiraUrl);
    }

    public void addComment(String issueKey, String commentBody) {
        Issue issue = getIssue(issueKey);
        restClient.getIssueClient()
                .addComment(issue.getCommentsUri(), Comment.valueOf(commentBody));
    }

    private void setField(String issueKey, String reportLink, String fieldId)
    {
        Issue issue = getIssue(issueKey);
        FieldInput fieldInput = new FieldInput(fieldId, reportLink);
        IssueInputBuilder issueBuilder = new IssueInputBuilder(issue.getProject().getKey(), issue.getIssueType().getId());
        IssueInput issueInput= issueBuilder.setFieldInput(fieldInput).build();
        restClient.getIssueClient().updateIssue(issue.getKey(),issueInput);

    }

    public void setAllureLink(String issueKey, String reportLink)
    {
        setField(issueKey,reportLink, "customfield_11501");
    }

    public void setTRLink(String issueKey, String reportLink)
    {
        setField(issueKey,reportLink, "customfield_11500");

    }

    private Issue getIssue(String issueKey) {
        return restClient.getIssueClient()
                .getIssue(issueKey)
                .claim();
    }

}
