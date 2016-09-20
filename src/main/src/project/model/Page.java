package project.model;

/**
 * Created on 25.08.2016.
 */
public class Page {

    private Integer pageNumber;
    private Long pageCount;
    private Integer pageSize;
    private Boolean toNext;
    private Boolean toPrev;

    public Page() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getToNext() {
        return toNext;
    }

    public void setToNext(Boolean toNext) {
        this.toNext = toNext;
    }

    public Boolean getToPrev() {
        return toPrev;
    }

    public void setToPrev(Boolean toPrev) {
        this.toPrev = toPrev;
    }
}
