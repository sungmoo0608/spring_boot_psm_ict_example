package edu.ict.ex.vo;

import java.util.List;

import edu.ict.ex.page.PageVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BoardPageVO  {
	
	private List<BoardVO> boards;
	private PageVO page;
	
}
