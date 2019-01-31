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
@Service	// service�� ����Ͻ� ������ ����ϴ� ��ü���� ǥ���ϱ� ���� ���
@AllArgsConstructor	// ��� �Ķ���͸� �̿��ϴ� �����ڸ� ����� ���� BoardMapper�� ���Թ޴� �����ڰ� �������
public class BoardServiceImpl implements BoardService {
	// spring 4.3 �̻󿡼� �ڵ� ó��
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

}
