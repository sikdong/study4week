package org.ebsoft.study4week.mvc.repository;

import org.apache.ibatis.annotations.Param;
import org.ebsoft.study4week.mvc.domain.Board;
import org.ebsoft.study4week.mvc.domain.Category;
import org.ebsoft.study4week.mvc.domain.FileUnit;
import org.ebsoft.study4week.mvc.domain.Search;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 repository
 */
@Repository
public interface BoardRepository {
    List<Board> getList(Search search);
    Board get(long boardId);
    void save(Board board);
    void update(Board board);
    void delete(long boardId);

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int getListNum(Search search);


    /**
     * 카테고리 전체 조회
     * @return 카테고리 전체 목록
     */
    List<Category> getCategoryList();

    /**
     * 파일 저장
     *
     * @param folder   파일 경로(년\\월\\일)
     * @param boardId  게시물 번호
     * @param fileName 파일 이름
     * @param fileUuidName uuid가 포함된 파일 명
     */
    void saveFile(@Param("folder") String folder
                , @Param("boardId") Long boardId
                , @Param("fileName") String fileName
                , @Param("fileUuidName") String fileUuidName);

    FileUnit getFile(String fileUuidName);
}
