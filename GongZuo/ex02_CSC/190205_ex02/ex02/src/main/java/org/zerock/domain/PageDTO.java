package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

// 시작페이지 
  private int startPage;
//마지막페이지
  private int endPage;	 
//이전페이지, 다음페이지 
  private boolean prev, next; 
// 토탈 
  private int total; 
  // pageNum;amount;type;keyword;
  private Criteria cri;

  public PageDTO(Criteria cri, int total) {

    this.cri = cri;
    this.total = total;

    this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
    this.startPage = this.endPage - 9;

    int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

    if (realEnd <= this.endPage) {
      this.endPage = realEnd;
    }

    this.prev = this.startPage > 1;
    this.next = this.endPage < realEnd;
  }
  
}

