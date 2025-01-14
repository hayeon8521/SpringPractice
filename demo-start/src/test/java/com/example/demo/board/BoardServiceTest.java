package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService boardService;
	
	//@Test
	@DisplayName("게시글등록")
	public void register() {
		String title = "새로운";
		//given
		BoardDTO board = BoardDTO.builder().title(title).content("잘굴러갑니다").writer("표하연").build();
		//when
		boardService.register(board);
		//then
		//assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 수정")
	public void update() {
		String title = "수정";
		//given
		BoardDTO board = BoardDTO.builder()
				                 .bno(4L)
				                 .title(title)
				                 .content("수정되어굴러갑니다")
				                 .writer("표하연123")
				                 .build();
		//when
		boolean result = boardService.modify(board);
		//then
		log.info("★update count : " + result);
		assertThat(result).isEqualTo(true);
	}
	
	//@Test
	@DisplayName("단건조회")
	public void read() {
		//given
		Long bno = 4L;
		//when
		BoardDTO board = boardService.get(bno);
		//then
		log.info("★★★"+board.toString());
		//assertThat(board.getBno()).isEqualTo(bno);
		assertThat(board).isNotNull();
	}
	
	//@Test
	@DisplayName("게시글 삭제")
	public void delete() {
		//given
		Long bno = 46L;
		//when
		boolean result = boardService.remove(bno);
		//then
		log.info("★update count : " + result);
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	@DisplayName("전체조회")
	public void testGetList() {
		//given
		//when
		List<BoardDTO> list = boardService.getList();
		//then
		list.forEach(board -> log.info(board.toString()));
		assertThat(list).isNotNull();
	}

}
