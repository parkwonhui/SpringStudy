package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service	// service는 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용
@AllArgsConstructor	// 모든 파라미터를 이용하는 생성자를 만든다 사용시 BoardMapper를 주입받는 생성자가 만들어짐
public class BoardServiceImpl implements BoardService {
	// spring 4.3 이상에서 자동 처리
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board){
		log.info("register......"+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get........"+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify........"+board);
		return (1 == mapper.update(board));
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove........"+bno);	
		return 1 == mapper.delete(bno);
	}

	/*@Override
	public List<BoardVO> getList() {
		log.info("getList.........");
		return mapper.getList();
	}*/

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria:"+cri);
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri){
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

}
