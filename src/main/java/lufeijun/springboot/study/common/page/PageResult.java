package lufeijun.springboot.study.common.page;

import lombok.Data;

import java.util.List;


// 分页结果数据
@Data
public class PageResult {

  private int pageNum;

  private int pageSize;

  private long totalSize;

  private long totalPages;

  // 数据模型
  private List<?> content;

}
