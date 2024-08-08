package com.company.support;

import com.company.support.dto.model.CommentEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class MockComments {
    public final UUID clientId_1 = UUID.fromString("209da369-850b-4a8d-9c0f-2c34a79956a6");
    public final String clientName_1 = "Ivanov Ivan";

    public final UUID issueId_1 = UUID.fromString("c87323e5-ecf4-4b52-bfa1-9d9577b779f1");
    public final UUID issueId_2 = UUID.fromString("66fca091-cd6d-41a7-81f7-763f215fbd67");

    public final List<CommentEntity> comments = List.of(
            new CommentEntity(
                    UUID.fromString("4966fe48-e940-47fd-9fa1-5c498531fceb"),
                    issueId_1,
                    "wrong response",
                    LocalDateTime.parse("2024-08-04 09:19:30.556+00", DateTimeFormatter.BASIC_ISO_DATE),
                    clientId_1,
                    clientName_1
            )
    );
}
