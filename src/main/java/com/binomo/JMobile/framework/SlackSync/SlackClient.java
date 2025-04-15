package com.example.JMobile.framework.SlackSync;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.users.UsersLookupByEmailRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.methods.response.users.UsersLookupByEmailResponse;
import com.slack.api.model.Attachment;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class SlackClient {

    private static Slack slack = Slack.getInstance();
    private static String token = System.getProperty("slack_token", "");
    private static MethodsClient methods = slack.methods(token);

    private static void sendMessage(SlackMessage message, String recipient) {
        boolean success = false;

        int retries = 0;
        while (!success && retries < 3) {
            try {
                ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                        .token(token)
                        .channel(recipient)
                        .text(message.toString())
                        .attachments(generateSlackAttachmentFromAnExistMessage(message))
                        .build();
                ChatPostMessageResponse response = methods.chatPostMessage(request);
                success = response.isOk();
            } catch (Exception e) {
                logger.info("Something went wrong in SlackClient.sendMessageToChannel() with error message: " + e.getMessage());
                e.printStackTrace();
            } finally {
                retries++;
                if (!success) {
                    try {
                        Thread.sleep(1000);
                        logger.info("Retry attempt #" + retries + " to send message to Slack");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void sendMessageToChannel(SlackMessage message, String slackChannel) {
        sendMessage(message, slackChannel);
    }

    public static void sendMessageToUser(SlackMessage message) {
        if (!message.getUser().isEmpty() && message.getUser() != null) {
            String userId = getUserId(message.getUser());
            sendMessage(message, userId);
        }
    }

    private static String getUserId(String userEmail) {
        String userId = "";
        try {

            UsersLookupByEmailResponse
                    response = methods.usersLookupByEmail
                    (UsersLookupByEmailRequest.builder()
                            .token(token).email(userEmail).build());

            userId = response.getUser().getId();

        } catch (Exception e) {
            logger.info("Something went wrong in SlackClient.getUserId() with error message: " + e.getMessage());
            e.printStackTrace();
        }
        return userId;
    }

    private static List<Attachment> generateSlackAttachmentFromAnExistMessage(SlackMessage message) {
        List<Attachment> attachments = new ArrayList<>();
        Attachment slackAttachment = new Attachment();


        if (Objects.equals(message.failedResultToString(), null)) {
            slackAttachment.setColor("#00b300");
            slackAttachment.setTitle("Test run was successful.");
            slackAttachment.setText("All autotests passed successfully!");

        } else {
            slackAttachment.setColor("#bb0000");
            slackAttachment.setTitle("Failed tests:");

            String fullText = message.failedResultToString();
            if (fullText.length() > 4000 - 3) // slack recommended limit
            {
                fullText = fullText.substring(0, 4000 - 3) + "...";
            }

            slackAttachment.setText(fullText);

        }

        attachments.add(slackAttachment);
        return attachments;
    }

}
