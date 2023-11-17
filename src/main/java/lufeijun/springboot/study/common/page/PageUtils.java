package lufeijun.springboot.study.common.page;

import com.github.pagehelper.PageInfo;

public class PageUtils {

  public static PageResult getPageResult(PageInfo<?> pageInfo) {
    var pageResult = new PageResult();
    pageResult.setPageNum(pageInfo.getPageNum());
    pageResult.setPageSize(pageInfo.getPageSize());

    pageResult.setTotalPages(pageInfo.getPages());
    pageResult.setTotalSize(pageInfo.getTotal());

    pageResult.setContent(pageInfo.getList());

    return pageResult;
  }

}
