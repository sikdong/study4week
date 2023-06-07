package org.ebsoft.study4week.mvc.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class Board {

    private Long boardId;
    private String title;
    private String content;
    private String regDate;
    private String modDate;
    private String writer;
    private String password;
    private int viewCount;
    private Category category;
    private List<FileUnit> fileUnits;
    private List<Comment> comment;

    // 게시물 등록 시 따로 바인딩 할 카테고리 id 필드(Category 안의 id랑 바인딩 하는 방법을 모르겠음)
    private int categoryNum;

    //3개를 따로 받다보니 이 방법 밖에 잘 모르겠다...다른 방법이 있나
    private MultipartFile firstFile;
    private MultipartFile secondFile;
    private MultipartFile thirdFile;

    /*public List<MultipartFile> getFileList(MultipartFile firstFile, MultipartFile secondFile, MultipartFile thirdFile){
        List<MultipartFile> fileList = new ArrayList<>();
        fileList.add(firstFile);
        fileList.add(secondFile);
        fileList.add(thirdFile);
        return fileList;
    }
*/
}
