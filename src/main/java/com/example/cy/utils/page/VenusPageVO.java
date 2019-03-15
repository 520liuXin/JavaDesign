package com.example.cy.utils.page;


import org.springframework.data.domain.Page;

public class VenusPageVO {
    private int size;
    private int page;
    private int totalPages;
    private long totalElements;

    public VenusPageVO init(Page page) {
        this.size = page.getSize();
        this.page = page.getNumber() + 1;
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        return this;
    }

    public VenusPageVO() {
    }

    public int getSize() {
        return this.size;
    }

    public int getPage() {
        return this.page;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof VenusPageVO)) {
            return false;
        } else {
            VenusPageVO other = (VenusPageVO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getSize() != other.getSize()) {
                return false;
            } else if (this.getPage() != other.getPage()) {
                return false;
            } else if (this.getTotalPages() != other.getTotalPages()) {
                return false;
            } else {
                return this.getTotalElements() == other.getTotalElements();
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof VenusPageVO;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        int result = result * 59 + this.getSize();
//        result = result * 59 + this.getPage();
//        result = result * 59 + this.getTotalPages();
//        long $totalElements = this.getTotalElements();
//        result = result * 59 + (int)($totalElements >>> 32 ^ $totalElements);
//        return result;
//    }

    public String toString() {
        return "VenusPageVO(size=" + this.getSize() + ", page=" + this.getPage() + ", totalPages=" + this.getTotalPages() + ", totalElements=" + this.getTotalElements() + ")";
    }
}
