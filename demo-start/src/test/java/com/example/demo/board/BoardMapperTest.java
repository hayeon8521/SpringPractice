package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardMapperTest {
	@Autowired BoardMapper boardMapper;
	
	//@Test
	@DisplayName("게시글등록")
	public void register() {
		String title = "자동차";
		//given
		BoardDTO board = BoardDTO.builder().title(title).content("잘굴러갑니다").writer("표하연").build();
		//when
		int cnt = boardMapper.insert(board);
		//then
		assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 업데이트")
	public void update() {
		String title = "자동차";
		//given
		BoardDTO board = BoardDTO.builder().bno(3L).title(title).content("잘굴러갑니다").writer("표하연").build();
		//when
		int cnt = boardMapper.update(board);
		//then
		assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 삭제")
	public void delete() {
		//given
		Long bno = 2L;
		//when
		int cnt = boardMapper.delete(bno);
		//then
		assertThat(cnt).isEqualTo(cnt);
		log.debug(cnt+"건 이 삭제 되었습니다");
	}
	
	@Test
	@DisplayName("단건조회")
	public void read() {
		//given
		Long bno = 4L;
		//when
		BoardDTO board = boardMapper.read(bno);
		//then
		log.info(board.toString());
		//assertThat(board.getBno()).isEqualTo(bno);
		assertThat(board).isNotNull();
	}
	
	@Test
	@DisplayName("전체조회")
	public void testGetList() {
		//given
		//when
		List<BoardDTO> list = boardMapper.getList();
		//then
		//list.forEach(board -> log.info(board.toString()));
		assertThat(list).isNotNull();
	}
		
}
