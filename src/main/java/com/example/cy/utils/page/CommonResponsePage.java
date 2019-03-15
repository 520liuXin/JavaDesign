package com.example.cy.utils.page;
import java.util.List;

public class CommonResponsePage<T> {
    private List<T> items;
    private VenusPageVO pagemeta;

    public CommonResponsePage() {
    }

    public List<T> getItems() {
        return this.items;
    }

    public VenusPageVO getPagemeta() {
        return this.pagemeta;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setPagemeta(VenusPageVO pagemeta) {
        this.pagemeta = pagemeta;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommonResponsePage)) {
            return false;
        } else {
            CommonResponsePage<?> other = (CommonResponsePage)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items != null) {
                        return false;
                    }
                } else if (!this$items.equals(other$items)) {
                    return false;
                }

                Object this$pagemeta = this.getPagemeta();
                Object other$pagemeta = other.getPagemeta();
                if (this$pagemeta == null) {
                    if (other$pagemeta != null) {
                        return false;
                    }
                } else if (!this$pagemeta.equals(other$pagemeta)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CommonResponsePage;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $items = this.getItems();
//        int result = result * 59 + ($items == null ? 43 : $items.hashCode());
//        Object $pagemeta = this.getPagemeta();
//        result = result * 59 + ($pagemeta == null ? 43 : $pagemeta.hashCode());
//        return result;
//    }

    public String toString() {
        return "CommonResponsePage(items=" + this.getItems() + ", pagemeta=" + this.getPagemeta() + ")";
    }
}
