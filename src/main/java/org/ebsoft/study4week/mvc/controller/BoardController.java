package org.ebsoft.study4week.mvc.controller;
import lombok.RequiredArgsConstructor;
import org.ebsoft.study4week.mvc.domain.Board;
import org.ebsoft.study4week.mvc.domain.Category;
import org.ebsoft.study4week.mvc.domain.PageInfo;
import org.ebsoft.study4week.mvc.domain.Search;
import org.ebsoft.study4week.mvc.service.BoardService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 게시판 컨트롤러
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService service;

    @GetMapping("list")
    public Map<String, Object> getList(@ModelAttribute("search") Search search
            , Model model
            , @ModelAttribute("pageInfo") PageInfo pageInfo) {
        List<Board> boards = service.getList(search, pageInfo);

        int listNum = service.getListNum(search);
        List<Category> categoryList = service.getCategoryList();
        Map<String, Object> map = new HashMap<>();
        map.put("boards", boards);
        map.put("listNum", listNum);
        map.put("categoryList", categoryList);
        return map;
    }


    /**
     * 게시물 상세 보기
     *
     * @param boardId 게시물 번호
     * @param model
     * @return 상세 보기 화면
     */
    @GetMapping("{boardId}")
    public Map<String, Object> get(@PathVariable long boardId, Model model) {
        Board board = service.get(boardId);
        Map<String, Object> map = new HashMap<>();
        map.put("board", board);
        return map;
    }

    /**
     * 게시물 등록 프로세스
     *
     * @param board 게시물 등록 정보
     * @return 게시물 조회 화면
     */
    @PostMapping("save")
    public String save(@ModelAttribute Board board) {
        service.save(board);
        return "redirect:/board/list";
    }

    /**
     * 게시물 등록 화면
     */
    @GetMapping("write")
    public Map<String, Object> write(Model model) {
        List<Category> categoryList = service.getCategoryList();
        Map<String , Object> map = new HashMap<>();
        map.put("categoryList", categoryList);
        return map;
    }


    /**
     * 게시물 업데이트 프로세스
     * @param board 게시물 수정 정보
     */
    @PostMapping("update")
    public void update(Board board) {
        service.update(board);
    }

    /**
     * 게시물 삭제 프로세스
     * @param boardId 게시물 번호
     */
    @DeleteMapping("delete")
    public void delete(@PathVariable long boardId) {
        service.delete(boardId);
    }


    /**
     * 파일 다운로드
     *
     * @param fileUuidName 파일명
     * @param response     the response
     * @throws IOException 입출력 오류
     */
    @GetMapping("fileDownload")
    public void fileDownload(@RequestParam String fileUuidName,
                             HttpServletResponse response) throws IOException {
        service.fileDownload(fileUuidName, response);
    }
}
