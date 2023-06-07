package org.ebsoft.study4week.mvc.domain;

import lombok.Data;

@Data
public class Comment {
    private Long commentId;
    private String comment;
    private String regDate;
    private String modDate;
}
